package pipeline;

public class IF_ID {
	private int Instruction;

	@Override
	public String toString() {
		return String.format("Inst=0x%08X", Instruction);
	}

	public int getInstruction() {
		return Instruction;
	}

	public void setInstruction(int instruction) {
		Instruction = instruction;
	}

	public void copy(IF_ID that) {
		this.Instruction = that.Instruction;
	}
}
