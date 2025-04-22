package animalshelter;

// Bird class extending BaseAnimal
public class Bird extends BaseAnimal {

    // Constructor for Bird
    public Bird(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    // Return the type of animal
    @Override
    public String getType() {
        return "Bird";
    }
}
