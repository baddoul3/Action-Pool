package Action;
import Pool.*;
public class TakeResourceAction extends Action {
	private ResourcePool<?> resourcePool;
	private Resource resource;
	private ResourcefulUser<Resource> user;
	public TakeResourceAction(ResourcePool<?> resourcePool, ResourcefulUser<Resource> user) {
		super();
		this.user = user;
		this.resourcePool = resourcePool;
	}
	public ResourcePool<?> getResourcePool() {
		return resourcePool;
	}
	public void setResourcePool(ResourcePool<Resource> resourcePool) {
		this.resourcePool = resourcePool;
	}
	public Resource getResource() {
		
		return this.resource;
	}
	public boolean isFinished() {
		return (getResource() != null);
	}

	public void realldoStep() {
		System.out.print(resourcePool.description());
		try
		{
			this.resource = resourcePool.provideResource();
			user.setResource(resource);
		}
		catch(Exception e)
		{}
	}
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void doStep() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isInProgress() {
		// TODO Auto-generated method stub
		return false;
	}


}