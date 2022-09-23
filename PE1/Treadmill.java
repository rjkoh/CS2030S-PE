/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

class Treadmill extends Equipment {
  private double speed;

  public Treadmill() {
    super();
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getSpeed() {
    return this.speed;
  }

  public void repair() {
    setSpeed(0);
  }

  @Override
  public String toString() {
    return String.format("Treadmill: %s km/h", this.getSpeed());
  }
}
