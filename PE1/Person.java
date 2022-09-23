/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

abstract class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
