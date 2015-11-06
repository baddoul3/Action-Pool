package resource;
<<<<<<< HEAD

import Action.*;
import Pool.*;
import resource.Resource;
import resource.ResourcefulUser;

/**
 * Free a resource
 * @author Decottignies - Morlet
 *
 * @param <T> a Resource
=======
import Action.*;
import Pool.*;
import resource.*;
/**
 * @author mahroug + mamane
 */
/**
 * This class free a resource
 * it create the FreeResourceAction
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
 */
public class FreeResourceAction <T extends Resource> extends Action{

	protected boolean isReady = true;
	protected boolean isFinished = false;
	protected ResourcePool<T> resourcePool;
	protected ResourcefulUser<T> resourcefulUser;
<<<<<<< HEAD
	
	/**
	 * create the FreeResourceAction with an user and a resource
	 * @param resourcePool a resource from the pool
	 * @param resourcefulUser an user from the pool
	 */
=======

>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
	public FreeResourceAction(ResourcePool<T> resourcePool,
			ResourcefulUser<T> resourcefulUser) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;	
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
	* tell if the action is ready
	* @return true if the action is ready else false
	*/
	@Override
	public boolean isFinished() {
		return isFinished;
	}

	/**
	 * an user freeing a resource
	 * @exception IllegalArgumentException if the user have no resource
	 */
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
			resourcePool.freeResource(resourcefulUser.getResource());
			resourcefulUser.resetResource();
			isReady = true;
		}
		catch(IllegalArgumentException e){
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
