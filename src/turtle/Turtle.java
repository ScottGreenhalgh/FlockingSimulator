package turtle;

import java.awt.Color;
import background.Canvas;
import geometry.CartesianCoordinate;
import tools.Utils;

public class Turtle {
	private double angle;
	private Canvas myCanvas;
	private CartesianCoordinate currentPosition;
	private CartesianCoordinate newPosition;
	boolean PenDown;
	boolean PenUp;
	boolean keepFlashingTurtle;
	private Color colour;
	// private double radius;
	public Turtle(Canvas canvas, CartesianCoordinate Start, Color colour) {
		angle = 0;
		this.myCanvas = canvas;
		this.currentPosition = Start;
		this.PenDown = true;
		this.keepFlashingTurtle = true;
		this.colour = colour;
		// this.radius=radius;
	}
	public Turtle(Canvas canvas, double xPosition, double yPosition) {
		newPosition = new CartesianCoordinate(xPosition, yPosition);
		angle = 0;
		this.myCanvas = canvas;
		this.currentPosition = new CartesianCoordinate(xPosition, yPosition);
		this.PenDown = true;
		this.keepFlashingTurtle = true;
		// TODO Auto-generated constructor stub
	}
	 //@param i The number of pixels to movement.
	public void movement(int i) {
		{
			double endX = currentPosition.getX() + i * Math.cos(Math.toRadians(angle));
			double endY = currentPosition.getY() + i * Math.sin(Math.toRadians(angle));
			newPosition = new CartesianCoordinate(endX, endY);

			// Add new x and y values into CartesianCoordinate called end
			if (PenDown) {
				myCanvas.drawLineBetweenPoints(currentPosition, newPosition);
			}
			currentPosition = newPosition;
		}
		}
	// currentPosition =new CartesianCoordinate(endX,endY);
	// @param i The number of degrees to turn.
	public void turn(double i) {
		angle += i;
		if (angle < 0) {
			angle += 360;
		}
	}
	public void putPenUp() {
		// TODO Auto-generated method stub
		this.PenDown = false;
	}
	public void putPenDown() {
		// TODO Auto-generated method stub
		this.PenDown = true;
	}
	public void undraw() {
		myCanvas.removementMostRecentLine();
		myCanvas.removementMostRecentLine();
		myCanvas.removementMostRecentLine();
		myCanvas.removementMostRecentLine();
		myCanvas.removementMostRecentLine();
	}
	public void draw() {
		putPenDown();
		turn(180);
		movement(15);
		turn(180);
		movement(15);
		turn(150);
		movement(30);
		turn(120);
		movement(30);
		turn(120);
		movement(30);
		turn(-30);
		putPenUp();
	}
	public void keepFlashingTurtle() {
		keepFlashingTurtle = true;
		while (keepFlashingTurtle) {
			draw();
			Utils.pause(1000);
			undraw();
			keepFlashingTurtle = false;
		}
	}
	public double getPositionX() {
		return currentPosition.getX();
	}
	public double getPositionY() {
		return currentPosition.getY();
	}
	public void setCurrentPosition(CartesianCoordinate currentPosition) {
		this.currentPosition = currentPosition;
	}
	public void wrapPosition(int maximumX, int maximumY) {
		maximumX = 800;
		maximumY = 600;
		if (currentPosition.getX() > maximumX) {
			currentPosition.setX(0);
		} else if (currentPosition.getX() <0) {
			currentPosition.setX(maximumX);
		} else if (currentPosition.getY() <0) {
			currentPosition.setY(maximumY);
		} else if (currentPosition.getY() > maximumY) {
			currentPosition.setY(0);
		}
	}
}

