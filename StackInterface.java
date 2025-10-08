//KIT107 Assignment 3
/**
 *	Stack ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Stack ADT.  The Stack is built
 *	using a linked list of Node ADTs.  A Stack object
 *	consists of a "tos" field which refers to a Node
 *	object.
 *	
 *	This file is complete.
*/


public interface StackInterface
{
	//public Stack();
	//public Stack(Object o);
	public boolean isEmpty();
	public Object top() throws EmptyStackException;
	public void pop() throws EmptyStackException;
	public void push(Object o);
	public String toString();
}
