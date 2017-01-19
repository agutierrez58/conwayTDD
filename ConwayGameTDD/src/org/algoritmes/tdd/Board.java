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
		Set<Cell> veinatge = getComunitat(cell);
		Set<Cell> veines = new HashSet();
		for (Cell c : veinatge){
			if (isAlive(c) && !c.equals(cell)){
				veines.add(c);
			}
		}
		return veines;
	}

	private Set<Cell> getComunitat(Cell cell) {
		// Barri
		Set<Cell> veines = new HashSet<>();
		
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

}
