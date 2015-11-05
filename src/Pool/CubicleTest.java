
package Pool;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author negmi
 *
 */
public class CubicleTest {
	Cubicle c1 = new Cubicle();
	assertEquals("cubicle description", c1.description());
	assertEquals("cubicle", c1.toString());

}
