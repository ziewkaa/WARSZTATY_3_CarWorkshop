package pl.coderslab.dao;

import pl.coderslab.models.Order;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String CREATE_ORDER_QUERY = "INSERT INTO Orders(registered, planned_repair_date, employee_id, problem_description, status, vehicle_id, repair_price, employee_work_price, repair_hours) VALUES (?,?,?,?,?,?,?,?)";
    private static final String READ_ORDER_QUERY = "SELECT * FROM Orders WHERE id = ?";
    private static final String UPDATE_ORDER_QUERY = "UPDATE Orders SET registered=?, planned_repair_date=?, actual_repair_date=?, employee_id=?, problem_description=?, repair_description=?, status=?, vehicle_id=?, repair_price=?, parts_price=?, employee_work_price=?, repair_hours=? WHERE id = ?";
    private static final String DELETE_ORDER_QUERY = "DELETE FROM Orders WHERE id = ?";
    private static final String FIND_ALL_ORDERS_QUERY = "SELECT * FROM Orders";

    static public void create(LocalDate registered, LocalDate planned_repair_date, int employee_id, String problem_description, int status, int vehicle_id, double repair_price, double employee_work_price) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_ORDER_QUERY);
            statement.setString(1, registered.toString());
            statement.setString(2, planned_repair_date.toString());
            statement.setInt(3,employee_id);
            statement.setString( 4, problem_description);
            statement.setInt(5, status);
            statement.setInt(6, vehicle_id);
            statement.setDouble(7, repair_price);
            statement.setDouble(8, employee_work_price);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Order read(int id) {
        Order order = new Order();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_ORDER_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setRegistered(LocalDate.parse(resultSet.getString("registered")));
                order.setPlanned_repair_date(LocalDate.parse(resultSet.getString("planned_repair_date")));
                order.setActual_repair_date(LocalDate.parse(resultSet.getString("actual_repair_date")));
                order.setEmployee_id(resultSet.getInt("employee_id"));
                order.setProblem_description(resultSet.getString("problem_description"));
                order.setRepair_description(resultSet.getString("repair_description"));
                order.setStatus(resultSet.getInt("status"));
                order.setVehicle_id(resultSet.getInt("vehicle_id"));
                order.setRepair_price(Double.parseDouble(resultSet.getString("repair_price")));
                order.setParts_price(Double.parseDouble(resultSet.getString("parts_price")));
                order.setEmployee_work_price(Double.parseDouble(resultSet.getString("employee_work_price")));
                order.setRepair_hours(resultSet.getInt("repair_hours"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    static public void update(Order order) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_QUERY);
            statement.setInt(13, order.getId());
            statement.setString(1, order.getRegistered().toString());
            statement.setString(2, order.getPlanned_repair_date().toString());
            statement.setString(3,order.getActual_repair_date().toString());
            statement.setInt(4,order.getEmployee_id());
            statement.setString( 5, order.getProblem_description());
            statement.setString(6, order.getRepair_description());
            statement.setInt(7, order.getStatus());
            statement.setInt(8, order.getVehicle_id());
            statement.setDouble(9, order.getRepair_price());
            statement.setDouble(10, order.getParts_price());
            statement.setDouble(11, order.getEmployee_work_price());
            statement.setInt(12, order.getRepair_hours());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public List<Order> findAllOrders() {

        List<Order> allOrders = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_ORDERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setRegistered(LocalDate.parse(resultSet.getString("registered")));
                order.setPlanned_repair_date(LocalDate.parse(resultSet.getString("planned_repair_date")));
                order.setActual_repair_date(LocalDate.parse(resultSet.getString("actual_repair_date")));
                order.setEmployee_id(resultSet.getInt("employee_id"));
                order.setProblem_description(resultSet.getString("problem_description"));
                order.setRepair_description(resultSet.getString("repair_description"));
                order.setStatus(resultSet.getInt("status"));
                order.setVehicle_id(resultSet.getInt("vehicle_id"));
                order.setRepair_price(Double.parseDouble(resultSet.getString("repair_price")));
                order.setParts_price(Double.parseDouble(resultSet.getString("parts_price")));
                order.setEmployee_work_price(Double.parseDouble(resultSet.getString("employee_work_price")));
                order.setRepair_hours(resultSet.getInt("repair_hours"));
                allOrders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allOrders;
    }


}
