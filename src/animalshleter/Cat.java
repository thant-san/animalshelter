package animalshelter;

// Cat class that extends BaseAnimal
public class Cat extends BaseAnimal {

    // Constructor for Cat
    public Cat(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    // Return the type of animal
    @Override
    public String getType() {
        return "Cat";
    }
}
