package Queues;

import java.util.Random;

public class BankSim {

	private int simRunTimeInMinutes;
	private int averageArrivalRate;
	private int averageProcessingTime;
	private int numTellers;
	private Teller []tellers;
	private LinkedQueue<Integer> queue;
	private int customersProcessed;
	private int maxWaitTime;
	private int totalCustomers;
	
	public void setup() {
		this.simRunTimeInMinutes = 480;
		averageArrivalRate = 2;
		averageProcessingTime = 15;
		numTellers = 1;
		customersProcessed = 0;
		totalCustomers = 1;
		maxWaitTime = 0;
		tellers = new Teller[numTellers];
		for (int i = 0; i < numTellers; i++) {
			tellers[i] = new Teller();
		}
		queue = new LinkedQueue<Integer>();
	}
	
	public void runSim() {
		Random gen = new Random();
		int nextCustomerArrivalTime = gen.nextInt(averageArrivalRate*2) + 1;
		
		for (int minute = 0; minute < this.simRunTimeInMinutes; minute++) {
			if (nextCustomerArrivalTime == minute) {
				System.out.println("Customer arrived at minute " + minute);
				queue.add(minute);
				
				totalCustomers++;
				
				// Enqueue the next customer
				nextCustomerArrivalTime = minute + gen.nextInt(averageArrivalRate*2) + 1;
			}
			
			// See if a teller has completed a transaction
			for (int i = 0; i < numTellers; i++) {
				if (tellers[i].isBusy()) {
					if ((tellers[i].getTimeCustomerArrived() + tellers[i].getTransactionTime()) < minute) {
						tellers[i].setBusy(false);
						customersProcessed++;
						System.out.println("Teller #" + i + " Finished customer at minute " + minute);
						System.out.println("Processing took " + tellers[i].getTimeCustomerArrived() );
					}
				}
			}
			
			// See if a teller is available
			while (!queue.isEmpty()) {
				int i;
				for (i = 0; i < numTellers; i++) {
					if (!tellers[i].isBusy()) {
						
						// Add this customer to a teller
						Integer custTime = queue.remove();
						System.out.println("Teller got customer " + minute + " " + custTime);
						if ((minute - custTime) > maxWaitTime) {
							maxWaitTime = minute - custTime; 
						}
						
						System.out.println("Customer assigned to teller " + i);
						tellers[i].setBusy(true);
						tellers[i].setTimeCustomerArrived(custTime);
						tellers[i].setTransactionTime(gen.nextInt(averageProcessingTime*2)+1);
						break;
					}
				}	
				
				if (i == numTellers) {
					// All tellers are busy
					break;
				}
			}
		}
		
	}
	
	public void printResult() {
		System.out.println("Simulation Terminated");
		System.out.println("Total Customers              : " + totalCustomers);
		System.out.println("Total Customers processed    : " + customersProcessed);
		System.out.println("Total Customers left waiting : " + queue.size());
		System.out.println("Maximum wait time            : " + maxWaitTime);
	}
}
