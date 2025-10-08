//KIT107 Assignment 3
/**
 *	Display ADT Interface
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

public interface DisplayInterface
{
	//public Display();
	public void setGraphics(Graphics g);
	public Graphics getGraphics();
}
