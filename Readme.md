## Project Background

In response to the growing number of stray and abandoned animals in Myanmar which also has underdeveloped and under budgeted birth-controlling programs for the stray animals in urban cities like Yangon and Mandalay, our Project focuses on developing a management system for an animal shelter. 

## Project Rationale

This system aims to support shelter operations by organizing data of new animals including breed, age, arrival dates and adoption status. Basic OOP principles of encapsulation, inheritance and polymorphism are used to ensure the program is usable and helpful for the shelters to manage animal data-entry.

#  Animal Shelter Management System (Java Console App)

## Description
This is a simple **Java console-based Animal Shelter Management System** that allows users to:
-  Add new animals (Dog, Cat, Bird, Rabbit)
-  Record animal details (name, age, type, breed, arrival date)
-  List all animals
-  Mark animals as adopted
-  Save and load data from a text file

The system ensures:
-  Only allowed animal types (Dog, Cat, Bird, Rabbit)
-  Valid date format using regular expressions (`yyyy/MM/dd`)
-  Input safety with number and string validation

---

##  Features
-  **Add New Animal**
    - Enter animal type (Dog/Cat/Bird/Rabbit)
    - Enter name, age, breed, arrival date
    - Validates numeric and date formats

-  **List All Animals**
    - Displays animal details with adoption status

-  **Select Animal Type**
    - Ensures only valid types (Dog, Cat, Bird, Rabbit) are accepted

-  **Mark as Adopted**
    - Change adoption status of an animal by name

-  **File Storage**
    - Saves and loads animal data from a text file for data persistence

## Class Digaram
  ![Class Diagram](images/classdiagram.png)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/animal-shelter-management.git
   cd animal-shelter-management
## Contributors
1.Thant Htoo San (6731503087)
2. Hein Zaw      (6731503055)
3. Nyan Sint Zaw (6731503077)
4. Nadi Zeya     (6731503070)
5. Min Thein Kyaw(6731503067)
