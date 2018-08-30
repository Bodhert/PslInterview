package com.bodhert.maven.pslMineSweeper;

public class Main {
	
	public static void main(String[] args) 
	{
		Board uniqueboard = Board.setUniqueBoard(9,3,1);
		PrintBoard.prettyPrintBoard(uniqueboard);
		PrintBoard.PrintAns(uniqueboard);
	}

}
