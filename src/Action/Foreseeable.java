package Action;


public class Foreseeable extends Action {
	
	protected final int totalTime;
	protected int remainingTime;
	protected int timeToEnd;

	public Foreseeable(int timeToEnd) {
		this.totalTime = timeToEnd;
		this.remainingTime = timeToEnd;
	}

	@Override
	public boolean isReady() {

		return remainingTime == totalTime;
	}

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

	@Override
	public Action createAction() {
		
		return new Foreseeable(timeToEnd);
	}


}