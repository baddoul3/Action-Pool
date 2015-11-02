package Action;

public class FairScheduler extends Scheduler {
	
	static int indexAction = 0;
	public Action getNextAction() {

		return this.actions.get(this.actions.indexOf(getCurrentAction()) + 1);

	}

	@Override
	public void doStep() {
		
		this.isReady = false;
		if(indexAction < actions.size())
		{
			Action nextAction = actions.get(indexAction);
			nextAction.doStep();
			
			if(nextAction.isFinished())
				actions.remove(indexAction);
			
			if(indexAction ==  actions.size()-1)
				indexAction = 0;
		
			else
				indexAction++;
			
		}

	}

}
