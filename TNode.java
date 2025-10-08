//KIT107 Assignment 3
/**
 *	Tree Node ADT
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Tree Node ADT which represents
 *	the nodes in a doubly-linked general tree.  Tree
 *	nodes consist of a "data" field, a level number
 *	("level"), and two references to other nodes
 *	(these being the child node ("child") and the
 *	eldest sibling node	("sibling").
 *	
 *	This file is complete.
*/


public class TNode implements TNodeInterface
{
	//finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// properties
	protected Object data;		// the value stored in the node
	protected int level;		// the level of the current node
	protected TNode child;		// the eldest child node of the current node
	protected TNode sibling;	// the next eldest node of the current node


	/**
	 *	TNode
	 *	Constructor method.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object holds the parameter value
	 *					(o) within its "data" field, the parameter
	 *					value (l) within its "level" field, and its
	 *					"child", and "sibling" fields are null
	 *	Informally: intialises the instance variables of the newly
	 *				created TNode object to hold the given parameters
	 *				and to terminate the "child" and "sibling" fields
	 *
	 *	@param o the Object to store in the data field of the node
	 *	@param l the level number of the created node
	*/
	public TNode(Object o, int l)
	{
      	trace("TNode: Constructor ends");

		data=o;
		level=l;
		child=null;
		sibling=null;

      	trace("TNode: Constructor ends");
	}


	/**
	 *	setData
	 *	Set method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's data field is altered to
	 *					hold the given (o) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "data" instance variable
	 *
	 *	@param o the Object to store in the data field of the node
	*/
	public void setData(Object o)
	{
      	trace("setData: setData starts");

		data=o;

      	trace("setData: setData ends");
	}
	
	
	/**
	 *	setLevel
	 *	Set method for "level" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's level field is altered to
	 *					hold the given (l) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "level" instance variable
	 *
	 *	@param l the level number of the node
	*/
	public void setLevel(int l)
	{
      	trace("setLevel: setLevel starts");

		level=l;

      	trace("setLevel: setLevel ends");
	}
	
	
	/**
	 *	setChild
	 *	Set method for "child" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's child field is altered
	 *					to hold the given (n) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "child" instance variable
	 *
	 *	@param n the node to set as the child of the current node
	*/
	public void setChild(TNode n)
	{
      	trace("setChild: setChild starts");

		child=n;

      	trace("setChild: setChild ends");
	}
	
	
	/**
	 *	setSibling
	 *	Set method for "sibling" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's sibling field is altered
	 *					to hold the given (n) value
	 *	Informally: assign the value of the parameter to the TNode
	 *				object's "sibling" instance variable
	 *
	 *	@param n the node to set as the sibling of the current node
	*/
	public void setSibling(TNode n)
	{
      	trace("setSibling: setSibling starts");

		sibling=n;

      	trace("setSibling: setSibling ends");
	}
	
	
	/**
	 *	getData
	 *	Get method for "data" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's data field is returned
	 *	Informally: examine the TNode object's "data" instance
	 *				variable returning its value
	 *
	 *	@return Object the item in the node
	*/
	public Object getData()
	{
      	trace("getData: getData starts and ends");

		return data;
	}
	
	
	/**
	 *	getLevel
	 *	Get method for "level" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's level field is
	 *				returned
	 *	Informally: examine the TNode object's "level" instance
	 *				variable returning its value
	 *
	 *	@return int the level number of the current node
	*/
	public int getLevel()
	{
      	trace("getLevel: getLevel starts and ends");

		return level;
	}
	
	
	/**
	 *	getChild
	 *	Get method for "child" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's child field is
	 *					returned
	 *	Informally: examine the TNode object's "child"
	 *				instance variable returning its value
	 *
	 *	@return TNode the child of the current node
	*/
	public TNode getChild()
	{
      	trace("getChild: getChild starts and ends");

		return child;
	}
	
	
	/**
	 *	getSibling
	 *	Get method for "sibling" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's sibling field is
	 *					returned
	 *	Informally: examine the TNode object's "sibling"
	 *				instance variable returning its value
	 *
	 *	@return TNode the sibling of the current node
	*/
	public TNode getSibling()
	{
      	trace("getSibling: getSibling starts and ends");

		return sibling;
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
			System.out.println("TNode: " + s);
		}
	}
}
