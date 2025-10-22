//KIT107 Assignment 3
/**
 *	Symbol ADT
 *
 *	@author Chris Luchavez (745963), Mel Goulding(745749)
 *	@version October 2025
 *	
 *	This file holds the Symbol ADT which represents
 *	pieces within the two-dimensional grid.
 *	A Symbol consists of a representation of a red or blue
 *	disc or empty.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


import java.awt.Color;


public class Symbol implements SymbolInterface, Cloneable, Comparable
{
	// finals 
	protected final boolean TRACING=false;		// do we want to see trace output?
	protected final Color COLOUR_1=Color.RED;	// red for player one
	protected final Color COLOUR_2=Color.BLUE;	// blue for player two
	protected final Color BLANK=Color.BLACK;	// black for blank symbol

	// properties
	protected Color colour;		// the colour of the symbol
	protected boolean empty;	// whether the symbol is the empty symbol
	
	
	/**
	 *	Symbol
	 *	Constructor method 1.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object is created empty
	 *	Informally: intialises the instance variable of the newly
	 *				created Symbol object to empty (and black)
	*/
	public Symbol()
	{
      	trace("Symbol: Constructor starts");

		empty=true;
		colour=BLANK;

      	trace("Symbol: Constructor ends");
	}
	
	/**
	 *	Symbol
	 *	Constructor method 2.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object is created for the specified
	 *					colour -- red if the parameter is true and
	 *					blue if the parameter is false
	 *	Informally: intialises the instance variable of the newly
	 *				created Symbol object to the symbol value indicated
	 *
	 *	@param x boolean for whether it should be colour 1 (red)
	*/
	public Symbol(boolean x)
	{
      	trace("Symbol: Constructor starts");

		if (x)
		{
			colour=COLOUR_1;
		}
		else
		{
			colour=COLOUR_2;
		}

		empty=false;

      	trace("Symbol: Constructor ends");
	}
	
	
	/**
	 *	setColour
	 *	Set method for "colour" instance variable.
	 *	Pre-condition: the colour (c) is valid
	 *	Post-condition: the Symbol object's colour is altered to hold
	 *					the given (c) value
	 *	Informally: assign the value of the parameter to the Symbol
	 *				object's colour instance variable
	 *
	 *	@param c the desired colour
	*/
	public void setColour(Color c)
	{
		assert (c != null);
		
      	trace("setColour: setColour starts");

		// sets parameter color to the variable
		this.colour = c;

      	trace("setColour: setColour ends");
	}
	
	
	/**
	 *	makeEmpty
	 *	Set method for "empty" (and "colour") instance variables.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's emptiness record is
	 *					altered to hold true and the colour is set
	 *					to a 'non-color', e.g. black
	 *	Informally: assign the value of true to the Symbol object's
	 *					empty instance variable and invalidate the colour
	 *					instance variable
	*/
	public void makeEmpty()
	{
      	trace("makeEmpty: makeEmpty starts");

		// flips objects empty record to true and overrides color 
		this.empty = true;
		this.colour = BLANK;

      	trace("makeEmpty: makeEmpty ends");
	}
	
	
	/**
	 *	getColour
	 *	Get method for "colour" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's colour is returned
	 *	Informally: examine the Symbol object's colour instance
	 *					variable returning its value
	 *
	 *	@return Color the colour of the symbol
	*/
	public Color getColour()
	{
      	trace("getColour: getColour starts and ends");

		// returns color of object
		return colour;	
	}
	
	
	/**
	 *	isEmpty
	 *	Get method for "empty" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object's emptiness record is returned
	 *	Informally: examine the Symbol object's empty instance variable
	 *					returning its value
	 *
	 *	@return boolean whether or not the symbol is empty
	*/
	public boolean isEmpty()
	{
      	trace("isEmpty: isEmpty starts and ends");

		// returns objects emptiness record
		return empty;
	}
	
	
	/**
	 *	compareTo
	 *	Test equality of symbols.
	 *	Pre-condition: parameter is a validly defined Symbol value
	 *	Post-condition: 0 is returned if current symbol and given value
	 *					are identical (both empty or possessing identical
	 *					colours), +1 otherwise
	 *	Informally: check whether the given symbol has the same colour as
	 *					the current symbol value (including whether both
	 *					are empty)
	 *
	 *	@param o the Symbol to be compared to the current Symbol
	 *	@return int 0 if the symbols are the same 1 otherwise
	*/
	public int compareTo(Object o)
	{
		Symbol s;
		
 		assert ((o instanceof Symbol) && (o!=null));
		
     	trace("compareTo: compareTo starts");

		s=(Symbol) o;
		if (((isEmpty()) && (s.isEmpty())) || (s.getColour().equals(getColour())))
  	    {
			// empty or same colour
  	    	trace("compareTo: compareTo ends (0)");
			return 0;
		}
		else
		{	
			// different colour
  	    	trace("compareTo: compareTo ends (1)");
			return 1;  // order is arbitrary
		}
	}
	
	
	/**
	 *	equals
	 *	Test equality of symbols.
	 *	Pre-condition: parameter is a validly defined Symbol value
	 *	Post-condition: true is returned if current symbol and given value
	 *					are identical (both empty or possessing identical
	 *					colours), false otherwise
	 *	Informally: check whether the given symbol has the same colour as
	 *					the current symbol value (including whether both
	 *					are empty)
	 *
	 *	@param s the Symbol to be compared to the current Symbol
	 *	@return boolean whether or not the two symbols are the same
	*/
	public boolean equals(Symbol s)
	{
 		assert (s!=null);
		
      	trace("equals: equals starts and ends");

		// returns objects symbols if they're the same
		return (isEmpty() && s.isEmpty()) || (colour == s.getColour());	
	}
	
	
	/**
	 *	opponent
	 *	Provide the opponent to a symbol.
	 *	Pre-condition: none
	 *	Post-condition: the opposite Symbol object is returned or an
	 *					empty symbol if the current Symbol is empty
	 *	Informally: find the opponent's Symbol
	 *
	 *	@return Symbol the 'opposite' of the Symbol
	*/
	public Symbol opponent()
	{
		Symbol s;	// result
		
      	trace("opponent: opponent starts");

		if (isEmpty())
		{
			// symbol is empty and has no opponent
			s=new Symbol();
		}
		else
		{
			s=new Symbol(true);	// assume player 1
			if (this.equals(s))
			{
				// current player is player 1, so opponent is player 2
				s=new Symbol(false);
			}
		}
						
      	trace("opponent: opponent ends");
		return s;
	}
	
	
	/**
	 *	clone
	 *	Clone a symbol.
	 *	Pre-condition: none
	 *	Post-condition: the Symbol object is copied
	 *	Informally: copy the current Symbol
	 *
	 *	@return Object the copy of the Symbol
	*/
	public Object clone()
	{
		Symbol s;	// result
		
      	trace("clone: clone starts");

		if (isEmpty())
		{
			// create empty clone
			s = new Symbol();
		}
		else
		{
			// create non-empty clone and update colour
			s = new Symbol(true);
			s.setColour(getColour());
		}
		
      	trace("clone: clone ends");
		return s;
	}
	
	
	/**
	 *	showSymbol
	 *	Display method for Symbol
	 *	Pre-condition: the Screen and Location parameters are
	 *					correctly defined and w is a positive
	 *					integer
	 *	Post-condition: the screen representation of the Symbol
	 *					object is displayed on the given Screen at
	 *					the given location in the grid using the
	 *					Symbol object's colour to display the
	 *					Symbol (of width w pixels)
	 *	Informally: display the current symbol
	 *
	 *	@param s the Display to show the Symbol upon
	 *	@param l the Location to show the Symbol at
	 *	@param w the maximum width/height for the Symbol in pixels
	*/
	public void showSymbol(Display s, Location l, int w)
	{
		int x, y;

		assert ((s!=null) && (l!=null) && (w>0));

      	trace("showSymbol: showSymbol starts");
		
		if (!isEmpty())
		{
		  	x=(l.getColumn()-1)*(w+5) + 10 + 3;
		  	y=75 + (l.getRow()-1)*(w+5) + 3;
		  	
		  	s.getGraphics().setColor(Color.BLACK);
		  	s.getGraphics().fillOval(x,y,w-6,w-6);
		  	s.getGraphics().setColor(getColour());
		  	s.getGraphics().fillOval(x+2,y+2,w-10,w-10);
			s.getGraphics().setColor(Color.BLACK);
			
 	     	trace("showSymbol: symbol is " + toString());
		}

		s.getGraphics().setColor(Color.BLACK);

      	trace("showSymbol: showSymbol ends");
	}
	
	
	/**
	 *	toString
	 *	Convert the symbol to a printable representation.
	 *	Pre-condition: none
	 *	Post-condition: a String representation of the current
	 *					Symbol is returned
	 *	Informally: find the String equivalent of the current
	 *				symbol ("1" for player 1/human; "2" for
	 *				player 2/computer)
	 *
	 *	@return String the printable representation of the Symbol
	*/
	public String toString()
	{
      	trace("toString: toString starts");

		if (isEmpty())
      	{
      		trace("toString: toString ends (empty)");
			return " ";
		}
		else
		{
			if (getColour().equals(COLOUR_1))
      		{
      			trace("toString: toString ends (Player 1)");
				return "1";
			}
			else
      		{
      			trace("toString: toString ends (Player 2)");
				return "2";
			}
		}
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s the String to be displayed as the trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("Symbol: " + s);
		}
	}
}