/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package uk.ac.tees.scedt.b1448179.console;

import java.util.ArrayList;
import uk.ac.tees.scedt.b1448179.console.MMStockItem;
import uk.ac.tees.scedt.b1448179.console.MeadMAdapter;
import java.util.List;
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
public class MeadMAdapterTest {

    public MeadMAdapterTest() {
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
     * Test of getProductCode method, of class MeadMAdapter.
     */
    @Test
    public void testGetProductCode() {
        System.out.println("getProductCode");
        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter instance = new MeadMAdapter(stock);
        String expResult = "EXE-123456-MM";
        String result = instance.getProductCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class MeadMAdapter.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter instance = new MeadMAdapter(stock);
        String expResult;
        expResult = "A fancy code                                     ";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class MeadMAdapter.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter instance = new MeadMAdapter(stock);
        String expResult = "Here is a description of that fancy coat";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPriceInPound method, of class MeadMAdapter.
     */
    @Test
    public void testGetPriceInPound() {
        System.out.println("getPriceInPound");
        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter instance = new MeadMAdapter(stock);
        int expResult = 10;
        int result = instance.getPriceInPound();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPriceInPence method, of class MeadMAdapter.
     */
    @Test
    public void testGetPriceInPence() {
        System.out.println("getPriceInPence");
        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter instance = new MeadMAdapter(stock);
        int expResult = 99;
        int result = instance.getPriceInPence();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class MeadMAdapter.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter instance = new MeadMAdapter(stock);
        int expResult = 100;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testConstructor() {
        MMStockItem item = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter adapter = new MeadMAdapter(item);
        assertEquals("EXE-123456-MM", adapter.getProductCode());
        assertEquals("A fancy code                                     ", adapter.getTitle());
        assertEquals("Here is a description of that fancy coat", adapter.getDescription());
        assertEquals(10, adapter.getPriceInPound());
        assertEquals(99, adapter.getPriceInPence());
        assertEquals(100, adapter.getQuantity());
    }
    
    
    
    /**
     * Test of setQuantity method, of class MeadMAdapter.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
        MeadMAdapter instance = new MeadMAdapter(stock);
        instance.setQuantity(quantity);
    }

//    /**
//     * Test of toString method, of class MeadMAdapter.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        MMStockItem stock = new MMStockItem(1, "123456", "A fancy code                                     Here is a description of that fancy coat", 10, 99, 100);
//        MeadMAdapter instance = new MeadMAdapter(stock);
//        String expResult = "MMStockItem{productCode=EXE-123456-MM, titleA fancy code                                     - description=Here is a description of that fancy coat, priceInPound=10, priceInPence=99,] quantity=100}";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//    }
    
    @Test
    public void testGetAdaptedList() {
        List<BBStockItem> stockItems = new ArrayList<>();
        List<BBStockItem> adaptedItems = MeadMAdapter.getAdaptedList(stockItems);
        assertEquals("EXE-123456-MM", adaptedItems.get(0).getProductCode());
        assertEquals("A fancy code                                     ", adaptedItems.get(0).getTitle());
        assertEquals("Here is a description of that fancy coat", adaptedItems.get(0).getDescription());
        assertEquals(1099, adaptedItems.get(0).getPencePrice());
        assertEquals(100, adaptedItems.get(0).getQuantity());
    }
    
}
