import static org.junit.Assert.*;

import org.junit.Test;

public class ForeseeableTest {

	@Test
	public void foreseeableAction() {
	BadAction action = createAction(2);
	// 2 steps remaining
	assertTrue(action.isReady());
	assertFalse(action.isInProgress());
	assertFalse(action.isFinished());
	action.doStep();
	// 1 step remaining
	assertFalse(action.isReady())
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

}
