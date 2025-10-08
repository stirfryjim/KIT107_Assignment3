//KIT107 Assignment 3
/**
 *	Empty Stack Exception
 *
 *	@author Julian Dermoudy
 *	@version September 2025
 *	
 *	This file holds the Empty Stack Exception.  This is
 *	used when Stack ADTs are accessed and errors
 *	result.  Specifically, EmptyStackException objects
 *	are created and thrown when attempts are made to
 *	access the top/remainder of an empty stack through
 *	top() or pop().
 *	
 *	This file is complete.
*/


public class EmptyStackException extends RuntimeException {
	public EmptyStackException()
	{
		super("Cannot access a component of an empty stack...");
	}
}