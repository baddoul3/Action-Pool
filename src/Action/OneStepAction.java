package Action;

import java.util.ArrayList;

public class OneStepAction extends Action {
	protected boolean isInitialized = false;
	protected boolean isReady = true;

	@Override
	public boolean isReady() {
		return isReady;
	}
/*each call doStep () represents the passage of a unit of time during
 *  which one and only one action can advance one 
 *  and only one step */
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
