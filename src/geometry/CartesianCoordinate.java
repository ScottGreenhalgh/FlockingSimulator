package geometry;

public class CartesianCoordinate {

	private double xPosition;
	private double yPosition;

	public CartesianCoordinate(double x, double y) {
		xPosition = x;
		yPosition = y;
	}
	public double getX() {
		return xPosition; 
	}
	public double getY() {
		return yPosition; 
	}
	public void setX(double x) {
		xPosition = x;
	}
	public void setY(double y) {
		yPosition = y;
	}
	public String toString() {
		return "X Position: " + xPosition + ", Y Position: " + yPosition;
	}
}