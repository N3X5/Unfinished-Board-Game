package Tiles;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Buildings.Bridge;
import Buildings.Building;
import Buildings.BuildingOrientation;
import Buildings.BuildingType;
import Buildings.Castle;
import Buildings.House;
import Buildings.Tunnel;
import Exceptions.CannotBuildBuildingException;
import Exceptions.TooManyUnitsOnTileException;
import Player.Player;
import Tiles.Field;
import Tiles.Forest;
import Tiles.Mountain;
import Tiles.Rock;
import Tiles.Sand;
import Tiles.Water;
import Tiles.Wheat;
import Units.Archer;
import Units.Footman;
import Units.Knight;
import Units.Unit;

public abstract class Hexagon extends Polygon {
	
	private static final long serialVersionUID = 1L;
	
	private final double pi = Math.PI;
	public static List<Hexagon> hexagList = new ArrayList<Hexagon>();
	private boolean selected = false;
	protected Building building;
	private List<Unit> unitsOnTile = new ArrayList<Unit>();
	private  int x, y;
	private static int FieldCnt = 21, ForestCnt = 19, WheatCnt = 16, WaterCnt = 13, RockCnt = 9, MountainCnt = 7, SandCnt = 6;
	
	
	public Hexagon(int x, int y, int radius) 
	{
		this.x = x;
		this.y = y;
		
		for(int i=0; i<6; i++) {
		    addPoint((int) (x + radius*Math.sin(i*2*pi/6)), (int) (y + radius*Math.cos(i*2*pi/6)));
		}
	}
	
	public abstract Color getColor();
	
	public Point getLocation() { return new Point(x, y); }
	
	public boolean isSelected() { return selected; }
	
	public void select() { selected = true; }
	
	public void deselect() { selected = false; }
	
	public Building getBuilding() { return building; }
	
	public List<Unit> getUnits() { return unitsOnTile; }
	
	public void buildCastle (Player owner) throws CannotBuildBuildingException { building = new Castle(owner); }
	
	public void buildHouse(Player owner) throws CannotBuildBuildingException { building = new House(owner); }
	
	public void buildBridge(BuildingOrientation orientation) throws CannotBuildBuildingException { throw new CannotBuildBuildingException(BuildingType.BRIDGE); }
	
	public void buildTunnel(BuildingOrientation orientation) throws CannotBuildBuildingException { throw new CannotBuildBuildingException(BuildingType.TUNNEL); }
	
	public void demolishBuilding() { building = null; }
	
	public void addUnitToTile(Unit unit) throws TooManyUnitsOnTileException { if(unitsOnTile.size()==3) throw new TooManyUnitsOnTileException(); else unitsOnTile.add(unit); }
	 
	public boolean isEmpty ()
	{
		if(building==null)
			return true;
		else 
			return false;
	}
	
	public static void resetCount() 
	{
		FieldCnt = 21;
		ForestCnt = 19;
		WheatCnt = 16;
		WaterCnt = 13;
		RockCnt = 9;
		MountainCnt = 7;
		SandCnt = 6;
	}
	
