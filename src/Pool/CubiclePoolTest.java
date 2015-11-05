package Pool;

import org.junit.*;

import static org.junit.Assert.*;


/**
 * @author negmi
 *
 */
public class CubiclePoolTest {

	CubiclePool c1 = new CubiclePool(1);
	
	@Test
	public void toStringTest(){
		assertEquals( "pool cubicle", c1.toString());
	}
	
	
	@Test
	public void createPoolTest(){
		assertTrue(CubiclePool.availableResources.contains(c1));	 
	}
	
	@Test
	public void descriptionTest() {
		assertEquals("description cubicle pool", c1.description()) ;
	}
}
