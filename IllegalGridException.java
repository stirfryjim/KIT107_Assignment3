//KIT107 Assignment 3
/**
 *	Grid Exception
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Grid Exception.  This
 *	is used when Grid ADTs are accessed beyond the
 *	boundary of the defined grid and errors	result.
 *	Specifically, IllegalGridException objects are
 *	created and thrown when attempts are made to
 *	set/get Square variables outside the rows and
 *	columns defined for the grid object through
 *	the third constructor, setSquare()/getSquare().
 *	
 *	This file is complete.
*/


public class IllegalGridException extends RuntimeException {
	public IllegalGridException()
	{
		super("Cannot access a component not in the grid...");
	}
}