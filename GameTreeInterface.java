//KIT107 Assignment 3
/**
 *	GameTree ADT Interface
 *
 *	@author Julian Dermoudy
 *	@version September 2025
 *	
 *	This file holds the GameTree ADT which is a
 *	general game tree.  The GameTree is built using
 *	TNode ADTs.  A GameTree object consists of a
 *	"root" field which refers to a TNode object
 *	which has a "data" field and "child" and
 *	"sibling" references, and a	"level" value.
 *	
 *	This file is complete.
*/


public interface GameTreeInterface
{
	//public GameTree();
	//public GameTree(Object o, int l);
	public boolean isEmpty();
	public void setData(Object o) throws EmptyGameTreeException;
	public Object getData() throws EmptyGameTreeException;
	public void setLevel(int l) throws EmptyGameTreeException;
	public int getLevel() throws EmptyGameTreeException;
	public void setChild(GameTree c) throws EmptyGameTreeException;
	public GameTree getChild() throws EmptyGameTreeException;
	public void setSibling(GameTree s) throws EmptyGameTreeException;
	public GameTree getSibling() throws EmptyGameTreeException;
	public void generateLevelDF(Stack s,Player p);
	public void generateLevelBF(Queue q,Player p);
	public void buildGameDF(Stack s,Player p,int l);
	public void buildGameBF(Queue q,Player p,int l);
	public void findBest(int w);
	public void findMove();
	public String toString();
}
