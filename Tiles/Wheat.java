package Tiles;

import java.awt.Color;

public class Wheat extends Hexagon {

	public Wheat(int x, int y, int radius) {
		super(x, y, radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor() {
		return Color.ORANGE;
	}
}
