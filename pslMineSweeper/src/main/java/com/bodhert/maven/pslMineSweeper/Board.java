package com.bodhert.maven.pslMineSweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.util.Pair;

public class Board 
{
	
	private static Board uniqueBoard;
	private int width,height,mines; //height = i, width j
	private int [][] BoardRepresentation;
	
	private Board(int height, int width, int mines) 
	{
		this.height = height;
		this.width = width;
		this.mines = mines;
		BoardRepresentation = new int[height][width];
		setBoardRepresentation();
	}
	
	private void setBoardRepresentation()
	{
		int tempMines = mines;
		// i could guarantee this method in exactly o(n^2)
		final int [] dr = {1,1,0,-1,-1,-1, 0, 1};
		final int [] dc = {0,1,1, 1, 0,-1,-1,-1};
		List <Pair <Integer,Integer> > RandomPairs =
				new ArrayList <Pair <Integer,Integer> > ();
		
		for(int i = 0; i < height;++i)
			for(int j = 0; j < width; ++j)
				RandomPairs.add(new Pair<Integer,Integer> (i,j));
		
		Collections.shuffle(RandomPairs);
		
		
		while(tempMines > 0)
		{
			int i = 0,j = 0;
			boolean placedMine = false;
			
			for(Pair <Integer,Integer> temp : RandomPairs)
			{
				i = temp.getKey();
				j = temp.getValue();
				if(BoardRepresentation[i][j] != 9 && BoardRepresentation[i][j] == 0)
				{
					RandomPairs.remove(temp);
					BoardRepresentation[i][j] = 9;
					placedMine = true;
					break;
				}
			}
			
	
			for(int d = 0; d < 8 && placedMine; ++d)
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
	
	public int getNumOfMines()
	{
		return this.mines;
	}

}
