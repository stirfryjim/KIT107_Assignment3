//KIT107 Assignment 3
/**
 *	Player ADT
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

public class Player implements PlayerInterface, Comparable, Cloneable
{
	//finals
	protected final boolean TRACING=false;		// do we want to see trace output?

	// properties
	protected Symbol symbol;		// the player's symbol
	
	
	/**
	 *	Player
	 *	Constructor method.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol value is defined and valid
	 *	Informally: intialises the instance variable of the newly
	 *				created Player object to have the specified
	 *				symbol
	 *
	 *	@param s Symbol of created player
	*/
	public Player(Symbol s)
	{
      	trace("Player: Constructor starts");

		symbol=(Symbol)(s.clone());

      	trace("Player: Constructor starts");
	}
	
	
	/**
	 *	setSymbol
	 *	Set method for "symbol" instance variable.
	 *	Pre-condition: the symbol (s) is valid
	 *	Post-condition: the Player object's symbol is altered to hold
	 *					the given (s) value
	 *	Informally: assign the value of the parameter to the Player
	 *				object's symbol instance variable
	 *
	 *	@param s Symbol for current player
	*/
	public void setSymbol(Symbol s)
	{
		assert (s!=null);
		
      	trace("setSymbol: setSymbol starts");

		symbol=s;

      	trace("setSymbol: setSymbol ends");
	}
	
	
	/**
	 *	getSymbol
	 *	Get method for "symbol" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Player object's symbol is returned
	 *	Informally: examine the Player object's symbol instance
	 *					variable returning its value
	 *
	 *	@return Symbol current Player's Symbol
	*/
	public Symbol getSymbol()
	{
      	trace("getSymbol: getSymbol starts and ends");

		return symbol;
	}
	
	
	/**
	 *	compareTo
	 *	Test equality of player.
	 *	Pre-condition: parameter is a validly defined Player value
	 *	Post-condition: 0 is returned if current player and given value
	 *					possess identical symbols, +/-1 is returned
	 *					otherwise
	 *	Informally: check whether the given player has the same symbol as
	 *					the current player value
	 *
	 *	@param o Player Object to compare with current Player
	 *	@return int 0 if the same Player symbols, +/- if different
	*/
	public int compareTo(Object o)
	{
		Player p;
		
		assert (o instanceof Player);
		
      	trace("compareTo: compareTo starts and ends");
      	
		p=(Player) o;

		return (symbol.compareTo(p.getSymbol()));
	}
	
	
	/**
	 *	opponent
	 *	Find the opponent
	 *	Pre-condition: none
	 *	Post-condition: the opposite player to the current player is
	 *					returned
	 *	Informally: find the opponent to the current player
	 *
	 *	@return Player whichever of p1 and p2 is not the current Player
	*/
	public Player opponent()
	{
		Player p;
		
      	trace("opponent: opponent starts with " + symbol.toString());

		p=new Player(getSymbol().opponent());
	   		
		trace("opponent: opponent ends with " + p.getSymbol().toString());
		return p;
	}
	
	
	/**
	 *	equals
	 *	Test equality of player symbols.
	 *	Pre-condition: parameter is a validly defined Player value
	 *	Post-condition: true is returned if current player and given value
	 *					possess identical symbols, false is returned
	 *					otherwise
	 *	Informally: check whether the given player has the same symbol as
	 *					the current player
	 *
	 *	@param p the Player to compare with the current Player
	 *	@return boolean whether or not the two Players possess the same
	 *				symbol
	*/
	public boolean equals(Player p)
	{
		assert (p!=null);
		
      	trace("equals: equals starts and ends");

		return (this.compareTo(p) == 0);
	}


	/**
	 *	clone
	 *	Copy the player.
	 *	Pre-condition: none
	 *	Post-condition: a clone of the current object is created
	 *	Informally: create a copy of the player
	 *
	 *	@return Object the copy of the current Player
	*/
	public Object clone()
	{
		Player p=new Player((Symbol) getSymbol().clone());

      	trace("clone: clone starts and ends");
		
		return p;
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s the String to display as the trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("Player: " + s);
		}
	}
}