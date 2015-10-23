package Tests;

import static org.junit.Assert.*;
import Action.*;
import org.junit.Test;

public  abstract class ActionTest {
	
	public abstract Action createAction() ;
	@Test
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
