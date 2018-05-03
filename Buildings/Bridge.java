package Buildings;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import GUI.GraphicsManager;
import GUI.MainFrame;
import Player.Player;

public class Bridge extends Building {
	
	private BuildingOrientation orientation;

	public Bridge(BuildingOrientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public void onTurnEnd() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Player getOwner() { return null; }

	@Override
	public void draw(Graphics g, Point location) {
		BufferedImage brdg = GraphicsManager.manager.GetImage(BuildingType.BRIDGE);
		BufferedImage brdg_60 = GraphicsManager.manager.GetImage(BuildingType.BRIDGE_60);
		BufferedImage brdg_120 = GraphicsManager.manager.GetImage(BuildingType.BRIDGE_120);
		
		switch(orientation) {
		case WEST_EAST:
			g.drawImage(brdg, location.x-26, location.y-13, 53, 25, MainFrame.panel);
			break;
		case SWEST_NEAST:
			g.drawImage(brdg_120, location.x-21, location.y-28, 44, 56, MainFrame.panel);
			break;
		case SEAST_NWEST:
			g.drawImage(brdg_60, location.x-21, location.y-28, 44, 56, MainFrame.panel);
			break;
		}
			
	}
}
