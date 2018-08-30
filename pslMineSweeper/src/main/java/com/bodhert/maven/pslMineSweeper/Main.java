package com.bodhert.maven.pslMineSweeper;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Board uniqueboard = Board.setUniqueBoard(5,5,1);
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
				logic.openCells(i, j);
				logic.ModifyState(i, j);
			}
			else if(option.equals("M"))
			{
				logic.putFlag(i, j);
			}
			else
				System.out.println("unrecogniced option");
			
			System.out.println();
			PrintBoard.prettyPrint(logic);
			System.out.println();
		}
		
		
		if(logic.getState() == 1)
			System.out.println("YOU WIN");
		else 
		{
			System.out.println("YOU LOSE");
			PrintBoard.PrintAns(uniqueboard); // debug purposes
		}
		
		System.out.println();
	}

}
