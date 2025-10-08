//KIT107 Assignment 3
/**
 *	Interface for Graphical User Interface and Solution
 *
 *	@author Julian Dermoudy
 *	@version September 2025
 *	
 *	This file holds the play() and other related
 *	routines from the sample solution.  The class is
 *	a frame that contains the graphical user interface.
 *	
 *	This file is complete.
*/


import java.awt.*;
import java.awt.event.*;


public interface Connect4Interface
{
	//public Connect4(String a)
    public void paint(Graphics g);
	public void actionPerformed(ActionEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseClicked(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseEntered(MouseEvent e);
	public void mouseExited(MouseEvent e);
}
