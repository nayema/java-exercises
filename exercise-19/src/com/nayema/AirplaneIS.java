package com.nayema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AirplaneIS {
    private JFrame frame;
    private JPanel mainPanel;
    private JTable table;

    public static void main(String[] args) {
        new AirplaneIS().buildAirplaneIS();
    }

    public void buildAirplaneIS() {
        Object[][] airplaneData = readData();
        bindDataToTable(airplaneData);
        renderUI();
    }

    private Object[][] readData() {
        AirplaneListHelper airplaneListHelper = new AirplaneListHelper();
        airplaneListHelper.readFromCSV();
        return airplaneListHelper.convertDataToTable();
    }

    private void bindDataToTable(Object[][] airplaneData) {
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
