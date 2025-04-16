package animalshelter;

import java.util.Scanner;

public class AnimalShelterApp {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n🐾 Animal Shelter Management 🐾");
            System.out.println("1. Add New Animal");
            System.out.println("2. List All Animals");
            System.out.println("3. List Animals by Type");
            System.out.println("4. Mark Animal as Adopted");
            System.out.println("0. Exit");
            System.out.print("Select: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addNewAnimal(sc, shelter);
                    break;
                case 2:
                    shelter.listAnimals();
                    break;
                case 3:
                    System.out.print("Enter type to list (Dog/Cat): ");
                    String type = sc.nextLine();
                    shelter.listByType(type);
                    break;
                case 4:
                    System.out.print("Enter name of animal to mark adopted: ");
                    String name = sc.nextLine();
                    shelter.markAdopted(name);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static void addNewAnimal(Scanner sc, AnimalShelter shelter) {
        String type;
        do{
            System.out.print("Enter animal type (Dog/Cat/Bird/Rabbit): ");
             type = sc.nextLine();
            if (!type.equalsIgnoreCase("Dog") && !type.equalsIgnoreCase("Cat") && !type.equalsIgnoreCase("Bird") && !type.equalsIgnoreCase("Rabbit")) {
                System.out.println("Invalid animal type. Only 'Dog', 'Cat' or 'Bird' are allowed.");
            }
        } while (!type.equalsIgnoreCase("Dog") && !type.equalsIgnoreCase("Cat") && !type.equalsIgnoreCase("Bird") &&  !type.equalsIgnoreCase("Rabbit"));
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        int age=-1;
        while(true){
            System.out.print("Enter age: ");
            String input=sc.nextLine();
            if(input.matches("^\\d+$")){
                age=Integer.parseInt(input);
                break;
            }else{
                System.out.println(" Invalid input. Please enter a valid number.");
            }
        }
        
        
        System.out.print("Enter breed: ");
        String breed = sc.nextLine();

        String date;
        do {
            System.out.print("Enter arrival date (yyyy/MM/dd): ");
            date = sc.nextLine();
            if (!isValidDate(date)) {
                System.out.println("Invalid date format. Please use yyyy/MM/dd.");
            }
        } while (!isValidDate(date));

        BaseAnimal animal = null;
        if (type.equalsIgnoreCase("Dog")) {
            animal = new Dog(name, age, breed, date, false);
        } else if (type.equalsIgnoreCase("Cat")) {
            animal = new Cat(name, age, breed, date, false);
        
        } else if(type.equalsIgnoreCase("Rabbit")){
           animal=new Rabbit(name, age, breed, date, false);
        }else if(type.equalsIgnoreCase("Bird")){
            animal=new Bird(name, age, breed, date, false);
        }
        else {
            
            System.out.println("Unknown animal type.");
            return;
        }

        shelter.addAnimal(animal);
        System.out.println("Animal added!");
    }

    private static boolean isValidDate(String date) {
        return date.matches("^\\d{4}/(0[1-9]|1[0-2])/([0][1-9]|[12][0-9]|3[01])$");
    }
}
