package Buildings;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import GUI.GraphicsManager;
import GUI.MainFrame;
import Player.Player;

public class Tunnel extends Building{

	private BuildingOrientation orientation;
	
	public Tunnel(BuildingOrientation orientation) {
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
		BufferedImage tun = GraphicsManager.manager.GetImage(BuildingType.TUNNEL);
		BufferedImage tun_60 = GraphicsManager.manager.GetImage(BuildingType.TUNNEL_60);
		BufferedImage tun_120 = GraphicsManager.manager.GetImage(BuildingType.TUNNEL_120);
		
		switch(orientation) 
		{
		case SEAST_NWEST:
			g.drawImage(tun_60, location.x-17, location.y-26, 37, 52, MainFrame.panel);
			break;
		case SWEST_NEAST:
			g.drawImage(tun_120, location.x-17, location.y-25, 37, 52, MainFrame.panel);
			break;
		case WEST_EAST:
			g.drawImage(tun, location.x-24, location.y-15, 49, 28, MainFrame.panel);
			break;
		}
	}
}
