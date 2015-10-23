package Tests;

import static org.junit.Assert.*;
import Action.*;
import org.junit.Test;

public  abstract class ActionTest {
	
	public abstract Action createAction() ;
	
	
	
	public void onlyOneValidStateAtEachMoment() {
		Action scheduler = createAction();
		scheduler.addAction(createAction());
		onlyOneValidStateAtEachMoment(scheduler);
	}
	public void schedulerWithScheduler() {
		Action action1 = createAction(2);
		Action subScheduler = createAction(0);
		Action scheduler = createAction(0);
		subScheduler.addAction(action1);
		scheduler.addAction(subScheduler);
		assertTrue(action1.isReady());
		assertTrue(subScheduler.isReady());
		scheduler.doStep();
		assertTrue(action1.isInProgress());
		assertTrue(subScheduler.isInProgress());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(subScheduler.isFinished());
	}

	


}
