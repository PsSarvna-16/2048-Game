package com.game;

import java.util.concurrent.ThreadLocalRandom;

class Grid{

	private int[][] matrix;
	private int x;
	private int y;

	public Grid(Position p){
		this.x = p.getX();
		this.y = p.getY();
		this.matrix = new int[x][y];
		fillRandom();
		fillRandom();
	}

	public int fillRandom(){
		int x1 = ThreadLocalRandom.current().nextInt(0,this.x);
		int y1 = ThreadLocalRandom.current().nextInt(0,this.y);
		if(matrix[x1][y1] == 0){
			matrix[x1][y1] = 2;
			return 0;
		}
		return fillRandom();
	}

	public void show(){
		for(int row = 0; row < this.x; row++){
			for(int col = 0; col < this.y; col++){
				if(matrix[row][col] == 0){
					System.out.printf("|       ");
				}else{
					System.out.printf("| %-5d ",matrix[row][col]);
				}
			}
			System.out.println("|\n");
		}
	}

	public void swipeLeft(){
		
		for(int row = 0; row < this.x; row++){
			int pos = 0;
			for(int col = 1; col < this.y; col++){
				if(matrix[row][col] != 0){
					if(matrix[row][pos] == 0){
						matrix[row][pos] += matrix[row][col];
					}
					else if(matrix[row][pos] == matrix[row][col] ){
						matrix[row][pos++] += matrix[row][col];
					}else{
						matrix[row][++pos] += matrix[row][col];
					}
					matrix[row][col] = 0;
				}

			}
		}
		fillRandom();
	}

	public void swipeRight(){
		
		for(int row = 0; row < this.x; row++){
			int pos = this.y-1;
			for(int col = this.y-2; col >= 0 ; col--){
				if(matrix[row][col] != 0){
					if(matrix[row][pos] == 0){
						matrix[row][pos] += matrix[row][col];
					}
					else if(matrix[row][pos] == matrix[row][col] ){
						matrix[row][pos--] += matrix[row][col];
					}else{
						matrix[row][--pos] += matrix[row][col];
					}
					matrix[row][col] = 0;
				}

			}
		}
		fillRandom();
	}
	public void swipeUp(){
		
		for(int col = 0; col < this.y; col++){
			int pos = 0;
			for(int row = 1; row < this.x; row++){
				if(matrix[row][col] != 0){
					if(matrix[pos][col] == 0){
						matrix[pos][col] += matrix[row][col];
					}
					else if(matrix[pos][col] == matrix[row][col] ){
						matrix[pos++][col] += matrix[row][col];
					}else{
						matrix[++pos][col] += matrix[row][col];
					}
					matrix[row][col] = 0;
				}

			}
		}
		fillRandom();
	}

	public void swipeDown(){
		
		for(int col = 0; col < this.y; col++){
			int pos = this.y-1;
			for(int row = this.x-2; row >= 0 ; row--){
				if(matrix[row][col] != 0){
					if(matrix[pos][col] == 0){
						matrix[pos][col] += matrix[row][col];
					}
					else if(matrix[pos][col] == matrix[row][col] ){
						matrix[pos--][col] += matrix[row][col];
					}else{
						matrix[--pos][col] += matrix[row][col];
					}
					matrix[row][col] = 0;
				}

			}
		}
		fillRandom();
	}
}