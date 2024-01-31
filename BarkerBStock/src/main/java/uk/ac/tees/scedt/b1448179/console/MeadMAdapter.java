/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

import java.util.List;

/**
 *
 * @author b1448179
 */
public class MeadMAdapter implements BBStockItemRecords {

    
    private final MMStockItem item;

    public MeadMAdapter(MMStockItem item) {

        this.item = item;
    }
//using switch statement to make product code compartible with the BB items table

    @Override
    public String getProductCode() {
        switch (item.getDepartmentId()) {
            case 1:
                return "EXE" + "-" + item.getCode() + "-" + "MM";
            case 2:
                return "CAS" + "-" + item.getCode() + "-" + "MM";
            case 3:
                return "SPO" + "-" + item.getCode() + "-" + "MM";
            default:
                break;
        }
        return null;
    }
    @Override
    public String getTitle() {
        return item.getName();
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }

    @Override
    public int getPriceInPound() {
        return item.getUnitPricePounds();
    }

    @Override
    public int getPriceInPence() {
        return item.getUnitPricePence();
    }

    @Override
    public int getQuantity() {
        return item.getQuantityInStock();
    }

    @Override
    public void setQuantity(int quantity) {
        item.setQuanity(quantity);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() { //to return the variables in String format
        return "MMStockItem{ProductCode= " + this.getProductCode() + " - "
                + "title= " + this.getTitle() + " - "
                + "description= " + this.getDescription() + " - "
                + this.getPriceInPence() + " - "
                + "quantity=" + this.getQuantity() + '}';
    }
//merging both files
    public static List<BBStockItem> getAdaptedList(List<BBStockItem> stockItems) {
        List<MMStockItem> items = MMStockItem.loadStock();

        for (MMStockItem item : items) {
            MeadMAdapter adaptedItem = new MeadMAdapter(item);
            
            BBStockItem stockItem = new BBStockItem(adaptedItem.getProductCode(),
                    adaptedItem.getTitle(),
                    adaptedItem.getDescription(),
                    Integer.parseInt(item.getHumanFriendlyUnitPrice()),
                    adaptedItem.getQuantity());

            stockItems.add(stockItem);
        }
        return stockItems;
    }
}
