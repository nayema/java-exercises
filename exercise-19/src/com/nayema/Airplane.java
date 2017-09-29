package com.nayema;

public class Airplane {
    private String modelName;
    private int seatCapacity;
    private String nextInspectionDate;
    private int weight;

    public Airplane(String[] airplaneRow) {
        this.modelName = airplaneRow[0];
        this.seatCapacity = Integer.parseInt(airplaneRow[1]);
        this.nextInspectionDate = airplaneRow[2];
        this.weight = Integer.parseInt(airplaneRow[3]);
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

