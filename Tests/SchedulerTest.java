import static org.junit.Assert.*;

import org.junit.Test;

public class SchedulerTest  {

	@Test
	public void schedulerTest() {
		BadAction action1 = createAction(2);
		BadAction action2 = createAction(1);
		BadAction scheduler = createAction(0);
		scheduler.addAction(action1);
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
		Action scheduler = createAction(0);
		scheduler.addAction(createAction(1));
		onlyOneValidStateAtEachMoment(scheduler);
	}

}
