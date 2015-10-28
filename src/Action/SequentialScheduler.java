package Action;


public class SequentialScheduler  extends Scheduler{
	
	
	public Action getNextAction(){	 
		 
		 if(!this.actions.get(0).isFinished())
		    	 return this.getCurrentAction();
		 else
			 
		 return this.actions.get(this.actions.indexOf(getCurrentAction())+1);
				 
				 
				 }
	 
	 
	
}
