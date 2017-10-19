package com.nayema.exercise_22;

import java.sql.*;

public class AirplaneRepository {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public AirplaneRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:/Users/Nayema/Development/java-exercises/nayema.sqlite.airplane");
    }

    public void insert(Airplane airplane) throws SQLException {
        String query = "INSERT INTO airplane_data(model_name, seat_capacity, next_inspection_date, weight) " +
                "VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, airplane.modelName);
        preparedStatement.setInt(2, airplane.seatCapacity);
        preparedStatement.setString(3, airplane.nextInspectionDate);
        preparedStatement.setInt(4, airplane.weight);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Airplane retrieve(String queryModelName) throws SQLException {
        String query = "SELECT * FROM airplane_data WHERE model_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, queryModelName);

        ResultSet results = preparedStatement.executeQuery();
        String modelName = results.getString("model_name");
        int seatCapacity = results.getInt("seat_capacity");
        String nextInspectionDate = results.getString("next_inspection_date");
        int weight = results.getInt("weight");
        preparedStatement.close();

        return new Airplane(modelName, seatCapacity, nextInspectionDate, weight);
    }
}