	private static Hexagon genRandomTile(int x, int y, int radius) 
	{
		Random r = new Random();
		int rNum = r.nextInt(7);
		boolean loop = false;
		
		do {
		switch (rNum) 
		{
			case 0:
				if(FieldCnt!=0) { FieldCnt--; return new Field(x, y, radius); }
				else { rNum = r.nextInt(7); loop = true; }
				break;
			case 1:
				if(ForestCnt!=0) { ForestCnt--; return new Forest(x, y, radius); }
				else { rNum = r.nextInt(7); loop = true; }
				break;
			case 2:
				if(WheatCnt!=0) { WheatCnt--; return new Wheat(x, y, radius); }
				else { rNum = r.nextInt(7); loop = true; }
				break;
			case 3:
				if(WaterCnt!=0) { WaterCnt--; return new Water(x, y, radius); }
				else { rNum = r.nextInt(7); loop = true; }
				break;
			case 4:
				if(RockCnt!=0) { RockCnt--; return new Rock(x, y, radius); }
				else { rNum = r.nextInt(7); loop = true; }
				break;
			case 5:
				if(MountainCnt!=0) { MountainCnt--; return new Mountain(x, y, radius); }
				else { rNum = r.nextInt(7); loop = true; }
				break;
			case 6:
				if(SandCnt!=0) { SandCnt--; return new Sand(x, y, radius); }
				else { rNum = r.nextInt(7); loop = true; }
				break;
		}
		} while (loop);
		return null;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void buildHexagList() 
	{
		Dimension d = new Dimension(800, 600);
		hexagList.clear();
		resetCount();
		
		for(int x=0; x<6; x++) {
			hexagList.add(genRandomTile(d.width/2+(x*51), d.height/2, 30));
			if(x!=0) {
				hexagList.add(genRandomTile(d.width/2-(x*51), d.height/2, 30));
				hexagList.add(genRandomTile(d.width/2+(25*x), d.height/2-(x*45), 30));
				hexagList.add(genRandomTile(d.width/2-(25*x), d.height/2-(x*45), 30));
				hexagList.add(genRandomTile(d.width/2+(25*x), d.height/2+(x*45), 30));
				hexagList.add(genRandomTile(d.width/2-(25*x), d.height/2+(x*45), 30));
				
				if(x==2) 
				{
					hexagList.add(genRandomTile(d.width/2, d.height/2+90, 30));
					hexagList.add(genRandomTile(d.width/2, d.height/2-90, 30));
					hexagList.add(genRandomTile(d.width/2-76, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2+76, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2-76, d.height/2+45, 30));
					hexagList.add(genRandomTile(d.width/2+76, d.height/2+45, 30));
				}
				else if(x==3) 
				{
					hexagList.add(genRandomTile(d.width/2-25, d.height/2-135, 30));
					hexagList.add(genRandomTile(d.width/2+25, d.height/2-135, 30));
					hexagList.add(genRandomTile(d.width/2-25, d.height/2+135, 30));
					hexagList.add(genRandomTile(d.width/2+25, d.height/2+135, 30));
					hexagList.add(genRandomTile(d.width/2-100, d.height/2-90, 30));
					hexagList.add(genRandomTile(d.width/2+100, d.height/2-90, 30));
					hexagList.add(genRandomTile(d.width/2-100, d.height/2+90, 30));
					hexagList.add(genRandomTile(d.width/2+100, d.height/2+90, 30));
					hexagList.add(genRandomTile(d.width/2-127, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2+127, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2-127, d.height/2+45, 30));
					hexagList.add(genRandomTile(d.width/2+127, d.height/2+45, 30));
				}
				else if(x==4) 
				{
					hexagList.add(genRandomTile(d.width/2-50, d.height/2-180, 30));
					hexagList.add(genRandomTile(d.width/2, d.height/2-180, 30));
					hexagList.add(genRandomTile(d.width/2+50, d.height/2-180, 30));
					hexagList.add(genRandomTile(d.width/2-50, d.height/2+180, 30));
					hexagList.add(genRandomTile(d.width/2, d.height/2+180, 30));
					hexagList.add(genRandomTile(d.width/2+50, d.height/2+180, 30));
					hexagList.add(genRandomTile(d.width/2-177, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2-150, d.height/2-90, 30));
					hexagList.add(genRandomTile(d.width/2-125, d.height/2-135, 30));
					hexagList.add(genRandomTile(d.width/2-177, d.height/2+45, 30));
					hexagList.add(genRandomTile(d.width/2-150, d.height/2+90, 30));
					hexagList.add(genRandomTile(d.width/2-125, d.height/2+135, 30));
					hexagList.add(genRandomTile(d.width/2+177, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2+150, d.height/2-90, 30));
					hexagList.add(genRandomTile(d.width/2+125, d.height/2-135, 30));
					hexagList.add(genRandomTile(d.width/2+177, d.height/2+45, 30));
					hexagList.add(genRandomTile(d.width/2+150, d.height/2+90, 30));
					hexagList.add(genRandomTile(d.width/2+125, d.height/2+135, 30));
				}
				else if(x==5)
				{				
					hexagList.add(genRandomTile(d.width/2-75, d.height/2-225, 30));
					hexagList.add(genRandomTile(d.width/2-25, d.height/2-225, 30));
					hexagList.add(genRandomTile(d.width/2+25, d.height/2-225, 30));
					hexagList.add(genRandomTile(d.width/2+75, d.height/2-225, 30));
					hexagList.add(genRandomTile(d.width/2-75, d.height/2+225, 30));
					hexagList.add(genRandomTile(d.width/2-25, d.height/2+225, 30));
					hexagList.add(genRandomTile(d.width/2+25, d.height/2+225, 30));
					hexagList.add(genRandomTile(d.width/2+75, d.height/2+225, 30));
					hexagList.add(genRandomTile(d.width/2-151, d.height/2+180, 30));
					hexagList.add(genRandomTile(d.width/2+151, d.height/2+180, 30));
					hexagList.add(genRandomTile(d.width/2-151, d.height/2-180, 30));
					hexagList.add(genRandomTile(d.width/2+151, d.height/2-180, 30));
					hexagList.add(genRandomTile(d.width/2+175, d.height/2+135, 30));
					hexagList.add(genRandomTile(d.width/2-175, d.height/2+135, 30));
					hexagList.add(genRandomTile(d.width/2+175, d.height/2-135, 30));
					hexagList.add(genRandomTile(d.width/2-175, d.height/2-135, 30));
					hexagList.add(genRandomTile(d.width/2-228, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2+228, d.height/2-45, 30));
					hexagList.add(genRandomTile(d.width/2-228, d.height/2+45, 30));
					hexagList.add(genRandomTile(d.width/2+228, d.height/2+45, 30));
					hexagList.add(genRandomTile(d.width/2+201, d.height/2+90, 30));
					hexagList.add(genRandomTile(d.width/2-201, d.height/2+90, 30));
					hexagList.add(genRandomTile(d.width/2+201, d.height/2-90, 30));
					hexagList.add(genRandomTile(d.width/2-201, d.height/2-90, 30));
				}
			}
		}
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
}
