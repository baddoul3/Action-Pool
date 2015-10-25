package Action;

import java.util.ArrayList;

public class Scheduler extends Action {

	protected boolean isInitialized;
	protected boolean isReady;

	protected final ArrayList<Scheduler> actions;
	
	public Scheduler(){
		this.isReady=true;
		this.isInitialized=false;
		actions = new ArrayList<Scheduler>();
	}

	public boolean isReady() {
		return isInitialized && isReady;
	}

	public void doStep() {
		this.isReady = false;
		Scheduler nextAction = actions.get(0);
		//nextAction.doStep();
		if (nextAction.isFinished())
			actions.remove(0);
	}

	public boolean isInProgress() {
		return isInitialized && !isReady() && !isFinished();
	}

	public boolean isFinished() {
		return isInitialized && !isReady() && actions.isEmpty();
	}

	public void addAction(Scheduler subAction) {
		isInitialized = true;
		if (subAction.isFinished()) {
			throw new IllegalArgumentException("Can’t add an already finished action");
		}
		if (isFinished()) {
			throw new IllegalStateException("You can’t add an action to a finished scheduler");
		} else {
			actions.add(subAction);
		}
	}


}
