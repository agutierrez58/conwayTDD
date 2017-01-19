package org.algoritmes.tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * https://www.youtube.com/watch?v=Gjcz-H73I0Q TDD Coding kata: game of life
 * 
 * 1) Escriure UnitTest. 
 * 2) Començar pel primer requeriment -
 * aSingleCellShouldHaveZeroNeighbors Escrius el codi mínim (i el vas
 * implementant..) ... i intentes fer el mínim codi per que passi el test (ni
 * mes ni menys). 
 * 3) Si no es passa el primer test, reimplementar codi perque passi ...
 * 4) Es pot fer un refactoring? (moure codi a variables locals, extreure mètodes?!, etc.)
 * 5) Es repeteix el proces amb el nou objectiu ...
 * 
 * Per desenvolupar aquest simulador:
 * 
 *    a) aSingleCellShouldHaveZeroNeighbors 
 *    b) twoCellsNextToEachOtherShouldBeNeighbors 
 *    c) aTwoSingleCellsFarFromEachOtherShouldHaveZeroNeighbours
 *    d) middleCellOf3x3BlocksShouldHaveEightNeighbors
 *    e)... i desprès implementar : GameOfLifeSpec
 * 
 * 
 * Attendees were split into pairs who were working on the task together, using
 * TDD practices with very strict rules:
 * 
 * 1) write exactly ONE failing test 
 * 2) make the test from (1) pass by first writing implementation code IN THE TEST 
 * 3) create a new implementation  method/function by: doing extract method on 
 *    implementation code created as per (2), or moving implementation code as per (2) into an existing implementation method 
 * 4) only ever create new methods IN THE TEST CLASS 
 * 5) only ever create implementation classes to provide a destination for
 * extracting a method created as per (4). 
 * 6)populate implementation classes by
 * doing move method from a test class into them 
 * 7) refactor as required 
 * 8) go to (1)
 * 
 * @author agutierrez
 *
 */

public class BoardTest {

	@Test
	public void aSingleCellShouldHaveZeroNeighbors() {
		// given
		Board board = new Board();
		board.addCell(new Cell(0, 0));

		// when  (inicialment era una List<Cell> .. pero ha passat a Set<Cell> ..)
		Set<Cell> neighbors = board.getVeines(new Cell(0, 0));

		// then
		assertEquals(0, neighbors.size());
	}

	@Test
	public void twoCellsNextToEachOtherShouldBeNeighbors() {
		// given
		Cell primeraCell = new Cell(0, 0);
		Cell segonaCell = new Cell(0, 1);
		Board board = new Board();
		board.addCell(primeraCell);
		board.addCell(segonaCell);

		// when
		Set<Cell> veinesPrimeraCell = board.getVeines(primeraCell);
		Set<Cell> veinesSegonaCell = board.getVeines(segonaCell);

		// then
		assertArrayEquals(new Cell[] { segonaCell }, veinesPrimeraCell.toArray());
		assertArrayEquals(new Cell[] { primeraCell }, veinesSegonaCell.toArray());
	}

	@Test
	public void aTwoSingleCellsFarFromEachOtherShouldHaveZeroNeighbours() {
		// given
		Board board = new Board();
		board.addCell(new Cell(0, 0));
		board.addCell(new Cell(0, 100));

		// when
		Set<Cell> veinesPrimeraCell = board.getVeines(new Cell(0, 0));
		Set<Cell> veinesSegonaCell = board.getVeines(new Cell(0, 100));

		// then
		assertArrayEquals(new ArrayList<>().toArray(), veinesPrimeraCell.toArray());
		assertArrayEquals(new ArrayList<>().toArray(), veinesSegonaCell.toArray());
	}

	@Test
	public void middleCellOf3x3BlocksShouldHaveEightNeighbors() {
		// given
		Board board = createBlockBoard(3,3);
		// when
		Set<Cell> veines = board.getVeines(new Cell(1, 1));
		
		// then
		assertEquals(8, veines.size());
		
	}

	/* Fins el 7' 16'' aprox de video (mateixes idees) */
	
	private Board createBlockBoard(int width, int height) {
		// Interessant, el refactoring ho fem una vegada el test s'ha executat amb exit...
		Board board = new Board();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
			  board.addCell(new Cell(i, j));
			}
		}
		/* Desprès de fer aquesta funció ens adonem que enlloc d'una llista, 
		  podem utilitzar directament un conjunt */
		
		return board;
		
	}

}
