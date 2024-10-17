package turtle;

import java.awt.Color;
import java.util.Random;
import background.Canvas;
import geometry.CartesianCoordinate;
import tools.Entities;

public class SecondTurtle extends Entities {
	private double angularVelocity;
	private Random randGen;
	public SecondTurtle(Canvas canvas, CartesianCoordinate Start,Color colour) {
		super(canvas, Start,colour);
		angularVelocity = 0.0;
		randGen = new Random();
	}
	public SecondTurtle(Canvas canvas, double xPosition, double yPosition) {
		super(canvas, xPosition, yPosition);
		angularVelocity = 0.0;
		randGen = new Random();
	}
	public void update(int time) {
		int distance;
		distance = (int) (getSpeed() * (time / (float) MILLI));
		int randomTurn = randGen.nextInt(100);
		if (randomTurn < 5) {
			int randTheta = randGen.nextInt(360) - 180;
			angularVelocity = randTheta * (time / (float) MILLI);
		}
		turn(angularVelocity);
		movement(distance);
	}
}