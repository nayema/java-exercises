package com.nayema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

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

    public Object[][] convertDataToTable3() {
        ArrayList<Object[]> data = new ArrayList();
        for (Airplane airplane : airplaneList) {
            ArrayList<String> airplaneRow = new ArrayList<>(4);
            airplaneRow.add(airplane.getModelName());
            airplaneRow.add(String.valueOf(airplane.getSeatCapacity()));
            airplaneRow.add(airplane.getNextInspectionDate());
            airplaneRow.add(String.valueOf(airplane.getWeight()));
            data.add(airplaneRow.toArray());
        }
        return data.toArray();
    }

    public Object[] convertDataToTable2() {
        Vector<Vector<String>> data = new Vector();
        for (Airplane airplane : airplaneList) {
            Vector<String> airplaneVector = new Vector<>(4);
            airplaneVector.add(airplane.getModelName());
            airplaneVector.add(String.valueOf(airplane.getSeatCapacity()));
            airplaneVector.add(airplane.getNextInspectionDate());
            airplaneVector.add(String.valueOf(airplane.getWeight()));
            data.add(airplaneVector);
        }
        return data.toArray();
    }
}
