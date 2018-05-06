package pl.coderslab.dao;

import pl.coderslab.models.Vehicle;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static final String CREATE_VEHICLE_QUERY = "INSERT INTO Vehicles( model, brand, customer_id, year, registration, next_check) VALUES (?,?,?,?,?,?)";
    private static final String READ_VEHICLE_QUERY = "SELECT * FROM Vehicles where id = ?";
    private static final String UPDATE_VEHICLE_QUERY = "UPDATE Vehicles SET  model=?, brand=?, customer_id=?, year=?, registration=?, next_check=?  WHERE id = ?";
    private static final String DELETE_VEHICLE_QUERY = "DELETE FROM Vehicles WHERE id = ?";
    private static final String FIND_ALL_VEHICLE_QUERY = "SELECT * FROM Vehicles";
    private static final String FIND_CUSTOMER_VEHICLE_QUERY = "SELECT * FROM Vehicles WHERE customer_id = ?";



    static public void create(String model, String brand, int customer_id, int year, String registration, LocalDate next_check) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_VEHICLE_QUERY);
            statement.setString(1, model);
            statement.setString(2, brand);
            statement.setInt(3, customer_id);
            statement.setInt(4, year);
            statement.setString(5, registration);
            statement.setString(6, next_check.toString());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Vehicle read(int id) {

        Vehicle vehicle = new Vehicle();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_VEHICLE_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setCustomer_id(resultSet.getInt("customer_id"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setRegistration(resultSet.getString("registration"));
                vehicle.setNext_check(LocalDate.parse(resultSet.getString("next_check")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    static public void update(Vehicle vehicle) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_VEHICLE_QUERY);
            statement.setInt(7, vehicle.getId());
            statement.setString(1, vehicle.getModel());
            statement.setString(2,  vehicle.getBrand());
            statement.setInt(3, vehicle.getCustomer_id());
            statement.setInt(4, vehicle.getYear());
            statement.setString(5, vehicle.getRegistration());
            statement.setString(6, vehicle.getNext_check().toString());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_VEHICLE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public List<Vehicle> findAllVehicles() {

        List<Vehicle> allVehicles = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_VEHICLE_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setCustomer_id(resultSet.getInt("customer_id"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setRegistration(resultSet.getString("registration"));
                vehicle.setNext_check(LocalDate.parse(resultSet.getString("next_check")));
                allVehicles.add(vehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allVehicles;
    }

    static public Vehicle findCustomerVehicle(int customer_id) {

        Vehicle vehicle = new Vehicle();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_CUSTOMER_VEHICLE_QUERY);
            statement.setInt(1, customer_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setCustomer_id(resultSet.getInt("customer_id"));
                vehicle.setYear(resultSet.getInt("year"));
                vehicle.setRegistration(resultSet.getString("registration"));
                vehicle.setNext_check(LocalDate.parse(resultSet.getString("next_check")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

}
