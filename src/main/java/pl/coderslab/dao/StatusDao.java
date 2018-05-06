package pl.coderslab.dao;

import pl.coderslab.models.Status;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {

    private static final String CREATE_STATUS_QUERY = "INSERT INTO Statuses(stage) VALUES (?)";
    private static final String READ_STATUS_QUERY = "SELECT * FROM Statuses where id = ?";
    private static final String UPDATE_STATUS_QUERY = "UPDATE Statuses SET stage=? WHERE id = ?";
    private static final String DELETE_STATUS_QUERY = "DELETE FROM Statuses WHERE id = ?";
    private static final String FIND_ALL_STATUSES_QUERY = "SELECT * FROM Statuses";



    static public void create(int stage) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_STATUS_QUERY);
            statement.setInt(1, stage);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Status read(int id) {

        Status status = new Status();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_STATUS_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                status.setId(resultSet.getInt("id"));
                status.setStage(resultSet.getInt("stage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    static public void update(Status status) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_QUERY);
            statement.setInt(2, status.getId());
            statement.setInt(1, status.getStage());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_STATUS_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public List<Status> findAllStatuses() {

        List<Status> allStatuses = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_STATUSES_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setStage(resultSet.getInt("stage"));
                allStatuses.add(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allStatuses;
    }

}
