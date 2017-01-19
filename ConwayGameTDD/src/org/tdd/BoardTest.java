package org.tdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * https://www.youtube.com/watch?v=Gjcz-H73I0Q
 * TDD Coding kata: game of life
 * 
 * 1) Escriure UnitTest.
 * 2) Començar pel primer requeriment - aSingleCellShouldHaveZeroNeighbors
 * 		Escrius el codi mínim (i el vas implementant..)
 *      ... i intentes fer el mínim codi per que passi el test.
 * 3)  
 * 		
 * 
 * 
 * 
		Attendees were split into pairs who were working on the task together, using TDD practices with very strict rules:
		
		1) write exactly ONE failing test
		2) make the test from (1) pass by first writing implementation code IN THE TEST
		3) create a new implementation method/function by:
		     doing extract method on implementation code created as per (2), or
		     moving implementation code as per (2) into an existing implementation method
		4) only ever create new methods IN THE TEST CLASS
		5) only ever create implementation classes to provide a destination for extracting a method created as per (4).
		6)populate implementation classes by doing move method from a test class into them
		7) refactor as required
		8) go to (1)

 * @author agutierrez
 *
 */


public class BoardTest {


	@Test
	public void aSingleCellShouldHaveZeroNeighbors() {
		// given
		Board board = new Board();
		board.addCell(new Cell());
		
		// when
		List<Cell> neighbors = board.getNeighbors(new Cell());
		
		// then 
		assertEquals(0, neighbors.size());
	}

	@Test
	public void twoCellsNextToEachOtherShouldBeNeighbors() {
		// given
	}
}
