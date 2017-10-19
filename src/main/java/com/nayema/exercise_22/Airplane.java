package com.nayema.exercise_22;

public class Airplane {
    public String modelName;
    public int seatCapacity;
    public String nextInspectionDate;
    public int weight;

    public Airplane(String modelName, int seatCapacity, String nextInspectionDate, int weight) {
        this.modelName = modelName;
        this.seatCapacity = seatCapacity;
        this.nextInspectionDate = nextInspectionDate;
        this.weight = weight;
    }

    public Airplane(String modelName, String seatCapacity, String nextInspectionDate, String weight) {
        this.modelName = modelName;
        this.seatCapacity = Integer.parseInt(seatCapacity);
        this.nextInspectionDate = nextInspectionDate;
        this.weight = Integer.parseInt(weight);
    }
}
