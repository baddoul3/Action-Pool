package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Action.*;


public class ForeseeableTest extends ActionTest{

	
	
	
	public  Action createAction() {
		return new Foreseeable(2);
		
	}

}
