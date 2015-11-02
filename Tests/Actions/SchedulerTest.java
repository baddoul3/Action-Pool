package Actions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import Action.*;

@RunWith(MockitoJUnitRunner.class)
public class SchedulerTest extends ActionTest {

	Scheduler scheduler;	
	Foreseeable action1;
	Foreseeable action2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		action1 = mock(Foreseeable.class);
		action1.setTimeToEnd(2);
		action2 = mock(Foreseeable.class);
		action1.setTimeToEnd(1);
		scheduler = this.createAction();
		
	}

	@Test
	public void schedulerTest() {
		scheduler = createAction();
		action1.isReady();
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
/*
	@Test
	public void onlyOneValidStateAtEachMoment() {
		scheduler = createAction();
		scheduler = createAction();
		action1 = this.createAction(1);
		scheduler.addAction(action1);
		this.onlyOneValidStateAtEachMoment(scheduler);

	}

	@Test
	public void schedulerWithScheduler() {

		action1 = mock(Foreseeable.class);
		action1.setTimeToEnd(2);
		Scheduler subScheduler = createAction();
		Scheduler scheduler = createAction();
		subScheduler.addAction(action1);
		scheduler.addAction(subScheduler);
		when(action1.isReady()).thenReturn(true);
		assertTrue(action1.isReady());
		assertTrue(subScheduler.isReady());
		scheduler.doStep();
		when(action1.isInProgress()).thenReturn(true);
		assertTrue(action1.isInProgress());
		assertTrue(subScheduler.isInProgress());
		assertTrue(scheduler.isInProgress());
		scheduler.doStep();
		when(action1.isFinished()).thenReturn(true);
		assertTrue(action1.isFinished());
		scheduler.doStep();
		assertTrue(subScheduler.isFinished());

	}
*/
	@Test
	public void withOneStepAction() {

		scheduler = createScheduler(action1);

		assertTrue(scheduler.isReady());
		scheduler.doStep();
		assertTrue(scheduler.isInProgress());
		when(action1.isFinished()).thenReturn(true);
		assertTrue(action1.isFinished());
	}
	

	private Scheduler createScheduler(Action action) {
		Scheduler scheduler = new Scheduler();
		scheduler.addAction(action);
		return scheduler;
	}

	public Scheduler createAction() {
		return mock(Scheduler.class);
		
	}

	public Foreseeable createAction(int timeToEnd) {
		return new Foreseeable(timeToEnd);
	}

}