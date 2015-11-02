package Pool;
/**
 * 
 * @author mahroug
 *
 */
public class BasketPool extends ResourcePool<Basket>{

	public BasketPool(int i){
		super(i);
	}
	
	public String toString(){
		return "basket pool";
	}
	
	protected void createPool(int nbOfResources){
		for(int i=0; i<nbOfResources; i++){
			availableResources.add(new Basket());
		}
	}
	
	public String description(){
		return "trying to take resource from "+this.toString()+" ...";
	}
	
	

}
