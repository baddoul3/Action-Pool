package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Action.*;


public class ForeseeableTest extends ActionTest{

	@Test
	public void foreseeableAction() {
	Action action = createAction(2);
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
	
	public void onlyOneValidStateAtEachMomentForForeseebleAction() {
		onlyOneValidStateAtEachMoment(createAction(10));
	}

	@Override
	protected ActionTest createAction() {
		return null;
	}

	@Override
	public void foreseeableActionTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void schedulerTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isReady() {
		// TODO Auto-generated method stub
		
	}

}
