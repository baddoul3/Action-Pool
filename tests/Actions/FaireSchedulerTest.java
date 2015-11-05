package Actions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import Action.Action;
import Action.ActionFinishedException;
import Action.FairScheduler;

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
		
		fairScheduler.doStep();
		fairScheduler.getActions().remove(0);
		fairScheduler.getActions().remove(0);
		assertTrue(fairScheduler.isFinished());
	}
	@Test @Override
	public void schedulerWithScheduler() {}
	@Test@Override
	public void onlyOneValidStateAtEachMoment() {}

	public FairScheduler createAction() {
		return new FairScheduler();
	}
	
}
