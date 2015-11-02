package Actions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import Action.*;
@RunWith(MockitoJUnitRunner.class)
public class SequentialSchedulerTest extends SchedulerTest {

	SequentialScheduler sequentialScheduler;

	@Test
	public void test() {

		sequentialScheduler = this.createAction();
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

	public SequentialScheduler createAction() {
		return new SequentialScheduler();
	}

}
