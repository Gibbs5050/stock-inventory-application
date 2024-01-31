/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import uk.ac.tees.scedt.b1448179.console.BBStockItem;

/**
 *
 * @author b1448179
 */
public class BBStockItemTableModel extends AbstractTableModel {

    private final List<BBStockItem> items;

    private final String[] columnHeader = {"Product Code","Product Title","Description","Unit Price","Quantity"};

    BBStockItemTableModel(List<BBStockItem> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnHeader.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        //item positions in array list
        BBStockItem item = items.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getProductCode();
            case 1:
                return item.getTitle();
            case 2:
                return item.getDescription();
            case 3:
                return item.getPencePrice();
            case 4:
                return item.getQuantity();
            default:
                return null;
        }
    }
//rename title columns
 @Override
    public String getColumnName(int column) {
        return columnHeader[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
