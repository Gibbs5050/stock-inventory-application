/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.scedt.b1448179.console; 

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Represents a Mead's Modernity stock item.
 *  @author Steven Mead
 * @version 1.0
 * @since 1.0
 */
public class MMStockItem {

    private final int departmentId;
    private final String code;
    private final String nameAndDescription;
    private final int unitPricePounds;
    private final int unitPricePence;
    private int quantityInStock;


    /**
     * Constructor
     * 
     * @param departmentId
     * @param code
     * @param titleAndDescription
     * @param unitPricePounds
     * @param unitPricePence
     * @param quantityInStock
     * @since 1.0
     */
    public MMStockItem(int departmentId, String code, String titleAndDescription, int unitPricePounds, int unitPricePence, int quantityInStock) {
        this.departmentId = departmentId;
        this.code = code;
        this.nameAndDescription = titleAndDescription;
        this.unitPricePounds = unitPricePounds;
        this.unitPricePence = unitPricePence;
        this.quantityInStock = quantityInStock;
    }


    /**
     * Returns the department ID used by Mead's Modernity
     * @return the department id.
     * @since 1.0
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * Returns the code of this stock item.
     * @return a string with the 6-digit code.
     * @since 1.0
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Returns the name of this stock item.
     * @return a string with the name.
     * @since 1.0
     */
    public String getName() {
        return nameAndDescription.substring(0, 49);
    }
    
    /**
     * Return the description of this stock item.
     * @return a string with the description.
     * @since 1.0
     */
    public String getDescription() {
        return nameAndDescription.substring(49);
    }

    /**
     * Returns the whole pounds part of this stock item's unit price.
     * @return an integer that represents the whole pounds.
     * @since 1.0
     */
    public int getUnitPricePounds() {
        return unitPricePounds;
    }

    /**
     * Return the pence part of this stock item's unit price.
     * @return an integer that represents the pence.
     * @since 1.0
     */
    public int getUnitPricePence() {
        return unitPricePence;
    }

    /**
     * Return the quantity of this stock item currently available in stock.
     * @return an integer that represents to stock quantity available.
     * @since 1.0
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    public String getHumanFriendlyUnitPrice() {
        return String.format("%d%02d", getUnitPricePounds(), getUnitPricePence());
    }

    public void setQuanity(int newQuantity) {
        if (newQuantity >= 0) {
            quantityInStock = newQuantity;
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%s - %s - %s - UNIT PRICE: £%d.%d - QTY: %d",
                getDepartmentId(),
                getCode(),
                getName(),
                getDescription(),
                getUnitPricePounds(),
                getUnitPricePence(),
                getQuantityInStock());
    }

    /**
     * Load a collection of MMStockItems into a list
     * @return a list of the mead modernity stock items.
     * @since 1.0
     */
    public static List<MMStockItem> loadStock() {
        final List<MMStockItem> loadedStock = new ArrayList<>();
        try ( Scanner myInput = new Scanner(new FileReader("./data/mead_modernity_stock_list_example.csv"))) {
            while (myInput.hasNextLine()) {
                
                //Split file by comma delimiter for csv files
                String[] columns = myInput.nextLine().split(",");

                if (columns.length < 6) {
                    System.err.println("Incompartible data, unable to create object");

                    //proceed
                    continue;
                }
                //creating an object item  and converting the strings to int
                MMStockItem item = new MMStockItem(
                        Integer.parseInt(columns[0]), 
                        columns[1], 
                        columns[2], 
                        Integer.parseInt(columns[3].trim()), 
                        Integer.parseInt(columns[4].trim()), 
                        Integer.parseInt(columns[5].trim()));

                //add new stock to the already existing file
                loadedStock.add(item);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        }
        return loadedStock;
    }
}
