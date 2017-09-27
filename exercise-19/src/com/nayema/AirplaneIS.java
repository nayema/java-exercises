package com.nayema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class AirplaneIS {
    private JFrame frame;
    private JPanel mainPanel;
    private JTable table;

    public static void main(String[] args) {
        new AirplaneIS().buildAirplaneIS();
    }

    public void buildAirplaneIS() {
        Vector<Vector<String>> airplaneData = readData2();
        //Object[][] airplaneData = readData();
        bindDataToTable2(airplaneData);
        renderUI();
    }

    private Object[][] readData() {
        AirplaneListHelper airplaneListHelper = new AirplaneListHelper();
        airplaneListHelper.readFromCSV();
        return airplaneListHelper.convertDataToTable();
    }

    private Vector<Vector<String>> readData2() {
        AirplaneListHelper airplaneListHelper = new AirplaneListHelper();
        airplaneListHelper.readFromCSV();
        return airplaneListHelper.convertDataToTable2();
    }

    private void bindDataToTable(Object[][] airplaneData) {
        String[] columnNames = {"Model Name", "Seat Capacity", "Next Inspection Date", "Weight"};
        DefaultTableModel tableModel = new DefaultTableModel(airplaneData, columnNames);
        table.setModel(tableModel);
        table.setAutoCreateRowSorter(true);
    }

    private void bindDataToTable2(Vector<Vector<String>> airplaneData) {
        String[] columnNames = {"Model Name", "Seat Capacity", "Next Inspection Date", "Weight"};
        DefaultTableModel tableModel = new DefaultTableModel(airplaneData, columnNames);
        table.setModel(tableModel);
        table.setAutoCreateRowSorter(true);
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
