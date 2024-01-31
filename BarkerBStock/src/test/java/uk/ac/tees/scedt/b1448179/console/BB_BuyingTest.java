/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

import uk.ac.tees.scedt.b1448179.console.BBStockItem;
import uk.ac.tees.scedt.b1448179.console.BB_Buying;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author b1448179
 */
public class BB_BuyingTest {

    public BB_BuyingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class BB_Buying.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        BBStockItem item = new BBStockItem("EVE1234567", "An elegant red dress", " Perfect for those evening parties", 10000, 10);
                System.out.println(item);
        item.setQuantity(15);
        String productCode = "EVE1234567";
        int quantity = 0;
        BB_Buying instance = new BB_Buying(item);
        instance.update(productCode, quantity);
    }

    /**
     * Test of display method, of class BB_Buying.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        BBStockItem item = new BBStockItem("EVE1234567", "An elegant red dress", " Perfect for those evening parties", 10000, 10);
                System.out.println(item);
        BB_Buying instance = new BB_Buying(item);
        item.setQuantity(15);
        String expResult = "no recent update";
        String result = instance.display();
        assertEquals(expResult, result);
    }

}
