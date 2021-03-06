package testJUnit;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import math.Calculatrice;


public class CalculatriceTest {
	
	   protected Calculatrice op;
	
	   @Before
	   public void setUp() {
		  op = new Calculatrice();
		  System.out.println("setUp");
		   
	   }
	   
	   @After
	   public void tearDown() {
		  System.out.println("tearDown"); 
	   }   
	 
	    
	   @Test
	   public void testAddition() throws Exception {		 
		   assertEquals(op.addition(2, 3), 5);
	   }
	   
	   @Test
	   public void testMultiplier() {		   
		   assertEquals(op.multiplier(2, 3), 6);	   }
	   
	   @Test
	   public void testDiviser()  {		   
		   assertEquals(op.diviser(6, 2), 3);
		   
		  
	   }
	 
	   @Test
	  public void testLireSymbole(){		  
		   assertEquals(op.lireSymbole(), '-');
	   }
	   
	   @Test(expected = NullPointerException.class)
	   public void methodCallToNullObject() {
	       Object o = null;
	       o.toString();
	   }	   
	  
	   
	   
}
