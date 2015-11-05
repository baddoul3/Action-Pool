package resource;
import java.util.NoSuchElementException;
import Action.Action;
import Pool.ResourcePool;

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
	
	public boolean isReady() {
		return isReady;
	}
	
	public boolean isFinished() {
		return isFinished;
	}
	
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

	public boolean isInProgress() {
		return false;
	}
}
