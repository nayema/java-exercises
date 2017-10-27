package com.nayema.exercise_22;

public class Airplane {
    private String modelName;
    private int seatCapacity;
    private String nextInspectionDate;
    private int weight;

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

    public String getModelName() {
        return modelName;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public String getNextInspectionDate() {
        return nextInspectionDate;
    }

    public int getWeight() {
        return weight;
    }
}
