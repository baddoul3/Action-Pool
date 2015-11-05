package Action;

public class OneStepAction extends Action {
	protected boolean isInitialized = false;
	protected boolean isReady = true;

	@Override
	public boolean isReady() {
		return isReady;
	}

	public void doStep() {

		this.isReady = false;
		this.isInitialized = true;

	}

	public boolean isInProgress() {

		return isInitialized && !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {

		return isInitialized && !isReady();
	}

	public boolean isInitialized() {
		return isInitialized;
	}

}
