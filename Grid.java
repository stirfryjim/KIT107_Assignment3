//KIT107 Assignment 3
/**
 *	Grid ADT
 *
 *	@author Chris Luchavez (745963), Mel Goulding(745749)
 *	@version October 2025
 *	
 *	This file holds the Grid ADT which represents
 *	the Connect-4 board.  The Grid consists of a location
 *	(of	the current position of the solver), a dimension,
 *	a value (of the current board), and a two-dimensional
 *	array (table/matrix) of the squares in the board.
 *  
 *  Work Split: 50:50
 * 
 *	YOU NEED TO MAKE CHANGES TO THIS FILE!
*/

import java.awt.*;


public class Grid implements GridInterface, Cloneable, Comparable
{
	// finals
	protected final boolean TRACING=false;	// do we want to see trace output?

	// properties
	protected int dimension;			// size of the grid
	protected Square board[][];			// all the Squares within the grid
	protected int value;				// 'worth' of grid

	
	/**
	 *	Grid
	 *	Constructor method 1.
	 *	Pre-condition: none
	 *	Post-condition: a 4x4 grid is created in which all
	 *					squares are empty
	 *	Informally: create an empty 4x4 grid
	*/
	public Grid()
	{
      	trace("Grid: Constructor starts");

		dimension=4;		
		initialiseGrid();

      	trace("Grid: Constructor ends");
	}
	
	/**
	 *	Grid
	 *	Constructor method 2.
	 *	Pre-condition: none
	 *	Post-condition: a grid of given dimension where all
	 *					squares are empty is created
	 *	Informally: create an unoccupied grid of given dimension
	 *
	 *	@param d number of rows and columns in grid
	*/
	public Grid(int d)
	{
      	trace("Grid: Constructor starts");
      	
		//sets dimensions and initializes grid
		dimension=d;
		initialiseGrid();
		
      	trace("Grid: Constructor ends");		
	}
	
	/*
	 *	Grid
	 *	Constructor method 3.
	 *	Pre-condition: the given Dimension, Location, and Symbol
	 *					values are defined and valid
	 *	Post-condition: a Grid of given Dimension is created
	 *					where all squares have no symbol but the
	 *					square at the given location is occupied
	 *					by the given symbol
	 *	Informally: create a grid of given dimension where all
	 *					squares are empty except the one at the
	 *					given location which is occupied by the
	 *					given symbol
	 *
	 *	@param d number of rows and columns in grid
	 *	@param l Location for first move
	 *	@param s Symbol for first move
	*/
	public Grid(int d, Location l, Symbol s) throws IllegalGridException
	{
		assert ((d>0) && (l!=null) && (s!=null));
		
      	trace("Grid: Constructor starts");

		// create an empty grid of required size
		dimension=d;
		initialiseGrid();

		// add the move to the empty grid (unless it is illegal)
		if (validMove(l))
		{
			trace("Grid: occupying initial square");
			occupySquare(l,s);
		}
		else
		{
			trace("Grid: initial square not on grid");
			throw new IllegalGridException();
		}

      	trace("Grid: Constructor ends");
	}
	
	/**
	 *	initialiseGrid
	 *	Set up the grid.
	 *	Pre-condition: none
	 *	Post-condition: the two-dimensional array of Squares is
	 *					instantiated and filled with newly
	 *					created empty squares each with the
	 *					correct location
	 *	Informally: create an empty grid of known dimension
	*/
	protected void initialiseGrid()
	{
		int r,c; // rows and columns of the grid
		Location l; // location of rows and columns
		
      	trace("initialiseGrid: initialiseGrid starts");
      	
		// instantiate the table (array of arrays)
		board = new Square[dimension][dimension];

		// initialise every square on the board
		for (r=1; r<=dimension; r++)
		{
			for (c=1; c<=dimension; c++)
			{
				l=new Location(r,c);
				board[r-1][c-1]=new Square(l);
			}
		}

		// initialise the starting value
		value=0;
		
      	trace("initialiseGrid: initialiseGrid ends");		
	}
	
	/**
	 *	clone
	 *	Copy the grid.
	 *	Pre-condition: the current Grid object is validly defined
	 *	Post-condition: the Grid object is copied
	 *	Informally: copy the current Grid
	 *
	 *	@return Object the new created copy of the grid
	*/
	public Object clone()
	{
		Grid b; // new grid with same dimensions
		int r, c; // rows and columns of the grid
		Location loc; // location object of the rows and columns
		Symbol s; // the symbol used at that object
		
      	trace("clone: clone starts");

		b = new Grid(dimension);
		
		for (r = 1; r <= dimension; r++)
		{
			for (c = 1; c <= dimension; c++)
			{
				loc = new Location(r, c);
				s = getSquare(loc).getSymbol();
				if (!s.isEmpty())
				{
					b.occupySquare(loc, s);
				}
			}
		}
		// copies worth to the cloned grid
		b.setWorth(this.getWorth());

      	trace("clone: clone ends");
		return b;
	}
	
