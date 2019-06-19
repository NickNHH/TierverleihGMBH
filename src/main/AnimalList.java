package main;

import main.animals.Giraffe;
import main.animals.Rabbit;

import java.util.ArrayList;

public class AnimalList {

    private static ArrayList<Animal> chosenAnimals = new ArrayList<>();

    public static ArrayList<Animal> getChosenAnimals() {
        return chosenAnimals;
    }

    public void setChosenAnimals(ArrayList<Animal> chosenAnimals) {
        AnimalList.chosenAnimals = chosenAnimals;
    }

    static void addGiraffes() {
        chosenAnimals.clear();

        for (Animal animal : AnimalFile.readAnimalsFile()) {
            if (animal.getClass() == Giraffe.class) {
                chosenAnimals.add(animal);
            }
        }
    }

    static void addRabbits() {
        chosenAnimals.clear();

        for (Animal animal : AnimalFile.readAnimalsFile()) {
            if (animal.getClass() == Rabbit.class) {
                chosenAnimals.add(animal);
            }
        }
    }
}
