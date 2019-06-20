package main;

import main.animals.*;

import java.io.*;
import java.util.ArrayList;

public abstract class AnimalFile implements Serializable {

    private static File file = new File("./animals.ser");

    //saves all animals in this arrayList
    private static ArrayList<Animal> allAnimals = new ArrayList<>();

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
        allAnimals.add(new Giraffe("giraffe.jpg", "Livio", "available", "3 days old"));
        allAnimals.add(new Giraffe("giraffe.jpg", "Simon", "available", "3 weeks old"));

        allAnimals.add(new Rabbit("rabbit.jpg", "Joel", "available", "1 month old"));
        allAnimals.add(new Rabbit("rabbit.jpg", "Nico", "available", "2 months old"));

        allAnimals.add(new Bat("bat.jpeg", "Oliver", "available", "1 month old"));
        allAnimals.add(new Bat("bat.jpeg", "Jeremy", "available", "2 months old"));

        allAnimals.add(new Loris("loris.jpg", "Loris", "available", "1 month old"));
        allAnimals.add(new Loris("loris.jpg", "Noel", "available", "2 months old"));

        allAnimals.add(new Guenther("guenther.jpg", "Philipp", "available", "1 month old"));
        allAnimals.add(new Guenther("guenther.jpg", "Marco", "available", "2 months old"));

        allAnimals.add(new Fox("fox.jpg", "Pablo", "available", "1 month old"));
        allAnimals.add(new Fox("fox.jpg", "DiMaria", "available", "2 months old"));
    }
}
