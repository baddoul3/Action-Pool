package resource;

/**
 * class FreeResourceAction allowing ResourcefulUser to free a resource given by ResourcePool
 * 
 * @author mamane
 */

import Action.*;
import Pool.*;
import resource.Resource;
import resource.ResourcefulUser;


public class FreeResourceAction <T extends Resource> extends Action{

	protected boolean isReady = true;
	protected boolean isFinished = false;
	protected ResourcePool<T> resourcePool;
	protected ResourcefulUser<T> resourcefulUser;
	
	
	public FreeResourceAction(ResourcePool<T> resourcePool,
			ResourcefulUser<T> resourcefulUser) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;	
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
			resourcePool.freeResource(resourcefulUser.getResource());
			resourcefulUser.resetResource();
			isReady = true;
		}
		catch(IllegalArgumentException e){
		}
	}

	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}
}
