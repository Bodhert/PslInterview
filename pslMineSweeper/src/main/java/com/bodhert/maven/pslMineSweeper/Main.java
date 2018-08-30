package com.bodhert.maven.pslMineSweeper;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Board uniqueboard = Board.setUniqueBoard(3,3,2);
		Logic logic = new Logic();
		InputHandler input = new InputHandler();
		
		while(logic.getState() == 0)
		{
			PrintBoard.PrintAns(uniqueboard); // debug purposes
			PrintBoard.prettyPrint(logic);
			String command = sc.nextLine();
			input.setCommand(command);
			input.execute();
			String option = input.getOption();
			int i,j;
			i = input.getHeight();
			j = input.getWidht();
			if(option.equals("U"))
			{
				try 
				{					
					logic.ModifyState(i, j);
				} 
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Out of bounds Indexes");
				}
			}
			else if(option.equals("M"))
			{
				try
				{
					logic.putFlag(i, j);
					
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Out of bound Indexes");
				}
			}
			else
				System.out.println("unrecogniced option");
			
			System.out.println();
			System.out.println();
		}
		
		if(logic.getState() == 1)
		{			
			System.out.println("YOU WIN");
			PrintBoard.prettyPrint(logic);
		}
			
		else 
		{
			System.out.println("YOU LOSE");
			PrintBoard.PrintAns(uniqueboard); 
		}
		
		System.out.println();
	}

}
