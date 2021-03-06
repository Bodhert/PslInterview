package com.bodhert.maven.pslMineSweeper;

public class PrintBoard 
{
	
	// TODO if the numbers advance eg 10..11..12 it create a bad position the index
	
	public static void prettyPrint(Logic logic)
	{
		int height = logic.getHeight();
		int widht = logic.getWidht();
		Board uniqueBoard =  Board.getUniqueBoard();
		
		//printing  indexes
//		System.out.print("   ");
//		for(int j = 0 ; j < widht; ++j)
//			System.out.print(j + "  ");
//		System.out.println();
		
		
		for(int i = 0; i < height; ++i)
		{
			System.out.print(i + " -> ");
			for(int j = 0; j < widht; ++j)
			{
				if (logic.getVisiblePos(i,j))
				{
					int value = uniqueBoard.getBoardRepresentation(i, j);
					if(value == 0)
					{
						System.out.print(" - ");
					}
					else if(value > 0 && value < 9)
					{
						System.out.printf(" %d ", value);
					}
					else if (value == 9)
						System.out.print(" * ");
					
					else System.out.println(" . ");
				}
				else if (logic.getFlag(i, j))
				{
					System.out.print(" P ");
				}
				else System.out.print(" . ");
				
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
