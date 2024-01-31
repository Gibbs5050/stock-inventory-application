/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import uk.ac.tees.scedt.b1448179.console.BB_Stores;

/**
 *
 * @author b1448179
 */
public class SalesTransactionsTableModel extends AbstractTableModel {

    public String[] columnNames = {"Entry Date/Time", "Product Code", "Quantity", "Unit Price"};

    private final List<BB_Stores> newSalesList;

    public SalesTransactionsTableModel(List<BB_Stores> newList) {
        this.newSalesList = newList;
    }

    @Override
    public int getRowCount() {
        return newSalesList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BB_Stores info = newSalesList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return info.getDate();
            case 1:
                return info.getProductCode();
            case 2:
                return info.getQuantity();
            case 3:
                return info.getPrice();
        }
        return null;
    }

}
