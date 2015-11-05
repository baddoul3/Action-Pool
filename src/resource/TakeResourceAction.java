package resource;

/**
 * class TakeResourceAction allowing ResourcefulUser to take a resource given by ResourcePool
 * 
 * @author mamane
 */

import java.util.NoSuchElementException;

import Action.*;
import Pool.*;
import resource.Resource;
import resource.ResourcefulUser;

public class TakeResourceAction <T extends Resource> extends Action{
	
	protected boolean isReady = true;
	protected boolean isFinished = false;
	protected ResourcePool<T> resourcePool;
	protected ResourcefulUser<T> resourcefulUser;


	public TakeResourceAction(CubiclePool cubiclePool, 
			ResourcefulUser<T> resourcefulUser) {
		this.resourcefulUser = resourcefulUser;
		ResourcePool<T> cubiclePool2 = (ResourcePool<T>) cubiclePool;
		this.resourcePool = cubiclePool2;
	}
	
	public ResourcePool<T> getResourcePool(){
		return resourcePool;
	}

	
	@Override
	public boolean isReady() {
		return isReady;
	}

	
	@Override
	public boolean isFinished() {
		return isFinished;
	}

	@Override
	public void doStep() {
		try {
			T res = resourcePool.provideResource();
			resourcefulUser.setResource(res);
			isReady = false;
			System.out.println("success");
		}
		catch(NoSuchElementException e){
			System.out.println("failed");
		}
	}

	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}
}
