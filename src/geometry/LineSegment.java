package geometry;

import geometry.CartesianCoordinate;
import java.awt.Color;

public class LineSegment {
	private Color Drawingcolour;
	private CartesianCoordinate startPoint; // Gathers the Cartesian values for the first X and Y//
	private CartesianCoordinate endPoint; // Gathers the Cartesian values for the second X and Y// 
	public LineSegment(CartesianCoordinate startPoint, CartesianCoordinate endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	public Color getColor() { return Drawingcolour;} 
	public CartesianCoordinate getStartPoint() { return startPoint;}
	public CartesianCoordinate getEndPoint() { return endPoint;}
	
	@Override
	public String toString() {
		return "LineSegment: startPoint = " + startPoint + ", endPoint = " + endPoint;
	}
}