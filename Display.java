//KIT107 Assignment 3
/**
 *	Display ADT
 *
 *	@author Julian Dermoudy
 *	@version September 2025
 *	
 *	This file holds the Display ADT which represents
 *	the computer screen.  Internally, the screen is
 *	represented by a graphics context.
 *	
 *	This file is complete.
*/

import java.awt.*;


public class Display implements DisplayInterface
{
	// finals
	protected final boolean TRACING=false;				// do we want to see trace output?

	// properties
	protected Graphics graphics;						// the window on which to draw etc.

	
	/**
	 *  Display
	 *	Constructor method.
	 *	Pre-condition: none
	 *	Post-condition: the Display object's "graphics" instance
	 *					variable is set to null
	 *	Informally: intialises the graphics window to null
	*/
	public Display()
	{
		trace("Display: constructor begins");
		
		graphics=null;
		
		trace("Display: constructor ends");
	}
	
	
	/**
	 *	setGraphics
	 *	Set method for "graphics" instance variable.
	 *	Pre-condition: the graphics context (g) is a valid window
	 *	Post-condition: the Display object's graphics instance variable
	 *					is altered to hold the given (g) value
	 *	Informally: assign a graphics window value to the object
	 *
	 *  @param g graphics context
	*/
	public void setGraphics(Graphics g)
	{
		assert (g!=null);
		
		trace("setGraphics: setGraphics starts");
		
		graphics=g;
		
		trace("setGraphics: setGraphics ends");
	}
	
	
	/**
	 *	getGraphics
	 *	Get method for "graphics" instance variable.
	 *	Pre-condition: none
	 *	Post-condition: the Display object's graphics value is
	 *					returned
	 *	Informally: examine the Graphics object's window component
	 *				instance variable returning its value
	 *
	 *	@return Graphics graphics context
	*/
	public Graphics getGraphics()
	{
		trace("getGraphics: getGraphics starts and ends");
		return graphics;
	}


	/**
	 *	trace
	 *	Provide trace output.
	 *	Pre-condition: none
	 *	Post-condition: if trace output is desired then the given String
	 *					parameter is shown on the console
	 *	Informally: show the given message for tracing purposes
	 *
	 *	@param s String to display as trace output
	*/
	protected void trace(String s)
	{
		if (TRACING)
		{
			System.out.println("Display: " + s);
		}
	}
}