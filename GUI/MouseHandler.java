package GUI;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Buildings.Building;
import Buildings.Castle;
import Exceptions.CannotBuildBuildingException;
import Exceptions.MultipleSelectionException;
import Exceptions.NonUpgradeableBuildingException;
import Player.Player;
import Tiles.Hexagon;
import Tiles.Mountain;
import Tiles.Water;

public class MouseHandler implements MouseListener {

	@Override
	public void mousePressed(MouseEvent me) {
		int clickedHexagonsCount = 0;
		Point p = new Point(me.getX(), me.getY());
		Player playerOnTurn = Player.getPlayerOnTurn();
		
		for(Hexagon hexag: Hexagon.hexagList)
		{
			if(hexag.contains(p)) {
				clickedHexagonsCount++;
				
				if(MainFrame.buildingButtonGroup.getSelection()!=null)
					hexag.deselect();
				
				try {
				if(MainFrame.tglbtnBuildBridge.isSelected() && hexag.isEmpty())
				{ 
					hexag.buildBridge(Building.getBuildingOrientationFromUser("Please choose the orientation of your bridge:",
							"Build a bridge")); 
					continue; 
				}
				else if(MainFrame.tglbtnBuildTunnel.isSelected() && hexag.isEmpty())
				{ 
					hexag.buildTunnel(Building.getBuildingOrientationFromUser("Please choose the orientation of your tunnel:",
							"Build a tunnel")); 
					continue; 
				}
				else if(MainFrame.tglbtnBuildHouse.isSelected() && hexag.isEmpty()) { hexag.buildHouse(playerOnTurn); continue; }
				else if(MainFrame.tglbtnBuildCastle.isSelected() && hexag.isEmpty()) { hexag.buildCastle(playerOnTurn); continue; }
				else if(MainFrame.tglbtnUpgrageBuilding.isSelected()) { hexag.getBuilding().upgradeLevel(); continue; }
				else if(MainFrame.tglbtnDemolishBuilding.isSelected()) { hexag.demolishBuilding(); continue; }
				} catch(CannotBuildBuildingException e) { e.printErrorToUser(); }
				catch(NonUpgradeableBuildingException e) { e.printErrorToUser(); }
				
				if(!hexag.isSelected())
					hexag.select();
				else
					hexag.deselect();
			}
			else 
				hexag.deselect();
		}
		
		if(clickedHexagonsCount>1)
			try { throw new MultipleSelectionException(clickedHexagonsCount); } catch (MultipleSelectionException e)
			{
				System.err.println("Multiple tiles have been selected at the same time by the player!");
				System.err.println("Only one tile will be selected at random by the game.");
			}
			
		MainFrame.panel.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

}
