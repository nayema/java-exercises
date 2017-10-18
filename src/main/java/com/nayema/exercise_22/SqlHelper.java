package com.nayema.exercise_22;

import java.sql.*;

public class SqlHelper {
    private Connection connection;
    private ResultSet resultSet;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public SqlHelper(String url) throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    public void insertRecord(String modelName, int seatCapacity, String nextInspectionDate, int weight) throws SQLException {
        String sql = "INSERT INTO airplane_data(model_name, seat_capacity, next_inspection_date, weight) VALUES (?, ?, ?, ?)";
        insertNewAirplaneRecord(modelName, seatCapacity, nextInspectionDate, weight, sql);
    }

    public void queryData(String modelNameQuery) throws SQLException {
        String sql = "SELECT * FROM airplane_data WHERE model_name = ?";
        queryByModelName(modelNameQuery, sql);
    }

    public ResultSetMetaData queryResultSetMetaData() throws SQLException {
        String sql = "SELECT * FROM airplane_data";
        return getMetaData(sql);

    }

    private void insertNewAirplaneRecord(String modelName, int seatCapacity, String nextInspectionDate, int weight, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, modelName);
        preparedStatement.setInt(2, seatCapacity);
        preparedStatement.setString(3, nextInspectionDate);
        preparedStatement.setInt(4, weight);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private ResultSetMetaData getMetaData(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        return resultSet.getMetaData();
    }

    private void queryByModelName(String modelNameQuery, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, modelNameQuery);
        preparedStatement.executeQuery();
    }
}