	/**
	 *	setSquare
	 *	Set method for an element of the "board" instance variable.
	 *	Pre-condition: the given location and square are defined
	 *	Post-condition: the given square is assigned to an element
	 *					of the Grid object selected according to
	 *					the given location within the grid
	 *	Informally: insert the given square into the grid at the
	 *				appropriate location
	 *
	 *	@param l Location for the square
	 *	@param s Square to be stored within grid
	*/	
	public void setSquare(Location l, Square s) throws IllegalGridException
	{
		int r, c; // rows and columns
		
		assert ((l!=null) && (s!=null));
		
      	trace("setSquare: setSquare starts");
      	
		if (!validMove(l))
		{
			trace("setSquare: location not on the grid");
			throw new IllegalGridException();
		}
		
		// update the grid at the indicated location with the given square
		s.setLocation(l);

		// place the square in the board
		r = l.getRow();
		c = l.getColumn();
		board[r-1][c-1] = s;

      	trace("setSquare: setSquare ends");
	}


	/**
	 *	getSquare
	 *	Get method for an element of the "board" instance variable.
	 *	Pre-condition: the given location is defined
	 *	Post-condition: the Square object at the appropriate
	 *					element of the "board" selected according
	 *					to the given Location value is returned
	 *	Informally: return the square of the grid at the given
	 *				location, an exception is thrown if the
	 *				location is not within the grid
	 *
	 *	@param l Location of desired square
	 *	@return Square the desired Square
	*/
	public Square getSquare(Location l) throws IllegalGridException
	{
		int r, c;

		assert (l!=null);

      	trace("getSquare: getSquare starts");
		
		if (!validMove(l))
		{
			trace("getSquare: location not on grid");
			throw new IllegalGridException();
		}
		
		// obtain the square at the indicated location from the grid
      	trace("getSquare: getSquare ends");
		
		r = l.getRow();
		c = l.getColumn();

		return board[r-1][c-1];
	}
		
	/**
	 *	setDimension
	 *	Set method for the "dimension" instance variable.
	 *	Pre-condition: the given Dimension value is defined and
	 *				   valid
	 *	Post-condition: the instance variable "dimension" is
	 *					assigned the given Dimension value
	 *	Informally: assign the given dimension to the Grid object
	 *
	 *	@param d the number of rows and columns in the grid
	*/
	public void setDimension(int d)
	{
		assert (d>0);
		
      	trace("setDimension: setDimension starts");
      	
		// upgdates dimension and initialize grid again
		dimension = d;
		initialiseGrid();
		
      	trace("setDimension: setDimension ends");
	}


	/**
	 *	getDimension
	 *	Get method for "dimension" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Grid object's dimension
	 *					field is returned
	 *	Informally: return the current grid's dimension
	 *
	 *	@return int the number of rows and columns in the grid
	*/
	public int getDimension()
	{
      	trace("getDimension: getDimension starts and ends");

		// returns grid dimension
		return dimension;
	}


	/**
	 *	setWorth
	 *	Set method for the "value" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the instance variable "value" is assigned
	 *					the given value
	 *	Informally: set the worth of the Grid
	 *
	 *	@param v the value (worth) of the grid
	*/
	public void setWorth(int v)
	{
      	trace("setWorth: setWorth starts");
      			
		value = v; // sets grid worth

      	trace("setWorth: setWorth ends");
	}
	
	
	/**
	 *	getWorth
	 *	Get method for "value" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the value of the Grid object's worth is
	 *					returned
	 *	Informally: return the worth of the Grid
	 *
	 *	@return double the value (worth) of the grid
	*/
	public int getWorth()
	{
      	trace("getWorth: getWorth starts and ends");

		// returns grid value
		return value;
	}
	
	
	/**
	 *	occupySquare
	 *	Make a move.
	 *	Pre-condition: the given location and symbol are defined
	 *	Post-condition: the square at the position in the
	 *					grid indicated by the given Location
	 *					value is altered to the given Symbol
	 *	Informally: update the square at the nominated location
	 *				of the grid with the given symbol
	 *
	 *	@param l Location to place symbol at
	 *	@param s Symbol to place
	*/
	public void occupySquare(Location l, Symbol s)
	{
		Square q;
 
		assert ((l!=null) && (s!=null));
		
      	trace("occupySquare: occupySquare starts" + " : " + s + " : " + l);

		// get the square from the grid, put the symbol on it, and put it back in the grid
		q = getSquare(l);
		q.setSymbol(s);

      	trace("occupySquare: occupySquare ends");
	}


