package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Action.*;

public class SchedulerTest extends ActionTest {

	
	
	@Override
	public Scheduler createAction() {

		return new Scheduler();
	}

	@Test
	public void schedulerTest() {
		Scheduler scheduler = createAction();
		/*Foreseeable action1 = createAction(2);
		Foreseeable action2 = createAction(1);

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
		assertTrue(action2.isFinished());*/
	}

	public void onlyOneValidStateAtEachMomentForScheduler() {
		/*Scheduler scheduler = createAction();
		scheduler.addAction(createAction(1));
		this.onlyOneValidStateAtEachMoment(scheduler);*/
	}

	public void schedulerWithScheduler() {
		/*Foreseeable action1 = createAction(2);
		Scheduler subScheduler = createAction();
		Scheduler scheduler = createAction();
		subScheduler.addAction(action1);
		scheduler.addAction(subScheduler);
		assertTrue(action1.isReady());
		assertTrue(subScheduler.isReady());
		scheduler.doStep();
		assertTrue(action1.isInProgress());
		assertTrue(subScheduler.isInProgress());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(subScheduler.isFinished());*/
	}

	public Foreseeable createAction(int a) {

		return new Foreseeable(a);
	}

}