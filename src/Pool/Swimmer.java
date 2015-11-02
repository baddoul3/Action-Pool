package Pool;

/**
 * 
 * @author mahroug
 *
 */

public class Swimmer {
	
	protected String name;
	protected int timeToSwim;
	protected int timeToDress;
	protected int timeToUndress;
	protected BasketPool baskets;
	protected CubiclePool cubicles;
	protected ResourcefulUser<Resource> resourcefullUserBasket;
	protected ResourcefulUser<Resource> resourcefullUserCubicle;

	public Swimmer(String name, BasketPool baskets, CubiclePool cubicles,int timeToUndress, int timeToSwim, int timeToDress) {
		super();
		this.name=name;
		this.baskets=baskets;
		this.cubicles=cubicles;
		this.timeToSwim=timeToSwim;
		this.timeToDress=timeToDress;
		this.timeToUndress=timeToUndress;
		resourcefullUserBasket=new ResourcefulUser<Resource>();
		resourcefullUserCubicle=new ResourcefulUser<Resource>();
		
	
	}

}
