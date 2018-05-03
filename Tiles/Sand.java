package Tiles;

import java.awt.Color;

public class Sand extends Hexagon{

	public Sand(int x, int y, int radius) {
		super(x, y, radius);
		// TODO Auto-generated constructor stub
	}

	private final float[] SandRGBColor = Color.RGBtoHSB(255, 255, 153, null);
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.getHSBColor(SandRGBColor[0], SandRGBColor[1], SandRGBColor[2]);
	}


}
