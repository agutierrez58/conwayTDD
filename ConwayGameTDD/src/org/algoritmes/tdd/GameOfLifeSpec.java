package org.algoritmes.tdd;

import static org.junit.Assert.*;
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
 * 	BoardTest
 *    a) aSingleCellShouldHaveZeroNeighbors 
 *    b) twoCellsNextToEachOtherShouldBeNeighbors 
 *    c) aTwoSingleCellsFarFromEachOtherShouldHaveZeroNeighbours
 *    d) middleCellOf3x3BlocksShouldHaveEightNeighbors
 *    e)... i desprès implementar : GameOfLifeSpec
 *    
 *  GameOfLifeSpec
 *    a) aSingleCellShouldDieNextIteration
 *    b) aCellWithTwoNeighboursShoudLiveInNextIteration
 *    c) aCellWithThreeNeighboursShoudLiveInNextIteration
 *    d) aCellWithMoreThanThreeNeighboursShoudDieInNextIterations
 *    e) aDeadCellWithExactlyThreeNeighboursShoudBeRebornInNextIteration
 *    
 *    Notar que el mateix codi "ja demana" els canvis que cal efectuar.
 *    
 *    */

/**
 * RULES
 * =====
 * Every cell interacts with its eight neighbours, which are the cells
 * that are horizontally, vertically, or diagonally adjacent. At each step in
 * time, the following transitions occur:
 * 
 * 1) Any live cell with fewer than two live neighbours dies, as if caused by
 * underpopulation. 
 * 
 * 2) Any live cell with two or three live neighbours lives on to
 * the next generation. 
 * 
 * 3) Any live cell with more than three live neighbours dies,
 * as if by overpopulation. 
 * 
 * 4) Any dead cell with exactly three live neighbours
 * becomes a live cell, as if by reproduction.
 * 
 * @author armand
 *
 */
public class GameOfLifeSpec {

	@Test
	public void aSingleCellShouldDieNextIteration() {

		// given
		Board board = new Board();
		board.addCell(new Cell(0, 0));
		Game game = new Game(board);

		// when
		Board nextBoard = game.nextIteration(); // Notar que primer implemento
												// test i desprès creo mètode
												// ...

		// then
		assertFalse(nextBoard.isAlive(new Cell(0, 0))); // Notar que aqui
														// canviem la
														// visibilitat isAlive
														// ... (no demana el
														// codi)

	}
	// 9'24''
	@Test
	public void aCellWithTwoNeighboursShoudLiveInNextIteration() {

		// given
		Board board = new Board();
		board.addCell(new Cell(0,0));
		board.addCell(new Cell(0,1));
		board.addCell(new Cell(1,0));
		Game game = new Game(board);
		// when
		Board nextBoard = game.nextIteration(); 

		// then
		assertTrue(nextBoard.isAlive(new Cell(0, 0))); 

	}
	
	@Test
	public void aCellWithThreeNeighboursShoudLiveInNextIteration() {

		// given
		Board board = new Board();
		board.addCell(new Cell(0,0));
		board.addCell(new Cell(0,1));
		board.addCell(new Cell(1,0));
		board.addCell(new Cell(1,1));
		Game game = new Game(board);

		// when
		Board nextBoard = game.nextIteration(); 

		// then
		assertTrue(nextBoard.isAlive(new Cell(0, 0))); 

	}
	
	@Test
	public void aCellWithMoreThanThreeNeighboursShoudDieInNextIteration() {

		// given
		Board board = new Board();
		Cell cellAmbMesTresVeines = new Cell(1,1);
		board.addCell(cellAmbMesTresVeines); 
		board.addCell(new Cell(0,0));
		board.addCell(new Cell(0,1));
		board.addCell(new Cell(1,0));		
		board.addCell(new Cell(0,2));
		Game game = new Game(board);
		

		// when
		Board nextBoard = game.nextIteration(); 

		// then
		assertFalse(nextBoard.isAlive(cellAmbMesTresVeines)); 

	}
	
	@Test
	public void aDeadCellWithExactlyThreeNeighboursShoudBeRebornInNextIteration() {
		/*Dubte. Una celula morta en aquesta nova generacio (no seleccionada),
		 * es reviu!? O de totes les celules mortes que hi han hagut en la simulacio?!
		 * Primer ho faré així. I desprès provaré el que passa de diferents maneres..
		 * */

		// given
		Board board = new Board();
		board.addCell(new Cell(0,1));
		board.addCell(new Cell(1,0));
		board.addCell(new Cell(1,1));
		Game game = new Game(board);
		
		Cell cellRessucitada = new Cell(0,0);
		
		// when
		Board nextBoard = game.nextIteration(); 

		// then
		assertTrue(nextBoard.isAlive(cellRessucitada)); 
	}
	
}
