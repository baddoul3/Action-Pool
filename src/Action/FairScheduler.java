package Action;

public class FairScheduler extends Scheduler {

	public Action getNextAction() {

		return this.actions.get(this.actions.indexOf(getCurrentAction()) + 1);

	}

	
	public void doStepFairScheduler() {
		
		this.currentAction.doStep();
		this.currentAction = this.actions.get(0);
		
		this.currentAction.doStep();
		this.getCurrentAction().doStep();		
		this.isReady = false;
		
		if (this.currentAction.isFinished())
			this.actions.remove(0);

	}

}
