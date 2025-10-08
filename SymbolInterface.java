//KIT107 Assignment 3
/**
 *	Symbol ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Symbol ADT which represents
 *	pieces within the two-dimensional grid.
 *	A Symbol consists of a representation of a red or blue
 *	disc or empty.
 *	
 *	This file is complete.
*/


import java.awt.Color;


public interface SymbolInterface
{
	//public Symbol();
	//public Symbol(boolean x);
	public void setColour(Color c);
	public Color getColour();
	public void makeEmpty();
	public boolean isEmpty();
	public int compareTo(Object o);
	public boolean equals(Symbol s);
	public Object clone();
	public Symbol opponent();
	public void showSymbol(Display s, Location l, int w);
	public String toString();
}

