/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

class Gym {
  private int capacity;
  private int count;

  public Gym(int capacity) {
    this.capacity = capacity;
    this.count = 0;
  }

  public void enter(Person p) {
    if (this.capacity > count) {
      System.out.println(p.toString() + " can enter");
      this.count++;
    } else {
      System.out.println(p.toString() + " cannot enter");
    }
  }

  @Override
  public String toString() {
    return String.format("Gym Capacity: %s/%s", this.count, this.capacity);
  }
}
