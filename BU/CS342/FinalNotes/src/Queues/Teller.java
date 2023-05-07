package Queues;


public class Teller {

	private int timeCustomerArrived;
	private int transactionTime;
	private boolean busy;
	
	public int getTimeCustomerArrived() {
		return timeCustomerArrived;
	}
	public void setTimeCustomerArrived(int timeCustomerArrived) {
		this.timeCustomerArrived = timeCustomerArrived;
	}
	public int getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(int transactionTime) {
		this.transactionTime = transactionTime;
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
}
