//KIT107 Assignment 3
/**
 *	Square ADT
 *
 *	@author Mel Goulding 745749
 *	@version September 2025
 *	
 *	This file holds the Square ADT which represents
 *	a physical space within a grid.  A Square in a
 *	grid consists of a location, and a symbol.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/

import java.awt.*;


public class Square implements SquareInterface, Cloneable
{	
	//finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// properties
	protected Location loc;		// the location of the current square within the grid
	protected Symbol symbol;	// the symbol of the current square
	
	
	/**
	 *	Square
	 *	Constructor method 1.
	 *	Pre-condition: the given location value is defined
	 *	Post-condition: the Square object's "loc" field is the value
	 *					given, its "symbol" field is the 'empty' (default) symbol
	 *	Informally: creates an empty square at the given location
	 *
	 *	@param l the Location to associate with the Square
	*/
	public Square(Location l)
	{
		assert (l!=null);
		
      	trace("Square: Constructor starts");

		this.loc = l;
		this.symbol = new Symbol();

      	trace("Square: Constructor ends");
	}
	
	
	/**
	 *	Square
	 *	Constructor method 2.
	 *	Pre-condition: the given location and symbol values are defined
	 *	Post-condition: the Square object's "loc" field is the value
	 *					given, and its "symbol" field is assigned
	 *					the given value
	 *	Informally: creates a square at the given location with the given
	 *					symbol
	 *
	 *	@param l the Location to associate with the Square
	 *	@param s the Symbol to store in the Square
	*/
	public Square(Location l,Symbol s)
	{
		assert ((l!=null) && (s!=null));
		
      	trace("Square: Constructor starts");

		this.loc = l;
		this.symbol = s;

      	trace("Square: Constructor ends");
	}
	
	
	/**
	 *	clone
	 *	Copy the square.
	 *	Pre-condition: the current Square object is validly defined
	 *	Post-condition: the Square object is copied
	 *	Informally: copy the current Square
	 *
	 *	@return Object the copy of the current Square
	*/
	public Object clone()
	{
		Square s;
		
		assert ((getLocation() != null) && (getSymbol() != null));
      	trace("clone: clone starts");

		s = new Square(loc, symbol);

      	trace("clone: clone ends");
		return s;	
	}
	
	
	/**
	 *	getLocation
	 *	Get method for "loc" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					location field is returned
	 *	Informally: return the current square's location
	 *	@return Location the Location associated with the square
	*/
	public Location getLocation()
	{
      	trace("getLocation: getLocation starts and ends");

		return loc;
	}
	
	
	/**
	 *	setLocation
	 *	Set method for "loc" instance variable.
	 *	Pre-condition: the given Location value is defined and
	 *				   valid within the enclosing grid
	 *	Post-condition: the value of the Square object's loc
	 *					field is altered to contain the given
	 *					Location value
	 *	Informally: update the Square object's Location to the
	 *				given value
	 *
	 *	@param l the Location to associate with the Square
	*/
	public void setLocation(Location l)
	{
		assert (l!=null);
		
      	trace("setLocation: setLocation ends");

		this.loc = l;

      	trace("setLocation: setLocation ends");
	}
	
	
	/**
	 *	getSymbol
	 *	Get method for "symbol" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's
	 *					symbol field is returned
	 *	Informally: return the current square's symbol
	 *
	 *	@return Symbol the Symbol stored within the Square
	*/
	public Symbol getSymbol()
	{
      	trace("getSymbol: getSymbol starts and ends");

		return symbol;
	}
	
	
	/**
	 *	setSymbol
	 *	Set method for "symbol" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Square object's symbol
	 *					field is altered to contain the given
	 *					Symbol value
	 *	Informally: update the Square object's Symbol to the
	 *				given value
	 *
	 *	@param s the Symbol to store within the Square
	*/
	public void setSymbol(Symbol s)
	{
      	trace("setSymbol: setSymbol ends");

		symbol=s;

      	trace("setSymbol: setSymbol ends");
	}
	
	
	/**
	 *	isEmpty
	 *	Check whether square is occupied.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the value of the Square
	 *					object's symbol field is returned
	 *	Informally: return whether the current square is occupied
	 *
	 *	@return boolean whether or not the square doesn't contain a
	 *				players' symbol
	*/
	public boolean isEmpty()
	{
      	trace("isEmpty: isEmpty starts and ends");

		trace("isEmpty: isEmpty ends");
		return (symbol.isEmpty());	// CHANGE ME
	}
	
	
	/**
	 *	showSquare
	 *	Display the square.
	 *	Pre-condition: the Screen parameter is correctly defined
	 *	Post-condition: the screen representation of the Square
	 *					object is displayed on the given Screen at
	 *					the position related to its location using
	 *					the Square object's symbol and the given
	 *					width
	 *	Informally: display the current square
	 *
	 *	@param s the Display upon which the square should be shown
	 *	@param w the desired number of pixels for the side length
	 *				of the Square
	*/
	public void showSquare(Display s,int w)
	{
		int x,y;
		Graphics g;
		
		assert (s!=null);
		
      	trace("showSquare: showSquare starts");
		
		x=(loc.getColumn()-1)*(w+5) + 5;
		y=70 + (loc.getRow()-1)*(w+5);

		g=s.getGraphics();
		g.fillRect(x,y,5,w+10);
		g.fillRect(x,y,w+10,5);
		g.fillRect(x+w+5,y,5,w+10);
		g.fillRect(x,y+w+5,w+10,5);
		
		trace("showSquare: square is " + toString());	
		symbol.showSymbol(s,loc,w);
		
      	trace("showSquare: toString ends");
	}
	
	
	/**
	 *	toString
	 *	Convert the Square to a printable representation
	 *	Pre-condition: none
	 *	Post-condition: a String representation of the current
	 *					Square is returned
	 *	Informally: find the String equivalent of the current
	 *				square
	 *
	 *	@return String the printable representation of the Square
	*/
	public String toString()
	{
      	trace("toString: toString starts and ends");
      	
		return symbol.toString();
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
			System.out.println("Square: " + s);
		}
	}
}
