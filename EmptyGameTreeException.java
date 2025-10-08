//KIT107 Assignment 3
/**
 *	Empty GameTree Exception
 *
 *	@author Julian Dermoudy
 *	@version September 2025
 *	
 *	This file holds the Empty GameTree Exception.  This is
 *	used when GameTree ADTs are accessed and errors
 *	result.  Specifically, EmptyGameTreeException objects
 *	are created and thrown when attempts are made to
 *	set/get instance variables in an empty GameTree.
 *	
 *	This file is complete.
*/


public class EmptyGameTreeException extends RuntimeException {
	public EmptyGameTreeException()
	{
		super("Cannot access a component of an empty game tree...");
	}
}