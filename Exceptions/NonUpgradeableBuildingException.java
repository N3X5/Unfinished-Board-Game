package Exceptions;

import GUI.MainFrame;

public class NonUpgradeableBuildingException extends Throwable {
	
	public void printErrorToUser() { MainFrame.showMessage("You cannot upgrade the level of this building!"); }
	
}
