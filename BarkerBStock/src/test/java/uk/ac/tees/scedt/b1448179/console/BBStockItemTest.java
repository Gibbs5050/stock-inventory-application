/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BBStockItemTest {
    @Test
    public void testConstructor() {
        BBStockItem item = new BBStockItem("EVE1234567", "An elegant red dress", " Perfect for those evening parties", 10000, 10);
        assertEquals("EVE1234567", item.getProductCode());
        assertEquals("An elegant red dress", item.getTitle());
        assertEquals(" Perfect for those evening parties", item.getDescription());
        assertEquals(10000, item.getPencePrice());
        assertEquals(10, item.getQuantity());
    }
    
    @Test
    public void testSetQuantity() {
        BBStockItem item = new BBStockItem("EVE1234567", "An elegant red dress", " Perfect for those evening parties", 10000, 10);
        item.setQuantity(5);
        assertEquals(5, item.getQuantity());
    }
}
