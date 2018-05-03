package GUI.InputFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.MainFrame;
import Player.Mouse;
import Player.Player;
import Player.Rabbit;
import Player.Rat;
import Player.Squirrel;

public class PlayerDataProcessor implements ActionListener {
	
	private List<String> names;
	private List<Integer> classSelectionIndexes;

	@Override
	public void actionPerformed(ActionEvent e) {
		names = InputFrame.getPlayerNames();
		classSelectionIndexes = InputFrame.getPlayerClassSelectionIndexes();
		
		if(hasDuplicates(names)) { InputFrame.showWarningMessage(UserWarningType.REPEATING_NAMES); return; }
		else if(hasDuplicates(classSelectionIndexes)) { InputFrame.showWarningMessage(UserWarningType.REPEATING_CLASSES); return; }
		
		for(String name: names) {
			if(name.length()==0 || name.indexOf(' ')!=-1) { InputFrame.showWarningMessage(UserWarningType.INVALID_NAME); return; }
		}
		
		for(int i=0; i<classSelectionIndexes.size(); i++) 
		{
			int index = classSelectionIndexes.get(i);
			String name = names.get(i);
			
			switch(index) 
			{
			case 0:
				Player.playerList.add(new Rabbit(name));
				break;
			case 1:
				Player.playerList.add(new Squirrel(name));
				break; 
			case 2:
				Player.playerList.add(new Mouse(name));
				break;
			case 3:
				Player.playerList.add(new Rat(name));
				break;
			}
		}
		
		MainFrame.currentPlayerLabel.setText(Player.playerList.get(0).getName());
		MainFrame.currentPlayerLabel.setForeground(Color.RED);
		MainFrame.hideFrame(false);
		InputFrame.frame.dispose();
	}
	
	private <T> boolean hasDuplicates(Iterable<T> all) {
	    Set<T> set = new HashSet<T>();
	    for (T each: all) if (!set.add(each)) return true;
	    return false;
	}

}
