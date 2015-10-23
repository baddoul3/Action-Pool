package Tests;

import static org.junit.Assert.*;
import Action.*;
import org.junit.Test;

public  abstract class ActionTest {
	
	public abstract Action createAction() ;
	
	@Test
	public void foreseeableAction() {
	Action action = this.createAction();
	// 2 steps remaining
	assertTrue(action.isReady());
	assertFalse(action.isInProgress());
	assertFalse(action.isFinished());
	action.doStep();
	// 1 step remaining
	assertFalse(action.isReady());
	assertTrue(action.isInProgress());
	assertFalse(action.isFinished());
	action.doStep();
	// 0 step remaining
	assertFalse(action.isReady());
	assertFalse(action.isInProgress());
	assertTrue(action.isFinished());
	}
	
	@Test
	public void schedulerTest() {
		Action action = this.createAction();
		ActionTest action1 = act.createAction();
		ActionTest action2 = act.createAction();
		Action scheduler = act.createAction();
		scheduler.aaddAction(action1);
		scheduler.addAction(action2);
		assertTrue(action1.isReady());
		assertTrue(action2.isReady());
		scheduler.doStep();
		assertTrue(action1.isInProgress());
		assertTrue(action2.isReady());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(action2.isReady());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());
	}
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
