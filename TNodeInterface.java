//KIT107 Assignment 3
/**
 *	Tree Node ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version October 2025
 *	
 *	This file holds the Tree Node ADT which represents
 *	the nodes in a doubly-linked general tree.  Tree
 *	nodes consist of a "data" field and two references
 *	to other nodes (these being the child node ("child")
 *	and the eldest sibling node ("sibling").
 *	
 *	This file is complete.
*/


public interface TNodeInterface
{
	//public TNode(Object o, int l);
	public void setData(Object o);
	public Object getData();
	public void setLevel(int l);
	public int getLevel();
	public void setChild(TNode n);
	public TNode getChild();
	public void setSibling(TNode n);
	public TNode getSibling();
}
