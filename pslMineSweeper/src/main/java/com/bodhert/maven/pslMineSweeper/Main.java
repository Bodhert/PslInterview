package com.bodhert.maven.pslMineSweeper;

public class Main {
	
	public static void main(String[] args) 
	{
		Board uniqueboard = Board.setUniqueBoard(5,5,5);
		PrintBoard.prettyPrintBoard(uniqueboard);
	}

}
