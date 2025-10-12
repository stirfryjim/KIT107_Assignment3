//KIT107 Assignment 3
/**
 *	Location ADT
 *
 *	@author Mel Goulding 745749
 *	@version October 2025
 *	
 *	This file holds the Location ADT which represents
 *	indices to (positions within) the two-dimensional grid.
 *	A Location consists of a Row number and a Column number.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


public class Location implements LocationInterface, Cloneable
{
	//finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// properties
	protected int row;			// the vertical component of the position
	protected int column;		// the horizontal component of the position
	
	
	/**
	 *	Location
	 *	Constructor method.
	 *	Pre-condition: none
	 *	Post-condition: the Location object records the vertical and
	 *					horizontal positions within instance variables
	 *	Informally: intialises the instance variables of the newly
	 *				created Location object to hold the vertical and
	 *				horizontal component values
	 *
	 *	@param r the row number
	 *	@param c the column number
	*/
	public Location(int r, int c)
	{
      	trace("Location: Constructor starts");

		this.row = r;
		this.column = c;

      	trace("Location: Constructor ends");
	}
	
	
	/**
	 *	setRow
	 *	Set method for "row" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Location object's vertical index is
	 *					altered to hold the given (r) value
	 *	Informally: assign the value of the parameter to the Location
	 *				object's vertical component instance variable
	 *
	 *	@param r the row number
	*/
	public void setRow(int r)
	{
      	trace("setRow: setRow starts");

		this.row = r;

      	trace("setRow: setRow ends");
	}
	
	
	/**
	 *	setColumn
	 *	Set method for "column" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Location object's horizontal index is
	 *					altered to hold the given (c) value
	 *	Informally: assign the value of the parameter to the Location
	 *				object's horizontal component instance variable
	 *
	 *	@param c the column number
	*/
	public void setColumn(int c)
	{
      	trace("setColumn: setColumn starts");

		this.column = c;

      	trace("setColumn: setColumn ends");
	}
	
	
	/**
	 *	getRow
	 *	Get method for "row" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Location object's vertical index is
	 *					returned
	 *	Informally: examine the Location object's vertical component
	 *				instance variable returning its value
	 *
	 *	@return int the row number
	*/
	public int getRow()
	{
      	trace("getRow: getRow starts and ends");

		return this.row;	// CHANGE ME
	}
	
	
	/**
	 *	getColumn
	 *	Get method for "column" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Location object's horizontal index is
	 *					returned
	 *	Informally: examine the Location object's horizontal component
	 *				instance variable returning its value
	 *
	 *	@return int the column number
	*/
	public int getColumn()
	{
      	trace("getColumn: getColumn starts and ends");

		return this.column;	// CHANGE ME
	}
	
	
	/**
	 *	clone
	 *	Clone variable for Location objects.
	 *	Pre-condition: none
	 *	Post-condition: a new Location object that is a copy of the
	 *					current object is returned
	 *	Informally: create a copy of the current object
	 *
	 *	@return Object the copied Location
	*/
	public Object clone()
	{
		Location l;
		
      	trace("clone: clone starts");

		l = new Location(row, column);

      	trace("clone: clone ends");
		return l;  // CHANGE ME
	}
	
	
	/**
	 *	toString
	 *	Convert the location to a String.
	 *	Pre-condition: none
	 *	Post-condition: a String representation of the current
	 *					Location is returned
	 *	Informally: find the String equivalent of the current
	 *				location
	 *
	 *	@return String the printable form of the Location
	*/
	public String toString()
	{
      	trace("toString: toString starts and ends");
      	
		return ("row " + getRow() + " and column " + getColumn());
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s String to display as a trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("Location: " + s);
		}
	}
}