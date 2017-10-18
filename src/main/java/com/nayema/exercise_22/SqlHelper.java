package com.nayema.exercise_22;

import java.sql.*;

public class SqlHelper {
    private Connection connection;

    public SqlHelper(String url) throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    public void clearTable() throws SQLException {
        String query = "DELETE FROM airplane_data";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void insertNewAirplaneRecord(String modelName, int seatCapacity, String nextInspectionDate, int weight) throws SQLException {
        String query = "INSERT INTO airplane_data(model_name, seat_capacity, next_inspection_date, weight) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, modelName);
        preparedStatement.setInt(2, seatCapacity);
        preparedStatement.setString(3, nextInspectionDate);
        preparedStatement.setInt(4, weight);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void queryData(String modelNameQuery) throws SQLException {
        String query = "SELECT * FROM airplane_data WHERE model_name = ?" ;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, modelNameQuery);
        preparedStatement.executeQuery();
    }
}
