/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BBStockItem class represents a stock item in a store and 
 * has functionality for reading and writing data to a CSV file
 * @author b1448179
 */
public class BBStockItem implements Subject, BBStockItemRecords {

    public static void exportCSV(List<BBStockItem> items) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
private final String productCode;  // product code of the item
    private final String title; // title of the item
    private final String description; // description of the item
    private final int pencePrice; // price of the item in pence
    private int quantity; // quantity of the item available in the stock
    private final List<Observer> observers = new ArrayList<>(); // list of observers

    /**
     * 
     * @param productCode of the item
     * @param title of the item
     * @param description of the item
     * @param pencePrice of the item
     * @param quantity of the item available in the stock
     */
    
    public BBStockItem(String productCode,
            String title,
            String description,
            int pencePrice,
            int quantity) {
        this.productCode = productCode;
        this.title = title;
        this.description = description;
        this.pencePrice = pencePrice;
        this.quantity = quantity;
    }
    /**
     * method to get product code of the item
     * @return product code of the item
     */
    
    @Override
    public String getProductCode() {
        return productCode;
    }
    /**
     * method to get title of the item
     * @return title of the item
     */
    @Override
    public String getTitle() {
        return title;
    }
    /**
     * method to get description of the item
     * @return description of the item
     */
    @Override
    public String getDescription() {
        return description;
    }
    
    /**
     * method to get price of the item in pence
     * @return price of the item in pence
     */
    
    public int getPencePrice() {
        return pencePrice;
    }
    /**
     * method to get quantity of the item available in the stock
     * @return quantity of the item available in the stock
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    /**
     * method to set quantity of the item available in the stock
     * @param quantity of the item available in the stock
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        reducedStock(); // we update setQuantity when stock is reduced
    }
    
    @Override
    public String toString() {
        return "BBStockItem{" + "productCode=" + productCode + ","
                + "title=" + title + ", "
                + "description=" + description + ","
                + "pencePrice=" + pencePrice + ","
                + "quantity=" + quantity + '}';
    }

    //method to update CSV after buying and selling
    public void updateCSV(List<BBStockItem> items) {
        try ( FileWriter output = new FileWriter("./data/barkers_boutique_stock_list_example.csv", false);  CSVWriter myOutput = new CSVWriter(output, ',', CSVWriter.NO_QUOTE_CHARACTER);) {

            for (BBStockItem item : items) {
                String[] data = {item.getProductCode(),
                    item.getTitle(),
                    item.getDescription(),
                    Integer.toString(item.getPencePrice()),
                    Integer.toString(item.getQuantity())};

                myOutput.writeNext(data);
            }
//ouput the outcome of file update
            System.out.println("File Successfully Updated");
        } catch (IOException e) {
            System.out.println("can not update file");
        }
    }

    public static List<BBStockItem> importCSV() {
        List<BBStockItem> importedItems = new ArrayList<>();

        try ( Scanner myInput = new Scanner(new FileReader("./data/barkers_boutique_stock_list_example.csv"))) {
            while (myInput.hasNextLine()) {
                //delimiting CSV by spliting the comma
                String[] columns = myInput.nextLine().split(",");

                if (columns.length < 5) {
                    System.err.println("Insufficient data, unable to create object of BBStockItem");

                    //to reiterate the process
                    continue;
                }
                //create an object of BBStockItem calling it item, and convert the strings to int by using Interger.parseInt
                BBStockItem item = new BBStockItem(columns[0],
                        columns[1],
                        columns[2],
                        Integer.parseInt(columns[3]),
                        Integer.parseInt(columns[4]));

                //add new stock to the already existing file
                importedItems.add(item);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        }
        return importedItems;
    }

    public void saleInfo(int quantity) {

        //loads to csv by opening a FileWriter for the specified file, with the option to overwrite the file if it already exists
        try ( FileWriter output = new FileWriter("./data/SalesTransactions_list.csv", true);  CSVWriter myOutput = new CSVWriter(output, ',', CSVWriter.NO_QUOTE_CHARACTER);) {

            String[] data = {String.valueOf(java.time.LocalDateTime.now()),
                this.getProductCode(),
                Integer.toString(quantity),
                String.format("%d", this.getPencePrice())};

            myOutput.writeNext(data);

            System.out.println("File Successfully Updated");
        } catch (IOException e) {
            System.out.println("can not update file");
        }

    }

    @Override
    public void registerObserver(Observer a) {
        observers.add(a);
    }

    @Override
    public void unregisterObserver(Observer a) {
        observers.remove(a);
    }

    @Override
    public void alertObserver() {
        for (Observer a : observers) {
            a.update(productCode, quantity);
        }
    }

    public void reducedStock() {
        if (quantity < 10) {
            alertObserver();
        }
    }

    @Override
    public int getPriceInPound() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getPriceInPence() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
