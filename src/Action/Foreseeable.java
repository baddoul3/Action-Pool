package Action;


public class Foreseeable extends Action {

	protected final int totalTime;
	protected int remainingTime;
	protected int timeToEnd;
/*class representative actions are not complete until after a parameterizable number of invocation*/
	public Foreseeable(int timeToEnd) {
		this.totalTime = timeToEnd;
		this.remainingTime = timeToEnd;
	}

	@Override
	public boolean isReady() {

		return remainingTime == totalTime;
	}
	
// redefinition of methods: doStep, inProgress, isFinished
	
	@Override
	public void doStep() {
		remainingTime--;

	}

	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		return remainingTime <= 0;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public int getTimeToEnd() {
		return timeToEnd;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}

	public void setTimeToEnd(int timeToEnd) {
		this.timeToEnd = timeToEnd;
	}

}