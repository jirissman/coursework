package MidtermNotes;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] queue = new Integer[10];

		for (int i = 0; i < queue.length; i++) {
			queue[i] = i;
		}
		for (int i = 0; i < queue.length; i++) {
			if (5 + i < queue.length) {
				System.out.println(queue[5 + i]);
			} else {
				System.out.println(queue[5 + i - queue.length]);
			}
		}

	}

}
