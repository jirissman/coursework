package ContainerClasses;

public class Driver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver2 me = new Driver2();
		me.doIt();
	}

	private void doIt() {
		
		Base x = new Base();
		Base y = new Base();
		
		y.setData(23);
		System.out.println(y.getData());
		System.out.println(Base.temp);
		
		System.out.println(x.getData());
	}
}
