/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

abstract class Equipment {
  private boolean inUse;

  public void setInUse(boolean b) {
    this.inUse = b;
  }

  public boolean isInUse() {
    return this.inUse;
  }

  abstract void repair();
}
