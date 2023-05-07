package LinkedList;

public class TemplateNode <E> {
	private E data;
	private TemplateNode<E> next;
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public TemplateNode<E> getNext() {
		return next;
	}
	public void setNext(TemplateNode<E> next) {
		this.next = next;
	}
}
