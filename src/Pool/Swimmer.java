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
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public boolean isReady() {
		return !isFinished();
	}

	@Override
	public boolean isFinished() {
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
}
