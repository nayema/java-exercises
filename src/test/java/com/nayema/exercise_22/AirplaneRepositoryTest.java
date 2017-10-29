package com.nayema.exercise_22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

@Tag("Integration")
class AirplaneRepositoryTest {
    private static Connection connection;

    @BeforeAll
    public static void ensureThereIsATestDatabase() throws SQLException, IOException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exercise-22-test");
        String query = new String(Files.readAllBytes(Paths.get("src/main/resources/exercise-22.schema.sql")));
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
    }

    @BeforeEach
    public void ensureAirplanesTableIsTruncated() throws SQLException {
        String query = "DELETE FROM airplanes;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
    }

    @Test
    public void itInsertsAnAirplane() throws SQLException {
        AirplaneRepository repository = new AirplaneRepository(connection);
        Airplane airplane = new Airplane("Some model name", 1, "01-JAN-2000", 100);

        repository.insert(airplane);

        Airplane result = repository.retrieve("Some model name");
        assertThat(result.getModelName(), is(equalTo("Some model name")));
        assertThat(result.getSeatCapacity(), is(equalTo(1)));
        assertThat(result.getNextInspectionDate(), is(equalTo("01-JAN-2000")));
        assertThat(result.getWeight(), is(equalTo(100)));
    }
}
