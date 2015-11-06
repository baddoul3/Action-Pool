package Pool;
<<<<<<< HEAD

import resource.Cubicle;

=======
import resource.*;
/**
 * @author mahroug + mamane
 */
/**
 * This class is a particular type of resource
 */
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
public class CubiclePool extends ResourcePool<Cubicle>{

	public CubiclePool(int nbResources) {
		super(nbResources);
	}

<<<<<<< HEAD
	@Override
=======
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
	protected Cubicle create() {
		return new Cubicle();
	}
}
