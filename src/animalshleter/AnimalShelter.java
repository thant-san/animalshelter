package animalshelter;

import java.io.*;
import java.util.*;

public class AnimalShelter {
    // List to store all animals in the shelter
    private List<BaseAnimal> animals;

    // File name for saving and loading animal data
    private final String fileName = "animals.txt";

    // Constructor: initializes the list and loads animals from file
    public AnimalShelter() {
        animals = new ArrayList<>();
        loadAnimals();  // Load animals when shelter is created
    }

    // Add a new animal to the list and save it to the file
    public void addAnimal(BaseAnimal animal) {
        animals.add(animal);
        saveAnimals();  // Save after adding
    }

    // List all animals in the shelter
    public void listAnimals() {
        for (BaseAnimal animal : animals) {
            System.out.println(animal.getInfo());
        }
    }

    // List animals by a specific type (Dog, Cat, etc.)
    public void listByType(String type) {
        for (BaseAnimal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type)) {
                System.out.println(animal.getInfo());
            }
        }
    }

    // Mark an animal as adopted based on its name
    public void markAdopted(String name) {
        for (BaseAnimal animal : animals) {
            if (animal.name.equalsIgnoreCase(name)) {
                animal.isAdopted = true;  // Mark adopted
                System.out.println(name + " has been adopted!");
                saveAnimals();  // Save changes
                return;
            }
        }
        // If no animal found with the given name
        System.out.println("Animal not found.");
    }

    // Save all animal data to the text file
    private void saveAnimals() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (BaseAnimal animal : animals) {
                writer.println(animal.toFileString());  // Write each animal's data
            }
        } catch (IOException e) {
            System.out.println("Error saving animals: " + e.getMessage());
        }
    }

    // Load animal data from the text file
    private void loadAnimals() {
        File file = new File(fileName);
        if (!file.exists()) return;  // If no file exists, skip loading

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Read each line (animal record)
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");  // Split by comma
                String type = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String breed = parts[3];
                String arrivalDate = parts[4];
                boolean isAdopted = Boolean.parseBoolean(parts[5]);

                BaseAnimal animal = null;

                // Create the appropriate animal object based on type
                if (type.equalsIgnoreCase("Dog")) {
                    animal = new Dog(name, age, breed, arrivalDate, isAdopted);
                } else if (type.equalsIgnoreCase("Cat")) {
                    animal = new Cat(name, age, breed, arrivalDate, isAdopted);
                } else if (type.equalsIgnoreCase("Bird")) {
                    animal = new Bird(name, age, breed, arrivalDate, isAdopted);
                } else if (type.equalsIgnoreCase("Rabbit")) {
                    animal = new Rabbit(name, age, breed, arrivalDate, isAdopted);
                }

                // Add valid animal to the list
                if (animal != null) {
                    animals.add(animal);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading animals: " + e.getMessage());
        }
    }
}
