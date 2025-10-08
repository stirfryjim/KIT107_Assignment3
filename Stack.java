//KIT107 Assignment 3
/**
 *	Stack ADT
 *
 *	@author <<Your names and Student IDs>>
 *	@version October 2025
 *	
 *	This file holds the Stack ADT.  The Stack is built
 *	using a linked list of Node ADTs.  A Stack object
 *	consists of a "tos" field which refers to a Node
 *	object.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


public class Stack implements StackInterface
{
	//finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// properties
	protected Node tos;		// the node on the top of the stack


	/**
	 *	Stack
	 *	Constructor method 1.
	 *	Pre-condition: none
	 *	Post-condition: the Stack object's "tos" field is null
	 *	Informally: intialises the instance variable of the newly
	 *				created Stack object by terminating the "tos"
	 *				field
	*/
	public Stack()
	{
      	trace("Stack: Constructor ends");

		tos=null;

      	trace("Stack: Constructor ends");
	}


	/**
	 *	Stack
	 *	Constructor method 2.
	 *	Pre-condition: none
	 *	Post-condition: the Stack object holds a reference to a Node
	 *					object within its "tos" field which holds
	 *					the parameter value (o)
	 *	Informally: intialises the instance variable ("tos") of the
	 *				newly created Stack object to hold a reference to
	 *				a new Node object containing the given parameter
	 *
	 *	@param o the Object to store within the Stack
	*/
	public Stack(Object o)
	{
      	trace("Stack: Constructor ends");

		tos=new Node(o);

      	trace("Stack: Constructor ends");
	}
	
	
	/**
	 *	isEmpty
	 *	Check whether the stack is empty or not.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the Stack object has no
	 *					items, false is returned if it does
	 *	Informally: examine the Stack object's tos instance variable
	 *					returning whether or not it is null
	 *
	 *	@return boolean whether or not the Stack is empty
	*/
	public boolean isEmpty()
	{
      	trace("isEmpty: isEmpty starts and ends");

//COMPLETE ME

		return false;	// CHANGE ME
	}


	/**
	 *	top
	 *	Examine the top item on the stack.
	 *	Pre-condition: the stack is non-empty
	 *	Post-condition: a reference to the item on the top of the
	 *					stack is returned
	 *	Informally: return a reference to the top of the Stack or
	 *				throw an exception if the Stack is empty
	 *
	 *	@return Object the item at the top of the Stack
	*/
	public Object top() throws EmptyStackException
	{
      	trace("top: top starts");

		if (isEmpty())
		{
	      	trace("top: empty stack");
			throw new EmptyStackException();
		}
		else
		{
//COMPLETE ME

			trace("top: top ends");
			return null;	// CHANGE ME
		}
	}


	/**
	 *	pop
	 *	Delete the top item from the stack.
	 *	Pre-condition: the stack is non-empty
	 *	Post-condition: the "tos" instance variable is re-assigned to
	 *					refer to the value of the second Node object
	 *					in the linked list
	 *	Informally: bypass the node on the top of the Stack so that
	 *				the second node on the Stack becomes the top.  If
	 *				the Stack is empty, throw an exception
	*/
	public void pop() throws EmptyStackException
	{
      	trace("pop: pop starts");

		if (isEmpty())
		{
 	     	trace("pop: empty stack");
			throw new EmptyStackException();
		}
		else
		{
	      	trace("pop: adjusting top of stack");
//COMPLETE ME
		}
		
      	trace("pop: pop ends");
	}


	/**
	 *	push
	 *	Add an item onto the stack.
	 *	Pre-condition: none
	 *	Post-condition: the Stack object's instance variable "tos" is
	 *					made to refer to a new Node object containing
	 *					the parameter (o) and the Node's "next" field
	 *					is assigned the original value of the "tos"
	 *					instance variable
	 *	Informally: create a new Node and insert it	before the others
	 *				on the stack making it the new top of stack
	 *
	 *	@param o the Object to add to the top of the Stack
	*/
	public void push(Object o)
	{
		Node n;
		
      	trace("push: push starts");
      	
//COMPLETE ME

      	trace("push: push ends");
	}
	
	
	/**
	 *	toString
	 *	Convert the contents of the stack to a printable representation.
	 *	Pre-condition: none
	 *	Post-condition: a String object is returned consisting of the
	 *				String representation of all items on the Stack,
	 *				from top to bottom in order, separated by " " and
	 *				contained within "<" and ">"
	 *	Informally: produce a String representation of the Stack
	 *
	 *	@return String the printable representation of the contents of
	 *				the Stack
	*/
	public String toString()
	{
		Node c;
		String s="";
		
      	trace("toString: toString starts");

		if (isEmpty())
		{
  	    	trace("toString: toString ends empty");
			s="<>";
		}
		else
		{
			c=tos;
			while (c != null)
			{
				s+=(c.getData().toString() + " ");
				c=c.getNext();
			}
	      	trace("toString: toString ends");
		}
		return s;
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
			System.out.println("Stack: " + s);
		}
	}
}
