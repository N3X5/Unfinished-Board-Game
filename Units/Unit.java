package Units;

import java.awt.Graphics;
import java.awt.Point;

import Player.Player;

public abstract class Unit {
	
	protected Player owner;
	
	public Unit(Player owner) { this.owner = owner; }
	
	public abstract void draw(Graphics g, Point location);
}
