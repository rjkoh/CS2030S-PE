/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

class Customer extends Person {
  public Customer(String name) {
    super(name);
  }

  @Override
  public String toString() {
    return "Customer: " + super.toString();
  }
}
