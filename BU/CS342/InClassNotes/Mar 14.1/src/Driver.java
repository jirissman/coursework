
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt2();
	}
	
	public void doIt() {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		System.out.println(q);
		q.add(12);
		q.add(22);
		q.add(32);
		q.add(42);
		System.out.println(q);
		
		System.out.println(q.peek());
		
		for (int i = 0; i < 3; i++) {
			System.out.println(q.remove());
		}
		
		System.out.println(q);
		
		q.add(13);
		q.add(23);
		q.add(33);
		q.add(43);
		
		System.out.println(q);
		
		q.add(55);
		
		System.out.println(q);

	}
	
	private void doIt2() {
		BankSim sim = new BankSim();
		sim.setup();
		sim.runSim();
		sim.printResult();
	}

}
