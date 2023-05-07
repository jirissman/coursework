
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		ArrayBag bag = new ArrayBag();
		
		bag.add(25);
		bag.add(35);
		bag.add(45);
		bag.add(25);
		System.out.println(bag);
		
		bag.remove(35);
		
		System.out.println(bag);
		
		System.out.println(bag.getCapacity());
		bag.ensureCapacity(50);
		System.out.println(bag.getCapacity());
		System.out.println(bag.size());
		bag.trimToSize();
		System.out.println(bag.getCapacity());
		System.out.println(bag.size());
		
		
	}

}
