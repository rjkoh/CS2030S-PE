/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

class Dumbbell extends Equipment {
  private final double weight;
  private int repairCount;

  public Dumbbell(double weight) {
    super();
    this.weight = weight;
    this.repairCount = 0;
  }

  @Override
  public void repair() {
    this.repairCount++;
  }

  public double getWeight() {
    return this.weight;
  }

  public int getRepairCount() {
    return this.repairCount;
  }

  @Override
  public String toString() {
    return String.format("Dumbbell: %s kg", this.getWeight());
  }

}
