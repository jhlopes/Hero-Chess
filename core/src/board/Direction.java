package board;

public enum Direction {

	TOP_LEFT(45), TOP_RIGHT(-20), LEFT(90), RIGHT(-90), BOTTOM_LEFT(135), BOTTOM_RIGHT(225);
	
	private int value;
	
	private Direction(int value) {
		this.value = value;
	}
	
	public int angle() {
		return value;
	}
	
}
