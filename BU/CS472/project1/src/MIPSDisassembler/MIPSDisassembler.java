package MIPSDisassembler;

public class MIPSDisassembler {

	public static void main(String[] args) {
//		int[] testInstructions = { 0x1107000A, 0x00A63820, 0x8D070004, 0xAE49FFFC};
//		int testProgramCounter = 0x9A000;
//
//		for (int i = 0; i < testInstructions.length; i++) {
//			System.out.println(disassemble(testProgramCounter, testInstructions[i]));
//			testProgramCounter += 4;
//		}
		int[] instructions = { 0x032BA020, 0x8CE90014, 0x12A90003, 0x022DA822, 0xADB30020, 0x02697824, 0xAE8FFFF4,
				0x018C6020, 0x02A4A825, 0x158FFFF7, 0x8ECDFFF0 };
		int programCounter = 0x9A040;
		for (int i = 0; i < instructions.length; i++) {
			System.out.println(disassemble(programCounter, instructions[i]));
			programCounter += 4;
		}
	}

	private static String disassemble(int programCounter, int instruction) {
		// output the instruction address
		String assemblyCode = String.format("%x", programCounter);
		
		// decode instruction
		int opcode = instruction >>> 26;
		int rs = (instruction >>> 21) & 0x1F;
		int rt = (instruction >>> 16) & 0x1F;
		int rd = (instruction >>> 11) & 0x1F;
		int funct = instruction & 0x3F;
		short offset = (short) (instruction & 0xFFFF);

		switch (opcode) {
		case 0x0: // R-format
			assemblyCode += " " + functLookup(funct) + " $" + rd + ", $" + rs + ", $" + rt;
			break;
		case 0x4: // Branch On Equal
			assemblyCode += " beq $" + rs + ", $" + rt + ", address "
					+ String.format("%x", programCounter + 4 + (offset << 2));
			break;
		case 0x5: // Branch On Not Equal
			assemblyCode += " bne $" + rs + ", $" + rt + ", address "
					+ String.format("%x", programCounter + 4 + (offset << 2));
			break;
		case 0x23: // Load Word
			assemblyCode += " lw  $" + rt + ", " + offset + " ($" + rs + ")";
			break;
		case 0x2B: // Store Word
			assemblyCode += " sw  $" + rt + ", " + offset + " ($" + rs + ")";
			break;
		default: 
			assemblyCode += " error";
			break;
		}

		return assemblyCode;
	}

	private static String functLookup(int funct) {
		switch (funct) {
		case 0x20:
			return "add";
		case 0x22:
			return "sub";
		case 0x24:
			return "and";
		case 0x25:
			return "or ";
		case 0x2A:
			return "slt";
		default:
			return "err";
		}
	}

}