	/**
	 *	squareOccupied
	 *	Check if a square is already taken
	 *	Pre-condition: the given location is defined
	 *	Post-condition: a Boolean value is returned which
	 *					represents whether the symbol of
	 *					the square of the current Grid
	 *					object with the given Location
	 *					value is empty
	 *	Informally: return whether or not the square at
	 *				the given location is occupied
	 *
	 *	@param l Location of square to check
	*/
	public boolean squareOccupied(Location l)
	{
		Square q;
		Symbol s;
		
		assert (l!=null);
		
      	trace("squareOccupied: squareOccupied starts and ends");
		// Get symbol at square
		q = getSquare(l);
		s = q.getSymbol();

		// checks if square is not empty
		return !s.isEmpty();
	}
	
	
	/**
	 *	getSymbol
	 *	Observe symbol at given location.
	 *	Pre-condition: the given location is defined
	 *	Post-condition: return the symbol of the square of
	 *					the current Grid object with the given
	 *					Location
	 *	Informally: return the symbol at the given location
	 *					of the grid
	 *
	 *	@param l Location of square lo look in
	 *	@return Symbol whatever is in the square of given Location
	*/
	public Symbol getSymbol(Location l)
	{
		Square q;
		Symbol s;
		
		assert (l!=null);

      	trace("getSymbol: getSymbol starts and ends");

		//also sets the symbol of the square
		q = getSquare(l);
		s = q.getSymbol();

		// return symbol
		return s;
	}
	
	
	/**
	 *	validMove
	 *	Check if a location is in the grid.
	 *	Pre-condition: the given location is defined
	 *	Post-condition: true is returned if the given
	 *					Location is within the bounds of
	 *					the current Grid object, false is
	 *					returned if it is not
	 *	Informally: return whether or not the given
	 *				location lies within the current grid
	 *
	 *	@param l Location to consider
	 *	@return boolean whether or not Location is on the grid
	*/
	public boolean validMove(Location l)
	{
		int r, c;
		boolean isValid;

		assert (l!=null);
		
      	trace("validMove: validMove starts");
      	
		// stores location row and column
		r = l.getRow();
		c = l.getColumn();

		// boolean expression that checks if the location is within the grid
		isValid = (c > 0 && c <= this.dimension) && (r > 0 && r <= this.dimension);
		
		// check whether the given location is within the bounds of the grid
      	trace("validMove: validMove ends");
		return (isValid);
	}


	/**
	 *	compareTo
	 *	Comparison method for Grid.
	 *	Pre-condition: the parameter o is a defined Grid object
	 *	Post-condition: 0 is returned if the Grids are the same, +/-1
	 *					is returned otherwise
	 *	Informally: check if two Grids are equivalent
	 *
	 *	@param o the Grid object to compare with the current grid
	 *	@return int 0 if the same, +/-1 otherwise
	*/
	public int compareTo(Object o)
 	{
 		int d1,d2;
 		Location l;
 		Grid g;
 		
 		assert (o instanceof Grid);
 		
      	trace("compareTo: compareTo starts");

 		g=(Grid) o;
 		d1=getDimension();
 		d2=g.getDimension();
 		
 		if (d1 != d2)
 		{
			// can't be the same grid -- they're different sizes!
			trace("compareTo: different dimension");
 			if (d1 < d2)
 			{
 				return -1;
 			}
 			else
 			{
 				return 1;
 			}
 		}
 		else
 		{
			// could be the same, better check all the squares
 			trace("compareTo: same dimension");
 			for (int r=1; r<=d1; r++)
 			{
 				for (int c=1; c<=d1; c++)
 				{
 					l=new Location(r,c);
 					if (! getSquare(l).getSymbol().equals(g.getSquare(l).getSymbol()))
 					{
						// found a difference, they're not the same grid
				      	trace("compareTo: different square content");
 						return -1; //it doesn't matter whether it's +/-1
 					}
				}
			}

	      	trace("compareTo: compareTo ends");
			// didn't find a difference, they must be equal
			return 0;
		}			
 	}
 	

