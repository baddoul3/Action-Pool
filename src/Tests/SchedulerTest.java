package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Action.*;
public class SchedulerTest  extends ActionTest{
	
	
	public Action createAction() {
		
		return new Scheduler();
	}

}