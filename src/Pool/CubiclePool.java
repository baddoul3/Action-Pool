package Pool;
import resource.*;
/**
 * @author mahroug + mamane
 */
/**
 * This class is a particular type of resource
 */
public class CubiclePool extends ResourcePool<Cubicle>{

	public CubiclePool(int nbResources) {
		super(nbResources);
	}

	protected Cubicle create() {
		return new Cubicle();
	}
}
