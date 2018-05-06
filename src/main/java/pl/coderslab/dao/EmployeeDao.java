package pl.coderslab.dao;

import pl.coderslab.models.Customer;
import pl.coderslab.models.Employee;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO Employees(name,surname,address,number,note, hour_salary) VALUES (?,?,?,?,?,?);";
    private static final String READ_EMPLOYEE_QUERY = "SELECT * FROM Employees where id = ?;";
    private static final String UPDATE_EMPLOYEE_QUERY = "UPDATE Employees SET name = ? , surname = ?, address = ?, number=?, note=?, hour_salary=? WHERE id = ?;";
    private static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM Employees WHERE id = ?;";
    private static final String FIND_ALL_EMPLOYEES_QUERY = "SELECT * FROM Employees;";



    static public void create(String name, String surname, String address, String number, String note, double hour_salary) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_EMPLOYEE_QUERY);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3,address);
            statement.setString(4,number);
            statement.setString( 5, note);
            statement.setDouble(6, hour_salary);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Employee read(int id) {

        Employee employee = new Employee();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_EMPLOYEE_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("address"));
                employee.setNumber(resultSet.getString("number"));
                employee.setNote(resultSet.getString("note"));
                employee.setHour_salary(Double.parseDouble(resultSet.getString("hour_salary")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    static public void update(Employee employee) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_QUERY);
            statement.setInt(7, employee.getId());
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3,employee.getAddress());
            statement.setString(4,employee.getNumber());
            statement.setString( 5, employee.getNote());
            statement.setDouble(6, employee.getHour_salary());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public Employee[] findAllEmployees() {

        List<Employee> allEmployees = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_EMPLOYEES_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setNumber(resultSet.getString("number"));
                employee.setNote(resultSet.getString("note"));
                employee.setHour_salary(Double.parseDouble(resultSet.getString("hour_salary")));
                allEmployees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Employee[] employees = new Employee[allEmployees.size()];
        employees = allEmployees.toArray(employees);
        return employees;
    }

}
