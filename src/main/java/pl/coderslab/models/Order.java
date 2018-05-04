package pl.coderslab.models;

import java.time.LocalDate;

public class Order {

    private int id;
    private LocalDate registered;
    private LocalDate planned_repair_date;
    private LocalDate actual_repair_date;
    private int employee_id;
    private String problem_description;
    private String repair_description;
    private int status;
    private int vehicle_id;
    private double repair_price;
    private double parts_price;
    private double employee_work_price;
    private int repair_hours;


    public Order(int id, LocalDate registered, LocalDate planned_repair_date, LocalDate actual_repair_date, int employee_id, String problem_description, String repair_description, int status, int vehicle_id, double repair_price, double parts_price, double employee_work_price, int repair_hours) {
        this.id = id;
        this.registered = registered;
        this.planned_repair_date = planned_repair_date;
        this.actual_repair_date = actual_repair_date;
        this.employee_id = employee_id;
        this.problem_description = problem_description;
        this.repair_description = repair_description;
        this.status = status;
        this.vehicle_id = vehicle_id;
        this.repair_price = repair_price;
        this.parts_price = parts_price;
        this.employee_work_price = employee_work_price;
        this.repair_hours = repair_hours;
    }

    public Order(LocalDate registered, LocalDate planned_repair_date, LocalDate actual_repair_date, int employee_id, String problem_description, String repair_description, int status, int vehicle_id, double repair_price, double parts_price, double employee_work_price, int repair_hours) {
        this.id = id;
        this.registered = registered;
        this.planned_repair_date = planned_repair_date;
        this.actual_repair_date = actual_repair_date;
        this.employee_id = employee_id;
        this.problem_description = problem_description;
        this.repair_description = repair_description;
        this.status = status;
        this.vehicle_id = vehicle_id;
        this.repair_price = repair_price;
        this.parts_price = parts_price;
        this.employee_work_price = employee_work_price;
        this.repair_hours = repair_hours;
    }

    public Order(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public LocalDate getPlanned_repair_date() {
        return planned_repair_date;
    }

    public void setPlanned_repair_date(LocalDate planned_repair_date) {
        this.planned_repair_date = planned_repair_date;
    }

    public LocalDate getActual_repair_date() {
        return actual_repair_date;
    }

    public void setActual_repair_date(LocalDate actual_repair_date) {
        this.actual_repair_date = actual_repair_date;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getProblem_description() {
        return problem_description;
    }

    public void setProblem_description(String problem_description) {
        this.problem_description = problem_description;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public double getRepair_price() {
        return repair_price;
    }

    public void setRepair_price(double repair_price) {
        this.repair_price = repair_price;
    }

    public double getParts_price() {
        return parts_price;
    }

    public void setParts_price(double parts_price) {
        this.parts_price = parts_price;
    }

    public double getEmployee_work_price() {
        return employee_work_price;
    }

    public void setEmployee_work_price(double employee_work_price) {
        this.employee_work_price = employee_work_price;
    }

    public int getRepair_hours() {
        return repair_hours;
    }

    public void setRepair_hours(int repair_hours) {
        this.repair_hours = repair_hours;
    }
}
