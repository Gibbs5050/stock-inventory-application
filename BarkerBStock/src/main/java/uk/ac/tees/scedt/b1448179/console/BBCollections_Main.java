/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

import java.util.List;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author b1448179
 */   

// display stock in array format
public class BBCollections_Main {
    public static void main(String[] args) throws IOException {
 System.out.println(" ********** BARKER'S BOUTIQUE STOCK INVENTORY CONSOLE APPLICATION **********\n\n");
 System.out.println(" ********** This displays all updated stock items and sales transactions from CSV **********\n\n");
        // Create a list of file paths
        List<String> filePaths = Arrays.asList("./data/barkers_boutique_stock_list_example.csv", "./data/SalesTransactions_list.csv");
        // Iterate through the list of file paths
        for (String filePath : filePaths) {
            // Create a CSVReader for the current file
            CSVReader reader = new CSVReader(new FileReader(filePath));
            // Read and display the contents of the current file
            String[] nextLine;
            System.out.println(filePath + ":");
            while ((nextLine = reader.readNext()) != null) {
                System.out.println(Arrays.toString(nextLine));
                
            }
        }
    }
}