	/**
	 *	equals
	 *	Comparison method for Grid.
	 *	Pre-condition: the parameter o is a defined Grid object
	 *	Post-condition: true is returned if the Grids are the same,
	 *					false is returned otherwise
	 *	Informally: check if two Grids are equivalent
	 *
	 *	@param g the Grid to compare with the current grid
	 *	@return boolean whether or not the two grids are equivalent
	*/
	public boolean equals(Grid g)
 	{
 		assert (g!=null);
 		
      	trace("equals: equals starts and ends");

		// checks if the grids are equivalent
		return (this.compareTo(g) == 0);
 	}


	/**
	 *	fullGrid
	 *	Check if the grid is full of symbols.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the grid has
	 *					all squares occupied, false is
	 *					returned if it is not
	 *	Informally: return whether or not the given
	 *				grid is full
	 *
	 *	@return boolean whether or not all squares have a
	 *				non-empty symbol within them
	*/
	protected boolean fullGrid()
	{
		final int TOP_ROW=1;

  		int c;
  		Location l;
  
      	trace("fullGrid: fullGrid starts");

		// check every square on the top row
		for (c=1; c<=dimension; c++)
		{
			l=new Location(TOP_ROW,c);
			if (! squareOccupied(l))
			{
				// this is isn't occupied, and so grid cannot be full
				trace("fullGrid: found an empty square");
				return false;
			}
		}
		
      	trace("fullGrid: fullGrid ends");		
  		return true;
	}

	
	/**
	 *	gameOver
	 *	Check if the game is over.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the game is
	 *					over because of either a win/loss
	 *					or a draw
	 *	Informally: return whether or not the game is over
	 *
	 *	@return boolean whether or not the game is over
	*/
	public boolean gameOver()
	{
		// the result of the game
		boolean res=false;

      	trace("gameOver: gameOver starts");

		if(!win().isEmpty() || fullGrid()){
			res = true;
		}

		trace("gameOver: gameOver ends");
		return res;
    }


	/**
	 *	win
	 *	Find out who (if anyone) has won.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the game is
	 *					over because of a win/loss
	 *	Informally: return whether or not the game has
	 *				been won or lost
	 *
	 *	@return Symbol the winner (or empty if noone)
	*/
	public Symbol win()
	{
  		Symbol res;
  
      	trace("win: win starts");

		// check the diagonals
  		res = diagWin();    
  		if (res.isEmpty())
  		{
			// no diagonal win, check the rows
    		res = horizWin();
      
    		if (res.isEmpty())
      		{
				// no diagonal or horizontal win, check the columns
      			res = vertWin();
      		}
  		}
  
      	trace("win: win ends");
  		return res;
	}


	/**
	 *	draw
	 *	Check if the game is drawn.
	 *	Pre-condition: none
	 *	Post-condition: true is returned if the game is
	 *					over because of a draw
	 *	Informally: return whether or not the game has
	 *				been drawn
	 *
	 *	@return boolean whether or not the game is a draw
	*/
	public boolean draw()
	{
		boolean res=false;

      	trace("draw: draw starts");

	  	if ((fullGrid()) && (win().isEmpty()))
    	{
			// the grid is full and there's no winner, must be a draw
    	  	trace("draw: draw ends");
    		res=true;
    	}
	  	else
    	{
			// there's a winner, or the game continues
	      	trace("draw: draw ends");
    	}

		return res;
    }


	/**
	 *	diagWin
	 *	Check whether a player has won diagonally.
	 *	Pre-condition: none
	 *	Post-condition: the winning player's symbol is returned if the
	 *					game is over because of a diagonal win/loss
	 *	Informally: return whether or not the game has
	 *				been won or lost diagonally
	 *
	 *	@return Symbol who has won diagonally (or empty if noone)
	*/
	protected Symbol diagWin()
	{
		Symbol res;
		
      	trace("diagWin: diagWin starts");

		// check the left diagonal
		res=leftDiagWin();
		if (res.isEmpty())
		{
			// no left diagonal win, check the right diagonal
	      	trace("diagWin: diagWin ends");
			return rightDiagWin();
		}
		else
		{
			// left diagonal win
    	  	trace("diagWin: diagWin ends");
			return res;
		}
	}


