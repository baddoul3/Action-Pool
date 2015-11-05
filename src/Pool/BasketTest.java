/**
 * 
 */
package Pool;

import static org.junit.Assert.*;
import Action.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author negmi
 *
 */
public class BasketTest {
 
	Basket b = new Basket();
	
	@Test
	public void descriptionTest(){
		assertEquals("basket description", b.description());
	}
	
	public void toStringTest(){
		assertEquals("basket", b.toString());  
	}
	
	
}
