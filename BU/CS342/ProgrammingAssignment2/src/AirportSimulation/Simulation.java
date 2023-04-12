package AirportSimulation;

import java.util.Random;

public class Simulation {
	// all times are in minutes
	private static final Integer timeToLand = 3; // amount of time needed for one plane to land
	private static final Integer timeToTakeoff = 4; // amount of time needed for one plane to takeoff
	private static final Integer rateOfLanding = 2; // average amount of time between arrival of planes to the landing
													// queue
	private static final Integer rateOfTakeoff = 1; // average amount of time between arrival of planes to the takeoff
													// queue
	private static final Integer maxTimeInQueue = 3; // maximum amount of time that a plane can stay in the landing
														// queue without running out of fuel and crashing
	private static final Integer timeToSimulate = 600; // total length of time to be simulated
	private DynamicQueue landingQueue = new DynamicQueue(); // queue of planes to land with time added to queue recorded
	private DynamicQueue takeoffQueue = new DynamicQueue(); // queue of planes to takeoff with time added to queue
															// recorded
	private Integer runwayStatus = 0; // time remaining until runway is free for the next plane
	private Integer planesArrived = 0; // number of planes that landed in the simulated time
	private Integer planesDeparted = 0; // number of planes that took off in the simulated time
	private Integer planesCrashed = 0; // number of planes that crashed because they ran out of fuel before they could
										// land
	private Integer timeInLandingQueue = 0; // total time a plane spent in the takeoff queue
	private Integer timeInTakeoffQueue = 0; // total time that a plane spent in the landing queue
	private static final int randomSeed = 1; // seed for the random number generator
	private Random rng = new Random(randomSeed);

	/**
	 * Runs the airport simulation for the specified amount of time with the
	 * specified parameters. (parameters set in class definition)
	 */
	public void runSimulation() {
		// determine when first planes arrive
		Integer nextLandingArrivalTime = rng.nextInt(rateOfLanding * 2) + 1;
		Integer nextTakeoffArrivalTime = rng.nextInt(rateOfTakeoff * 2) + 1;

		// begin simulation
		for (Integer minute = 0; minute < timeToSimulate; minute++) {
			if (runwayStatus > 0) {
				runwayStatus--; // process plane currently on runway
			}
			if (nextLandingArrivalTime.equals(minute)) {
				landingQueue.add(minute); // add plane to landing queue and record when it was added
				nextLandingArrivalTime = minute + rng.nextInt(rateOfLanding * 2) + 1;
			}
			if (nextTakeoffArrivalTime.equals(minute)) {
				takeoffQueue.add(minute); // add plane to takeoff queue and record when it was added
				nextTakeoffArrivalTime = minute + rng.nextInt(rateOfTakeoff * 2) + 1;
			}
			if (runwayStatus == 0) {
				// runway is free for next plane to use
				if (!landingQueue.isEmpty()) {
					// landing queue is not empty and must be processed
					while (runwayStatus == 0 && !landingQueue.isEmpty()) { 
						// must loop here to handle unknown number of crashed planes
						Integer timeSpentInQueue = (minute - landingQueue.remove());
						if (timeSpentInQueue > maxTimeInQueue) {
							planesCrashed++;
						} else {
							timeInLandingQueue += timeSpentInQueue;
							planesArrived++;
							runwayStatus = timeToLand;
						}
					}
				} else if (!takeoffQueue.isEmpty()) {
					// landing queue is empty so takeoff queue can now be processed
					Integer timeSpentInQueue = (minute - takeoffQueue.remove());
					timeInTakeoffQueue += timeSpentInQueue;
					planesDeparted++;
					runwayStatus = timeToTakeoff;
				}
			}
		}
	}

	/**
	 * Outputs the simulation parameters and results to the console.
	 */
	public void outputResults() {
		System.out.println("Simulation Parameters");
		System.out.println("The amount of time needed for one plane to land: " + timeToLand);
		System.out.println("The amount of time needed for one plane to takeoff: " + timeToTakeoff);
		System.out
				.println("The average amount of time between arrival of planes to the landing queue: " + rateOfLanding);
		System.out
				.println("The average amount of time between arrival of planes to the takeoff queue: " + rateOfTakeoff);
		System.out.println(
				"The maximum amount of time that a plane can stay in the landing queue without running out of fuel and crashing: "
						+ maxTimeInQueue);
		System.out.println("The total length of time to be simulated: " + timeToSimulate);
		System.out.println("The seed for the random number generator: " + randomSeed);
		System.out.println("\nSimulation Results");
		System.out.println("Number of planes that took off: " + planesDeparted);
		System.out.println("Number of planes that landed: " + planesArrived);
		System.out.println("Number of planes that crashed: " + planesCrashed);
		// convert to float for average time because it's extremely unlikely to be a
		// whole number
		System.out.printf("Average time a plane spent in the takeoff queue: %.2f%n",
				((float) timeInTakeoffQueue / (float) planesDeparted));
		System.out.printf("Average time a plane spent in the landing queue: %.2f",
				((float) timeInLandingQueue / (float) planesArrived));
	}
}