	/**
	 *	leftDiagWin
	 *	Check whether a player has won on the left diagonal.
	 *	Pre-condition: none
	 *	Post-condition: the winning player's symbol is returned if the
	 *					game is over because of a left-diagonal
	 *					win/loss
	 *	Informally: return whether or not the game has
	 *				been won or lost on a left-diagonal
	 *
	 *	@return Symbol who has won diagonally (or empty if noone)
	*/
	protected Symbol leftDiagWin()
	{
		Symbol res;
		int r,c;
		int count;
		Location l;
  		boolean win;
  
      	trace("leftDiagWin: leftDiagWin starts");
		// systematically, check the left diagonal
	  	for (int rc=1; rc<=(dimension-3); rc++)
	  	{
		  	for (int cc=1; cc<=(dimension-3); cc++)
		  	{
				// determine which symbol starts the 'streak'
		  		r=rc;
		  		c=cc;
		  		l=new Location(r,c);
		  		res=getSquare(l).getSymbol();
		  
		  		win=true;
		  		count=1;
		  		c++;
		  		r++;
		  		l=new Location(r,c);

				// check for a string of 4 like symbols
		  		while ((win) && (count<4) && (c<=dimension))
		  		{
		    		if (! res.equals(getSquare(l).getSymbol()))
					{
						// different symbol, not a streak
				      	win=false;
					}
					else
		    		{
						// same symbol, could still be a streak
		      			c++;
		      			r++;
		  				l=new Location(r,c);
						count++;
		      		}
		  		}

		  		if ((win) && (count==4) && (! res.isEmpty()))
		  		{
					// winner!
			      	trace("leftDiagWin: leftDiagWin ends");
		    		return res;
		    	}
		    }
		}
		
		// no win on the left diagonal
      	trace("leftDiagWin: leftDiagWin ends");
		return (new Symbol());
	}


	/**
	 *	rightDiagWin
	 *	Check whether a player has won on the left diagonal.
	 *	Pre-condition: none
	 *	Post-condition: the winning player's symbol is returned if the
	 *					game is over because of a right-diagonal
	 *					win/loss
	 *	Informally: return whether or not the game has
	 *				been won or lost on a right-diagonal
	 *
	 *	@return Symbol who has won diagonally (or empty if noone)
	*/
	protected Symbol rightDiagWin()
	{
 		Symbol res;
		int r,c;
		int count;
		Location l;
  		boolean win;
  
      	trace("rightDiagWin: rightDiagWin starts");
		// systematically, check the right diagonal
		for (int cc=dimension; cc>=4; cc--)
	  	{
		  	for (int rc=1; rc<=(dimension-3); rc++)
		  	{
				// determine which symbol starts the 'streak'
		  		r=rc;
		  		c=cc;
		  		l=new Location(r,c);
		  		res=getSquare(l).getSymbol();
		  
		  		win=true;
		  		count=1;
		  		c--;
		  		r++;
		  		l=new Location(r,c);

				// check for a string of 4 like symbols
		  		while ((win) && (count<4) && (c>=1))
		  		{
		    		if (! res.equals(getSquare(l).getSymbol()))
				    {
						// different symbol, not a streak
				    	win=false;
		    		}
		    		else
		    		{
						// same symbol, could still be a streak
		      			c--;
		      			r++;
		  				l=new Location(r,c);
		  				count++;
		      		}
		  		}

		  		if ((win) && (count==4) && (! res.isEmpty()))
		    	{
					// winner!
			      	trace("rightDiagWin: rightDiagWin ends");
		    		return res;
		    	}
		    }
		}
		
		// no win on the right diagonal
		trace("rightDiagWin: rightDiagWin ends");
		return (new Symbol());
  	}


	/**
	 *	horizWin
	 *	Check whether a player has won horizontally.
	 *	Pre-condition: none
	 *	Post-condition: the winning player's symbol is returned if the
	 *					game is over because of a horizontal win/loss
	 *	Informally: return whether or not the game has
	 *				been won or lost horizontally
	 *
	 *	@return Symbol who has won horizontally (or empty if noone)
	*/
	protected Symbol horizWin()
	{
  		Symbol res=new Symbol();
  		int c;
		int count;
  		Location l;
  		boolean win;
  
      	trace("horizWin: horizWin starts");

		// systematically, check the rows
 		for (int r=1; r<=dimension; r++)
  		{
	  		for (int i=1; i<=(dimension-3); i++)
	  		{
				// determine which symbol starts the 'streak'
	    		c=i;
	    		l=new Location(r,c);
			    res=getSquare(l).getSymbol();
	    		win=true;
	    		count=1;
	    		c=c+1;

				// check for a string of 4 like symbols
	    		while ((c<=dimension) && (count<4) && (win))
	    		{
		    		l=new Location(r,c);
			      	if (! res.equals(getSquare(l).getSymbol()))
	        		{
						// different symbol, not a streak
	        			win=false;
	      			}
	      			else
	      			{
						// same symbol, could still be a streak
	      				count++;
	        			c++;
	        		}
	    		}

	    		if ((win) && (count==4) && (! res.isEmpty()))
			    {
					// winner!
			    	trace("horizWin: horizWin ends");
	      			return res;
	      		}
	  		}
	    }

		// no win on the horizontal
		trace("horizWin: horizWin ends");
    	return new Symbol();
	}


