package Exceptions;

import Tiles.Hexagon;

public class MultipleSelectionException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MultipleSelectionException(int count) 
	{
		for(Hexagon hexag: Hexagon.hexagList) 
		{
			if (count==1) break;
			
			if(hexag.isSelected()) 
			{
				hexag.deselect();
				count--;
			}
		}
	}

}
