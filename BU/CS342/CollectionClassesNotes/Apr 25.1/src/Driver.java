
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.testSearch();
	}
	
	private int []data = { 2, 5, 7, 12, 3, 45, 13, 18, 19, 1};
	private int []sortedData = {3, 6, 8, 11, 14, 17, 19, 24, 27, 34, 38, 45, 56, 66, 72, 78, 80};
	private void doIt() {
		
		System.out.println(linearSearch(data, 46));
		System.out.println(itBinarySearch(sortedData, 35));
		System.out.println(recBinarySearch(sortedData, 38, 0, sortedData.length-1));
		System.out.println(recBinSrch(sortedData, 38));
		
	}
	
	int []testData;
	private static final int DATA_SIZE = 100_000_000;
	private void testSearch() {
		testData = new int[DATA_SIZE];
		for (int i = 0; i < testData.length; i++) {
			testData[i] = i *2;
		}
		
		long start1 = System.currentTimeMillis();
		System.out.println(linearSearch(testData, testData[DATA_SIZE-1]));
		long end1 = System.currentTimeMillis();
		System.out.println("linear Search took " + (end1-start1) + " Milliseconds");
		
		long start2 = System.currentTimeMillis();
		System.out.println(recBinSrch(testData, testData[DATA_SIZE-1]));
		long end2 = System.currentTimeMillis();
		System.out.println("Binary Search took " + (end2-start2) + " Milliseconds");
	}
	
	public int linearSearch(int []array, int value) {
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int itBinarySearch(int []array, int value) {
		
		int hi = array.length-1;
		int lo = 0;
		int mid;
		
		// As long as lo < hi we can continue
		// if lo > hi, the value is not found
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			
			if (array[mid] == value) {
				return mid;
			}
			
			if (value < array[mid]) {
				hi = mid-1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}
	
	public int recBinSrch(int []array, int value) {
		return recBinarySearch(array, value, 0, array.length-1);
	}
	
	private int recBinarySearch(int []array, int value, int lo, int hi) {
		
		int mid;
		
		// Base case for not found
		if (lo > hi) {
			return -1;
		}
		
		// Find the mid point
		mid = (lo + hi) / 2;
		
		// Base case for found
		if (array[mid] == value) {
			return mid;
		}
		
		if (value < array[mid]) {
			// Look at the left side
			return recBinarySearch(array, value, lo, mid-1);
		} else {
			// Look at the right side
			return recBinarySearch(array, value, mid + 1, hi);
		}
	}

}
