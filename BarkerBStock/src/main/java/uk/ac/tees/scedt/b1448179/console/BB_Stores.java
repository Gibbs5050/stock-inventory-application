/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b1448179
 */
//gets and records all sales transactions
public class BB_Stores {

    public String date;
    public String productCode;
    public String quantity;
    public String price;

//contructor created
    public BB_Stores(String date, String productCode, String quantity, String price) {
        this.date = date;
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public static List<BB_Stores> loadSalesInfoCSV() {
        List<BB_Stores> saleInfo = null;

        try ( Scanner myInput = new Scanner(new FileReader("./data/SalesTransactions_list.csv"))) {
            saleInfo = new ArrayList<>();

            while (myInput.hasNext()) {
              
                
                //this seperates cells using comma in the case of csv files
                String[] columns = myInput.nextLine().split(",");

                if (columns.length < 4) {
               /*  System.err.println("more data needed");*/
                    continue;
                }// next iteration based on read data, create a new sale named newSale

                BB_Stores newSale = null;

                newSale = new BB_Stores(columns[0],
                        columns[1],
                        columns[2],
                        columns[3]);

                saleInfo.add(newSale);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BB_Stores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saleInfo;
    }

}
