package Buildings;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import GUI.GraphicsManager;
import GUI.MainFrame;
import Player.Player;

public class House extends Building {
	
	public House(Player owner) { super.owner = owner; }

	@Override
	public void onTurnEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, Point location) {
		BufferedImage img = GraphicsManager.manager.GetImage(BuildingType.HOUSE);
		g.drawImage(img, location.x-18, location.y-15, 38, 28, MainFrame.panel);
	}

}
