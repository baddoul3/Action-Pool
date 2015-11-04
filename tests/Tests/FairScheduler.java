package Action;

public class FairScheduler extends Scheduler {
	protected boolean remove = false;
	static int indexAction = 0;

	@Override
	public Action getNextAction() {
		return this.actions.get(this.actions.indexOf(getCurrentAction()) + 1);

	}
	@Override
	public void doStep() {

		this.isReady = false;
		if (indexAction < actions.size()) {

			Action nextAction = actions.get(indexAction);
			nextAction.doStep();

			if (nextAction.isFinished()) {
				if (indexAction == actions.size() - 1) {

					actions.remove(indexAction);
					indexAction = 0;
				} else
					actions.remove(indexAction);
				remove = true;
			}

			else if (!remove)
				indexAction++;

		}

	}
	
	public FairScheduler createAction() {
		return new FairScheduler();
	}

}
