package Pool;
/**
 * 
 * @author mahroug
 *
 */
public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int i){
		super(i);
	}

	public String toString(){
		return "pool cubicle";
	}
	
	protected void createPool(int nbResources){
		for(int i=0; i<nbResources; i++){
			this.availableResources.add(new Cubicle());
		}
	}

	public String description() {
		return "description cubicle pool";
	}
}
