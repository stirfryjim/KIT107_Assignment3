//KIT107 Assignment 3
/**
 *	Grid ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Grid ADT which represents
 *	the Connect-4 board.  The Grid consists of a dimension,
 *	a value (of the current board), and a two-dimensional
 *	array (table/matrix) of the squares in the board.
 *	
 *	This file is complete.
*/


public interface GridInterface
{
	//public Grid();
	//public Grid(int m)
	//public Grid(int m, Location l, Symbol s) throws IllegalGridException;
	public Object clone();
	public void setSquare(Location l, Square s) throws IllegalGridException;
	public Square getSquare(Location l) throws IllegalGridException;
	public void setDimension(int d);
	public int getDimension();
	public void setWorth(int v);
	public int getWorth();
	public void occupySquare(Location l, Symbol s);
	public boolean squareOccupied(Location l);
	public Symbol getSymbol(Location l);
	public boolean validMove(Location l);
	public boolean gameOver();
	public Symbol win();
	public boolean draw();
	public String toString();
	public int evaluateGrid(Player p);
	public void showGrid(Display s);
	public int compareTo(Object o);
	public boolean equals(Grid g);
}
