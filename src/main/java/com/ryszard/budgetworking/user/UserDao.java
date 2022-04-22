package com.ryszard.budgetworking.user;

import com.ryszard.budgetworking.db.DataSourceProvider;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;


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
        System.out.println("DUPA     "+firstName);
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


}