package Buildings;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import Exceptions.NonUpgradeableBuildingException;
import GUI.GraphicsManager;
import GUI.MainFrame;
import Player.Player;

public class Castle extends Building {
	
	private int level = 1;
	
	public Castle(Player owner) { super.owner = owner; }

	@Override
	public void onTurnEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, Point location) {
		BufferedImage cstl = GraphicsManager.manager.GetImage(BuildingType.CASTLE);
		BufferedImage cstl_lvl2 = GraphicsManager.manager.GetImage(BuildingType.CASTLE_LVL2);
		BufferedImage cstl_lvl3 = GraphicsManager.manager.GetImage(BuildingType.CASTLE_LVL3);
		
		switch(level) 
		{
		case 1:
			g.drawImage(cstl, location.x-22, location.y-20, 33, 39, MainFrame.panel);
			break;
		case 2:
			g.drawImage(cstl_lvl2, location.x-19, location.y-19, 37, 37, MainFrame.panel);
			break;
		case 3:
			g.drawImage(cstl_lvl3, location.x-22, location.y-21, 45, 45, MainFrame.panel);
			break;
		}
	}
	
	public int getLevel() { return level; }
	
	@Override
	public void upgradeLevel() throws NonUpgradeableBuildingException { if(level!=3) level++; else throw new NonUpgradeableBuildingException(); }
	
	

}
