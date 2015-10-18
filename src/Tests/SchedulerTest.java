package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Action.*;
public class SchedulerTest  extends ActionTest{

	@Test
	public void schedulerTest() {
		Action action1 = createAction();
		Action action2 = createAction();
		Action scheduler = createAction();
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
		Action scheduler = createAction();
		scheduler.addAction(createAction());
		onlyOneValidStateAtEachMoment(scheduler);
	}
	public void schedulerWithScheduler() {
		Action action1 = createAction(2);
		Action subScheduler = createAction(0);
		Action scheduler = createAction(0);
		subScheduler.addAction(action1);
		scheduler.addAction(subScheduler);
		assertTrue(action1.isReady());
		assertTrue(subScheduler.isReady());
		scheduler.doStep();
		assertTrue(action1.isInProgress());
		assertTrue(subScheduler.isInProgress());
		scheduler.doStep();
		assertTrue(action1.isFinished());
		assertTrue(subScheduler.isFinished());
	}
	@Override
	protected Action createAction() {
		return new Scheduler();
	}
	@Override
	public void foreseeableActionTest() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void isReady() {
		// TODO Auto-generated method stub
		
	}