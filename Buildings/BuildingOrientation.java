package Buildings;

public enum BuildingOrientation {
	WEST_EAST, SWEST_NEAST, SEAST_NWEST;
	
	public static BuildingOrientation getOrientation(int index)
	{
		switch(index) 
		{
		case 0:
			return WEST_EAST;
		case 1:
			return SWEST_NEAST;
		case 2:
			return SEAST_NWEST;
		default:
			return WEST_EAST;
		}
	}
}
