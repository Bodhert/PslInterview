package com.bodhert.maven.pslMineSweeper;

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
		//TODO write code logic
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
