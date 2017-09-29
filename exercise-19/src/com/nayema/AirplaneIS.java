package com.nayema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
    private JLabel modelNameLabel;
    private JLabel seatCapacityLabel;
    private JLabel nextInspectionDateLabel;
    private JLabel weightLabel;
    private JScrollPane tableScrollPane;
    private JButton clearFieldButton;
    private ArrayList<Airplane> airplaneList = new ArrayList<>();
    private DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

    public AirplaneIS() {
        newAirplaneRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNewAirplaneDataAndWriteToCSV();
                addNewAirplaneRowToTable();
                newAirplaneRecordButton.setText("Saved");
            }

            private void getNewAirplaneDataAndWriteToCSV() {
                Airplane newAirplane = new Airplane(
                        modelNameTextField.getText(),
                        seatCapacityTextField.getText(),
                        nextInspectionDateTextField.getText(),
                        weightTextField.getText()
                );
                airplaneList.add(newAirplane);

                try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("data.csv", true)))) {
                    printWriter.println(new AirplaneCsvSerializer(newAirplane).serialize());
                    printWriter.flush();
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void addNewAirplaneRowToTable() {
                Object[] newAirplaneRowData = getAirplaneData(airplaneList.size() - 1);
                tableModel.addRow(newAirplaneRowData);
            }
        });
        clearFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
            }

            private void clearTextFields() {
                newAirplaneRecordButton.setText("Save new airplane record");
                modelNameTextField.setText(null);
                seatCapacityTextField.setText(null);
                nextInspectionDateTextField.setText("DD-MMM-YYYY");
                weightTextField.setText(null);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        new AirplaneIS().buildAirplaneIS();
    }

    public void buildAirplaneIS() throws IOException {
        populateTable();
        renderUI();
    }

    private void populateTable() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
        String firstLine = reader.readLine();
        String[] columnNames = firstLine.split(",");
        tableModel.setColumnIdentifiers(columnNames);

        Object[] dataLines = reader.lines().toArray();
        for (Object dataLine : dataLines) {
            String line = dataLine.toString();
            String[] airplaneRow = line.split(",");
            Airplane airplane = new Airplane(airplaneRow);
            airplaneList.add(airplane);
        }
        for (int i = 0; i < airplaneList.size(); i++) {
            Object[] airplaneRowData = getAirplaneData(i);
            tableModel.addRow(airplaneRowData);
        }
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
