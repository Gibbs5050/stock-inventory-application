/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

/**
 *
 * @author b1448179
 */
public class BB_Buying implements Observer {

    private String productCode; // Field to hold the product code of the item that triggered the alert.
    private int quantity; // Field to hold the remaining quantity of the item that triggered the alert.

    public BB_Buying(BBStockItem item) {
        item.registerObserver(this); // Registering the current instance of BB_Buying as an observer of the passed BBStockItem.
    }

    @Override
    public void update(String productCode, int quantity) {
        this.productCode = productCode; // Assigning the passed product code to the field
        this.quantity = quantity; // Assigning the passed quantity to the field
    }

    @Override
    public String display() {
        if (productCode == null) { // check if product code is null
            return "no recent update"; // if product code is null, return "no recent update"
        } else {
            System.out.println(quantity + " left " + productCode); // print the remaining quantity and product code
            return "low stock"; //return "low stock"
        }
    }

}

