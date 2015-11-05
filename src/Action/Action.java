package Action;

public abstract class Action {
	

	public abstract boolean isReady();

	public abstract void doStep();

	public abstract boolean isInProgress();

	public abstract boolean isFinished();
	
	
	

   
}
