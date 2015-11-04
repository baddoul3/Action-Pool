package Tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;


import Action.*;

public class SequentialSchedulerTest extends SchedulerTest {

	SequentialScheduler sequentialScheduler;

	@Test
	public void test() {

		sequentialScheduler = this.createSequentialScheduler();
		sequentialScheduler.addAction(action1);
		sequentialScheduler.addAction(action2);
		when(action1.isReady()).thenReturn(true);
		when(action2.isReady()).thenReturn(true);

		assertTrue(action1.isReady());
		assertTrue(action2.isReady());
		assertTrue(sequentialScheduler.isReady());

		sequentialScheduler.doStep();

		assertTrue(sequentialScheduler.isInProgress());		
		assertFalse(sequentialScheduler.isFinished());
		when(action1.isInProgress()).thenReturn(true);
		when(action2.isInProgress()).thenReturn(false);
		assertTrue(action1.isInProgress());
		assertFalse(action2.isInProgress());		
		
		sequentialScheduler.doStep();
		
		when(action1.isFinished()).thenReturn(true);		
		assertTrue(action1.isFinished());
		assertTrue(sequentialScheduler.isInProgress());	
		
		sequentialScheduler.doStep();
		
		when(action2.isFinished()).thenReturn(true);
		assertTrue(action2.isFinished());		
		
		sequentialScheduler.doStep();
		
		assertTrue(sequentialScheduler.isFinished());
	}

	public SequentialScheduler createSequentialScheduler() {
		return new SequentialScheduler();
	}
	public SequentialScheduler createAction() {
		Foreseeable action1 = new Foreseeable(1) ;
		SequentialScheduler sequentialScheduler = new SequentialScheduler();
		sequentialScheduler.addAction(action1);
		return sequentialScheduler;
		
	}

}