	/**
	 *	vertWin
	 *	Check whether a player has won vertically.
	 *	Pre-condition: none
	 *	Post-condition: the winning player's symbol is returned if the
	 *					game is over because of a vertical win/loss
	 *	Informally: return whether or not the game has
	 *				been won or lost vertically
	 *
	 *	@return Symbol who has won vertically (or empty if noone)
	*/
	protected Symbol vertWin()
	{
  		Symbol res=new Symbol();
  		int r;
		int count;
  		Location l;
  		boolean win;
  
      	trace("vertWin: vertWin starts");

		// systematically, check the columns
 		for (int c=1; c<=dimension; c++)
		{
	  		for (int i=1; i<=(dimension-3); i++)
	  		{
				// determine which symbol starts the 'streak'
	    		r=i;
	    		l=new Location(r,c);
			    res=getSquare(l).getSymbol();
	    		win=true;
	    		count=1;
	    		r=i+1;

				// check for a string of 4 like symbols
				while ((r<=dimension) && (count<4) && (win))
	    		{
		    		l=new Location(r,c);
			      	if (! res.equals(getSquare(l).getSymbol()))
					{
						// different symbol, not a streak
	        			win=false;
					}
	      			else
	      			{
						// same symbol, could still be a streak
	      				count++;
	        			r++;
	        		}
	    		}

	    		if ((win) && (count==4) && (! res.isEmpty()))
			    {
			    	trace("vertWin: vertWin ends");
	      			return res;
	      		}
	  		}
	    }

		// no win on the vertical
		trace("vertWin: vertWin ends");
    	return new Symbol();
	}


	/**
	 *	evaluateGrid
	 *	Find the value of a grid from a player's perspective.
	 *	Pre-condition: the player is defined
	 *	Post-condition: the value of the grid from the given
	 *					player's perspective is returned
	 *	Informally: count the given player's advantage
	 *
	 *	@param p Player from whose perspective the grid should be
	 *				evaluated
	 *	@return int worth of the grid
	*/
	public int evaluateGrid(Player p)
	{
  		Symbol w;
  		int playerTotal;
  
		assert (p!=null);
		
      	trace("evaluateGrid: evaluateGrid starts");

		// find out what the grid's worth from the given player's perspective
  		if (draw())
  		{
			// it's a draw, so it's neither good nor bad
	      	trace("evaluateGrid: evaluateGrid ends (draw)");
  			return 0;
  		}
  		else
  		{
	  		w=win();
	  		if (w.equals(p.getSymbol()))
	   		{
				// it's a win, so it's great!
      			trace("evaluateGrid: evaluateGrid ends (win)");
	   			return dimension*dimension;
	   		}
	  		else
	  		{
	    		if (! w.isEmpty())
	      		{
					// it's a loss, so it's not great at all!
			      	trace("evaluateGrid: evaluateGrid ends (loss)");
	      			return -(dimension*dimension);
	      		}
	      		else
	      		{
					// determine value based on sole occupancy of rows, columns, and diagonals
	      			playerTotal=evaluateRows(p);
	      			playerTotal+=evaluateCols(p);
	      			playerTotal+=evaluateLDiags(p);
	      			playerTotal+=evaluateRDiags(p);
			      	trace("evaluateGrid: evaluateGrid ends (" + playerTotal + ")");
	      			return playerTotal;
	      		}
	      	}
	    }
	}


