package org.example;

// Define the Animal class
public class Animal {
    private String name;
    private String type;

    public Animal(int i, String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        byte id = 0;
        return id;
    }

    public void setName(String newAnimalName) {
        this.name = newAnimalName;
    }

    public void setType(String newAnimalType) {
        this.type = newAnimalType;
    }


    public String getDescription() {
        // Replace this with the actual description of the animal.
        return "The " + name + " is a fascinating animal. It is known for its unique characteristics and behaviors. " +
                "Visitors can observe its habitat and learn more about its lifestyle when they visit the zoo.";
    }

}
