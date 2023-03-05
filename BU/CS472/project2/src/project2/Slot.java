package project2;

public class Slot {
	private static final int BLOCKSIZE = 16;
	private boolean valid;
	private boolean dirty;
	private int tag;
	private int data[] = new int[BLOCKSIZE];
	public Slot() {
		this.valid = false;
		this.dirty = false;
		this.tag = 0;
		for (int i = 0; i < data.length; i++) {
			data[i] = 0;
		}
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public boolean isDirty() {
		return dirty;
	}
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	public int getByte(int offset) {
		return data[offset];
	}
	public void setByte(int offset, int value) {
		this.data[offset] = value;
	}
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		String print = "";
		for (int i : data) {
			print += String.format("%02X ", i);
		}
		return print;
	}
}
