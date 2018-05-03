package Tiles;

import java.awt.Color;

import Buildings.BuildingOrientation;
import Buildings.BuildingType;
import Buildings.Tunnel;
import Exceptions.CannotBuildBuildingException;
import Player.Player;

public class Mountain extends Hexagon {
	
	public Mountain(int x, int y, int radius) {
		super(x, y, radius);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void buildCastle (Player owner) throws CannotBuildBuildingException { throw new CannotBuildBuildingException(BuildingType.CASTLE); }
	
	@Override
	public void buildHouse(Player owner) throws CannotBuildBuildingException { throw new CannotBuildBuildingException(BuildingType.HOUSE); }
	
	@Override
	public void buildTunnel(BuildingOrientation orientation) throws CannotBuildBuildingException { super.building = new Tunnel(orientation); }

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.DARK_GRAY;
	}

}
