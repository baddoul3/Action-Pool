package Pool;

import resource.Basket;

public class Basketpool extends ResourcePool<Basket>{

	public Basketpool(int nbResources) {
		super(nbResources);
	}
	
	@Override
	protected Basket create() {
		return new Basket();
	}
	
}
