package com.nayema.exercise_22;

import java.sql.*;

public class AirplaneRepository {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public AirplaneRepository() throws SQLException {
        connect();
    }

    public void insert(Airplane airplane) throws SQLException {
        String query = "INSERT INTO airplanes(model_name, seat_capacity, next_inspection_date, weight) " +
                "VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, airplane.getModelName());
        preparedStatement.setInt(2, airplane.getSeatCapacity());
        preparedStatement.setString(3, airplane.getNextInspectionDate());
        preparedStatement.setInt(4, airplane.getWeight());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Airplane retrieve(String queryModelName) throws SQLException {
        String query = "SELECT * FROM airplanes WHERE model_name = ?";
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

    private void connect() throws SQLException {
        String url = "jdbc:sqlite:src/main/resources/exercise-22.sqlite";
        connection = DriverManager.getConnection(url);
        connection.close();
    }

}
