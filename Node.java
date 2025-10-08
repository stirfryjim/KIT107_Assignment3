//KIT107 Assignment 3
/**
 *	Linked List Node ADT
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Linked List Node ADT which
 *	represents the nodes in a linked-list.  Linked-list
 *	nodes consist of a "data" field and a reference to
 *	the next node in the linked-list, "next".
 *	
 *	This file is complete.
*/


public class Node implements NodeInterface
{
	//finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// properties
	protected Object data;		// the item value stored in the node
	protected Node next;		// a reference to the next node
  
  
	/**
	 *	Node
	 *	Constructor method.
	 *	Pre-condition: none
	 *	Post-condition: the Node object holds the parameter value
	 *					(o) within its "data" field and its "next"
	 *					field is null
	 *	Informally: intialises the instance variables of the newly
	 *				created Node object to hold the given parameter
	 *				and to terminate the "next" field
	 *
	 *	@param o Object to store in the node
	*/
	public Node(Object o)
	{
      	trace("Node: Constructor starts");

		data=o;
		next=null;

      	trace("Node: Constructor ends");
	}
	
	
	/**
	 *	setData
	 *	Set method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Node object's data field is altered to
	 *					hold the given (o) value
	 *	Informally: assign the value of the parameter to the Node
	 *				object's "data" instance variable
	 *
	 *	@param o Object to store in the node
	*/
	public void setData(Object o)
	{
      	trace("setData: setData starts");

		data=o;

      	trace("setData: setData ends");
	}
	
	
	/**
	 *	setNext
	 *	Set method for "next" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Node object's next field is altered to
	 *					hold the given (n) value
	 *	Informally: assign the value of the parameter to the Node
	 *				object's "next" instance variable
	 *
	 *	@param n Node to store in the next field
	*/
	public void setNext(Node n)
	{
      	trace("setNext: setNext starts");

		next=n;
		
      	trace("setNext: setNext ends");
	}
	
	
	/*
	 *	getData
	 *	Get method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Node object's data field is returned
	 *	Informally: examine the Node object's "data" instance
	 *				variable returning its value
	 *
	 *	@return Object the contents of the current Node's data field
	*/
	public Object getData()
	{
      	trace("getData: getData starts and ends");

		return data;
	}
	
	
	/**
	 *	getNext
	 *	Get method for "next" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Node object's next field is returned
	 *	Informally: examine the Node object's "next" instance
	 *				variable returning its value
	 *
	 *	@return Node the contents of the current Node's next field
	*/
	public Node getNext()
	{
      	trace("getNext: getNext starts and ends");

		return next;
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s String to print as trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("Node: " + s);
		}
	}
}


