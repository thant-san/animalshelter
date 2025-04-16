package animalshelter;

import java.io.*;
import java.util.*;

public class AnimalShelter {
    private List<BaseAnimal> animals;
    private final String fileName = "animals.txt";

    public AnimalShelter() {
        animals = new ArrayList<>();
        loadAnimals();
    }

    public void addAnimal(BaseAnimal animal) {
        animals.add(animal);
        saveAnimals();
    }

    public void listAnimals() {
        for (BaseAnimal animal : animals) {
            System.out.println(animal.getInfo());
        }
    }

    public void listByType(String type) {
        for (BaseAnimal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type)) {
                System.out.println(animal.getInfo());
            }
        }
    }

    public void markAdopted(String name) {
        for (BaseAnimal animal : animals) {
            if (animal.name.equalsIgnoreCase(name)) {
                animal.isAdopted = true;
                System.out.println(name + " has been adopted!");
                saveAnimals();
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    private void saveAnimals() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (BaseAnimal animal : animals) {
                writer.println(animal.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving animals: " + e.getMessage());
        }
    }

    private void loadAnimals() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String breed = parts[3];
                String arrivalDate = parts[4];
                boolean isAdopted = Boolean.parseBoolean(parts[5]);

                BaseAnimal animal = null;
                if (type.equalsIgnoreCase("Dog")) {
                    animal = new Dog(name, age, breed, arrivalDate, isAdopted);
                } else if (type.equalsIgnoreCase("Cat")) {
                    animal = new Cat(name, age, breed, arrivalDate, isAdopted);
                }else if (type.equalsIgnoreCase("Bird")){
                    animal=new Bird(name, age, breed, arrivalDate, isAdopted);
                }else if(type.equalsIgnoreCase("Rabbit")){
                    animal=new Rabbit(name, age, breed, arrivalDate, isAdopted);
                }

                if (animal != null) {
                    animals.add(animal);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading animals: " + e.getMessage());
        }
    }
}
