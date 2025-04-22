package animalshelter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();  // Create animal shelter instance to manage animals

        // Main menu loop
        int choice = -1; // Initialize with a non-zero value
        Scanner sc = new Scanner(System.in);
        
        do {
            try {
                // Display menu options
                System.out.println("\n Animal Shelter Management");
                System.out.println("1. Add New Animal");
                System.out.println("2. List All Animals");
                System.out.println("3. List Animals by Type");
                System.out.println("4. Mark Animal as Adopted");
                System.out.println("0. Exit");
                System.out.print("Select: ");
        
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline
        
                // Handle user's menu selection
                switch (choice) {
                    case 1:
                        addNewAnimal(sc, shelter);  // Add a new animal
                        break;
                    case 2:
                        shelter.listAnimals();      // List all animals
                        break;
                    case 3:
                        // Ask user for type and list animals of that type
                        System.out.print("Enter type to list (Dog/Cat/Rabbit/Bird): ");
                        String type = sc.nextLine();
                        shelter.listByType(type);
                        break;
                    case 4:
                        // Ask user for animal name to mark as adopted
                        System.out.print("Enter name of animal to mark adopted: ");
                        String name = sc.nextLine();
                        shelter.markAdopted(name);
                        break;
                    case 0:
                        System.out.println("Exiting...");  // Exit message
                        break;
                    default:
                        System.out.println("Invalid option.");  // Invalid option message
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the invalid input
            }
        } while (choice != 0);
    }
        

    // Method to add a new animal with validation
    private static void addNewAnimal(Scanner sc, AnimalShelter shelter) {
        String type;

        // Validate animal type input
        do {
            System.out.print("Enter animal type (Dog/Cat/Bird/Rabbit): ");
            type = sc.nextLine();
            if (!type.equalsIgnoreCase("Dog") && !type.equalsIgnoreCase("Cat") &&
                !type.equalsIgnoreCase("Bird") && !type.equalsIgnoreCase("Rabbit")) {
                System.out.println("Invalid animal type. Only 'Dog', 'Cat', 'Bird', or 'Rabbit' are accepted.");
            }
        } while (!type.equalsIgnoreCase("Dog") && !type.equalsIgnoreCase("Cat") &&
                 !type.equalsIgnoreCase("Bird") && !type.equalsIgnoreCase("Rabbit"));

        // Get animal name
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        // Validate age input (only numeric)
        int age = -1;
        while (true) {
            System.out.print("Enter age: ");
            String input = sc.nextLine();
            if (input.matches("^\\d+$")) {
                age = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Validate breed input (letters only)
        String breed;
        do {
            System.out.print("Enter breed (letters only): ");
            breed = sc.nextLine();
            if (!breed.matches("^[a-zA-Z ]+$")) {
                System.out.println("Invalid breed. Please enter letters only.");
            }
        } while (!breed.matches("^[a-zA-Z ]+$"));

        // Validate date input (format yyyy/MM/dd)
        String date;
        do {
            System.out.print("Enter arrival date (YYYY/MM/dd): ");
            date = sc.nextLine();
            if (!isValidDate(date)) {
                System.out.println("Invalid date!");
            }
        } while (!isValidDate(date));

        BaseAnimal animal = null;
        try {
            // Create appropriate animal object based on type
            if (type.equalsIgnoreCase("Dog")) {
                animal = new Dog(name, age, breed, date, false);
            } else if (type.equalsIgnoreCase("Cat")) {
                animal = new Cat(name, age, breed, date, false);
            } else if (type.equalsIgnoreCase("Rabbit")) {
                animal = new Rabbit(name, age, breed, date, false);
            } else if (type.equalsIgnoreCase("Bird")) {
                animal = new Bird(name, age, breed, date, false);
            } else {
                // This should never happen due to validation, but added as a safety check
                throw new InvalidAnimalTypeException("Unknown animal type: " + type);
            }

            shelter.addAnimal(animal);  // Add animal to the shelter

        } catch (InvalidAnimalTypeException e) {
            // Catch and display custom exception for invalid type
            System.out.println(e.getMessage());
        }
    }

    // Method to validate date format yyyy/MM/dd using regex
    // private static boolean isValidDate(String date) {
    //     return date.matches("^\\d{4}/(0[1-9]|1[0-2])/([0][1-9]|[12][0-9]|3[01])$");
    // }

    private static boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            LocalDate today = LocalDate.now();
            return !parsedDate.isAfter(today); // Valid only if not in the future
        } catch (DateTimeParseException e) {
            return false; // Invalid format or impossible date
        }
    }
    
}
