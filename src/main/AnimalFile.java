package main;

import main.animals.*;

import java.io.*;
import java.util.ArrayList;

public abstract class AnimalFile implements Serializable {

    private static File file = new File("./animals.ser");

    //saves all animals in this arrayList
    private static ArrayList<Animal> allAnimals = new ArrayList<>();
    
    public static ArrayList<Animal> getAnimalList() {
        return allAnimals;
    }
    //read the file and get the content
    static ArrayList<Animal> readAnimalsFile() {
        try {
            FileInputStream fileIn = new FileInputStream(file);
            if (fileIn.available() != 0) {
                ObjectInputStream input = new ObjectInputStream(fileIn);
                allAnimals = (ArrayList<Animal>) input.readObject();
                input.close();
                fileIn.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File is empty");
        }
        return allAnimals;
    }

    //save all animals in an external file
    static void saveAnimalsFile() {
        if (allAnimals.isEmpty()) {
            addAnimals();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fileOut);
            output.writeObject(allAnimals);
            output.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //If ArrayList is empty, write default animals in it.
    private static void addAnimals() {
        allAnimals.add(new Giraffe(0, "giraffe.jpg", "Livio", "available", "3 days old"));
        allAnimals.add(new Giraffe(1, "giraffe.jpg", "Simon", "available", "3 weeks old"));

        allAnimals.add(new Rabbit(0, "rabbit.jpg", "Joel", "available", "1 month old"));
        allAnimals.add(new Rabbit(1, "rabbit.jpg", "Nico", "available", "2 months old"));

        allAnimals.add(new Bat(0, "bat.jpeg", "Oliver", "available", "1 month old"));
        allAnimals.add(new Bat(1, "bat.jpeg", "Jeremy", "available", "2 months old"));

        allAnimals.add(new Loris(0, "loris.jpg", "Loris", "available", "1 month old"));
        allAnimals.add(new Loris(1, "loris.jpg", "Noel", "available", "2 months old"));

        allAnimals.add(new Guenther(0, "guenther.jpg", "Philipp", "available", "1 month old"));
        allAnimals.add(new Guenther(1, "guenther.jpg", "Marco", "available", "2 months old"));

        allAnimals.add(new Fox(0, "fox.jpg", "Pablo", "available", "1 month old"));
        allAnimals.add(new Fox(1, "fox.jpg", "DiMaria", "available", "2 months old"));
    }
}
