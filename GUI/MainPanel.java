package GUI;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Tiles.Hexagon;
import Tiles.Mountain;
import Tiles.Water;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public MainPanel() 
	{	
		addMouseListener(new MouseHandler());
	}
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		Stroke stroke = g2.getStroke();
		g2.setStroke(new BasicStroke(3));
		
		g.setColor(Color.BLACK);
		g.drawRect(50, 30, 700, 545);
		g.setColor(Color.lightGray);
		g.fillRect(51, 31, 699, 544);
		
		g2.setStroke(stroke);
		
		for(Hexagon hexag: Hexagon.hexagList)
			new GraphicsManager(g, hexag).drawHexagon();
	}


}
