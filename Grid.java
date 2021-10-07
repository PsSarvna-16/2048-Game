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

	public boolean fillRandom(){

		if(isThereSpace()){
			int x1 = ThreadLocalRandom.current().nextInt(0,this.x);
			int y1 = ThreadLocalRandom.current().nextInt(0,this.y);
			if(matrix[x1][y1] == 0){
				
				matrix[x1][y1] = 2;
				isThereMove() ?	return true :return false;
			}
			return fillRandom();
		}else{
			isThereMove() ?	return true :return false;
		}
	}

	public boolean isThereSpace(){
		for(int row = 0; row < this.x; row++){
			for(int col = 0; col < this.y; col++){
				if(matrix[row][col] == 0){
					return true;
				}
			}
		}
		return false;
	}

	public boolean isThereMove(){
		
		for(int row = 0; row < this.x ;row++){
			for(int col = 0; col < this.y-1; col++){
				if(matrix[row][col]-matrix[row][col+1] == 0){
					return true;
				}
			}
		}
		for(int col = 0; col < this.y ;col++){
			for(int row = 0; row < this.x-1; row++){
				if(matrix[row][col]-matrix[row][col+1] == 0){
					return true;
				}
			}
		}
		return false;
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

	public boolean swipeLeft(){
		
		for(int row = 0; row < this.x; row++){
			int pos = 0;
			for(int col = 0; col < this.y; col++){
				
				if(pos != col && matrix[row][col] != 0){

					if(matrix[row][pos] == 0){
						matrix[row][pos] = matrix[row][col];
						matrix[row][col] = 0;
					}
					else if(matrix[row][pos] == matrix[row][col] ){
						matrix[row][pos++] += matrix[row][col];
						matrix[row][col] = 0;
					}else{
						int temp = matrix[row][col];
						matrix[row][col] = 0;
						matrix[row][++pos] += temp;
					}
				}		
			}
		}
		return fillRandom();
	}

	public boolean swipeRight(){
		
		for(int row = 0; row < this.x; row++){

			int pos = this.y-1;
			for(int col = this.y-1; col >= 0; col--){
				
				if(pos != col && matrix[row][col] != 0){

					if(matrix[row][pos] == 0){
						matrix[row][pos] = matrix[row][col];
						matrix[row][col] = 0;
					}
					else if(matrix[row][pos] == matrix[row][col] ){
						matrix[row][pos--] += matrix[row][col];
						matrix[row][col] = 0;
					}else{
						int temp = matrix[row][col];
						matrix[row][col] = 0;
						matrix[row][--pos] += temp;
					}
				}	
			}
		}
		return fillRandom();
	}
	public boolean swipeUp(){

		for(int col = 0; col < this.y; col++){

			int pos = 0;
			for(int row = 0; row < this.x; row++){

				if(pos != row && matrix[row][col] != 0){

					if(matrix[pos][col] == 0){
						matrix[pos][col] = matrix[row][col];
						matrix[row][col] = 0;
					}
					else if(matrix[pos][col] == matrix[row][col] ){
						matrix[pos++][col] += matrix[row][col];
						matrix[row][col] = 0;
					}else{
						int temp = matrix[row][col];
						matrix[row][col] = 0;
						matrix[++pos][col] += temp;
					}
				}		
			}
		}
		return fillRandom();
	}

	public boolean swipeDown(){
		
		for(int col = 0; col < this.y; col++){
			int pos = this.y-1;
			for(int row = this.y-1; row >= 0; row--){

				if(pos != row && matrix[row][col] != 0){

					if(matrix[pos][col] == 0){
						matrix[pos][col] = matrix[row][col];
						matrix[row][col] = 0;
					}
					else if(matrix[pos][col] == matrix[row][col] ){
						matrix[pos--][col] += matrix[row][col];
						matrix[row][col] = 0;
					}else{
						int temp = matrix[row][col];
						matrix[row][col] = 0;
						matrix[--pos][col] += temp;
					}
				}
			}
		}
		return fillRandom();
	}
}