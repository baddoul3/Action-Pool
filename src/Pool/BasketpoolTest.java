package Pool;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author negmi
 *
 */
//test 
public class BasketpoolTest {
	BasketPool b1 = new BasketPool(2);
	@Test 
	public void toStringtest(){
		assertEquals("basket pool", b1.toString());
	}
	
	
	public void descriptiontest(){
		assertEquals("trying to take resource from "+b1.toString()+" ...", b1.description());
	}

}
