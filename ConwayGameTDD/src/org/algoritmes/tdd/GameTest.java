package org.algoritmes.tdd;

import org.junit.Test;

public class GameTest {

	@Test
	public void simula() {
		
		// Executar 
		int tamany=3;  // 5!?¿
		Board board = BoardTest.createBlockBoard(tamany, tamany);
		Game game = new Game(board);
		
		int numIteracions = 30;
		int i = 0;		
		do {
			game.paintBoard(tamany);
			game.nextIteration(); i++;
			System.out.println("-------");
		} while (i < numIteracions);	
		
	}
	
}
