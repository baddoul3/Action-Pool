package Pool;
import java.util.*;
import resource.*;
/**
 * @author mahroug + mamane
 */
/**
 * This class represents the resource manager.
 * Each instance of this class can be specialized for a particular type of resource.
 */

public abstract class ResourcePool <T extends Resource>{

	protected int nbavailableResources;
	protected List<T> availableResources;
	protected List<T> givenResources = new ArrayList<T>();

	public ResourcePool(int nbavailableResources){
		this.nbavailableResources = nbavailableResources;
		this.availableResources = new ArrayList<T>();
		for (int i = 0; i < nbavailableResources; i++)
			this.availableResources.add(create());
	}

	protected abstract T create();

	public T provideResource() throws NoSuchElementException{
		if (availableResources.isEmpty()){
			throw new NoSuchElementException();
		}
		T resource = availableResources.get(0);
		givenResources.add(resource);
		availableResources.remove(0);
		return resource;
	}

	public void freeResource(T resource){
		if (givenResources.contains(resource)){
			availableResources.add(resource);
			givenResources.remove(resource);
		}
		else
			throw new IllegalArgumentException();
	}
}
