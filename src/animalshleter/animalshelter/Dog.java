package animalshelter;

// Dog class that extends BaseAnimal
public class Dog extends BaseAnimal {

    // Constructor for Dog
    public Dog(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    // Return the type of animal
    @Override
    public String getType() {
        return "Dog";
    }
}
