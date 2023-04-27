package pipeline;

public class IF_ID {
	private int Instruction;
	private String InSTRuction;

	@Override
	public String toString() {
		return String.format("Instruction = %2$s%nInst=0x%1$08X", Instruction, InSTRuction);
	}

	public int getInstruction() {
		return Instruction;
	}

	public void setInstruction(int instruction) {
		Instruction = instruction;
	}

	public String getInSTRuction() {
		return InSTRuction;
	}

	public void setInSTRuction(String inSTRuction) {
		InSTRuction = inSTRuction;
	}

	public void copy(IF_ID that) {
		this.Instruction = that.Instruction;
		this.InSTRuction = that.InSTRuction;
	}
}
