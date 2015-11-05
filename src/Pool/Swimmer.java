package Pool;

import Action.*;

import Pool.*;
import resource.*;
/**
 * 
 * @author mahroug + addou + mamane
 *
 */
public class Swimmer extends Action {
	protected String name;
	protected ResourcePool basketPool;
	protected ResourcePool cubiclePool;
	protected ResourcefulUser<Resource> rBasket;
	protected ResourcefulUser<Resource> rCubicle;
	protected Foreseeable undressing;
	protected Foreseeable swimming;
	protected Foreseeable dressing;
	protected TakeResourceAction<Resource> traBasket;
	protected TakeResourceAction<Resource> traCubicle;
	protected FreeResourceAction<Resource> fraBasket;
	protected FreeResourceAction<Resource> fraCubicle;
	
	
	
	public Swimmer(String name, Basketpool basketPool, CubiclePool cubiclePool, int undressingTime, int swimmingTime, int dressingTime){
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		rBasket = new ResourcefulUser<Resource>();
		rCubicle = new ResourcefulUser<Resource>();
		undressing = new Foreseeable(undressingTime);
		swimming = new Foreseeable(swimmingTime);
		dressing = new Foreseeable(dressingTime);
		traBasket = new TakeResourceAction<Resource>((ResourcePool)basketPool, rBasket);
		traCubicle = new TakeResourceAction<Resource>((ResourcePool)cubiclePool, rCubicle);
		fraBasket = new FreeResourceAction<Resource>((ResourcePool)basketPool, rBasket);
		fraCubicle = new FreeResourceAction<Resource>((ResourcePool)cubiclePool, rCubicle);
	}
	
	public String getName(){
		return name;
	}
	
	public Basketpool getBasketPool(){
		return (Basketpool) basketPool;
	}
	
	public CubiclePool getCubiclePool(){
		return (CubiclePool) cubiclePool;
	}
	
	
	@Override
	public boolean isReady() {
		return !isFinished();
	}

	@Override
	public boolean isFinished() {
		return undressing.isFinished() && swimming.isFinished() && dressing.isFinished() 
				&& rBasket.getResource() == null && rCubicle.getResource() == null;
	}


	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doStep() {
		// TODO Auto-generated method stub
		
	}
}