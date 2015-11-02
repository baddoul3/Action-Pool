package Pool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/**
 * 
 * @author mahroug
 *
 * @param <T>
 */

public abstract class ResourcePool<T extends Resource> {
	protected List<T> availableResources;
	protected Set<T> notAvailableResources;

	public ResourcePool(int nbResources) {
		this.availableResources = new ArrayList<T>();
		this.notAvailableResources = new HashSet<T>();
		this.createPool(nbResources);
	}

	public T provideResource() throws InterruptedException{
		if(availableResources.isEmpty()){
			System.out.println("failed");
			throw new NoSuchElementException("no resource available");
		}
		System.out.println("success");
		T resource = availableResources.get(0);
		notAvailableResources.add(resource);
		availableResources.remove(resource);
		return resource;
	}

	public void freeResource(Resource resource){
		if(notAvailableResources.contains(resource)){
			availableResources.add((T) resource);
			notAvailableResources.remove(resource);	
		}
	}

	protected abstract void createPool(int nbResources);

	public abstract String description();	
}


