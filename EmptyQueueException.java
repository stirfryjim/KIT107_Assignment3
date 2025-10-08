//KIT107 Assignment 3
/**
 *	Empty Queue Exception
 *
 *	@author Julian Dermoudy
 *	@version September 2025
 *	
 *	This file holds the Empty Queue Exception.  This
 *	is used when Queue ADTs are accessed and errors
 *	result.  Specifically, EmptyQueueException objects
 *	are created and thrown when attempts are made to
 *	set/get instance variables in an empty Queue through
 *	front()/remove().
 *	
 *	This file is complete.
*/


public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException()
	{
		super("Cannot access a component of an empty queue...");
	}
}