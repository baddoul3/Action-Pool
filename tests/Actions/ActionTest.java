package Actions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import Action.*;
import org.junit.Test;

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

	@Test //(expected = ActionFinishedException.class, timeout = 2000)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException {
		Action action = createAction();
		while (!action.isFinished()) {
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				fail("action was not supposed to be finished, we just checked");
			}

			assertTrue(action.isFinished());

		}
	}

}
