//KIT107 Assignment 3
/**
 *	GameTree ADT
 *
 *	@author <<Your names and Student IDs>>
 *	@version October 2025
 *	
 *	This file holds the GameTree ADT which is a
 *	general game tree.  The GameTree is built using
 *	TNode ADTs.  A GameTree object consists of a
 *	"root" field which refers to a TNode object
 *	which has a "data" field and "child" and
 *	"sibling" references, and a "level" value.
 *	
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/


public class GameTree implements GameTreeInterface
{
	// finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// non-finals
	protected TNode root;								// the node at the top of the tree


	/**
	 *	GameTree
	 *	Constructor method 1.
	 *	Pre-condition: none
	 *	Post-condition: the GameTree object's "root" field is null
	 *	Informally: creates an empty tree
	*/
	public GameTree()
	{
		trace("GameTree: constructor starts");
		
		this.root = null;
		
		trace("GameTree: constructor ends");
	}


	/**
	 *	GameTree
	 *	Constructor method 2.
	 *	Pre-condition: none
	 *	Post-condition: the GameTree object's "root" field refers
	 *					to a new TNode object containing the
	 *					parameter value (o) of level with
	 *					parameter value (l) with a null child,
	 *					and a null sibling
	 *	Informally: create a tree of a single node (i.e. a leaf)
	 *				with the node and level value provided on the
	 *				parameter list
	 *
	 *	@param o Object to include in GameTree node
	 *	@param l level number for GameTree
	*/
	public GameTree(Object o, int l)
	{
		trace("GameTree: constructor starts");
		
		root=new TNode(o,l);
		
		trace("GameTree: constructor ends");
	}
	
	
	/**
	 *	isEmpty
	 *	Emptiness test.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the GameTree object is
	 *					empty, false is returned otherwise
	 *	Informally: indicate if the GameTree contains no nodes
	 *
	 *	@return boolean whether or not the game tree is empty
	*/
	public boolean isEmpty()
	{
		trace("isEmpty: isEmpty starts and ends");
		
		return (root == null);
	}


	/**
	 *	getData
	 *	Get method for "root" instance variable's data value.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's data
	 *					field is returned
	 *	Informally: return the value within the root node,
	 *				throw an exception if the tree is empty
	 *
	 *	@return Object the data item of the root node
	*/
	public Object getData() throws EmptyGameTreeException
	{
		trace("getData: getData starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("getData: empty game tree");
			throw new EmptyGameTreeException();
		}

		// non-empty tree
		trace("getData: getData ends");
		
		return root.getData();	
	}
	
	
	/**
	 *	getLevel
	 *	Get method for "root" instance variable's level value.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's data
	 *					field's level is returned
	 *	Informally: return the level value within the root node,
	 *				throw an exception if the tree is empty
	 *
	 *	@return int the level number of the root node
	*/
	public int getLevel() throws EmptyGameTreeException
	{
		trace("getLevel: getLevel starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("getLevel: empty game tree");
			throw new EmptyGameTreeException();
		}	
		
		// non-empty tree
		trace("getLevel: getLevel ends");

		return root.getLevel();	
	}	
	

	/**
	 *	getChild
	 *	Get method for "root" instance variable's child value.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's child
	 *					field is returned in a newly
	 *					constructed GameTree object
	 *	Informally: return the GameTree object's child, throw
	 *					an exception if the tree is empty
	 *
	 *	@return GameTree the eldest child of the current node
	*/
	public GameTree getChild() throws EmptyGameTreeException
	{
		GameTree r;
		
		trace("getChild: getChild starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("getChild: empty game tree");
			throw new EmptyGameTreeException();
		}
  
		// non-empty tree, need to create a game tree to hold the answer
		r=new GameTree();
		r.root=root.getChild();

		trace("getChild: getChild ends");
		return r;
	}


	/**
	 * 	getSibling
	 *	Get method for "root" instance variable's sibling value.
	 *	Pre-condition: none
	 *	Post-condition: the value of the GameTree object's sibling
	 *					field is returned in a newly
	 *					constructed GameTree object
	 *	Informally: return the GameTree object's sibling, throw
	 *					an exception if the tree is empty
	 *
	 *	@return GameTree the next sibling of the current node
	*/
	public GameTree getSibling() throws EmptyGameTreeException
	{
		GameTree r;
		
		trace("getSibling: getSibling starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("getSibling: empty game tree");
			throw new EmptyGameTreeException();
  		}
  		
		// non-empty tree, need to create a game tree to hold the answer
		r = new GameTree();
		r.root = root.getSibling();

		trace("getSibling: getSibling ends");
		return r;
	}


	/**
	 *	setData
	 *	Set method for "root" instance variable's data field.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's data field is altered to
	 *					hold the given (o) value
	 *	Informally: store the given value in the root node of the
	 *				GameTree object, throw an exception if the tree is
	 *				empty
	 *
	 *	@param o Object to install as data for root node
	*/
	public void setData(Object o) throws EmptyGameTreeException
	{
		trace("setData: setData starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("setData: empty game tree");
			throw new EmptyGameTreeException();
		}
		
		root.setData(o);
		
		trace("setData: setData ends");
	}
	
	
	/**
	 *	setLevel
	 *	Set method for "root" instance variable's level field.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's level field is altered
	 *					to hold the given (l) value
	 *	Informally: assign the given value as the level of the
	 *				GameTree object, throw an exception if the tree is
	 *				empty
	 *
	 *	@param l level number for root of current game tree
	*/
	public void setLevel(int l) throws EmptyGameTreeException
	{
		trace("setLevel: setLevel starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("setLevel: empty game tree");
			throw new EmptyGameTreeException();
  		}
  		
		// non-empty tree, need to update the instance variable
		root.setLevel(l);
		
		trace("setLevel: setLevel ends");
	}
	
	
	/**
	 *	setChild
	 *	Set method for "root" instance variable's child field.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's child field is altered
	 *					to hold the given (t) value
	 *	Informally: assign the given value as the child of the
	 *				GameTree object, throw an exception if the tree is
	 *				empty
	 *
	 *	@param t GameTree to be set as eldest child of current game tree
	*/
	public void setChild(GameTree t) throws EmptyGameTreeException
	{
		trace("setChild: setChild starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("setChild: empty game tree");
			throw new EmptyGameTreeException();
  		}
  		
		// non-empty tree, need to update the instance variable
		root.setChild(t.root);
		
		trace("setChild: setChild ends");
	}
	
	
	/**
	 *	setSibling
	 *	Set method for "root" instance variable's sibling field.
	 *	Pre-condition: none
	 *	Post-condition: the TNode object's sibling field is altered
	 *					to hold the given (t) value
	 *	Informally: assign the given value as the sibling of the
	 *				GameTree object, throw an exception if the tree is
	 *				empty
	 *
	 *	@param t GameTree to be set as next sibling of current game tree
	*/
	public void setSibling(GameTree t) throws EmptyGameTreeException
	{
		GameTree sibling;
		
		trace("setSibling: setSibling starts");
		
		if (isEmpty())
		{
			// empty tree, can't continue
			trace("setSibling: empty game tree");
			throw new EmptyGameTreeException();
		}
		  
		sibling = t;

		// non-empty tree, need to update the instance variable
		root.setSibling(sibling.root);

		trace("setSibling: setSibling ends");
	}
	
	
	/**
	 *	generateLevelDF
	 *	Generate the next level of the tree
	 *	Pre-condition: the given tree is defined, the given stack
	 *				   is defined, and the given player represents
	 *				   the current player
	 *	Post-condition: an additional level of possible moves has
	 *					been added to the given game tree and each
	 *					tree node of the new level also has been
	 *					pushed onto the stack.  Each move is for
	 *					the given player if the level number of the
	 *					level is even, and for its opponent
	 *					otherwise.  Each grid in the new level has
	 *					a value calculated from the opponent's
	 *					perspective
	 *	Informally: generate the next level of the game tree
	 *
	 *	@param s Stack of reachable but unexpanded game trees
	 *	@param curr current Player
	*/
	public void generateLevelDF(Stack s,Player curr)
	{
		Grid currentGrid, hollowGrid;
		int currentLevel, gridLevel;
		int gridDimension;
		Player currentPlayer;
		Location loc;

		assert ((s!=null) && (curr!=null));

		trace("generateLevelDF: generateLevelDF starts");
		
		currentGrid = (Grid) getData();
		currentLevel = getLevel();
		gridDimension = currentGrid.getDimension();
		
		gridLevel = (currentLevel + 1);
		if (gridLevel % 2 == 0) 
		{
			currentPlayer = curr; 
		}
		else
		{
			currentPlayer = curr.opponent();
		}
		
		if (!currentGrid.gameOver()) 
		{
			int row, col;
			boolean moveMade;
			for (col = gridDimension; col > 0; col--)
			{
				moveMade = false;
				row = gridDimension;
				while (!moveMade && row >= 1)
				// since Grid is initialised with Row 4 as the lowest
				{
					loc = new Location(row, col);

					if ((!currentGrid.squareOccupied(loc))) 
					{
						hollowGrid = (Grid) currentGrid.clone();

						moveMade = true;
						hollowGrid.occupySquare(loc, currentPlayer.getSymbol()); 
						hollowGrid.setWorth(hollowGrid.evaluateGrid(currentPlayer));

						GameTree alternative = new GameTree(hollowGrid, gridLevel); 

						GameTree firstChild = this.getChild();
						if (this.getChild().isEmpty()) 
						{
							this.setChild(alternative);
						}
						else
						{
							GameTree last = firstChild;
							while (!last.getSibling().isEmpty())
							{
								last = last.getSibling();
							}
							last.setSibling(alternative);
						}
						
						s.push(alternative);
					}
					else
					{
						row--;
						loc = new Location(row, col);
					}
				}

			}
		}

		trace("generateLevelDF: generateLevelDF ends");
	}
	
	
	/**
	 *	buildGameDF
	 *	Generate the game tree in a depth-first manner
	 *	Pre-condition: the current tree isn't empty, the given stack
	 *				   is defined, the given player represents the
	 *				   current player, and the given int value
	 *				   represents the desired depth of the tree
	 *	Post-condition: If the given tree is not already deep enough, 
	 *				    if there are children, then these are traversed
	 *					and all siblings are pushed onto the stack.  If
	 *					(when) there are no children an additional
	 *					level of possible moves is added to the given
	 *					game tree and each tree node of the new level
	 *					also is pushed onto the stack.  Finally, the
	 *					next tree is determined by removing the top of
	 *					the stack and the process continues until the
	 *					stack is empty
	 *	Informally: generate the game tree from the current point
	 *				in a depth-first manner until it is "d" levels
	 *				deep
	 *
	 *	@param s Stack of reachable but unexpanded game trees
	 *	@param curr current Player
	 *	@param d desired depth (number of moves ahead) that game tree should be built to
	*/
	public void buildGameDF(Stack s, Player curr, int d)
	{
		Grid gameGrid;
		GameTree t;
		
		assert ((!isEmpty()) && (s!=null) && (curr!=null) && (d>0));
			
		trace("buildGameDF: buildGameDF starts");

		gameGrid = (Grid) root.getData();

		if ((getLevel() >= d) || gameGrid.gameOver())
		{	
			return;
		} 

		generateLevelDF(s, curr);
		
		if (!s.isEmpty())
		{
			t = (GameTree) s.top();	
			s.pop();	
			t.buildGameDF(s, curr, d);	
		} 
		
		trace("buildGameDF: buildGameDF ends");
	}
	
	
	/**
	 *	generateLevelBF
	 *	Generate the next level of the tree
	 *	Pre-condition: the given tree is defined, the given queue
	 *				   is defined, and the given player represents
	 *				   the current player
	 *	Post-condition: an additional level of possible moves has
	 *					been added to the given game tree and each
	 *					tree node of the new level also has been
	 *					appended to the queue.  Each move is for
	 *					the given player if the level number of the
	 *					level is even, and for its opponent
	 *					otherwise.  Each grid in the new level has
	 *					a value calculated from the opponent's
	 *					perspective
	 *	Informally: generate the next level of the game tree
	 *
	 *	@param q Queue of reachable but unexpanded game trees
	 *	@param curr current Player
	*/
	public void generateLevelBF(Queue q,Player curr)
	{
	
		assert ((q!=null) && (curr!=null));

		trace("generateLevelBF: generateLevelBF starts");
		
//COMPLETE ME
		
		trace("generateLevelBF: generateLevelBF ends");
	}
	
	
	/**
	 *	buildGameBF
	 *	Generate the game tree in a breadth-first manner
	 *	Pre-condition: the current tree isn't empty, the given queue
	 *				   is defined, the given player represents the
	 *				   current player, and the given int value
	 *				   represents the desired depth of the tree
	 *	Post-condition: If the given tree is not already deep enough, 
	 *				    if there are children, then these are traversed
	 *					and all siblings are added to the queue.  If
	 *					(when) there are no children an additional
	 *					level of possible moves is added to the given
	 *					game tree and each tree node of the new level
	 *					also is added to the queue.  Finally, the next
	 *					tree is determined by removing the front of
	 *					the queue and the process continues until the
	 *					queue is empty
	 *	Informally: generate the game tree from the current point
	 *				in a breadth-first manner until it is "d" levels
	 *				deep
	 *
	 *	@param q Queue of reachable but unexpanded game trees
	 *	@param curr current Player
	 *	@param d desired depth (number of moves ahead) that game tree should be built to
	*/
	public void buildGameBF(Queue q, Player curr, int d)
	{
		GameTree t;
		
		assert ((!isEmpty()) && (q!=null) && (curr!=null) && (d>0));
			
		trace("buildGameBF: buildGameBF starts");
		
//COMPLETE ME
		
		trace("buildGameBF: buildGameBF ends");
	}				


	/**
	 *	adjustLevel
	 *	Adjust the level numbers of the tree
	 *	Pre-condition: none
	 *	Post-condition: all level numbers in the tree are reduced
	 *					by one
	 *	Informally: decrement the level number of all nodes in
	 *				the game tree
	*/
	protected void adjustLevel()
	{
		trace("adjustLevel: adjustLevel starts");
		
		// traverse the entire tree, reducing the level value of every node by 1
  		if (! isEmpty()) {
    		getChild().adjustLevel();
    		getSibling().adjustLevel();
    		trace("adjustLevel: setting level to " + (getLevel()-1));
    		setLevel(getLevel()-1);
  		}
  		
		trace("adjustLevel: adjustLevel ends");
	}


	/**
	 *	chooseBest
	 *	Find the value of the best move in the tree
	 *	Pre-condition: none
	 *	Post-condition: the value of the best move that can be made
	 *					is returned
	 *	Informally: examine the next alternate moves and return the
	 *				value of the best one
	 *
	 *	@return int indicates worth of best move
	*/
	protected int chooseBest()
	{
  		int i;		// worth of 'current' grid
  		int v;		// best value found so far
  		GameTree t;	// traversal variable
  
		trace("chooseBest: chooseBest starts");
		trace("chooseBest: next move should have worth of " + ((Grid)getData()).getWorth());
		
  		v=((Grid)getData()).getWorth();
  		trace("chooseBest: starting with a worth of " + v);
  		
		// search all siblings for the best value and determine how many equal-valued alternatives there are
  		t=this;
  		while (! t.getSibling().isEmpty())
  		{
    		t=t.getSibling();
    		i=((Grid)t.getData()).getWorth();
    		trace("chooseBest: considering a worth of " + i);
    		
   			if (t.getLevel() % 2 != 0)
   			{ 
       			if (i > v)
       			{
	    			trace("chooseBest: found a better worth of " + i);
          			v=i;
          		}
      		}
      		else
      		{
        		if (i < v)
        		{
	    			trace("chooseBest: found a better worth of " + i);
          			v=i;
          		}
      		}
  		}
  		
		trace("chooseBest: chooseBest ends with " + v);
  		return v;
	}


	/**
	 *	traverse
	 *	Walk over the tree determining the best outcome so far
	 *	Pre-condition: none
	 *	Post-condition: the grids of all nodes in the tree have
	 *					up-to-date values
	 *	Informally: filter the best move values from the leaf
	 *				nodes up to the root
	*/
	public void traverse()
	{
  		int v;		// best value of the options
  		GameTree t;	// traversal variable
  		Grid b;		// board of root node

		trace("traverse: traverse starts");
		
		// search the entire game tree for the value of the best move and percolate that up
  		if (! isEmpty())
  		{
    		if (! getChild().isEmpty())
    		{
      			t=getChild();
      			while (! t.isEmpty())
      			{
        			t.traverse();
        			t=t.getSibling();
      			}
      			trace("traverse: siblings traversed");
      			v=getChild().chooseBest();
      			b=(Grid)getData();
      			b.setWorth(v);
      			setData(b);
      			trace("traverse: worth of " + v + " set");
    		}
  		}
  		
		trace("traverse: traverse ends");
	}


	/**
	 *	findBest
	 *	Find the best move in the tree for the computer
	 *	Pre-condition: moves exist in the child level of the
	 *				   current tree with a worth of the given
	 *				   value (v)
	 *	Post-condition: the tree is adjusted so that the current
	 *					state is overriden by the game tree with
	 *					the best next move as its root (the
	 *					first encountered) and all level numbers
	 *					are decremented accordingly
	 *	Informally: computer has a turn!
	 *
	 *	@param v worth of best move
	*/
	public void findBest(int v)
	{
  		GameTree t;		// tree for traversal
  		boolean found;	// whether we have found the move yet
  
  		assert (! isEmpty());
  		
		trace("findBest: findBest starts");

		// go to the next level and find the move we've chosen
  		t=getChild();
  		found=false;
    	while (!found)
    	{
      		trace("findBest: Move is: " + ((Grid)t.getData()).toString());
    		if (((Grid)t.getData()).getWorth() == v)
      		{
     			trace("findBest: stopping search");
      			found=true;
      		}
      		else
      		{
	      		trace("findBest: not this move, trying sibling");
 	      		t=t.getSibling();
     		}
  		}
  		
		// this should now be the root of game tree, so delete the redundant parent and prune all siblings
  		trace("findBest: found it; cutting off remaining siblings and adjusting");
        t.setSibling(new GameTree());
    	t.adjustLevel();
    	
    	root=t.root;
    	
		trace("findBest: findBest ends");
	}


	/**
	 *	findMove
	 *	Find the nominated move in the tree (located at the top and as one child)
	 *	Pre-condition: none
	 *	Post-condition: the tree is adjusted so that the current
	 *					state is overriden by the game tree with
	 *					the grid as specified in the parameter as
	 *					its root and all level numbers are
	 *					decremented accordingly
	 *	Informally: find the move the human just made!
	*/
	public void findMove()
	{
	  	GameTree t;

		trace("findMove: findMove starts");
		
		// go down to the child level and find the move in the game tree that matches the user's move
	  	t=getChild();
	  	if (! t.isEmpty())
	  	{
	    	while ((! t.isEmpty()) && (! ((Grid) t.getData()).equals((Grid) getData())))
	      	{
	      		trace("findMove: not this move, trying sibling");
	      		t=t.getSibling();
      		}
      		
	    	if (t.isEmpty())
	    	{
				// hmmm something went wrong, that just shouldn't happen
	    		trace("findMove: not there, creating empty tree as sentinel");
				t=new GameTree();
	    	}
	    	else
	    	{
				// this should now be the root of game tree, so delete the redundant parent and prune all siblings
				trace("findMove: found it, cutting off remaining siblings and adjusting");
	      		t.setSibling(new GameTree());
	      		t.adjustLevel();
	    	}
	  	}
	  	
		root=t.root;
		trace("findMove: findMove ends");
	}
	

	/**
	 *	rootNodeToString
	 *	String conversion for root node value
	 *	Pre-condition: none
	 *	Post-condition: a String object is returned consisting of the
	 *				String representation of the value within the
	 *				root node, followed by " " or "<>" if the GameTree
	 *				object is the empty tree
	 *	Informally: produce a String representation of the tree's root
	 *				node
	 *
	 *	@return String printable equivalent of root node contents
	*/
	protected String rootNodeToString()
	{
		String s="";

		trace("rootNodeToString: rootNodeToString starts");
		
		if (isEmpty())
		{
			s="<>";
		}
		else
		{
			s+=(getData().toString() + " ");
		}

		trace("rootNodeToString: rootNodeToString ends");
		return s;
	}
	
	
	/**
	 *	toString
	 *	String conversion for tree
	 *	Pre-condition: none
	 *	Post-condition: a String object is returned consisting of the
	 *				String representation of all items in the GameTree,
	 *				from top to bottom in depth-first order, separated by
	 *				" " and contained within "<" and ">"
	 *	Informally: produce a String representation of the Stack
	 *
	 *	@return String printable contents of game tree
	*/
	public String toString()
	{
		GameTree c;
		String s="";

		trace("toString: toString starts");
		
		if (isEmpty())
		{
			// nothing to see here
			trace("toString: toString ends");
			s="<>";
		}
		else
		{
			// traverse, node value first
			s+=rootNodeToString();
			// and then the children in depth-first order
			c=getChild();
			if (! c.isEmpty())
			{
				s+=c.toString();
			}
			c=getSibling();
			if (! c.isEmpty())
			{
				s+=c.toString();
			}
		}

		trace("toString: toString ends");
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
	 *	@param s String to display as tracing message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("GameTree: " + s);
		}
	}
}
