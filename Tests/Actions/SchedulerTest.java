package Actions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import Action.*;

public class SchedulerTest extends ActionTest {

	Scheduler scheduler;
	Foreseeable action1;
	Foreseeable action2;

	@Before
	public void setup() {

		action1 = mock(Foreseeable.class);
		action1.setTimeToEnd(2);
		action2 = mock(Foreseeable.class);
		action1.setTimeToEnd(1);
		scheduler =this.createAction();
	}

	@Test
	public void schedulerTest() {
		scheduler = createAction();
		when(action1.isReady()).thenReturn(true);
		when(action2.isReady()).thenReturn(true);
		assertFalse(scheduler.isReady());

		scheduler.addAction(action1);
		scheduler.addAction(action2);

		assertTrue(action1.isReady());
		assertTrue(action2.isReady());

		scheduler.doStep();
		when(action1.isInProgress()).thenReturn(true);
		when(action2.isReady()).thenReturn(true);
		assertTrue(action1.isInProgress());
		assertTrue(action2.isReady());

		scheduler.doStep();
		when(action1.isFinished()).thenReturn(true);
		when(action2.isInProgress()).thenReturn(true);
		assertTrue(action1.isFinished());
		assertTrue(action2.isInProgress());

		scheduler.doStep();
		when(action1.isFinished()).thenReturn(true);
		when(action2.isFinished()).thenReturn(true);
		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());
	}

	@Test
	public void onlyOneValidStateAtEachMoment() {
		scheduler = createAction();
		scheduler = createAction();
		Foreseeable action1 = this.createAction(1);
		scheduler.addAction(action1);
		this.onlyOneValidStateAtEachMoment(scheduler);

	}
@Test
	public void schedulerWithScheduler() {

		Foreseeable action1 = createAction(2);
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
		assertTrue(subScheduler.isFinished());

	}

	@Test
	public void with1OneStepAction() {
		
	Action action1 = mock(Action.class);	
	Scheduler scheduler = createScheduler(action1);
	
	assertFalse(scheduler.isFinished());
	assertFalse(action1.isFinished());
	
	scheduler.doStep();
	when(scheduler.isFinished()).thenReturn(true);
	assertTrue(scheduler.isFinished());
	when(action1.isFinished()).thenReturn(true);
	assertTrue(action1.isFinished());
	}

	private Scheduler createScheduler(Action action) {
		Scheduler scheduler = mock(Scheduler.class);
		scheduler.addAction(action);
		return scheduler;
	}

	public Scheduler createAction() {
		return new Scheduler();
	}

	public Foreseeable createAction(int timeToEnd) {
		return new Foreseeable(timeToEnd);
	}

}