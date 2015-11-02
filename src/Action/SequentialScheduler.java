package Action;

public class SequentialScheduler extends Scheduler {

	@Override
	public void doStep() {

		this.isReady = false;
		currentAction = actions.get(0);
		
		currentAction.doStep();
		if (currentAction.isFinished())
			actions.remove(0);
			
	}

}
