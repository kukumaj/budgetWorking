package com.ryszard.budgetworking.user;

import com.ryszard.budgetworking.db.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


class UserDao {
    private static final Logger LOGGER = Logger.getLogger( UserDao.class.getName());
    private final DataSource dataSource;

    public UserDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String area, String phoneNumber, String firstName, String lastName, String birthDate, String password) {
        LOGGER.info("Test    " + birthDate);
        String sql = "INSERT INTO users(area_code, phone_number , first_name, last_name ,birth_date ,password) VALUES (?, ?, ?, ?, ? , ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, area);
            statement.setString(2, phoneNumber);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setDate(5, Date.valueOf(birthDate));
            statement.setString(6, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, User user) {
        LOGGER.info("oKOOOO");
        String sql = "UPDATE users set area_code = ?, phone_number = ?, first_name = ?, last_name = ?, password = ?, birth_date = ? where id = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.areaCode);
            statement.setString(2, user.phoneNumber);
            statement.setString(3, user.firstName);
            statement.setString(4, user.lastName);
            statement.setString(5, user.password);
            statement.setDate(6,  new java.sql.Date(user.birthDate.getTime()));
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAllUsers() {
        String sql = "SELECT id,area_code FROM users";
        List<User> items = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String area = resultSet.getString("area_code");
                long id = resultSet.getLong("id");
                items.add(new User(id, area, null, null, null, null,null));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public User findUser(int id) {
        User user;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?")
        ) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                user = new User();
                System.out.println("RESULT SET   " + resultSet);
                user.setId(resultSet.getInt("id"));
                user.setAreaCode(resultSet.getString("area_code"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return user;
    }
    public boolean delete(int id) {
        boolean rowDeleted;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from users where id = ?;")) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }
}
