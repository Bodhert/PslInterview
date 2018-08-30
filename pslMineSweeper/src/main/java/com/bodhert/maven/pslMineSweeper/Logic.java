package com.bodhert.maven.pslMineSweeper;
// only returns states 1 i win, 0 still playing, -1 lost
public class Logic 
{
	private boolean [][] flags;
	private boolean [][] visible;
	private int state, height,width, correctFlags, winnigMoves;
	final int [] dr = {1,1,0,-1,-1,-1, 0, 1};
	final int [] dc = {0,1,1, 1, 0,-1,-1,-1};
	Board uniqueboard = Board.getUniqueBoard();
	
	public Logic()
	{
		height = uniqueboard.getHeight();
		width = uniqueboard.getWidth();
		flags = new boolean[height][width];
		visible = new boolean[height][width];
		correctFlags = 0;
		winnigMoves = (height*width) - uniqueboard.getNumOfMines();
		state = 0;
	}
	
	
	private boolean hasCloseMines(int i, int j)
	{
		boolean closeMine = false;
		for(int d = 0; d < 8; ++d)
		{
			int checkcellI = i + dr[d];
			int checkcellJ = j + dc[d];
			if(areInRange(checkcellI, checkcellJ))
				if(uniqueboard.getBoardRepresentation(checkcellI, checkcellJ) == 9) 
				{								
					closeMine = true;
					break;
				}
		}
		return closeMine;
	}
	
	public void openCells(int i, int j)
	{
		if(areInRange(i, j))
		{
			if(!visible[i][j] && !flags[i][j]) 
			{
				visible[i][j] = true;
				if(!hasCloseMines(i, j)) 
				{
					for(int d = 0; d < 8; ++d)
					{
						int checkcellI = i + dr[d];
						int checkcellJ = j + dc[d];
						if(areInRange(checkcellI, checkcellJ))
								openCells(checkcellI, checkcellJ);
					}
				}
			}
		}
	}
	
	
	private boolean areInRange(int i, int j)
	{
		return (i >= 0 && i < height) && (j >= 0 && j < width);
	}
	
	public void ModifyState(int i, int j)
	{
		if(!checkBoard(i, j))
		{
			openCells(i,j);
			if(playingState())
				state = 1; // win
			else
				state = 0; // still playing
		}
		else
		{
			state = -1;
		}
	}
	
	private boolean playingState()
	{
		int cont = 0;
		for(int i = 0; i < height; ++i)
			for(int j = 0; j < width; ++j)
				if(visible[i][j])
					cont++;
		
		return cont == winnigMoves;
		
	}
	
	// return -1 in case that we select a mine
	private boolean checkBoard(int i, int j)
	{
		return (uniqueboard.getBoardRepresentation(i, j) == 9 && !flags[i][j]);
	}
	
	public void putFlag(int i, int j)
	{
		if(!visible[i][j]) 
		{			
			flags[i][j] = true;
			visible[i][j] = false;
		}
	}
	
	public void unsetFlag(int i, int j)
	{
		if(visible[i][j]) 
		{			
			flags[i][j] = false;
			visible[i][j] = true;
		}
	}
	
	public boolean getVisiblePos(int i, int j)
	{
		return visible[i][j];
	}
	
	public boolean getFlag(int i, int j)
	{
		return flags[i][j];
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getWidht()
	{
		return this.width;
	}
	
	public int getState()
	{
		return this.state;
	}
	
}
