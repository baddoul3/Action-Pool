package resource;

/**
<<<<<<< HEAD
 * 
 * @author Decottignies - Morlet
 *
 * @param <R> a resource
=======
 * @author mahroug + mamane
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
 */
public class ResourcefulUser <R extends Resource>{
	protected R resource;
	
<<<<<<< HEAD
	/**
	 * get the resource
	 * @return the resource
	 */
	public R getResource(){
		return resource;
	}
	
	/**
	 * set the resource
	 * @param resource to set
	 */
=======
	public R getResource(){
		return resource;
	}

>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
	public void setResource(R resource){
		this.resource = resource;
	}
	
<<<<<<< HEAD
	/**
	 * set the resource to null
	 */
=======
>>>>>>> dbfd4899f89734150dccf01d3fa58abd58ac7b88
	public void resetResource(){
		this.resource = null;
	}
}
