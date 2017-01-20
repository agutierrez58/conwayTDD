package org.algoritmes.tdd;

public class Game {

	private Board board;
	
	public Game(Board board) {
		this.board = board;
	}

	public Board nextIteration() {
		Board nextBoard = board.nextIteration();
		this.board = nextBoard;	
		return nextBoard;	
	}
	
	public void paintBoard(int tamany) {
		for (int i=0; i < tamany;i++){
			for (int j=0; j < tamany; j++) {
				System.out.print(board.isAlive(new Cell(i,j)) ? "X" :" " );
			}
			System.out.print("\n");
		}
	}
	

	
}
