/**
 * 
 */
package Pool;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author negmi
 *
 */
public class RessourcefullUserTest {
	ResourcefulUser<Resource> r = new ResourcefulUser<>();
	
	@Test
	public void resetResourceTest() {
		assertEquals(null, r.resource);
	 
	}
}
