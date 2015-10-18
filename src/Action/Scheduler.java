package Action;

import java.util.ArrayList;

public class Scheduler extends Action{	
	
	protected boolean isInitialized = false;
	protected boolean isReady = true;
	
	protected final ArrayList<Action> actions = new ArrayList<Action>();

	
	@Override
	public boolean isReady() {
		return isInitialized && isReady;
	}
	
	
	public void doStep(){
		
		this.isReady = false;
		Action nextAction = actions.get(0);
		nextAction.doStep();
		if(nextAction.isFinished())
			actions.remove(0);
				
	}


	
	public boolean isInProgress() {
		
		return isInitialized && !isReady() && ! isFinished();
	}


	@Override
	public boolean isFinished() {
		
		return isInitialized && ! isReady() && actions.isEmpty();
	}
	public void addAction(Action subAction) {
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


	@Override
	protected Action createAction(int timeToEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
