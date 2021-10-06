package com.game;

class Game{

	static Grid grid;

	public Game(Position p){
		this.grid = new Grid(p);
	} 

	public static void main(String args[]){

		Game game = new Game(new Position(4,4));
		game.grid.show();
		System.out.println();

		game.grid.swipeLeft();
		System.out.println();
		game.grid.show();

		game.grid.swipeRight();
		System.out.println();
		game.grid.show();	

		game.grid.swipeUp();
		System.out.println();
		game.grid.show();

		game.grid.swipeDown();
		System.out.println();
		game.grid.show();

	}
}