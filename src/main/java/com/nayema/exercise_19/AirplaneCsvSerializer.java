package com.nayema.exercise_19;

public class AirplaneCsvSerializer {
    private Airplane airplane;

    public AirplaneCsvSerializer(Airplane airplane) {
        this.airplane = airplane;
    }

    public String serialize() {
        return airplane.getModelName() + ","
                + airplane.getSeatCapacity() + ","
                + airplane.getNextInspectionDate() + ","
                + airplane.getWeight();
    }
}
