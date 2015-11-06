package Pool;
<<<<<<< HEAD

import resource.Basket;

=======
import resource.*;
/**
 * @author mahroug + mamane
 */
/**
 * This class is a particular type of resource
 */
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
public class Basketpool extends ResourcePool<Basket>{

	public Basketpool(int nbResources) {
		super(nbResources);
	}
<<<<<<< HEAD
	
	@Override
	protected Basket create() {
		return new Basket();
	}
	
=======

	protected Basket create() {
		return new Basket();
	}

>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
}
