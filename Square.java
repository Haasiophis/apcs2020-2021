public class Square {

	private String xOrO;
	private boolean selected;
	private String display;

	// unselected, blank square
	public Square(String XO) {
		xOrO = XO;
		selected = false;
		display = "[ ]";
	}

	// selected, X
	public void addX() {
		selected = true;
		display = "[X]";

	}

	// selected, O
	public void addO() {
		selected = true;
		display = "[O]";

	}

	// prints out if the box is selected
	public boolean getSelected() {
		return selected;
	}

	// prints out what the box contains
	public String getValue() {
		return xOrO;
	}

	// shows
	public String toString() {
		return display;
	}
}
