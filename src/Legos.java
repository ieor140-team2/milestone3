import lejos.nxt.Battery;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;


public class Legos {

	
	public static void main(String[] args) {	
		DifferentialPilot pilot = new DifferentialPilot(5.6, 11.9, Motor.C, Motor.A, false); // parameters in inches
		pilot.setRotateSpeed(150); 
		pilot.setTravelSpeed(25);
		pilot.setAcceleration(1000);
		go(pilot);	
	}
	
	/** Makes the robot do two polygons and two circles **/
	public static void go(DifferentialPilot pilot) {
		polygon(pilot, 61, 3, true); 
		polygon(pilot, 61, 5, false);
		circle(pilot, 180, 91.48, true);
		circle(pilot, 90, 30.48, false);
	}
	
	/** Makes the robot trace a polygon
	@param Diffentail pilot
	@param the length of the sides of the polygon
	@param the number of sides in the polygon
	@param the direction of the robot, if true the robot turns left, if false the robot turns right **/
	public static void polygon(DifferentialPilot pilot, int sidesLength, int numberOfSides, boolean direction) {
		Button.waitForAnyPress(); 
		int i = 1;
		if (direction) {
			i = -1;
		}
		for (int k = 0; k < numberOfSides; k++) {
			pilot.travel(sidesLength);
			pilot.rotate(i*(180-((180*(numberOfSides-2))/numberOfSides))); 
		}
	}
	
	/** Makes the robot trace a circle
	@param Diffentail pilot
	@param the degree of witch the NXT robot will turn 
	@param the radius that the NXT robot moves along
	@param the direction of the robot, if true the robot turns left, if false the robot turns right **/
	public static void circle(DifferentialPilot pilot, double degree, double radius, boolean direction) {
		Button.waitForAnyPress(); 
		int j = 1;
		if (direction) {
			j = -1;
		}
		pilot.arc(j*radius, j*degree);
	}
	
	
	
	
	
	
	public static void go1(){
		Button.waitForAnyPress();
		Motor.A.forward();
		Delay.msDelay(2000);
		Motor.A.stop();
		System.out.println(Motor.A.getTachoCount());
			
		Motor.A.backward();
		Delay.msDelay(2000);
		Motor.A.stop();
		System.out.println(Motor.A.getTachoCount());
			
		Motor.A.rotate(360);
		System.out.println(Motor.A.getTachoCount());
			
		Button.waitForAnyPress();
	}

	public static void go2() {
		Button.waitForAnyPress();
		Motor.A.setAcceleration(6000);
		Motor.A.setSpeed(700);
		Motor.A.resetTachoCount();
		Motor.A.forward();
		while(Motor.A.getTachoCount() < 720) {	
		}
		System.out.println(Motor.A.getTachoCount());
		Motor.A.stop();
		System.out.println(Motor.A.getTachoCount());
		Motor.A.resetTachoCount();
		Motor.A.setSpeed(350);
		Motor.A.forward();
		while(Motor.A.getTachoCount() < 720) {	
		}
		System.out.println(Motor.A.getTachoCount());
		Motor.A.stop();
		System.out.println(Motor.A.getTachoCount());
		Motor.A.resetTachoCount();
		Motor.A.setAcceleration(20000);
		Motor.A.setSpeed(700);
		Motor.A.forward();
		while(Motor.A.getTachoCount() < 720) {	
		}
		System.out.println(Motor.A.getTachoCount());
		Motor.A.stop();
		System.out.println(Motor.A.getTachoCount());
		Motor.A.resetTachoCount();
	}
	
	public static void go3(int s) {
		Motor.A.setSpeed(s);
		Motor.C.setSpeed(s);
		Motor.A.forward();
		Motor.C.forward();
		Delay.msDelay(2000);
		Motor.A.stop();
		Motor.C.stop();
		System.out.println(Motor.A.getTachoCount());
		System.out.println(Motor.C.getTachoCount());
		System.out.println(Battery.getVoltage());
	}
	
	public static void go4() {
		Motor.A.setSpeed(800);
		Motor.C.setSpeed(800);
		Motor.A.rotate(720, true);
		Motor.C.rotate(-720);
		System.out.println(Motor.A.getTachoCount());
		System.out.println(Motor.C.getTachoCount());
		Button.waitForAnyPress();
	}
	
	public static void square(int r) {
		Button.waitForAnyPress();
		Motor.A.setAcceleration(1000);
		Motor.C.setAcceleration(1000);
		Motor.A.setSpeed(500);
		Motor.C.setSpeed(500);
		for(int k=0; k < 8; k++)  { 	
			Motor.A.rotate(1871, true);
			Motor.C.rotate(1871);
			Motor.A.stop();
			Motor.C.stop();
			Motor.A.rotate(r, true);
			Motor.C.rotate(-r);
		}
		
		for(int k=0; k < 8; k++)  { 	
			Motor.A.rotate(-r, true);
			Motor.C.rotate(r);
			Motor.A.stop();
			Motor.C.stop();
			Motor.A.rotate(-1871, true);
			Motor.C.rotate(-1871);
		}
	}
	
	
	 
}
