package com.ryszard.budgetworking.user;

import com.ryszard.budgetworking.db.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;


class UserDao {
    private final DataSource dataSource;

    public UserDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String area, String phoneNumber, String firstName) {
        System.out.println("Test    " + firstName);
        String sql = "INSERT INTO users(area_code,phone_number , first_name) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, area);
            statement.setString(2, phoneNumber);
            statement.setString(3, firstName);
            //TODO: Do it later
//            statement.setString(4, user.getLastName());
//            statement.setDate(5, (Date) user.getBirthDate());
//            statement.setString(6, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, String area) {
        System.out.println("Update test   " +id + area);
        String sql = "UPDATE users set area_code = ? where id = ?;";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "123");
            statement.setInt(2, 1);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAllUsers() {
        String sql = "SELECT area_code FROM users";
        List<User> items = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String area = resultSet.getString("area_code");
                items.add(new User(area, null, null, null, null, null));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public User findUser(int id) {
        User user = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT  area_code FROM users WHERE id=?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User();
                    System.out.println("RESULT SET   " + resultSet);
                    user.setId(resultSet.getInt("id"));
                    user.setAreaCode(resultSet.getString("area_code"));
                }
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return user;
    }


}