	/**
	 *	evaluateRows
	 *	Find the value of rows in a grid from a player's perspective.
	 *	Pre-condition: the given player is defined
	 *	Post-condition: the value of the grid's rows from the
	 *					given player's perspective is returned
	 *	Informally: count the given player's advantage in terms of
	 *				rows
	 *
	 *	@param p Player from whose perspective the grid should be
	 *				evaluated
	 *	@return int worth of the grid's rows
	*/
	protected int evaluateRows(Player p)
	{
		Symbol w;
		int r,c;
		int count;
		Location l;
		int playerRow, oppRow;
		int playerTotal;
				
      	trace("evaluateRows: evaluateRows starts");
		playerTotal=0;

		// systematically, evaluate the rows
		for (int rc=1; rc<=dimension; rc++)
		{
			for (int cc=1; cc<=(dimension-3); cc++)
			{
				playerRow=0;
				oppRow=0;
		  		r=rc;
		  		c=cc;
		  		count=1;
				// check the next sequence of 4 symbols
		  		while (count<=4)
		  		{
					l=new Location(r,c);
					if (squareOccupied(l))
					{
						w=getSquare(l).getSymbol();
						if (w.equals(p.getSymbol()))
						{
							// 'mine'
							playerRow++;
						}
						else
						{
							// 'theirs'
							oppRow++;
						}
					}
			  		c++;
					count++;
				}

				if ((playerRow > 0) && (oppRow == 0))
				{
					// the sequence is all 'me'
					playerTotal++;
				}
				if ((oppRow > 0) && (playerRow == 0))
				{
					// the sequence is all 'them'
					playerTotal--;
				}
			}
		}

      	trace("evaluateRows: evaluateRows ends (" + playerTotal + ")");
		return playerTotal;
	}
				

	/**
	 *	evaluateCols
	 *	Find the value of columns in a grid from a player's
	 *		perspective.
	 *	Pre-condition: the given player is defined
	 *	Post-condition: the value of the grid's columns from
	 *					the given player's perspective is returned
	 *	Informally: count the given player's advantage in terms of
	 *				columns
	 *
	 *	@param p Player from whose perspective the grid should be
	 *				evaluated
	 *	@return int worth of the grid's columns
	*/
	protected int evaluateCols(Player p)
	{
		Symbol w;
		int r,c;
		int count;
		Location l;
		int playerCol, oppCol;
		int playerTotal;
		
		assert (p!=null);
		
      	trace("evaluateCols: evaluateCols starts");
		playerTotal=0;

		// systematically, evaluate the columns
		for (int cc=1; cc<=dimension; cc++)
		{
			for (int rc=1; rc<=(dimension-3); rc++)
			{
				playerCol=0;
				oppCol=0;
		  		r=rc;
		  		c=cc;
		  		count=1;

				// check the next sequence of 4 symbols
		  		while (count<=4)
		  		{
					l=new Location(r,c);
					if (squareOccupied(l))
					{
						w=getSquare(l).getSymbol();
						if (w.equals(p.getSymbol()))
						{
							// 'mine'
							playerCol++;
						}
						else
						{
							// 'theirs'
							oppCol++;
						}
					}
			  		r++;
					count++;
				}

				if ((playerCol > 0) && (oppCol == 0))
				{
					// the sequence is all 'me'
					playerTotal++;
				}
				if ((oppCol > 0) && (playerCol == 0))
				{
					// the sequence is all 'them'
					playerTotal--;
				}
			}
		}

      	trace("evaluateCols: evaluateCols ends (" + playerTotal + ")");
		return playerTotal;
	}
				

