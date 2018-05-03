package IO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Buildings.BuildingType;
import Units.UnitType;

public class AssetManager {
	
	private HashMap<BuildingType, BufferedImage> buildings;
	private HashMap<UnitType, BufferedImage> units;
	private static String sourcesPath; 
	
	public AssetManager() {
		try {
			sourcesPath = new File(".").getCanonicalPath()+"\\";
		} catch (Exception e) {}
		
		buildings = new HashMap<BuildingType, BufferedImage>();
		units = new HashMap<UnitType, BufferedImage>();
		
		String imagesPath = sourcesPath + "images\\";
		
		this.AddImage(BuildingType.CASTLE, imagesPath + "castle.png");
		this.AddImage(BuildingType.CASTLE_LVL2, imagesPath + "castle_lvl2.png");
		this.AddImage(BuildingType.CASTLE_LVL3, imagesPath + "castle_lvl3.png");
		
		this.AddImage(BuildingType.BRIDGE, imagesPath +"bridge.png");
		this.AddImage(BuildingType.BRIDGE_60, imagesPath + "bridge_60_rotated.png");
		this.AddImage(BuildingType.BRIDGE_120, imagesPath + "bridge_120_rotated.png");
		
		this.AddImage(BuildingType.HOUSE, imagesPath + "house.png");
		
		this.AddImage(BuildingType.TUNNEL,  imagesPath + "tunnel.png");
		this.AddImage(BuildingType.TUNNEL_60,  imagesPath + "tunnel_60_rotated.png");
		this.AddImage(BuildingType.TUNNEL_120,  imagesPath + "tunnel_120_rotated.png");
		
		this.AddImage(UnitType.ARCHER_MOUSE, imagesPath + "archer_mouse.png");
		this.AddImage(UnitType.ARCHER_RABBIT, imagesPath + "archer_rabbit.png");
		this.AddImage(UnitType.ARCHER_RAT, imagesPath + "archer_rat.png");
		this.AddImage(UnitType.ARCHER_SQUIRREL, imagesPath + "archer_squirrel.png");
		
		this.AddImage(UnitType.FOOTMAN_MOUSE, imagesPath + "footman_mouse.png");
		this.AddImage(UnitType.FOOTMAN_RABBIT, imagesPath + "footman_rabbit.png");
		this.AddImage(UnitType.FOOTMAN_RAT, imagesPath + "footman_rat.png");
		this.AddImage(UnitType.FOOTMAN_SQUIRREL, imagesPath + "footman_squirrel.png");
		
		this.AddImage(UnitType.KNIGHT_MOUSE, imagesPath + "knight_mouse.png");
		this.AddImage(UnitType.KNIGHT_RABBIT, imagesPath + "knight_rabbit.png");
		this.AddImage(UnitType.KNIGHT_RAT, imagesPath + "knight_rat.png");
		this.AddImage(UnitType.KNIGHT_SQUIRREL, imagesPath + "knight_squirrel.png");
		
	}
	
	private void AddImage(BuildingType ob, String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		}
		catch(Exception e) {}
		
		this.buildings.put(ob, image);
	}
	
	private void AddImage(UnitType ob, String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		}
		catch(Exception e) {}
		
		this.units.put(ob, image);
	}
	
	public BufferedImage GetImage(BuildingType ob) {
		return this.buildings.get(ob);
	}
	
	public BufferedImage GetImage(UnitType ob) {
		return this.units.get(ob);
	}
	
}
