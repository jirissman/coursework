package pipeline;

public class Pipeline {

	public static void main(String[] args) {
		Pipeline pipeline = new Pipeline();
		pipeline.run();
	}

	private int[] InstructionCache = { 0xa1020000, 0x810AFFFC, 0x00831820, 0x01263820, 0x01224820, 0x81180000,
			0x81510010, 0x00624022, 0x00000000, 0x00000000, 0x00000000, 0x00000000 };
	private int PC = 0;
	private int[] Main_Mem = new int[1024];
	private int[] Regs = new int[32];
	private IF_ID IF_ID_WRITE = new IF_ID();
	private IF_ID IF_ID_READ = new IF_ID();
	private ID_EX ID_EX_WRITE = new ID_EX();
	private ID_EX ID_EX_READ = new ID_EX();
	private EX_MEM EX_MEM_WRITE = new EX_MEM();
	private EX_MEM EX_MEM_READ = new EX_MEM();
	private MEM_WB MEM_WB_WRITE = new MEM_WB();
	private MEM_WB MEM_WB_READ = new MEM_WB();

	public void run() {
		initialize();
		for (int i = 0; i < InstructionCache.length; i++) {
			IF_stage();
			ID_stage();
			EX_stage();
			MEM_stage();
			WB_stage();
			Print_out_everything();
			Copy_write_to_read();
		}
	}

	private void initialize() {
		// initialize Main Memory
		for (int i = 0; i < Main_Mem.length; i++) {
			Main_Mem[i] = i & 0xFF;
		}
		// initialize Registers
		for (int i = 0; i < Regs.length; i++) {
			Regs[i] = 0x100 + i;
		}
		Regs[0] = 0;
		return;
	}

	private void IF_stage() {
		int instruction = InstructionCache[PC++];
		IF_ID_WRITE.setInstruction(instruction);
		IF_ID_WRITE.setInSTRuction(disassemble(instruction));
	}

	private void ID_stage() {
		// get instruction from register and pass along to next register
		int instruction = IF_ID_READ.getInstruction();
		ID_EX_WRITE.setInstruction(IF_ID_READ.getInSTRuction());
		// handle nop
		if (instruction == 0) {
			ID_EX_WRITE.clear();
			ID_EX_WRITE.setInstruction("nop");
			return;
		}
		// decode instruction
		int opcode = instruction >>> 26;
		int rs = (instruction >>> 21) & 0x1F;
		int rt = (instruction >>> 16) & 0x1F;
		int rd = (instruction >>> 11) & 0x1F;
		int func = instruction & 0x3F;
		short offset = (short) (instruction & 0xFFFF);
		// set control bits
		ID_EX_WRITE.setRegDst(opcode == 0); // set true for r-format instructions
		ID_EX_WRITE.setALUSrc(opcode != 0); // set true for loads and stores
		ID_EX_WRITE.setALUOp(opcode == 0 ? 10 : 0); // set to 10 for add or sub
		ID_EX_WRITE.setMemRead(opcode == 0x20); // set true for load
		ID_EX_WRITE.setMemWrite(opcode == 0x28); // set true for store
		ID_EX_WRITE.setMemToReg(opcode == 0x20); // set true for load
		ID_EX_WRITE.setRegWrite(opcode == 0 || opcode == 0x20); // set true for load, add, or sub
		// retrieve register values
		ID_EX_WRITE.setReadReg1Value(Regs[rs]);
		ID_EX_WRITE.setReadReg2Value(Regs[rt]);
		ID_EX_WRITE.setSEOffset(offset);
		ID_EX_WRITE.setWriteReg_20_16(rt);
		ID_EX_WRITE.setWriteReg_15_11(rd);
		ID_EX_WRITE.setFunction(func);
	}

	private void EX_stage() {
		// pass through control bits
		EX_MEM_WRITE.setInstruction(ID_EX_READ.getInstruction());
		EX_MEM_WRITE.setMemRead(ID_EX_READ.getMemRead());
		EX_MEM_WRITE.setMemWrite(ID_EX_READ.getMemWrite());
		EX_MEM_WRITE.setMemToReg(ID_EX_READ.getMemToReg());
		EX_MEM_WRITE.setRegWrite(ID_EX_READ.getRegWrite());
		// set write register number based on control bit
		EX_MEM_WRITE.setWriteRegNum(
				ID_EX_READ.getRegDst() ? ID_EX_READ.getWriteReg_15_11() : ID_EX_READ.getWriteReg_20_16());
		// set value for potential store
		EX_MEM_WRITE.setSWValue(ID_EX_READ.getReadReg2Value());
		// set ALU inputs based on control
		int ALUinput1 = ID_EX_READ.getReadReg1Value();
		int ALUinput2 = ID_EX_READ.getALUSrc() ? ID_EX_READ.getSEOffset() : ID_EX_READ.getReadReg2Value();
		// calculate ALU result based on operation
		if (ID_EX_READ.getALUOp() == 10 && ID_EX_READ.getFunction() == 0x20) { // add
			EX_MEM_WRITE.setALUResult(ALUinput1 + ALUinput2);
		}
		if (ID_EX_READ.getALUOp() == 10 && ID_EX_READ.getFunction() == 0x22) { // sub
			EX_MEM_WRITE.setALUResult(ALUinput1 - ALUinput2);
		}
		if (ID_EX_READ.getALUOp() == 00) { // load or store
			EX_MEM_WRITE.setALUResult(ALUinput1 + ALUinput2);
		}
	}

