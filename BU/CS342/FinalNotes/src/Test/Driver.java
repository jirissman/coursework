package Test;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		String phrase = "How can mirrors be real if our eyes aren't real";
		System.out.println(me.toJadenCase(phrase));
		System.out.println(rowSumOddNumbers(1));
		System.out.println(rowSumOddNumbers(2));
		System.out.println(rowSumOddNumbers(3));
		System.out.println(rowSumOddNumbers(4));
	}

	public String toJadenCase(String phrase) {
		// TODO put your code below this comment
		String rtn = phrase;
		for (int i = 0; i < rtn.length(); i++) {
			if (i == 0) {
				rtn = rtn.substring(0, 1).toUpperCase() + rtn.substring(1);
			} else {
				if (rtn.substring(i - 1, i).equals(" ")) {
					rtn = rtn.substring(0, i) + rtn.substring(i, i + 1).toUpperCase() + rtn.substring(i + 1);
				}
			}
		}
		return rtn;
	}

	public static int findIt(int[] a) {
		int odd = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count % 2 == 1) {
				odd = a[i];
			}
		}
		return odd;
	}

	public static int rowSumOddNumbers(int n) {
		// TODO
		return n * n * n;
	}

	public static boolean isIsogram(String str) {
		String lower = str.toLowerCase();
		for (int i = 0; i < lower.length(); i++) {
			if (lower.indexOf(lower.charAt(i)) != i) {
				return false;
			}
		}
		return true;
	}

	public static String makeReadable(int seconds) {
		return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
	}
}
