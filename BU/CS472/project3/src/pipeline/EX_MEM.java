package pipeline;

public class EX_MEM {
	// Instruction
	private String Instruction;
	// Control
	private boolean MemRead;
	private boolean MemWrite;
	private boolean MemToReg;
	private boolean RegWrite;
	// Values
	private int ALUResult;
	private int SWValue;
	private int WriteRegNum;

	public void copy(EX_MEM that) {
		this.Instruction = that.Instruction;
		this.MemRead = that.MemRead;
		this.MemWrite = that.MemWrite;
		this.MemToReg = that.MemToReg;
		this.RegWrite = that.RegWrite;
		this.ALUResult = that.ALUResult;
		this.SWValue = that.SWValue;
		this.WriteRegNum = that.WriteRegNum;
	}

	@Override
	public String toString() {
		return String.format(
				"Instruction = %s%nControl: MemRead=%s, MemWrite=%s, MemToReg=%s, RegWrite=%s%nALUResult=%03X, SWValue=%03X, WriteRegNum=%s",
				Instruction, MemRead, MemWrite, MemToReg, RegWrite, ALUResult, SWValue, WriteRegNum);
	}

	public String getInstruction() {
		return Instruction;
	}

	public void setInstruction(String instruction) {
		Instruction = instruction;
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

	public int getALUResult() {
		return ALUResult;
	}

	public void setALUResult(int aLUResult) {
		ALUResult = aLUResult;
	}

	public int getSWValue() {
		return SWValue;
	}

	public void setSWValue(int sWValue) {
		SWValue = sWValue;
	}

	public int getWriteRegNum() {
		return WriteRegNum;
	}

	public void setWriteRegNum(int writeRegNum) {
		WriteRegNum = writeRegNum;
	}
}
