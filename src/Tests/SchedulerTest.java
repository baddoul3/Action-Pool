package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Action.*;
public class SchedulerTest  extends ActionTest{
	
	@Override
	public Scheduler createAction() {
		
		return new Scheduler();
	}
	@Test
	public void schedulerTest() {
		Action scheduler = this.createAction();
		
		Action action1 = this.createAction(1);
		Action action2 = this.createAction(2);
		
		
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
	public Action createAction(int a) {
		
		return new Foreseeable(a);
	}

}