package animalshelter;

/**
 * Abstract base class for all animal types in the shelter.
 * Defines common properties and behavior that every animal should have.
 */
public abstract class BaseAnimal {
    // Common properties for all animals
    protected String name;
    protected int age;
    protected String breed;
    protected String arrivalDate;
    protected boolean isAdopted;

    /**
     * Constructor to initialize an animal's details.
     *
     * @param name        Name of the animal
     * @param age         Age of the animal
     * @param breed       Breed of the animal
     * @param arrivalDate Date the animal arrived at the shelter
     * @param isAdopted   Adoption status of the animal
     */
    public BaseAnimal(String name, int age, String breed, String arrivalDate, boolean isAdopted) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.arrivalDate = arrivalDate;
        this.isAdopted = isAdopted;
    }

    /**
     * Abstract method that must be implemented by all subclasses to return the animal type.
     *
     * @return Animal type as a string (e.g. "Dog", "Cat").
     */
    public abstract String getType();

    /**
     * Converts the animal's data into a single line of comma-separated values.
     * Used for saving data to a file.
     *
     * @return Formatted string for file storage.
     */
    public String toFileString() {
        return getType() + "," + name + "," + age + "," + breed + "," + arrivalDate + "," + isAdopted;
    }

    /**
     * Returns a formatted string containing the animal's information.
     * Used for displaying animal details in the console.
     *
     * @return Human-readable description of the animal.
     */
    public String getInfo() {
        return getType() + " | Name: " + name + " | Age: " + age + " | Breed: " + breed +
               " | Arrival: " + arrivalDate + " | Adopted: " + (isAdopted ? "Yes" : "No");
    }
}
