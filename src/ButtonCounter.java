import lejos.nxt.Button;


public class ButtonCounter {
	
	private int x = 0;
	private int y = 0;
	
	/*
	 * Read the button to get the coordinates from the operator
	 * Exit button breaks the loop
	 * 
	 * /**
	 * method does: main class for testing all the mile stones
	 * 
	 * @param currentX
	 * @param currentY
	 * @return X and Y
	 */
	 
	public void count(int currentX, int currentY) {
		x = currentX;
		y = currentY;
		boolean loop = true;
		
		while(loop) {
			System.out.println(" x:" + x + "      y:" + y);
			int ButtonID = Button.waitForAnyPress();
			
			if (ButtonID == 2) {
				x++;
			}
			
			if (ButtonID == 3) {
				x--;
			}
			
			if (ButtonID == 4) {
				y++;
			}
			
			if (ButtonID == 5) {
				y--;
			}
			
			if (ButtonID == Button.ESCAPE.getId()) {
				loop = false;
			}
			
		}
	}
	/*
	 * Returns x-coordinate value
	 */
	public int getX() {
		return x;
	}
	/*
	 * Returns y-coordinate value
	 */
	public int getY() {
		return y;
	}

}
