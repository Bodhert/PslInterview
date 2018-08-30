package com.bodhert.maven.pslMineSweeper;

public class PrintBoard 
{
	
	// TODO if the numbers advance eg 10..11..12 it create a bad position the index
	public static void prettyPrintBoard(Board uniqueBoard)
	{
		int height = uniqueBoard.getHeight();
		int widht = uniqueBoard.getWidth();
		
		//printing  indexes
		System.out.print("   ");
		for(int j = 0 ; j < widht; ++j)
			System.out.print(j + "  ");
		System.out.println();
		
		for(int i = 0; i < height; ++i)
		{
			System.out.print(i + " ");
			for(int j = 0; j < widht; ++j)
			{
				// TODO i can change this if statements for switch cases
				// TODO i dont know how to put the flag yet 
				int value = uniqueBoard.getBoardRepresentation(i, j);
				boolean isSelected = uniqueBoard.getBoardMove(i, j);
				if(!isSelected)
				{
					System.out.print(" . ");
				}
				else if(isSelected && value == 0)
				{
					System.out.print(" - ");
				}
				else if(isSelected && value >= 0 && value < 9)
				{
					System.out.print(' ' + value);
				}
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public static void PrintAns(Board uniqueBoard)
	{
		int height = uniqueBoard.getHeight();
		int widht = uniqueBoard.getWidth();

		for(int i = 0; i < height; ++i)
		{
			for(int j = 0; j < widht; ++j)
			{
				System.out.print(uniqueBoard.getBoardRepresentation(i, j) + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	
	
	
	
}
