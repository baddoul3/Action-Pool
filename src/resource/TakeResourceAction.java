package resource;

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


	public TakeResourceAction(ResourcePool<T> resourcePool, 
			ResourcefulUser<T> resourcefulUser) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;
	}
	
	public ResourcePool<T> getResourcePool(){
		return resourcePool;
	}

	/**
	* tell if the action is ready
	* @return true if the action is ready else false
	*/
	@Override
	public boolean isReady() {
		return isReady;
	}

	/**
	 * tell if the action is finished
	 * @return true if is finished else false
	 */
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
