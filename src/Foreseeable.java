
public class Foreseeable  extends Action{
	protected final int totalTime;
	protected int remainingTime;
	
	
	public Foreseeable(int totalTime, int remainingTime) {
		super();
		this.totalTime = totalTime;
		this.remainingTime = remainingTime;
	}


	@Override
	public boolean isReady() {
		
		return remainingTime == totalTime;
	}

//   for all scheduler classes
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

	

}