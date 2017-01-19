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
 *    b)  
 *    
 *    Notar que el mateix codi "ja demana" els canvis que cal efectuar.
 *    
 *    */
 
public class GameOfLifeSpec {
	
	@Test
	public void aSingleCellShouldDieNextIteration() {
		
		// given
		Board board = new Board();
		board.addCell(new Cell(0,0));
		Game game = new Game(board);
		
		// when
		Board nextBoard = game.nextIteration(); // Notar que primer implemento test i desprès creo mètode ...
		
		// then
		assertFalse(nextBoard.isAlive(new Cell(0,0))); // Notar que aqui canviem la visibilitat isAlive ... (no demana el codi)

	}
	// 9'24''
}
