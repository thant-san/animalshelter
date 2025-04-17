package animalshelter;

public class Cat extends BaseAnimal {
    public Cat(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        super(name, age, breed, arrivalDate, isAdopted);
    }

    @Override
    public String getType() {
        return "Cat";
    }
}
