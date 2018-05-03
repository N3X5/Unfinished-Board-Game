package Exceptions;

import GUI.MainFrame;

public class TooManyUnitsOnTileException extends Throwable {
		
	public void printErrorToUser() 
	{
		MainFrame.showMessage("You cannot have more than 3 units on a single tile!");
	}
}
