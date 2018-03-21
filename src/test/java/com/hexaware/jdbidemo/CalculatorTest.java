package com.hexaware.jdbidemo;

import com.hexaware.jdbidemo.Calculator;
import static org.junit.Assert.*;
import java.text.ParseException;
import org.junit.*;
import java.util.*;


public class CalculatorTest {

    static Calculator calculator = null;

    @BeforeClass
    public static void setUp(){
        System.out.println("Before all the test cases are executed ..");        
        calculator = new Calculator();
    }
    @Before
    public void setUpBeforeMethodCall(){
//        System.out.println("Before calling the method");
    }

    @After
    public void setUpAfterMethodCall(){
  //      System.out.println("After calling the method");
//        calculator = new Calculator();
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("After all the test cases are executed ..");
        calculator = null;  
    }


    @Test
    public void testSumWithPositiveValues(){
        int result = 0;
        try{
            result = calculator.sum("34","56");
        } catch(ParseException e){
            fail("This method should not throw exception");
        }
        assertEquals(90, result);
    }
    
    @Test
    public void testSumWithNegativeValues(){
        int result = 0;
        try{
            result = calculator.sum("-34", "56");
        } catch (ParseException e){
            fail("The method is not parsing the correct value.");
        }
        assertEquals(22, result);
    }    
    @Test
    public void testSumWithInvalidStringValues(){
        int result = 0;
        try{
            result = calculator.sum("abdgfdg", "56");
        } catch (Exception e){
            assertNotNull(e);
            assertTrue(e instanceof NumberFormatException);
        }
        assertEquals(0, result);
    }   

    @Test(expected=NumberFormatException.class)
    public void testSumWithInvalidStringValuesCatchingException() throws ParseException{
        int result = calculator.sum("abdgfdg", "56");
    }

    @Test
    public void testRetunList(){
        List<String> list = calculator.returnList();
        assertNotNull(list);
        assertTrue(list.size() == 2);
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }  

    @Test
    public void testConstructor(){
        Calculator calculator = new Calculator(34,56);
        int a = calculator.getA();
        int b = calculator.getB();
        assertEquals(a, 34);
        assertEquals(b, 56);
    }          

    @Test
    public void testSetA(){
        Calculator calculator = new Calculator();
        calculator.setA(78);
        int b = calculator.getA();
        assertEquals(b, 78);
    } 

    @Test
    public void testHashCode(){
        Calculator calculator = new Calculator();
        int b = calculator.hashCode();
        assertEquals(b, 34);
    }             

    @Test
    public void testEqusls(){
        Calculator calculator = new Calculator();
        Calculator calculator2 = calculator;
        assertEquals(calculator, calculator2);
    }             

    @Test
    public void testEquslsWithSameValues(){
        Calculator calculator = new Calculator(45,56);
        Calculator calculator2 = new Calculator(45,56);;
        assertEquals(calculator, calculator2);
    }  

    @Test
    public void testEquslsWithDifferentValues(){
        Calculator calculator = new Calculator(45,56);
        Calculator calculator2 = new Calculator(45,56);
        assertEquals(calculator, calculator2);
    }                


}