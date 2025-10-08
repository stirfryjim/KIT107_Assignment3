//KIT107 Assignment 3
/**
 *	Queue ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Queue ADT.  The Queue is built
 *	using a linked list of Node ADTs.  A Queue object
 *	consists of a "first" field which refers to a Node
 *	object.
 *	
 *	This file is complete.
*/


public interface QueueInterface
{
	//public Queue();
	//public Queue(Object o);
	public boolean isEmpty();
	public Object front() throws EmptyQueueException;
	public void remove() throws EmptyQueueException;
	public void add(Object o);
	public String toString();
}