	/**
	 *	evaluateLDiags
	 *	Find the value of left-diagonals in a grid from a player's
	 *		perspective.
	 *	Pre-condition: the given player is defined
	 *	Post-condition: the value of the grid's left-diagonals from
	 *					the given player's perspective is returned
	 *	Informally: count the given player's advantage in terms of
	 *				left-diagonals
	 *
	 *	@param p Player from whose perspective the grid should be
	 *				evaluated
	 *	@return int worth of the grid's left diagonal
	*/
	protected int evaluateLDiags(Player p)
	{
		Symbol w;
		int r,c;
		int count;
		Location l;
		int playerDiag, oppDiag;
		int playerTotal;
  
		assert (p!=null);
		
       	trace("evaluateLDiags: evaluateLDiags starts");
  		playerTotal=0;

		// systematically, evaluate the left-diagonals
		for (int rc=1; rc<=(dimension-3); rc++)
	  	{
		  	for (int cc=1; cc<=(dimension-3); cc++)
		  	{
		  		playerDiag=0;
		  		oppDiag=0;
		  		r=rc;
		  		c=cc;
		  		count=1;

				// check the next sequence of 4 symbols
		  		while (count<=4)
		  		{
			  		l=new Location(r,c);
			  		if (squareOccupied(l))
			  		{
				  		w=getSquare(l).getSymbol();
						if (w.equals(p.getSymbol()))
						{
							// 'mine'
							playerDiag++;
						}
						else
						{
							// 'theirs'
							oppDiag++;
						}
		  			}
			  		c++;
			  		r++;
					count++;
		  		}		

				if ((playerDiag > 0) && (oppDiag == 0))
				{
					// the sequence is all 'me'
					playerTotal++;
				}
				if ((oppDiag > 0) && (playerDiag == 0))
				{
					// the sequence is all 'them'
					playerTotal--;
				}
		    }
		}

      	trace("evaluateLDiags: evaluateLDiags ends (" + playerTotal + ")");
		return playerTotal;
	}
	
	
	/**
	 *	evaluateRDiags
	 *	Find the value of right-diagonals in a grid from a
	 *		player's perspective.
	 *	Pre-condition: the given player is defined
	 *	Post-condition: the value of the grid's right-diagonals
	 *					from the given player's perspective is returned
	 *	Informally: count the given player's advantage in terms of
	 *				right-diagonals
	 *
	 *	@param p Player from whose perspective the grid should be
	 *				evaluated
	 *	@return int worth of the grid's right diagonal
	*/
	protected int evaluateRDiags(Player p)
	{
		Symbol w;
		int r,c;
		int count;
		Location l;
		int playerDiag, oppDiag;
		int playerTotal;
  
		assert (p!=null);
		
      	trace("evaluateRDiags: evaluateRDiags starts");
  		playerTotal=0;

		// systematically, evaluate the right-diagonals
	  	for (int cc=dimension; cc>=4; cc--)
	  	{
		  	for (int rc=1; rc<=(dimension-3); rc++)
		  	{
		  		playerDiag=0;
		  		oppDiag=0;
		  		r=rc;
		  		c=cc;
		  		count=1;

				// check the next sequence of 4 symbols
		  		while (count<=4)
		  		{
			  		l=new Location(r,c);
			  		if (squareOccupied(l))
			  		{
				  		w=getSquare(l).getSymbol();
						if (w.equals(p.getSymbol()))
						{
							// 'mine'
							playerDiag++;
						}
						else
						{
							// 'theirs'
							oppDiag++;
						}
		  			}
			  		c--;
			  		r++;
					count++;
		  		}		

				if ((playerDiag > 0) && (oppDiag == 0))
				{
					// the sequence is all 'me'
					playerTotal++;
				}
				if ((oppDiag > 0) && (playerDiag == 0))
				{
					// the sequence is all 'them'
					playerTotal--;
				}
		    }
		}

		trace("evaluateRDiags: evaluateRDiags ends (" + playerTotal + ")");
		return playerTotal;
	}
	
	
	/**
	 *	toString
	 *	Convert the grid to a String representation.
	 *	Pre-condition: none
	 *	Post-condition: a String representation of the grid
	 *					is returned
	 *	Informally: find a String representation of the grid
	 *
	 *	@return String representation of the grid
	*/
	public String toString()
	{
		Location l;
		String s;

	   	trace("toString: toString starts");

		// build string of all cells row by row, column by column, separating rows by ,
		s="[";
		for (int r=1; r<=dimension; r++)
		{
			for (int c=1; c<=dimension; c++)
			{
				l=new Location(r,c);
				s=s+getSquare(l);
			}

			if (r != dimension)
			{
				s=s+",";
			}
		}
		s=s+"]\t";

 		s+="Worth: " + getWorth();
		
      	trace("toString: toString ends");
		return s;
	}


	/**
	 *	showGrid
	 *	Display the grid.
	 *	Pre-condition: the Screen parameter is correctly defined
	 *	Post-condition: the screen representation of the Grid
	 *					object is displayed on the given Screen
	 *	Informally: display the current grid
	 *
	 *	@param s the Display upon which the grid should be shown
	*/
	public void showGrid(Display s)
	{
		final Color EDGE=Color.BLACK;
		final Color BACKGROUND=Color.LIGHT_GRAY;

		int r,c;
		Location l;
		Graphics g;
		int width;
		Square q;
		
		assert (s!=null);
		
      	trace("showGrid: showGrid starts");

		g=s.getGraphics();
		g.setColor(BACKGROUND);
		g.fillRect(0,70,600,600);
		width=(600-10-((dimension-1)*5)) / dimension;
		
		g.setColor(EDGE);

		// show the grid
		for (r=1; r<=dimension; r++)
		{
			for (c=1; c<=dimension; c++)
			{
				l=new Location(r,c);
				q=getSquare(l);
				q.showSquare(s,width);
			}
		}

		trace("showGrid: grid is " + toString());
  		g.setColor(EDGE);

      	trace("showGrid: showGrid ends");
 	}
 	

	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s String to display as trace message
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("Grid: " + s);
		}
	}
}
