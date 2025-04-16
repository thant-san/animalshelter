package animalshelter;
public class Bird extends BaseAnimal {
    public Bird(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    @Override
    public String getType() {
        return "Bird";
    }
}

