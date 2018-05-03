package Buildings;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;
import GUI.MainFrame;
import Player.Player;
import Exceptions.NonUpgradeableBuildingException;

public abstract class Building {
	protected Player owner;
	
	public abstract void onTurnEnd();
	public abstract void draw(Graphics g, Point location);
	public void upgradeLevel() throws NonUpgradeableBuildingException { throw new NonUpgradeableBuildingException(); }
	
	public Player getOwner() { return owner; }
	
	public static BuildingOrientation getBuildingOrientationFromUser(String message, String dialogTitle) 
	{
		int input = JOptionPane.showOptionDialog(MainFrame.frame, 
					message, dialogTitle,
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, new String[] { "West-East", "SWest-NEast", "SEast-NWest" }, 0);
		
		return BuildingOrientation.getOrientation(input);
	}
}
