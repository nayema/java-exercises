package com.nayema.exercise_22;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AirplaneIS {
    private JPanel mainPanel;
    private JTable table1;
    private JButton insertButton;
    private JTextField modelNameTextField;
    private JTextField seatCapacityTextField;
    private JTextField nextInspectionDateTextField;
    private JTextField weightTextField;
    private JTextField queryModelNameTextField;
    private JButton queryButton;
    private JButton refreshButton;
    private AirplaneRepository repository;
    private DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
    private ArrayList<Airplane> airplaneList = new ArrayList<>();

    public AirplaneIS() throws SQLException {
        repository = new AirplaneRepository();
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Airplane newAirplane = new Airplane(
                        modelNameTextField.getText(),
                        seatCapacityTextField.getText(),
                        nextInspectionDateTextField.getText(),
                        weightTextField.getText()
                );
                try {
                    repository.insert(newAirplane);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                airplaneList.add(newAirplane);
                try {
                    updateTable();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                clearTextFields();
            }
        });
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                String modelName = queryModelNameTextField.getText();
                try {
                    Airplane airplane = repository.retrieve(modelName);
                    airplaneList.add(airplane);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    updateTable();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                try {
                    populateTable();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws IOException, SQLException {
        new AirplaneIS().buildAirplaneIS();
    }

    private void buildAirplaneIS() throws SQLException {
        populateTable();
        renderUI();
    }

    private void populateTable() throws SQLException {
        String[] columnNames = {"Model Name", "Seat Capacity", "Next Inspection Date", "Weight (lbs)"};
        tableModel.setColumnIdentifiers(columnNames);

        Statement statement = repository.getConnection().createStatement();
        String query = "SELECT model_name, seat_capacity, next_inspection_date, weight FROM airplanes";
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        while (resultSet.next()) {
            Object[] objects = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                objects[i] = resultSet.getObject(i + 1);
            }
            tableModel.addRow(objects);
        }
        table1.setModel(tableModel);
    }

    private void renderUI() {
        JFrame frame = new JFrame("Airplane Information System");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateTable() throws SQLException {
        Object[] newAirplaneRecord = getAirplaneData(airplaneList.size() - 1);
        tableModel.addRow(newAirplaneRecord);
    }

    private Object[] getAirplaneData(int index) {
        return new Object[]{
                airplaneList.get(index).getModelName(),
                airplaneList.get(index).getSeatCapacity(),
                airplaneList.get(index).getNextInspectionDate(),
                airplaneList.get(index).getWeight()
        };
    }

    private void clearTextFields() {
        modelNameTextField.setText(null);
        seatCapacityTextField.setText(null);
        nextInspectionDateTextField.setText("DD-MMM-YYYY");
        weightTextField.setText(null);
    }
}
