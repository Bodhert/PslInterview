package com.bodhert.maven.pslMineSweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board 
{
	
	private static Board uniqueBoard;
	private int width,height,mines; //height = i, width j
	private int [][] BoardRepresentation;
	private boolean [][] BoardMoves;
	
	private Board(int height, int width, int mines) 
	{
		this.height = height;
		this.width = width;
		this.mines = mines;
		BoardRepresentation = new int[height][width];
		BoardMoves = new boolean[height][width];
		setBoardRepresentation();
	}
	
	private void setBoardRepresentation()
	{
		int tempMines = mines;
		// i could guarantee this method in exactly o(n^2)
		Random randomI = new Random();
		Random randomJ = new Random();
		final int [] dr = {1,1,0,-1,-1,-1, 0, 1};
		final int [] dc = {0,1,1, 1, 0,-1,-1,-1};
		while(tempMines > 0)
		{
			int i,j;
			// TODO A better loop
			while(true)
			{
				i = randomI.nextInt(height);
				j = randomJ.nextInt(width);
				if(BoardRepresentation[i][j] != 9) break;
			}
			
			for(int d = 0; d < 8; ++d)
			{
				int checkcellI = i + dr[d];
				int checkcellJ = j + dc[d];
				if( areInRange(checkcellI,checkcellJ))
				{
					BoardRepresentation[checkcellI][checkcellJ]++;
				}
			}
			tempMines--;
		}
		
	}
	
	
	private boolean areInRange(int i, int j)
	{
		return (i >= 0 && i < height) && (j >= 0 && j < width);
	}
	
	public static Board setUniqueBoard(int height, int width, int mines)
	{
		if(uniqueBoard == null) 
			return uniqueBoard = new Board(height, width, mines);
		else
			System.out.println("Board already created, returning the board created");
		return uniqueBoard;
	}
	
	public static Board getUniqueBoard()
	{
		if(uniqueBoard != null) 
			return uniqueBoard;
		else
			System.out.println("Board is not created returning a null board");
			return null;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getBoardRepresentation(int i , int j) 
	{
		return BoardRepresentation[i][j];
	}

	public boolean getBoardMove(int i, int j) {
		return BoardMoves[i][j];
	}
	
	public void setTrueBoardMove(int i, int j) 
	{
		BoardMoves[i][j] = true;
	}

}
