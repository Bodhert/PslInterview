package com.bodhert.maven.pslMineSweeper;

import java.util.Scanner;
import java.util.StringTokenizer;

public class InputHandler 
{
	private String command;
	private String[] commands;
	public int height,widht;
	public String option;
	
	public void InputHandler() {}
	
	public void execute()
	{
		parseCommands();
	}
	

	
	private void parseCommands()
	{
		commands = command.split("\\s");
		 StringTokenizer sTokenizer  = new StringTokenizer(command);
//		 System.out.println(sTokenizer.nextToken());
//	 	 System.out.println(sTokenizer.nextToken(""));
	 	 
	 	 if(sTokenizer.countTokens() < 3)
	 	 {
	 		 System.out.println("command malFormed");
	 	 }
	 	 else 
	 	 {
	 		 height = Integer.parseInt(sTokenizer.nextToken());
	 		 widht = Integer.parseInt(sTokenizer.nextToken());
	 		 option = sTokenizer.nextToken();
	 	 }
	}

	public int[] getNumbers(String numbers)
	{
		StringTokenizer sTokenizer  = new StringTokenizer(numbers);
		int size = sTokenizer.countTokens();
		int temp[] = new int[size];
		
		for(int i = 0; i < size; ++i)
		{
			temp[i] = Integer.parseInt(sTokenizer.nextToken());
		}
		return temp;
		
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidht() {
		return widht;
	}

	public String getOption() {
		return option;
	}
	
	public void setCommand(String command)
	{
		this.command = command;
	}
	
	
	

}
