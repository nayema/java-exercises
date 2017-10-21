package com.nayema.exercise_22;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class AirplaneRepositoryTest {
    @BeforeAll
    public void itCreatesADatabaseIfItDoesNotExist() throws SQLException {
        AirplaneRepository repository = new AirplaneRepository();
    }

    @AfterEach

    @Test
    public void itInsertsAnAirplane() throws SQLException {
        AirplaneRepository repository = new AirplaneRepository();
        Airplane airplane = new Airplane("Some model name", 1, "01-JAN-1000", 100);

        repository.insert(airplane);

        Airplane result = repository.retrieve("Some model name");
        assertThat(result.getModelName(), is(equalTo("Some model name")));
        assertThat(result.getSeatCapacity(), is(equalTo(1)));
        assertThat(result.getNextInspectionDate(), is(equalTo("01-JAN-1000")));
        assertThat(result.getWeight(), is(equalTo(100)));
    }
}