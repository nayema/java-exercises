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

public class AirplaneIS {
    private JFrame frame;
    private JPanel mainPanel;
    private JTable table1;
    private JPanel editorPanel;
    private JButton insertButton;
    private JTextField modelNameTextField;
    private JTextField seatCapacityTextField;
    private JTextField nextInspectionDateTextField;
    private JTextField weightTextField;
    private JLabel modelNameLabel;
    private JLabel seatCapacityLabel;
    private JLabel inspectionDateLabel;
    private JLabel weightLabel;
    private JPanel queryPanel;
    private JTextField queryModelNameTextField;
    private JLabel queryModelNameLabel;
    private JButton queryButton;
    private AirplaneRepository repository;

    public AirplaneIS() throws SQLException {
        repository = new AirplaneRepository();
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Airplane airplane = new Airplane(
                        modelNameTextField.getText(),
                        seatCapacityTextField.getText(),
                        nextInspectionDateTextField.getText(),
                        weightTextField.getText()
                );
                try {
                    repository.insert(airplane);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                clearTextFields();
            }

            private void clearTextFields() {
                modelNameTextField.setText(null);
                seatCapacityTextField.setText(null);
                nextInspectionDateTextField.setText("DD-MMM-YYYY");
                weightTextField.setText(null);
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
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        String[] columnNames = {"ID", "Model Name", "Seat Capacity", "Next Inspection Date", "Weight (lbs)"};
        tableModel.setColumnIdentifiers(columnNames);

        Statement statement = repository.getConnection().createStatement();
        String query = "SELECT * FROM airplane_data";
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
        frame = new JFrame("Airplane Information System");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
