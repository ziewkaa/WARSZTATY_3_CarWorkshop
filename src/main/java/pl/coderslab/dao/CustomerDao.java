package pl.coderslab.dao;

import pl.coderslab.models.Customer;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static final String CREATE_CUSTOMER_QUERY = "INSERT INTO Customers(name,surname,birthdate) VALUES (?,?,?)";
    private static final String READ_CUSTOMER_QUERY = "SELECT * FROM Customers where id = ?";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE Customers SET name = ? , surname = ?, birthdate = ?  WHERE id = ?";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM Customers WHERE id = ?";
    private static final String FIND_ALL_CUSTOMERS_QUERY = "SELECT * FROM Customers";



    static public void create(String name, String surname, LocalDate birth_date) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_CUSTOMER_QUERY);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, birth_date.toString());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Customer read(int id) {

        Customer customer = new Customer();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_CUSTOMER_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setBirth_date(LocalDate.parse(resultSet.getString("birthdate")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    static public void update(Customer customer) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_QUERY);
            statement.setInt(4, customer.getId());
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getBirth_date().toString());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public List<Customer> findAllCustomers() {

        List<Customer> allCustomers = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_CUSTOMERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setBirth_date(LocalDate.parse(resultSet.getString("birthdate")));
                allCustomers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCustomers;
    }

}
