import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ActionTest {

	protected abstract Action createAction() {
		return new Action();
	}

	
	public abstract void foreseeableActionTest();

	public abstract void schedulerTest() ;
	
	public abstract void isReady() ;

	
	public void schedulerWithScheduler() {
		BadAction action1 = createAction(2);
		BadAction subScheduler = createAction(0);
		BadAction scheduler = createAction(0);
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

	
	

	protected void onlyOneValidStateAtEachMoment(Action action) {
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		while (!action.isFinished()) {
			action.doStep();
			assertFalse(action.isReady());
			// isFinished xor isInProgress
			assertTrue(action.isFinished() == !action.isInProgress());
		}
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
}

}
