package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import tools.Entities;
import turtle.SecondTurtle;
import tools.Utils;
import background.Canvas;
import geometry.CartesianCoordinate;

public class Main {
	private JButton addTurtle;
	private JButton delTurtle;
	private JButton addPred;
	private List<Entities> turtles;
	private List<Entities> predator;
	private JButton button;
	private JLabel sliderName;
	private JLabel sliderName1;
	Canvas canvas = new Canvas();

	public Main() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		final JSlider slider;
		//JSlider slider = new JSlider();
		JSlider slider1 = new JSlider();
		JSlider slider2 = new JSlider();
		JPanel pSlider = new JPanel();
		sliderName = new JLabel();
		sliderName1 = new JLabel();
		slider = new JSlider(0, 1000, 100);
		slider1 = new JSlider(0, 100, 50);
		slider2 = new JSlider(0, 100, 50);
		frame.setTitle("Turtle Frame");
		frame.setSize(800, 600);

		turtles = new ArrayList<Entities>();
		predator = new ArrayList<Entities>();
		button = new JButton("click Press me!");
		frame.add(canvas, BorderLayout.CENTER);

		//addPred.addActionListener(new ButtonListener()); //possible removal
		
		addTurtle = new JButton("Click to Create");
		addPred = new JButton("Add Predator");
		delTurtle = new JButton("Delete Turtle");
		slider.setPaintTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(500);
		slider.setMinorTickSpacing(100);

		slider1.setPaintTicks(true);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMajorTickSpacing(50);
		slider1.setMinorTickSpacing(5);

		slider2.setPaintTicks(true);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.setMajorTickSpacing(50);
		slider2.setMinorTickSpacing(5);

		sliderName.setText("TurtleSpeed =" + slider.getValue());
		sliderName1.setText("Turtle =" + slider1.getValue());
		
		panel.add(addTurtle, BorderLayout.EAST);
		panel.add(addPred, BorderLayout.SOUTH);
		panel.add(delTurtle, BorderLayout.WEST);
		panel.add(button, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.NORTH);

		pSlider.add(slider, BorderLayout.SOUTH);
		pSlider.add(sliderName, BorderLayout.EAST);
		pSlider.add(slider1, BorderLayout.SOUTH);
		pSlider.add(sliderName1, BorderLayout.WEST);
		pSlider.add(slider2, BorderLayout.SOUTH);
		frame.add(pSlider, BorderLayout.SOUTH);
		//Increases the speed of the slider//
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				for(int i=0;i<turtles.size();i++)
				turtles.get(i).setSpeed(slider.getValue());
			}
		});
		//Adds the turtle to the screen//
		addTurtle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random radomTurtle = new Random();
				turtles.add( new SecondTurtle(canvas,
				new CartesianCoordinate(radomTurtle.nextInt(600), radomTurtle.nextInt(600)), Color.magenta));
				button.setText("TURTLES ADDED");
				for (int i =0;i<turtles.size();i++){
					turtles.get(i).setSpeed(slider.getValue());	
			}
			}
		});
		delTurtle.addActionListener(e -> {
			if (turtles.size() ==  0)return;
			turtles.get(turtles.size()-1).undraw();
			turtles.remove(turtles.size()-1);
		});
		addPred.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random randomTurtle = new Random();
				predator.addAll(extracted(randomTurtle));
			}

			private Collection<? extends Entities> extracted(Random randomTurtle) {
				return (Collection<? extends Entities>) new SecondTurtle(canvas,new CartesianCoordinate(randomTurtle.nextInt(500), randomTurtle.nextInt(400)), Color.RED);
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.revalidate();
	}
	private void loop() {
		int deltaTime = 20;
		boolean continueRunning = true;
		while (continueRunning) {
			for (Entities turtle : turtles) {
				turtle.undraw();
			}
			for (Entities addPredator : predator) {
				addPredator.undraw();
			}
			for (Entities turtle : turtles) {
				turtle.update(deltaTime);
			}
			for (Entities addPredator : predator) {
				addPredator.update(deltaTime);
			}
			for (Entities turtle : turtles) {
				turtle.draw();
				turtle.wrapPosition(800,600);
			}
			for (Entities addPredator : predator) {
				addPredator.draw();
			}
			Utils.pause(deltaTime);
		}
	}
	private void secondLoop() {
		int deltaTime = 20;
		boolean continueRunning = true;
		while (continueRunning) {
			for (Entities addPredator : predator) {
				addPredator.undraw();
			}
			for (Entities addPredator : predator) {
				addPredator.update(deltaTime);
				addPredator.wrapPosition(800,600);
			}
			for (Entities addPredator : predator) {
				addPredator.draw();
			}
			Utils.pause(deltaTime);
		}
	}
	public static void main(String[] args) {
		Main callMain = new Main();
		callMain.loop();
	}
}
