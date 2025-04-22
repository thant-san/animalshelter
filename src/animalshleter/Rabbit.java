package animalshelter;

// Rabbit class extending BaseAnimal
public class Rabbit extends BaseAnimal {

    // Constructor for Rabbit
    public Rabbit(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    // Return the type of animal
    @Override
    public String getType() {
        return "Rabbit";
    }
}
