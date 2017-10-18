package com.nayema.exercise_22;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AirplaneIS {
    private JFrame frame;
    private JPanel mainPanel;
    private JTable table1;
    private JPanel editorPanel;
    private JButton insertButton;
    private JTextField modelNameTextField;
    private JTextField seatCapacityTextField;
    private JTextField nextInspectionDateTextField;
    private JTextField weightLbsTextField;
    private JLabel modelNameLabel;
    private JLabel seatCapacityLabel;
    private JLabel inspectionDateLabel;
    private JLabel weightLabel;
    private JButton queryButton;
    private SqlHelper sqlHelper;

    public AirplaneIS() throws SQLException {
        sqlHelper = new SqlHelper("jdbc:sqlite:/Users/Nayema/Development/java-exercises/nayema.sqlite.airplane");
    }

    public static void main(String[] args) throws IOException, SQLException {
        new AirplaneIS().buildAirplaneIS();
    }

    private void buildAirplaneIS() throws SQLException {
        populateTable();
        renderUI();
    }

    private void populateTable() throws SQLException {
        ResultSetMetaData resultSetMetaData = sqlHelper.queryResultSetMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setColumnCount(0);
        for (int i = 1; i < columnCount; i++) {
            tableModel.addColumn(resultSetMetaData.getColumnName(i));
        }
        tableModel.setRowCount(0);
        ResultSet resultSet = sqlHelper.getResultSet();
        while (resultSet.next()) {
            String[] record = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                record[i] = resultSet.getString(i + 1);
            }
            tableModel.addRow(record);
        }
        tableModel.fireTableDataChanged();
        resultSet.close();
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
