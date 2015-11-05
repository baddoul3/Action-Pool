package resource;
import Action.*;
import Pool.*;
import resource.*;
/**
 * @author mahroug + mamane
 */
/**
 * This class free a resource
 * it create the FreeResourceAction
 */
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
	public boolean isReady() {
		return isReady;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void doStep() {
		try {
			resourcePool.freeResource(resourcefulUser.getResource());
			resourcefulUser.resetResource();
			isReady = true;
		}
		catch(IllegalArgumentException e){
		}
	}
	public boolean isInProgress() {
		return false;
	}
}
