package Action;

public abstract class Action {

	protected int TotalTime;
	protected int remainingTime;
	protected  int timeToEnd=2;
	
	public abstract boolean isReady();
	public abstract void doStep();
	public abstract boolean isInProgress();
	public abstract boolean isFinished();
	
	public  int getTimeToEnd(){
		return timeToEnd;
	}
   
}
