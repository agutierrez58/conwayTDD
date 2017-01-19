package org.algoritmes.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {

	private Set<Cell> cells = new HashSet<>();
	
	
	public List<Cell> getVeines(Cell cell) {
		List<Cell> veines = new ArrayList<>();
		
		for (int dy=-1; dy <= 1; dy++){
			Cell c = new Cell(cell.x, cell.y + dy);
			if (cells.contains(c) && !c.equals(cell)){
				veines.add(c);
			}
		}
		
		return veines;
	}

	public void addCell(Cell cell) {
		cells.add(cell);
	}

}
