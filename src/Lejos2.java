
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;


public class Lejos2 {

	/**
	 * method does: main class for testing all the mile stones
	 * 
	 * @param args
	 * @return toCoordinate();
	 */
	public static void main(String[] args) {
		DifferentialPilot pilot = new DifferentialPilot(5.6, 11.9, Motor.C, Motor.A, false);
		LightSensor leftEye = new LightSensor(SensorPort.S1);
		LightSensor rightEye = new LightSensor(SensorPort.S4);
		Tracker tracker = new Tracker(pilot, leftEye, rightEye);
		tracker.calibrate();
		Milestone3 milestone3 = new Milestone3(tracker);
		milestone3.toCoordinate();
		//tracker.trackAndTurn();
		//tracker.trackAnEight();
		//tracker.gridNavigation();
	}

}
