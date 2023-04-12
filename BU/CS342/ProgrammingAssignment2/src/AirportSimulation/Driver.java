package AirportSimulation;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt();
	}

	public void doIt() {
		Simulation airportSim = new Simulation();
		airportSim.runSimulation();
		airportSim.outputResults();
	}
}
