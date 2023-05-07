package ContainerClasses;

public class Base {
		public static int temp;
		
		private int data;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
			temp = data;
		}
}
