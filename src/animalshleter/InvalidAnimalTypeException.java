package animalshelter;

// Custom exception for handling invalid animal types
public class InvalidAnimalTypeException extends Exception {
    public InvalidAnimalTypeException(String message) {
        super(message);
    }
}
