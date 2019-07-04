package main;

import java.util.ArrayList;

public class CartItem {

    private static ArrayList<Animal> cartItems = new ArrayList<>();

    static ArrayList<Animal> getCartItems() {
        return cartItems;
    }

    public static void addItem(Animal animal) {
        cartItems.add(animal);
    }

    public static void deleteItem(Animal animal) {
        cartItems.remove(animal);
    }
}
