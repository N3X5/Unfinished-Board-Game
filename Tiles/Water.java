package Tiles;

import java.awt.Color;

import Buildings.Bridge;
import Buildings.BuildingOrientation;
import Buildings.BuildingType;
import Exceptions.CannotBuildBuildingException;
import Player.Player;

public class Water extends Hexagon {
	
	public Water(int x, int y, int radius) {
		super(x, y, radius);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void buildHouse(Player owner) throws CannotBuildBuildingException { throw new CannotBuildBuildingException(BuildingType.HOUSE); }
	
	@Override
	public void buildBridge(BuildingOrientation orientation) throws CannotBuildBuildingException { super.building = new Bridge(orientation); }
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.CYAN;
	}
}
