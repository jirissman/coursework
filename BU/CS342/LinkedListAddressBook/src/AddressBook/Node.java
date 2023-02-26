package AddressBook;

public class Node {
	private String name;
	private String email;
	private String phone;
	private Node next;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public String getLast() {
		String[] arr = name.split("\\s+");
		return arr[arr.length-1];
	}
	@Override
	public String toString() {
		return "[name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
}
