package Actions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import Action.*;
@RunWith(MockitoJUnitRunner.class)
public class ForeseeableTest extends ActionTest {
	
	Foreseeable action;	
	

	@Before
	public void setup() {
		action = this.createAction();

	}

	@Test
	public void foreseeableAction() {
		
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
		return mock(Foreseeable.class);

	}

}
