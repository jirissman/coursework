package pipeline;

public class ID_EX {
	// Instruction
	private String Instruction;
	// Control
	private boolean RegDst;
	private boolean ALUSrc;
	private int ALUOp;
	private boolean MemRead;
	private boolean MemWrite;
	private boolean MemToReg;
	private boolean RegWrite;
	// Values
	private int ReadReg1Value;
	private int ReadReg2Value;
	private int SEOffset;
	private int WriteReg_20_16;
	private int WriteReg_15_11;
	private int Function;

	public void copy(ID_EX that) {
		this.Instruction = that.Instruction;
		this.RegDst = that.RegDst;
		this.ALUSrc = that.ALUSrc;
		this.ALUOp = that.ALUOp;
		this.MemRead = that.MemRead;
		this.MemWrite = that.MemWrite;
		this.MemToReg = that.MemToReg;
		this.RegWrite = that.RegWrite;
		this.ReadReg1Value = that.ReadReg1Value;
		this.ReadReg2Value = that.ReadReg2Value;
		this.SEOffset = that.SEOffset;
		this.WriteReg_20_16 = that.WriteReg_20_16;
		this.WriteReg_15_11 = that.WriteReg_15_11;
		this.Function = that.Function;
	}

	@Override
	public String toString() {
		return String.format(
				"Instruction = %s%nControl: RegDst=%s, ALUSrc=%s, ALUOp=%02d, MemRead=%s, MemWrite=%s, MemToReg=%s, RegWrite=%s%nReadReg1Value=%03X, ReadReg2Value=%03X, SEOffset=%08X, WriteReg_20_16=%s, WriteReg_15_11=%s, Function=%02X",
				Instruction, RegDst, ALUSrc, ALUOp, MemRead, MemWrite, MemToReg, RegWrite, ReadReg1Value, ReadReg2Value,
				SEOffset, WriteReg_20_16, WriteReg_15_11, Function);
	}

	public void clear() {
		Instruction = "";
		RegDst = false;
		ALUSrc = false;
		ALUOp = 0;
		MemRead = false;
		MemWrite = false;
		MemToReg = false;
		RegWrite = false;
		ReadReg1Value = 0;
		ReadReg2Value = 0;
		SEOffset = 0;
		WriteReg_20_16 = 0;
		WriteReg_15_11 = 0;
		Function = 0;
	}

	public String getInstruction() {
		return Instruction;
	}

	public void setInstruction(String instruction) {
		Instruction = instruction;
	}

	public boolean getRegDst() {
		return RegDst;
	}

	public void setRegDst(boolean regDst) {
		RegDst = regDst;
	}

	public boolean getALUSrc() {
		return ALUSrc;
	}

	public void setALUSrc(boolean aLUSrc) {
		ALUSrc = aLUSrc;
	}

	public int getALUOp() {
		return ALUOp;
	}

	public void setALUOp(int aLUOp) {
		ALUOp = aLUOp;
	}

	public boolean getMemRead() {
		return MemRead;
	}

	public void setMemRead(boolean memRead) {
		MemRead = memRead;
	}

	public boolean getMemWrite() {
		return MemWrite;
	}

	public void setMemWrite(boolean memWrite) {
		MemWrite = memWrite;
	}

	public boolean getMemToReg() {
		return MemToReg;
	}

	public void setMemToReg(boolean memToReg) {
		MemToReg = memToReg;
	}

	public boolean getRegWrite() {
		return RegWrite;
	}

	public void setRegWrite(boolean regWrite) {
		RegWrite = regWrite;
	}

	public int getReadReg1Value() {
		return ReadReg1Value;
	}

	public void setReadReg1Value(int readReg1Value) {
		ReadReg1Value = readReg1Value;
	}

	public int getReadReg2Value() {
		return ReadReg2Value;
	}

	public void setReadReg2Value(int readReg2Value) {
		ReadReg2Value = readReg2Value;
	}

	public int getSEOffset() {
		return SEOffset;
	}

	public void setSEOffset(int sEOffset) {
		SEOffset = sEOffset;
	}

	public int getWriteReg_20_16() {
		return WriteReg_20_16;
	}

	public void setWriteReg_20_16(int writeReg_20_16) {
		WriteReg_20_16 = writeReg_20_16;
	}

	public int getWriteReg_15_11() {
		return WriteReg_15_11;
	}

	public void setWriteReg_15_11(int writeReg_15_11) {
		WriteReg_15_11 = writeReg_15_11;
	}

	public int getFunction() {
		return Function;
	}

	public void setFunction(int function) {
		Function = function;
	}
}
