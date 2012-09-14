
public class Milestone3 {
	
	private Tracker tracker;
	private int currentX;
	private int currentY;
	
	/*
	 * Set the first location to 0,0 and then navigate the grid 
	 *
	 * 
	 * @param currentX
	 * @param currentY
	 * @return X and Y
	 
	 */
	public Milestone3(Tracker tracker) {
		this.tracker = tracker;
		currentX = 0;
		currentY = 0;
	}
	
	public void toCoordinate() {
		int turnValue = 0;
		toCoordinate(turnValue);
	}
	
	private void toCoordinate(int turnValue) {
		ButtonCounter buttonCounter = new ButtonCounter();
		System.out.println("Set Coordinates. Current position: ");
		buttonCounter.count(currentX, currentY);
		int x = buttonCounter.getX();
		int y = buttonCounter.getY();
		if (x < 0 || y < 0 || x > 6 || y > 8 ) {
			System.out.println("Enter new coordinates! ");
			toCoordinate(turnValue);
		}
		if (x == currentX && y == currentY) {
			System.out.println("Your are already in this position. Enter new coordinates! ");
			toCoordinate(turnValue);
		}
		toCoordinate(x, y, turnValue);
	}
	
	
	private void toCoordinate(int x, int y, int turnValue) {
		int diffX = x - currentX;
		int diffY = y - currentY;
		int turnDirectionY = 1;
		if (diffX < 0) {
			tracker.turn(2);
			turnDirectionY = -1;
			turnValue = turnValue + 2;
		}
		tracker.trackLine(Math.abs(diffX));
		if (diffY < 0) {
			tracker.turn(turnDirectionY);
			turnValue = turnValue - turnDirectionY;
		} 
		if (diffY > 0){
			tracker.turn(turnDirectionY*-1);
			turnValue = turnValue - turnDirectionY*-1;
		}
		tracker.trackLine(Math.abs(diffY));
		if(turnValue == 3) {
			turnValue = -1;
		}
		currentX = x;
		currentY = y;
		tracker.stop();
		toCoordinate(turnValue);
	}

}
