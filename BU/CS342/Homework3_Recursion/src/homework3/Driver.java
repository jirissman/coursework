package homework3;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.recursiveAsterisks(5);
		me.recursiveAsterisks(12);
		me.recursiveAsterisks(50);
		System.out.println(me.convert(1234));
		System.out.println(me.convert(97283457));
		System.out.println(me.convert(69179));
	}

	private void recursiveAsterisks(Integer n) {
		recursiveAsterisks(1, n);
	}

	private void recursiveAsterisks(Integer min, Integer max) {
		if (min.equals(max)) {
			// base case: print lines n, n + 1, and n + 2
			printAsterisks(min);
			printAsterisks(min);
			printAsterisks(min);
			return;
		} else {
			// recursive case: current number is less than n
			printAsterisks(min);
			recursiveAsterisks(min + 1, max);
			printAsterisks(min);
		}
	}

	private void printAsterisks(Integer n) {
		String asterisk = "*";
		System.out.println(asterisk.repeat(n));
	}

	private String convert(int num) {
		if (num < 10) {
			// base case: single digit number
			char num_char = (char) (num + 48);
			String rtn = "";
			rtn += num_char;
			return rtn;
		} else {
			// recursive case: multiple digit number
			char num_char = (char) (num % 10 + 48);
			return convert(num / 10) + num_char;
		}
	}
}
