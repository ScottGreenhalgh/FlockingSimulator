package tools;

import java.awt.Color;
import background.Canvas;
import geometry.CartesianCoordinate;

public class Entities extends turtle.Turtle {
	private int speed = 100;
	protected int MILLI = 1000;
	public Entities(Canvas canvas, double xPos, double yPos) {
		super(canvas, xPos, yPos);
		// draw();
	}
	public Entities(background.Canvas canvas, CartesianCoordinate Start, Color colour) {
		super(canvas, Start, colour);
		draw();
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void update(int time) {
		int distance;
		distance = (int) (speed * (time / (float) MILLI));
		movement(distance);
	}
}
