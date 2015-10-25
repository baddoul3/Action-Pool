package Action;

public class Foreseeable extends Action {
	
	protected final int totalTime;
	protected int remainingTime;
	protected int timeToEnd;

	public Foreseeable(int timeToEnd) {
		this.totalTime = timeToEnd;
		this.remainingTime = timeToEnd;
	}

	public boolean isReady() {
		return remainingTime == totalTime;
	}

	public void doStep() {
		remainingTime--;
	}

	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	public boolean isFinished() {
		return remainingTime <= 0;
	}

	public int getTotalTime() {
		return totalTime;
	}

}