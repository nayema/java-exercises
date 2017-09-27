package com.nayema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AirplaneListHelper {
    ArrayList<Airplane> airplaneList = new ArrayList<>();

    public void readFromCSV() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("data.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        boolean done = false;
        while (!done) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                done = true;
            } else {
                String[] cellTokens = line.split(",");
                String modelName = cellTokens[0];
                int seatCapacity = Integer.parseInt(cellTokens[1]);
                String nextInspectionDate = cellTokens[2];
                int weight = Integer.parseInt(cellTokens[3]);
                Airplane airplane = new Airplane(modelName, seatCapacity, nextInspectionDate, weight);
                airplaneList.add(airplane);
            }
        }
    }

    public Object[][] convertDataToTable() {
        Object[][] airplaneData = new Object[airplaneList.size()][4];
        for (int i = 0; i < airplaneList.size(); i++) {
            airplaneData[i][0] = airplaneList.get(i).getModelName();
            airplaneData[i][1] = airplaneList.get(i).getSeatCapacity();
            airplaneData[i][2] = airplaneList.get(i).getNextInspectionDate();
            airplaneData[i][3] = airplaneList.get(i).getWeight();
        }
        return airplaneData;
    }
}