	private void MEM_stage() {
		// pass through control bits
		MEM_WB_WRITE.setInstruction(EX_MEM_READ.getInstruction());
		MEM_WB_WRITE.setMemToReg(EX_MEM_READ.getMemToReg());
		MEM_WB_WRITE.setRegWrite(EX_MEM_READ.getRegWrite());
		// pass through data values
		MEM_WB_WRITE.setALUResult(EX_MEM_READ.getALUResult());
		MEM_WB_WRITE.setWriteRegNum(EX_MEM_READ.getWriteRegNum());
		// handle loads and stores
		if (EX_MEM_READ.getMemWrite()) { // store
			Main_Mem[EX_MEM_READ.getALUResult()] = EX_MEM_READ.getSWValue() & 0xFF; // mask least significant byte
		}
		if (EX_MEM_READ.getMemRead()) { // load
			MEM_WB_WRITE.setLWDataValue(Main_Mem[EX_MEM_READ.getALUResult()]);
		}
	}

	private void WB_stage() {
		if (MEM_WB_READ.getRegWrite()) {
			// if RegWrite is true, write the data from the correct source depending on MemToReg
			Regs[MEM_WB_READ.getWriteRegNum()] = MEM_WB_READ.getMemToReg() ? MEM_WB_READ.getLWDataValue() : MEM_WB_READ.getALUResult();
		}
	}

	private void Print_out_everything() {
		System.out.println("Clock Cycle " + PC);
		System.out.println("Register Values");
		for (int i = 0; i < Regs.length; i++) {
			System.out.printf("%3s=0x%03X%n", "$" + i, Regs[i]);
		}
		System.out.println("\nIF/ID_Write\n"+IF_ID_WRITE.toString());
		System.out.println("\nIF/ID_Read\n"+IF_ID_READ.toString());
		System.out.println("\nID/EX_Write\n"+ID_EX_WRITE.toString());
		System.out.println("\nID/EX_Read\n"+ID_EX_READ.toString());
		System.out.println("\nEX/MEM_Write\n"+EX_MEM_WRITE.toString());
		System.out.println("\nEX/MEM_Read\n"+EX_MEM_READ.toString());
		System.out.println("\nMEM/WB_Write\n"+MEM_WB_WRITE.toString());
		System.out.println("\nMEM/WB_Read\n"+MEM_WB_READ.toString());
		System.out.println();
	}

	private void Copy_write_to_read() {
		IF_ID_READ.copy(IF_ID_WRITE);
		ID_EX_READ.copy(ID_EX_WRITE);
		EX_MEM_READ.copy(EX_MEM_WRITE);
		MEM_WB_READ.copy(MEM_WB_WRITE);
	}

	// disassemble code taken from project 1 and modified for this project
	private String disassemble(int instruction) {
		// handle nop
		if (instruction == 0) {
			return "nop";
		}
		// decode instruction
		int opcode = instruction >>> 26;
		int rs = (instruction >>> 21) & 0x1F;
		int rt = (instruction >>> 16) & 0x1F;
		int rd = (instruction >>> 11) & 0x1F;
		int func = instruction & 0x3F;
		short offset = (short) (instruction & 0xFFFF);

		switch (opcode) {
		case 0x0: // R-format
			return funcLookup(func) + " $" + rd + ", $" + rs + ", $" + rt;
		case 0x20: // Load Byte
			return "lb  $" + rt + ", " + offset + " ($" + rs + ")";
		case 0x28: // Store Byte
			return "sb  $" + rt + ", " + offset + " ($" + rs + ")";
		default:
			return "error";
		}
	}

	private String funcLookup(int func) {
		switch (func) {
		case 0x20:
			return "add";
		case 0x22:
			return "sub";
		default:
			return "error";
		}
	}

}
