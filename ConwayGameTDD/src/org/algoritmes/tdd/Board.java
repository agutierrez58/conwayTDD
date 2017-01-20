package org.algoritmes.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {

	private Set<Cell> cells = new HashSet<>();
	
	
	public Set<Cell> getVeines(Cell cell) {
		// 1er refactoring separar veinatge i veines ...
		Set<Cell> veinatge = getBarriComunitat(cell);
		Set<Cell> veines = new HashSet();
		for (Cell c : veinatge){
			if (isAlive(c) && !c.equals(cell)){
				veines.add(c);
			}
		}
		return veines;
	}

	private Set<Cell> getBarriComunitat(Cell cell) {
		/* Tota la Regio Potencial (incloent punts que no hi ha cap celula )*/
		Set<Cell> veines = new HashSet<>();
		
		// Matriu relativa de posicions (+1 i -1 en cada direcció)		
		for (int dx=-1; dx <= 1; dx++){
			for (int dy=-1; dy <= 1; dy++){
				Cell c = new Cell(cell.x + dx, cell.y + dy);
					veines.add(c);
			}
		}
		veines.remove(cell);
		return veines;
	}

	boolean isAlive(Cell c) {
		// Existeix aquesta casella!?
		return cells.contains(c);
	}

	public void addCell(Cell cell) {
		cells.add(cell);
	}

	private boolean haDeResucitar(Cell c) {
		
		return getVeines(c).size() == 3;
	}
	
	/* Simula la propera generació de formes basat en l'actual
	 * */
	public Board nextIteration() {
		// Simulacio per la proxima generacio
		Set<Cell> candidatesAReviure = new HashSet();
		
		Board nextBoard = new Board();
		for (Cell c : cells ){
			if ( getVeines(c).size() == 2 || getVeines(c).size() == 3 ) {
				nextBoard.addCell(c);
			}			
			candidatesAReviure.addAll(getBarriComunitat(c));
		}		
		
		for (Cell c : candidatesAReviure){
			if (!isAlive(c) && haDeResucitar(c)){
				nextBoard.addCell(c);
			}
		}
		return nextBoard;
	}



}
