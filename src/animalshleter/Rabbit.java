package animalshelter;

public class Rabbit extends BaseAnimal {
    public Rabbit(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    @Override
    public String getType() {
        return "Rabbit";
    }
}
