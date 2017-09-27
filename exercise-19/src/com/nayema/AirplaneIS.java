package com.nayema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AirplaneIS {
    private JFrame frame;
    private JPanel mainPanel;
    private JTable table;
    private JPanel editorPanel;
    private JTextField modelNameTextField;
    private JTextField seatCapacityTextField;
    private JTextField nextInspectionDateTextField;
    private JTextField weightTextField;
    private JButton newAirplaneRecordButton;
    private JButton saveRecordButton;
    private JLabel modelNameLabel;
    private JLabel seatCapacityLabel;
    private JLabel nextInspectionDateLabel;
    private JLabel weightLabel;
    private JScrollPane tableScrollPane;
    private ArrayList<Airplane> airplaneList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new AirplaneIS().buildAirplaneIS();
    }

    public void buildAirplaneIS() throws IOException {
        populateTable();
        renderUI();
    }

    private void populateTable() throws IOException {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
        String firstLine = reader.readLine();
        String[] columnNames = firstLine.split(",");
        tableModel.setColumnIdentifiers(columnNames);

        Object[] dataLines = reader.lines().toArray();
        for (Object dataLine : dataLines) {
            String line = dataLine.toString();
            String[] airplaneRow = line.split(",");
            Airplane airplane = makeAirplane(airplaneRow);
            airplaneList.add(airplane);
        }
        for (int i = 0; i < airplaneList.size(); i++) {
            Object[] airplaneRowData = getAirplaneData(i);
            tableModel.addRow(airplaneRowData);
        }
    }

    private Airplane makeAirplane(String[] airplaneRow) {
        String modelName = airplaneRow[0];
        int seatCapacity = Integer.parseInt(airplaneRow[1]);
        String nextInspectionDate = airplaneRow[2];
        int weight = Integer.parseInt(airplaneRow[3]);
        return new Airplane(modelName, seatCapacity, nextInspectionDate, weight);
    }

    private Object[] getAirplaneData(int index) {
        return new Object[]{
                airplaneList.get(index).getModelName(),
                airplaneList.get(index).getSeatCapacity(),
                airplaneList.get(index).getNextInspectionDate(),
                airplaneList.get(index).getWeight()
        };
    }

    private void renderUI() {
        frame = new JFrame("Airplane Information System");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
