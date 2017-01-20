package org.algoritmes.tdd;

public class Game {

	private Board board;
	
	public Game(Board board) {
		this.board = board;
	}

	public Board nextIteration() {
	
		return board.nextIteration();	
	}
	/*
	 * print
	 */

}
