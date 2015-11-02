package Actions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import Action.*;
import Action.FairScheduler;
import Action.Foreseeable;
import Action.Scheduler;
import Action.SequentialScheduler;

public class FaireSchedulerTest extends SchedulerTest{

	FairScheduler fairScheduler;

	@Test
	public void test() {

		fairScheduler = this.createAction();
		fairScheduler.addAction(action1);
		fairScheduler.addAction(action2);
		when(action1.isReady()).thenReturn(true);
		when(action2.isReady()).thenReturn(true);

		assertTrue(action1.isReady());
		assertTrue(action2.isReady());
		assertTrue(fairScheduler.isReady());

		fairScheduler.doStep();

		assertTrue(fairScheduler.isInProgress());		
		assertFalse(fairScheduler.isFinished());
		when(action1.isInProgress()).thenReturn(true);
		when(action2.isInProgress()).thenReturn(false);
		assertTrue(action1.isInProgress());
		assertFalse(action2.isInProgress());		
		
		fairScheduler.doStep();
		
		assertTrue(fairScheduler.isInProgress());	
		when(action1.isInProgress()).thenReturn(true);		
		when(action2.isFinished()).thenReturn(true);		
		assertTrue(action1.isInProgress());
		assertTrue(action2.isFinished());
		
		
		fairScheduler.doStep();
		
		assertTrue(fairScheduler.isInProgress());	
		when(action1.isFinished()).thenReturn(true);				
		assertTrue(action1.isFinished());
		//System.out.println(fairScheduler.getActions().size());
		fairScheduler.doStep();
		fairScheduler.getActions().remove(0);
		fairScheduler.getActions().remove(0);
		assertTrue(fairScheduler.isFinished());
	}

	public FairScheduler createAction() {
		return new FairScheduler();
	}

}
