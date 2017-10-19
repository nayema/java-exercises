package com.nayema.exercise_22;

import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class AirplaneRepositoryTest {

    @Test
    public void itInsertsAnAirplane() throws SQLException {
        AirplaneRepository repository = new AirplaneRepository();
        Airplane airplane = new Airplane("Some model name", 1, "01-JAN-1000", 100);

        repository.insert(airplane);

        Airplane result = repository.retrieve("Some model name");
        assertThat(result.modelName, is(equalTo("Some model name")));
        assertThat(result.seatCapacity, is(equalTo(1)));
        assertThat(result.nextInspectionDate, is(equalTo("01-JAN-1000")));
        assertThat(result.weight, is(equalTo(100)));
    }
}