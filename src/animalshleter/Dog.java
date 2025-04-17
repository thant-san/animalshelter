package animalshelter;

public class Dog extends BaseAnimal {
    public Dog(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    @Override
    public String getType() {
        return "Dog";
    }
}
