//KIT107 Assignment 3
/**
 *	Linked List Node ADT Interface
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


public interface NodeInterface
{
	//public Node(Object o);
	public void setData(Object o);
	public Object getData();
	public void setNext(Node n);
	public Node getNext();
}


