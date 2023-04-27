package pipeline;

public class MEM_WB {
	// Instruction
	private String Instruction;
	// Control
	private boolean MemToReg;
	private boolean RegWrite;
	// Values
	private int ALUResult;
	private int LWDataValue;
	private int WriteRegNum;

	public void copy(MEM_WB that) {
		this.Instruction = that.Instruction;
		this.MemToReg = that.MemToReg;
		this.RegWrite = that.RegWrite;
		this.ALUResult = that.ALUResult;
		this.LWDataValue = that.LWDataValue;
		this.WriteRegNum = that.WriteRegNum;
	}

	@Override
	public String toString() {
		return String.format(
				"Instruction = %s%nControl: MemToReg=%s, RegWrite=%s%nALUResult=%03X, LWDataValue=%03X, WriteRegNum=%s",
				Instruction, MemToReg, RegWrite, ALUResult, LWDataValue, WriteRegNum);
	}

	public String getInstruction() {
		return Instruction;
	}

	public void setInstruction(String instruction) {
		Instruction = instruction;
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

	public int getALUResult() {
		return ALUResult;
	}

	public void setALUResult(int aLUResult) {
		ALUResult = aLUResult;
	}

	public int getLWDataValue() {
		return LWDataValue;
	}

	public void setLWDataValue(int lWDataValue) {
		LWDataValue = lWDataValue;
	}

	public int getWriteRegNum() {
		return WriteRegNum;
	}

	public void setWriteRegNum(int writeRegNum) {
		WriteRegNum = writeRegNum;
	}
}
