package Tiles;

import java.awt.Color;

public class Forest extends Hexagon {
	
	public Forest(int x, int y, int radius) {
		super(x, y, radius);
		// TODO Auto-generated constructor stub
	}

	private final float[] ForestRGBColor = Color.RGBtoHSB(0, 128, 0, null);

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.getHSBColor(ForestRGBColor[0], ForestRGBColor[1], ForestRGBColor[2]);
	}

}
