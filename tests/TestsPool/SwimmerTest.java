package TestsPool;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import Pool.Basketpool;
import Pool.CubiclePool;
import Pool.Swimmer;

/**
 * 
 * @author mahroug
 *
 */

public class SwimmerTest {

	protected Basketpool basket;
	protected CubiclePool cubicle;
	protected Swimmer swimmer1, swimmer2;

	
	@Before
	public void setUp(){
		basket = new Basketpool(1);
		cubicle = new CubiclePool(1);
		swimmer1 = new Swimmer("toto", basket, cubicle, 1, 1, 1);
		swimmer2 = new Swimmer("titi", basket, cubicle, 1, 1, 1);
	}
	
	@Test
	public void testConstructeur() {
		assertEquals("toto", swimmer1.getName());
		assertEquals(basket, swimmer1.getBasketPool());
		assertEquals(cubicle,  swimmer1.getCubiclePool());
		assertTrue(swimmer1.isReady());
		assertFalse(swimmer1.isFinished());
	}
	
	@Test
	public void doStepTest(){
		while (!swimmer2.isFinished()){
			swimmer2.doStep();
		}
		assertTrue(swimmer2.isFinished());		
	}

}