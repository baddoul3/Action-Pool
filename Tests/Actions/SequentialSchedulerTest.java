package Actions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.*;

import Action.*;

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

		sequentialScheduler.sequentielStep();

		assertTrue(sequentialScheduler.isInProgress());
		assertFalse(sequentialScheduler.isFinished());

		when(action1.isInProgress()).thenReturn(true);
		when(action2.isReady()).thenReturn(true);
		assertTrue(action1.isInProgress());
		assertTrue(action2.isReady());

		

		

	}

	public SequentialScheduler createAction() {
		return new SequentialScheduler();
	}

}
