package Pool;
import resource.*;
/**
 * @author mahroug + mamane
 */
/**
 * This class is a particular type of resource
 */
public class Basketpool extends ResourcePool<Basket>{

	public Basketpool(int nbResources) {
		super(nbResources);
	}

	protected Basket create() {
		return new Basket();
	}

}
