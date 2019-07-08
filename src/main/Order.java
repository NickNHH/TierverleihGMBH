package main;

import java.util.ArrayList;

public class Order {
    String firstName;
    String lastname;
    String email;
    String street;
    String zipCode;
    String reason;

    private ArrayList<Order> orders = new ArrayList<>();

    Order(String firstName, String lastName, String email, String street, String zipCode, String reason) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.email = email;
        this.street = street;
        this.zipCode = zipCode;
        this.reason = reason;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrders(Order orders) {
        this.orders.add(orders);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
