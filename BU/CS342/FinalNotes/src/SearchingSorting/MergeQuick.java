package SearchingSorting;

public class MergeQuick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeQuick me = new MergeQuick();
//		me.doIt();
		// me.doIt2();
		me.doIt3();
	}

	public void doIt() {

		int[] array = { 23, 12, 45, 67, 2, 98, 89, 1, 129, 132, 138 };
		// int [] array = {12, 23, 67, 34, 45};
//		int [] a2 = array.clone();
		int[] a2 = new int[10];
		int num = a2.length;
		for (int i = 0; i < a2.length; i++) {
			a2[i] = num--;
		}
		a2 = array;

		re = 0;
		System.out.println(pa(a2, 0, a2.length));
		System.out.println("sorting");
		quickSort(a2, 0, a2.length - 1);
		// mergesort(a2, 0, a2.length);
		System.out.println("sorted");
		System.out.println(pa(a2, 0, a2.length));

		int[] a3 = { 1, 5, 6, 4, 7, 8 };

		// mergesort(a3, 0, a3.length);
		// System.out.println(re);
	}

	private void doIt2() {
		int[] array = new int[100000];
		int cnt = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			array[cnt--] = i + 5;
		}

		System.out.println("Array is built.");
		long start = System.currentTimeMillis();
		quickSort(array, 0, array.length - 1);
		// mergesort(array, 0, array.length);
		long end = System.currentTimeMillis();

		System.out.println("Sort took " + (end - start) + " milliseconds");

	}

	int re = 0;

	public void mergesort(int data[], int first, int n) {
		int n1;
		int n2;
		re++;

		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;

//			System.out.println(pa(data, first, n1));
//			System.out.println(pa(data, first+n1, n2));
			mergesort(data, first, n1);
			mergesort(data, first + n1, n2);

			merge(data, first, n1, n2);
		}
	}

	private void merge(int[] data, int first, int n1, int n2) {

		int[] temp = new int[n1 + n2];
		int copied = 0;
		int copied1 = 0;
		int copied2 = 0;
		int i;
		System.out.println("Merging...");
		System.out.println(pa(data, first, n1));
		System.out.println((pa(data, first + n1, n2)));
		System.out.println();

		while ((copied1 < n1) && (copied2 < n2)) {
			if (data[first + copied1] < data[first + n1 + copied2])
				temp[copied++] = data[first + (copied1++)];
			else
				temp[copied++] = data[first + n1 + (copied2++)];
		}

		// Copy all the left remaining elements. We don't need to
		// copy the right side, because they are already in in the right places.
		while (copied1 < n1) {
			temp[copied++] = data[first + (copied1++)];
		}

		for (i = 0; i < copied; i++) {
			data[first + i] = temp[i];
		}

		System.out.println(pa(data, first, n1 + n2));
	}

	private String pa(int[] array, int first, int len) {
		String rtn = "";

		for (int i = first; i < first + len; i++) {
			if (i < array.length)
				rtn += "[" + i + "] = " + array[i] + ", ";
			if ((i > 0) && ((i % 15) == 0)) {
				rtn += "\n";
			}
		}
		rtn += "\n";
		return rtn;
	}

	public int partition(int arr[], int left, int right)

	{

		int tooBigIndex = left, tooSmallIndex = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		System.out.println("Pivot is " + pivot);
		while (tooBigIndex <= tooSmallIndex) {
			while (arr[tooBigIndex] < pivot)
				tooBigIndex++;
			while (arr[tooSmallIndex] > pivot)
				tooSmallIndex--;

			if (tooBigIndex <= tooSmallIndex) {
				tmp = arr[tooBigIndex];
				arr[tooBigIndex] = arr[tooSmallIndex];
				arr[tooSmallIndex] = tmp;
				tooBigIndex++;
				tooSmallIndex--;
			}

		}

		return tooBigIndex;

	}

	void quickSort(int arr[], int left, int right) {
		// System.out.println("left " +left + " right " + right);
		int index = partition(arr, left, right);
		System.out.println(pa(arr, left, arr.length));
		if (left < index - 1)
			quickSort(arr, left, index - 1);

		System.out.println(pa(arr, left, arr.length));
		if (index < right)
			quickSort(arr, index, right);

	}

	private void doIt3() {
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		int[] merge = new int[20];
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		arr1[3] = 40;
		arr1[4] = 50;
		arr1[5] = 60;
		arr1[6] = 70;
		arr1[7] = 80;
		arr1[8] = 90;
		arr1[9] = 100;
		arr2[0] = 1;
		arr2[1] = 5;
		arr2[2] = 15;
		arr2[3] = 27;
		arr2[4] = 41;
		arr2[5] = 89;
		arr2[6] = 150;
		arr2[7] = 180;
		arr2[8] = 200;
		arr2[9] = 1000;
		merge(arr1, arr2, merge);
		System.out.println(merge.length);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(merge[i]);
		}
	}
	private void merge(int[] array1, int[] array2, int[] merged) {
		if (merged.length != array1.length + array2.length) {
			// merged array is not the correct size
			return;
		}
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < merged.length; i++) {
			if (index1 == array1.length) {
				// array1 is fully copied
				merged[i] = array2[index2++];
			} else if (index2 == array2.length || array1[index1] < array2[index2]) {
				// array1 has the smaller value or array2 is fully copied
				merged[i] = array1[index1++]; // increment index we just copied
			} else {
				// array2 has the smaller value or they are equal
				merged[i] = array2[index2++]; // increment index we just copied
			}
		}

	}
}
