package resource;
<<<<<<< HEAD

import java.util.NoSuchElementException;

import Action.*;
import Pool.*;
import resource.Resource;
import resource.ResourcefulUser;
=======
import java.util.NoSuchElementException;
import Action.Action;
import Pool.ResourcePool;
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88

public class TakeResourceAction <T extends Resource> extends Action{
	
	protected boolean isReady = true;
	protected boolean isFinished = false;
	protected ResourcePool<T> resourcePool;
	protected ResourcefulUser<T> resourcefulUser;

<<<<<<< HEAD

=======
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
	public TakeResourceAction(ResourcePool<T> resourcePool, 
			ResourcefulUser<T> resourcefulUser) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;
	}
	
	public ResourcePool<T> getResourcePool(){
		return resourcePool;
	}
<<<<<<< HEAD

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
=======
	
	public boolean isReady() {
		return isReady;
	}
	
	public boolean isFinished() {
		return isFinished;
	}
	
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
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

<<<<<<< HEAD
	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
=======
	public boolean isInProgress() {
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
		return false;
	}
}
