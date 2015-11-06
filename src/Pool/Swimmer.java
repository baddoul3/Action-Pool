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
<<<<<<< HEAD
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
=======
	protected ResourcePool basketPool, cubiclePool;
	protected ResourcefulUser<Resource> rfuBasket , rfuCubicle;
	protected Foreseeable toUndress , toSwim , toDress;
	protected TakeResourceAction<Resource> tResABasket;
	protected TakeResourceAction<Resource> tResACubicle;
	protected FreeResourceAction<Resource> fResABasket;
	protected FreeResourceAction<Resource> fResACubicle;
	
	
	
	public Swimmer(String name, Basketpool basketPool, CubiclePool cubiclePool, int toUndressTime, int toSwimTime, int toDressTime){
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		rfuBasket = new ResourcefulUser<Resource>();
		rfuCubicle = new ResourcefulUser<Resource>();
		toUndress = new Foreseeable(toUndressTime);
		toSwim = new Foreseeable(toSwimTime);
		toDress = new Foreseeable(toDressTime);
		tResABasket = new TakeResourceAction<Resource>((ResourcePool)basketPool, rfuBasket);
		tResACubicle = new TakeResourceAction<Resource>((ResourcePool)cubiclePool, rfuCubicle);
		fResABasket = new FreeResourceAction<Resource>((ResourcePool)basketPool, rfuBasket);
		fResACubicle = new FreeResourceAction<Resource>((ResourcePool)cubiclePool, rfuCubicle);
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
	}
	
	public String getName(){
		return name;
	}
	
<<<<<<< HEAD
	public Basketpool getBasketPool(){
		return (Basketpool) basketPool;
	}
	
	public CubiclePool getCubiclePool(){
		return (CubiclePool) cubiclePool;
	}
	
	
=======
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
	@Override
	public boolean isReady() {
		return !isFinished();
	}

	@Override
	public boolean isFinished() {
<<<<<<< HEAD
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
=======
		return toUndress.isFinished() && toSwim.isFinished() && toDress.isFinished() 
				&& rfuBasket.getResource() == null && rfuCubicle.getResource() == null;
	}
	public void doStep() {
		
		System.out.println(this.getName()+"'s turn");
		if (rfuBasket.getResource() == null){
			System.out.print(getName()+" trying to take resource from pool basket... ");
			tResABasket.doStep();
		}
		else if (!toUndress.isFinished() && rfuCubicle.getResource() == null){
				System.out.print(getName()+" trying to take resource from pool cubicle... ");
				tResACubicle.doStep();			
			
		}
		else if (rfuCubicle.getResource() != null && toDress.isFinished()){
			System.out.println(getName()+" freeing resource pool cubicle");
			fResACubicle.doStep();		
		}
		else{
			System.out.println(getName()+" freeing resource pool basket");
			fResABasket.doStep();					
		}
	}

	public boolean isInProgress() {
		return false;
	}
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
}