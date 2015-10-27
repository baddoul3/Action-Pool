package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Action.*;

public class ForeseeableTest extends ActionTest {

	@Test
	public void foreseeableAction() {
		Foreseeable action = this.createAction();

		// 2 steps remaining

		action.getTotalTime();
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
	public void onlyOneValidStateAtEachMomentFor() {
		onlyOneValidStateAtEachMoment(this.createAction());
	}

	public Foreseeable createAction() {
		return new Foreseeable(2);

	}

}
