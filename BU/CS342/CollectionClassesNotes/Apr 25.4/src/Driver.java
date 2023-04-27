
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}

	private int data[] =  {45, 23, 12, 3, 6, 8, 4, 18, 29, 15, 22, 48, 55, 56, 1, 9};
	private int data2[] = {56, 55, 48, 45, 29, 23, 22, 18, 15, 12, 9, 8, 6, 4, 3, 1};
	private int data3[] = {1, 23, 12, 3, 6, 8, 4, 18, 29, 15, 22, 48, 55, 56, 45, 9};

	private void doIt() {
		int arr2[] = copyArray(data2);
		//		arr2 = bubbleSort(arr2);
		//		arr2 = bubbleSort2(arr2);
				arr2 = selectionSort(arr2);
		//arr2 = insertionSort(arr2);
	}

	private void printArray(String label, int []array) {
		System.out.print(label);
		for (int i = 0; i < array.length; i++) {
			System.out.printf("a[%d] = %d, ", i, array[i]);
		}
		System.out.println();
	}

	private int[] copyArray(int[] array) {
		int []newArray = new int[array.length];

		System.arraycopy(array, 0, newArray, 0, array.length);

		return newArray;
	}

	private int[] bubbleSort(int []array) {
		int count = 0;

		printArray("Before: ", array);
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length-1; i++) {
				count++;
				if (array[i] > array[i+1]) {
					// swap them
					int tmp = array[i];
					array[i] = array[i+1];
					array[i+1] = tmp;
				}
			}
			printArray("idx= " + j + " 1", array);
		}
		printArray("After: ", array);
		System.out.println("Number of comparisons = " + count);
		return array;
	}

	private int[] bubbleSort2(int []array) {
		// Enhanced to not sort already sorted data, and to stop when the array is sorted.
		int count = 0;
		boolean changesMade = false;
		int numsToCompare = array.length-1;

		printArray("Before: ", array);
		for (int j = 0; j < array.length; j++) {
			changesMade = false;
			for (int i = 0; i < numsToCompare; i++) {
				count++;
				if (array[i] > array[i+1]) {
					changesMade = true;
					// swap them
					int tmp = array[i];
					array[i] = array[i+1];
					array[i+1] = tmp;
				}
			}

			numsToCompare--;
			printArray("idx=" + j, array);
			if (!changesMade) {
				break;
			}
		}
		printArray("After: ", array);
		System.out.println("Number of comparisons = " + count);
		return array;
	}

	private int[] selectionSort(int []array) {
		int max = array.length-1;
		int currentLargestIndex;

		printArray("Before: ", array);
		for (int j = 0; j < array.length; j++) {

			currentLargestIndex = 0;
			for (int i = 0; i <= max; i++) {
				if (array[currentLargestIndex] < array[i]) {
					currentLargestIndex = i;
				}
			}

			int tmp = array[currentLargestIndex];
			array[currentLargestIndex] = array[max];
			array[max] = tmp;
			max--;

			printArray("idx= " + j + " 1", array);

		}
		printArray("After: ", array);
		return array;
	}


	private int[] insertionSort(int []array) {
		int []newArray = new int[array.length];
		int max = array.length-1;
		int currentLargestIndex;

		printArray("Before: ", array);
		for (int j = 0; j < array.length; j++) {

			currentLargestIndex = 0;
			for (int i = 0; i < array.length; i++) {
					if (array[currentLargestIndex] < array[i]) {
						currentLargestIndex = i;
					}
			}

			newArray[max] = array[currentLargestIndex];
			array[currentLargestIndex] = Integer.MIN_VALUE;
			max--;

			printArray("idx= " + j + " 1", newArray);

		}
		printArray("After: ", newArray);
		return newArray;
	}

}
