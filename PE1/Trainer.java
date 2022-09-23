/**
 * CS2030S PE1 Question 1
 * AY21/22 Semester 2
 *
 * @author A0239234E
 */

class Trainer extends Person {
  private boolean available;
  private Customer customer;
  private Equipment equipment;

  public Trainer(String name) {
    super(name);
    this.available = true;
  }

  public void startTraining(Customer customer, Equipment equipment) throws CannotTrainException {
    if (this.available && !equipment.isInUse()) {
      this.available = false;
      this.customer = customer;
      this.equipment = equipment;
      equipment.setInUse(true);
    } else {
      throw new CannotTrainException();
    }
  }

  public void stopTraining() {
    this.available = true;
    this.customer = null;
    equipment.setInUse(false);
    this.equipment = null;
  }

  public String getStatus() {
    if (this.available) {
      return this.toString() + " not training";
    } else {
      return this.toString() + " training " + this.customer.toString();
    }
  } 

  @Override
  public String toString() {
    return "Trainer: " + super.toString();
  }
  
}
