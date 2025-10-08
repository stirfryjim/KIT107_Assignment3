//KIT107 Assignment 3
/**
 *	Square ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Square ADT which represents
 *	a physical space within a grid.  A Square in a
 *	grid consists of a location, and a symbol.
 *	
 *	This file is complete.
*/


public interface SquareInterface
{
	//public Square(Location l);
	//public Square(Location l,Symbol s);
	public Object clone();
	public Location getLocation();
	public void setLocation(Location l);
	public Symbol getSymbol();
	public void setSymbol(Symbol s);
	public boolean isEmpty();
	public void showSquare(Display s, int w);
	public String toString();
}
