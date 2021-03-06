package pl.coderslab.models;

import java.time.LocalDate;

public class Vehicle {

    private int id;
    private String model;
    private String brand;
    private int customer_id;
    private int year;
    private String registration;
    private LocalDate next_check;

    public Vehicle(int id, String model, String brand, int customer_id, int year, String registration, LocalDate next_check) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.customer_id = customer_id;
        this.year = year;
        this.registration = registration;
        this.next_check = next_check;
    }

    public Vehicle(String model, String brand, int customer_id, int year, String registration, LocalDate next_check) {
        this.model = model;
        this.brand = brand;
        this.customer_id = customer_id;
        this.year = year;
        this.registration = registration;
        this.next_check = next_check;
    }

    public Vehicle(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public LocalDate getNext_check() {
        return next_check;
    }

    public void setNext_check(LocalDate next_check) {
        this.next_check = next_check;
    }
}
