package main;

import java.util.ArrayList;

public class AnimalList {

    private static ArrayList<Animal> allAnimals = new ArrayList<>();

    public static ArrayList<Animal> getAllAnimals() {
        return allAnimals;
    }

    public void setAllAnimals(ArrayList<Animal> allAnimals) {
        AnimalList.allAnimals = allAnimals;
    }

    static void addGiraffes() {
        Animal giraffe1 = new Giraffe("giraffe.jpg", "Joel", "available", "1 month old");
        Animal giraffe2 = new Giraffe("giraffe.jpg", "Nico", "available", "2 months old");

        allAnimals.add(giraffe1);
        allAnimals.add(giraffe2);
    }

    static void addRabbits() {
        Animal giraffe1 = new Animal("rabbit.jpg", "Joel", "available", "1 month old");
        Animal giraffe2 = new Animal("rabbit.jpg", "Nico", "available", "2 months old");

        allAnimals.add(giraffe1);
        allAnimals.add(giraffe2);
    }
}
