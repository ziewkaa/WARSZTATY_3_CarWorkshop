package pl.coderslab.models;

public class Employee {

    private int id;
    private int order_id;
    private String name;
    private String surname;
    private String address;
    private String number;
    private String note;
    private double hour_salary;

    public Employee(int id, int order_id, String name, String surname, String address, String number, String note, double hour_salary) {
        this.id = id;
        this.order_id = order_id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.note = note;
        this.hour_salary = hour_salary;
    }

    public Employee(int order_id, String name, String surname, String address, String number, String note, double hour_salary) {
        this.id = id;
        this.order_id = order_id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.note = note;
        this.hour_salary = hour_salary;
    }

    public Employee(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getHour_salary() {
        return hour_salary;
    }

    public void setHour_salary(double hour_salary) {
        this.hour_salary = hour_salary;
    }
}
