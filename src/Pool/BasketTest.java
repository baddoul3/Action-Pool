  
package Pool;

import static org.junit.Assert.*;

import org.junit.*;
/**
 * @author negmi
 *
 *
 */
public class BasketTest {
 
	Basket b = new Basket();
	
	@Test
	public void descriptionTest(){
		assertEquals("basket description", b.description());
	}
	
	@Test
	public void toStringTest(){
		assertEquals("basket", b.toString());  
	}
	
	
}
