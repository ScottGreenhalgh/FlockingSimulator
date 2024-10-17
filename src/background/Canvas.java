package background;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import geometry.CartesianCoordinate;
import geometry.LineSegment;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;
	private int xSize, ySize;
	private List<LineSegment> lines;
	private final static int DEFAULT_X = 800;
	private final static int DEFAULT_Y = 600;
	//Default constructor which produces a canvas of the default size of 800 x 600.
	public Canvas() {
		this(DEFAULT_X, DEFAULT_Y);
	}
	//Constructor which produces a canvas of a specified size.
	public Canvas(int x, int y) {
		xSize = x;
		ySize = y;
		setupCanvas();
		lines = Collections.synchronizedList(new ArrayList<LineSegment>());
	}
	private void setupCanvas() {
		setSize(xSize, ySize);
		setVisible(true);
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 																						
		g2.setStroke(new BasicStroke(3));
		synchronized (lines) {
			for (LineSegment line : lines) {
				g2.draw(new Line2D.Double(line.getStartPoint().getX(), line.getStartPoint().getY(),
						line.getEndPoint().getX(), line.getEndPoint().getY()));
			}
		}
	}
	 // Draws a line between two CartesianCoordinates to the canvas.
	public void drawLineBetweenPoints(CartesianCoordinate startPoint, CartesianCoordinate endPoint) {
		synchronized (lines) {
			lines.add(new LineSegment(startPoint, endPoint));
		}
		repaint();
	}
	 //Draws a line segment to the canvas.
	public void drawLineSegment(LineSegment lineSegment) {
		synchronized (lines) {
			lines.add(lineSegment);
		}
		repaint();
	}
	 //Draws multiple line segments to the canvas.
	public void drawLineSegments(LineSegment[] lineSegments) {
		for (LineSegment thisLineSegment : lineSegments) {
			synchronized (lines) {
				lines.add(thisLineSegment);
			}
		}
		repaint();
	}
	public void removementMostRecentLine() {
		synchronized (lines) {
			if (lines.size() == 0)return;
			lines.remove(lines.size() - 1);
		}
	}
	// clears canvas
	public void clear() {
		synchronized (lines) {
			lines.clear();
		}
		repaint();
	}
}