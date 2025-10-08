//KIT107 Assignment 3
/**
 *	Player ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Player ADT which represents
 *	the concept of a game participant.
 *	A Player consists of a coloured symbol.
 *	
 *	This file is complete.
*/


public interface PlayerInterface
{
	//public Player(Symbol s);
	public void setSymbol(Symbol s);
	public Symbol getSymbol();
	public int compareTo(Object o);
	public Player opponent();
	public boolean equals(Player p);
	public Object clone();
}
