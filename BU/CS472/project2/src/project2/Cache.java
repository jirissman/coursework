package project2;

public class Cache {
	private static final int CACHESIZE = 16;
	private Slot[] cache = new Slot[CACHESIZE];
	private int[] mainMemory = new int[2048];

	public Cache() {
		// initialize Main Memory
		for (int i = 0; i < mainMemory.length; i++) {
			mainMemory[i] = i & 0xFF;
		}
		// initialize cache to all zeros
		for (int i = 0; i < cache.length; i++) {
			cache[i] = new Slot();
		}
	}

	public boolean Read(int address) {
		if (address < 0 || address > 2048) {
			System.out.println("Invalid address");
			return false;
		}
		boolean hit = false;
		int value = 0;
		int blockOffset = address & 0xF;
		int blockStart = address & 0x7F0;
		int slotNumber = (address & 0xF0) >>> 4;
		int tag = address >>> 8;
		Slot slot = cache[slotNumber];
		if (slot.getTag() == tag && slot.isValid()) {
			// found the right block and it is valid
			hit = true;
			value = slot.getByte(blockOffset);
		} else {
			// need to go to main memory to get the data
			hit = false;
			if (slot.isDirty()) {
				// update main memory with current data first
				writeMM(slotNumber, slot);
			}
			// update slot with new info from MM
			slot.setData(readMM(blockStart));
			slot.setTag(tag);
			slot.setValid(true);
			slot.setDirty(false);
			value = slot.getByte(blockOffset);
		}
		System.out.printf("At the address %H, there is the value %H %s%n", address, value,
				hit ? "(Cache Hit)" : "(Cache Miss)");
		return true;
	}

	public boolean Write(int address, int value) {
		if (address < 0 || address > 2048) {
			System.out.println("Invalid address");
			return false;
		}
		if (value < 0 || value > 0xFF) {
			System.out.println("Invalid data");
			return false;
		}
		boolean hit = false;
		int blockOffset = address & 0xF;
		int blockStart = address & 0x7F0;
		int slotNumber = (address & 0xF0) >>> 4;
		int tag = address >>> 8;
		Slot slot = cache[slotNumber];
		if (slot.getTag() == tag && slot.isValid()) {
			// found the right block and it is valid
			hit = true;
			slot.setByte(blockOffset, value);
			slot.setDirty(true);
		} else {
			// need to go to main memory to get the data
			hit = false;
			if (slot.isDirty()) {
				// update main memory with current data first
				writeMM(slotNumber, slot);
			}
			// update slot with new info from MM
			slot.setData(readMM(blockStart));
			slot.setTag(tag);
			slot.setValid(true);
			// write new data to cache and set dirty bit high
			slot.setByte(blockOffset, value);
			slot.setDirty(true);
		}
		System.out.printf("Value %H has been written to address %H %s%n", value, address,
				hit ? "(Cache Hit)" : "(Cache Miss)");
		return true;
	}

	public void Display() {
		System.out.println("Slot Valid Dirty Tag Data");
		for (int i = 0; i < cache.length; i++) {
			Slot slot = cache[i];
			System.out.printf("%-4H %-5d %-5d %-3H %s%n", i, slot.isValid() ? 1 : 0, slot.isDirty() ? 1 : 0,
					slot.getTag(), slot.toString());
		}
	}

	private void writeMM(int slotNumber, Slot slot) {
		int blockStart = (slot.getTag() << 8) + (slotNumber << 4);
		for (int i = 0; i < 16; i++) {
			mainMemory[blockStart + i] = slot.getByte(i);
		}
	}

	private int[] readMM(int blockStart) {
		int[] data = new int[16];
		for (int i = 0; i < 16; i++) {
			data[i] = mainMemory[blockStart + i];
		}
		return data;
	}
}
