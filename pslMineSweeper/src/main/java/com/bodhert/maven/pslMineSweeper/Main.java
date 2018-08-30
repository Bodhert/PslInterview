package com.bodhert.maven.pslMineSweeper;

public class Main {
	
	public static void main(String[] args) 
	{
		Board uniqueboard = Board.setUniqueBoard(10,10,3);
		Logic logic = new Logic();
//		PrintBoard.prettyPrintBoard(logic.getVisible());
		PrintBoard.prettyPrint(logic);
		logic.openCells(0, 0);
		System.out.println();
		PrintBoard.prettyPrint(logic);
		PrintBoard.PrintAns(uniqueboard);
	}

}
