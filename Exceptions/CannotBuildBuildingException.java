package Exceptions;

import Buildings.BuildingType;
import GUI.MainFrame;

public class CannotBuildBuildingException extends Throwable {
	
	private BuildingType buildingType;
	
	public CannotBuildBuildingException(BuildingType type) { buildingType = type; }
	
	public void printErrorToUser() 
	{
		String message = "";
		
		switch(buildingType) {
		case CASTLE:
			message = "You cannot build castles on mountains!";
			break;
		case HOUSE:
			message = "You cannot build houses over water or on mountains!";
			break;
		case BRIDGE:
			message = "You can only build bridges over water!";
			break;
		case TUNNEL:
			message = "You can only build tunnels under mountains!";
			break;
		}
		
		MainFrame.showMessage(message);
	}
}
