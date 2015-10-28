package Action;

public class SequentialScheduler extends Scheduler {

	public void sequentielStep() {

		this.isReady = false;
		currentAction = actions.get(0);
		
		currentAction.doStep();
		if (currentAction.isFinished())
			actions.remove(0);
			
	}

}
