package Tiles;

import java.awt.Color;

public class Rock extends Hexagon {

	public Rock(int x, int y, int radius) {
		super(x, y, radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.GRAY;
	}
}
