package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import IO.AssetManager;
import Tiles.Hexagon;

public class GraphicsManager {
	
	public static AssetManager manager = new AssetManager();
	private Graphics g;
	private Point location;
	private Hexagon hexag;
	
	public GraphicsManager(Graphics g, Hexagon hexag) 
	{
		this.g = g;
		this.hexag = hexag;
		location = hexag.getLocation();
	}
	
	private void fillInHexagon() 
	{
		if(!hexag.isSelected())
			g.setColor(hexag.getColor());
		else
			g.setColor(Color.BLUE);
		g.fillPolygon(hexag);
	}
	
	public static BufferedImage rotateImage(BufferedImage image, int degrees) 
	{
		AffineTransform transform = new AffineTransform();
	    transform.rotate(Math.toRadians(degrees), image.getWidth()/2, image.getHeight()/2);
	    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
	    return op.filter(image, null);
	}
	
	public void drawHexagon() 
	{				
			if(hexag.getBuilding()!=null) 
			{		
				if(MainFrame.buildingButtonGroup.getSelection()!=null) 
				{ 
					g.setColor(hexag.getColor());
					g.fillPolygon(hexag);
					hexag.getBuilding().draw(g, location); 
				}
				else  
				{ 
					fillInHexagon();
					hexag.getBuilding().draw(g, location);
				}	
			}
			else
				fillInHexagon();
			
			g.setColor(Color.BLACK);
			g.drawPolygon(hexag);
	}
	
	
}
