import java.util.ArrayList;

public  abstract class Action {
	
	protected int remainingTime;
	public abstract boolean  isReady();
	public abstract void doStep();
	public abstract boolean  isInProgress();
	public abstract boolean  isFinished();
	
}
