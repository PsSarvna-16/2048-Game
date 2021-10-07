package com.game;

import java.util.Scanner;

class Game{

	static Grid grid;

	public Game(Position p){
		this.grid = new Grid(p);
	} 

	public static void main(String args[]){

		Game game = new Game(new Position(4,4));
		game.grid.show();
		System.out.println();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("\n Enter your Choice  : ");
			int choice = sc.nextInt();
			switch(choice){
				case 8 :
				{
					game.grid.swipeUp();
					System.out.println();
					game.grid.show();
					break;	
				}

				case 2 :
				{
					game.grid.swipeDown();
					System.out.println();
					game.grid.show();
					break;
				}
				
				case 4 :
				{
					game.grid.swipeLeft();
					System.out.println();
					game.grid.show();
					break;
				}

				case 6 :
				{
					game.grid.swipeRight();
					System.out.println();
					game.grid.show();
					break;
				}

				case 0 :
				{
					return;
				} 
			}

		}
	}
}