package Pool;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import resource.Resource;

public abstract class ResourcePool <T extends Resource>{
	
	protected int nbResources;
	protected List<T> resources;
	protected List<T> usedResources = new ArrayList<T>();
	
	public ResourcePool(int nbResources){
		this.nbResources = nbResources;
		this.resources = new ArrayList<T>();
		for (int i = 0; i < nbResources; i++)
			this.resources.add(create());
	}
	
	protected abstract T create();
	
	public T provideResource(){
		if (!resources.isEmpty()){
			T tmp = resources.get(0);
			usedResources.add(tmp);
			resources.remove(0);
			return tmp;
		}
		throw new NoSuchElementException();
	}
	
	public void freeResource(T resource){
		if (usedResources.contains(resource)){
			resources.add(resource);
			usedResources.remove(resource);
=======
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
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
		}
		else
			throw new IllegalArgumentException();
	}
}
