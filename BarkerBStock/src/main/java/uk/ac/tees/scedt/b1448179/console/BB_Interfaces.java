/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

/**
 *
 * @author b1448179
 */
interface Subject {
    //registers, unregisters and alerts observer

    public void registerObserver(Observer a);

    public void unregisterObserver(Observer a);

    public void alertObserver();

}

interface Observer {
    
    public void update(String productCode, int quantity);

    public String display();

}
//to pull records from BBStockItem class

interface BBStockItemRecords {

    public String getProductCode();

    public String getTitle();

    public String getDescription();

    public int getPriceInPound();

    public int getPriceInPence();

    public int getQuantity();

    public void setQuantity(int quantity);

}
