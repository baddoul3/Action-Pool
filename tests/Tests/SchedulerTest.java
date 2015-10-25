package Tests;

import static org.junit.Assert.*;
import Action.*;
import org.junit.Test;

public class SchedulerTest extends ActionTest {

	private Scheduler createAction() {
		return new Scheduler();
	}

	@Test
	public void scheduler() {

		Scheduler scheduler = createAction();
		Scheduler scheduler1 = createAction();
		Scheduler scheduler2 = createAction();
		scheduler.addAction(scheduler1);
		scheduler.addAction(scheduler2);
		assertTrue(scheduler.isReady());	
		scheduler2.addAction(scheduler);
		scheduler2.doStep();
		assertTrue(scheduler.isReady());
		assertTrue(scheduler2.isInProgress());
		assertTrue(!scheduler2.isFinished());
	}
	
	@Test
	public void schedulerWithScheduler() {
		Scheduler action1 = createAction();
		Scheduler subScheduler = createAction();
		Scheduler scheduler = createAction();
    	subScheduler.addAction(action1);
    	scheduler.addAction(subScheduler);
    	assertTrue(!action1.isReady());
    	assertTrue(subScheduler.isReady());
    	scheduler.doStep();
    	assertTrue(!subScheduler.isInProgress());
		scheduler.doStep();
		assertTrue(!action1.isFinished());
		assertTrue(!subScheduler.isFinished());
	}
	
	@Test
	public void onlyOneValidStateAtEachMomentForScheduler() {
		Scheduler scheduler = createAction();
		scheduler.addAction(createAction());
		//onlyOneValidStateAtEachMoment(scheduler);
	}
}



