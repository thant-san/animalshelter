package animalshelter;

public abstract class BaseAnimal {
    protected String name;
    protected int age;
    protected String breed;
    protected String arrivalDate;
    protected boolean isAdopted;

    public BaseAnimal(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.arrivalDate = arrivalDate;
        this.isAdopted = isAdopted;
    }

    public  abstract String getType();

    public String toFileString() {
        return getType() + "," + name + "," + age + "," + breed + "," + arrivalDate + "," + isAdopted;
    }

    public String getInfo() {
        return getType() + " | Name: " + name + " | Age: " + age + " | Breed: " + breed +
               " | Arrival: " + arrivalDate + " | Adopted: " + (isAdopted ? "Yes" : "No");
    }
}
