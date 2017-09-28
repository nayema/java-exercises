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
                String[] newAirplaneData = getNewAirplaneDataFromTextFields();
                writeToCSVFile(newAirplaneData);

                Object[] newAirplaneRowData = getAirplaneData(airplaneList.size() - 1);
                tableModel.addRow(newAirplaneRowData);
                newAirplaneRecordButton.setText("Saved");
            }

            private String[] getNewAirplaneDataFromTextFields() {
                String[] newAirplaneData = new String[4];
                newAirplaneData[0] = modelNameTextField.getText();
                newAirplaneData[1] = seatCapacityTextField.getText();
                newAirplaneData[2] = nextInspectionDateTextField.getText();
                newAirplaneData[3] = weightTextField.getText();
                Airplane newAirplane = makeAirplane(newAirplaneData);
                airplaneList.add(newAirplane);
                return newAirplaneData;
            }

            private void writeToCSVFile(String[] newAirplaneData) {
                try (FileWriter fileWriter = new FileWriter("data.csv", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                     PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                    printWriter.println(newAirplaneData[0] + ","
                            + newAirplaneData[1] + ","
                            + newAirplaneData[2] + ","
                            + newAirplaneData[3]);
                    printWriter.flush();
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
