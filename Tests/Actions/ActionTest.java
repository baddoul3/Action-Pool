package Actions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;

import Action.*;
import org.junit.Test;
import org.mockito.Mock;

public abstract class ActionTest {
	
	

	
	public abstract Action createAction();
	
	
	protected void onlyOneValidStateAtEachMoment(Action action) {
		
		 
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		while (!action.isFinished()) {
			action.doStep();
			assertFalse(action.isReady());
			
			assertTrue(action.isFinished() == !action.isInProgress());
		}
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
}
