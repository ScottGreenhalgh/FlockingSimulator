/*package main;

import java.util.ArrayList;
import java.util.List;

import tools.Entities;;

public class Manager {
  private static Manager Manager = new Manager();

  private List<Entities> turtles = new ArrayList<Entities>();
  private List<Entities> predators = new ArrayList<Entities>();
  private Manager() {
  }
  public List<Entities> getTurtles() {
    return turtles;
  }
  public List<Entities> getPredators() {
    return predators;
  }
  public void addTurtle(Entities turtle) {
    turtles.add(turtle);
  }
  public void addPredator(Entities predator) {
    predators.add(predator);
  }
  public Entities findNearest(Entities finder, List<Entities> turtles) {
    double distance = 0.0;
    Entities found = finder;
    for (Entities Turtle : turtles) {
      if (Turtle.equals(finder)) {
        continue;
      }
      double turtleDistance = finder.distance(Turtle);
      if (distance == 0.0 || turtleDistance < distance) {
        distance = turtleDistance;
        found = Turtle;
      }
    }
    return found;
  }
  public Entities findNearestTurtle(Entities finder) {
    return findNearest(finder, turtles);
  }
  public Entities findNearestPredator(Entities finder) {
    return findNearest(finder, predators);
  }
  public void setPredators(List<Entities> predators) {
    this.predators = predators;
  }
  public static Manager getInstance() {
    return Manager;
  }
}*/
