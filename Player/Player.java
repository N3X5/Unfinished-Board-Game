package Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	
	private static int playerOnTurn = 1;
	public static List<Player> playerList = new ArrayList<Player>();
	private String name;
	private int straw = 0, stone = 0, ore = 0, wood = 0;
	
	public Player(String name) { this.name = name; }
	public String getName() { return name; }
	public static Player getPlayerOnTurn() { return playerList.get(playerOnTurn-1); }
	public static void endTurnForPlayer() { if(playerOnTurn!=playerList.size()) playerOnTurn++; else playerOnTurn = 1; }
	
	public int getStrawCount() { return straw; }
	public int getStoneCount() { return stone; }
	public int getOreCount() { return ore; }
	public int getWoodCount() { return wood; }
}
