package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Action.*;


public class ForeseeableTest extends ActionTest{

	
	@Test
	public void foreseeableAction() {
	Action action = new Foreseeable(2);
	// 2 steps remaining
	action.get
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
	
	public  Action createAction() {
		return new Foreseeable(2);
		
	}

}
