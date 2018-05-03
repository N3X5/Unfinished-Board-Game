package GUI.InputFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Player.Mouse;
import Player.Player;
import Player.Rabbit;
import Player.Rat;
import Player.Squirrel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InputFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static JFrame frame;
	private JPanel contentPane;
	private int numOfPlayers;
	private static List<JTextField> textFields = new ArrayList<JTextField>();
	@SuppressWarnings("rawtypes")
	private static List<JComboBox> comboBoxes = new ArrayList<JComboBox>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InputFrame() {
		frame = this;
		this.numOfPlayers = getNumberOfPlayers();
		
		setTitle("Welcome to the game!");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new PlayerDataProcessor());
		btnNewButton.setBounds(10, 88, 419, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblPlayer = new JLabel("Player 1");
		lblPlayer.setForeground(Color.RED);
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer.setBounds(73, 8, 46, 14);
		contentPane.add(lblPlayer);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 36, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		lblPlayer_1.setForeground(Color.BLUE);
		lblPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer_1.setBounds(168, 8, 46, 14);
		contentPane.add(lblPlayer_1);
		
		JLabel lblPlayer_2 = new JLabel("Player 3");
		lblPlayer_2.setForeground(Color.GREEN);
		lblPlayer_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer_2.setBounds(262, 8, 46, 14);
		contentPane.add(lblPlayer_2);
		
		JLabel lblPlayer_3 = new JLabel("Player 4");
		lblPlayer_3.setForeground(Color.PINK);
		lblPlayer_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer_3.setBounds(359, 8, 46, 14);
		contentPane.add(lblPlayer_3);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(47, 0, 2, 85);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(146, 0, 2, 85);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(242, 0, 2, 85);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(338, 0, 2, 85);
		contentPane.add(separator_3);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(10, 61, 46, 14);
		contentPane.add(lblClass);
		
		for(int i=0; i<4; i++) 
		{
			textFields.add(new JTextField());
			textFields.get(i).setBounds(55+(i*96), 33, 86, 20);
			contentPane.add(textFields.get(i));
			textFields.get(i).setColumns(10);
			
			String classChoices[] = {"Rabbit", "Squirrel", "Mouse", "Rat"};
			comboBoxes.add(new JComboBox(classChoices));
			comboBoxes.get(i).setBounds(59+(i*96), 58, 77, 20);
			contentPane.add(comboBoxes.get(i));
			
			if(i>=numOfPlayers) 
			{
				textFields.get(i).setEnabled(false);
				comboBoxes.get(i).setEnabled(false);
			}
		}
	}
	
	private int getNumberOfPlayers() 
	{
		Object[] arr = { 2, 3, 4 };
		int numberOfPlayers = -1;
		
		try {
			numberOfPlayers = (int) JOptionPane.showInputDialog(this, "How many players are going to play?", "Welcome to the game!", 
					JOptionPane.PLAIN_MESSAGE, new ImageIcon(), arr, "2");
		} catch(Exception e) { System.exit(0); }
		
		return numberOfPlayers;
	}

	protected static void showWarningMessage(UserWarningType type) 
	{
		String warningMessage = "";
		
		switch(type) 
		{
		case INVALID_NAME:
			warningMessage = "Please make sure that all players have valid names! (no spaces)";
			break;
		case REPEATING_NAMES:
			warningMessage = "Please make sure that all players have unique names!";
			break;
		case REPEATING_CLASSES:
			warningMessage = "Please make sure that all player have unique classes!";
			break;
		}
		
		JOptionPane.showMessageDialog(frame, warningMessage, "Warning!", JOptionPane.WARNING_MESSAGE);
	}
	
	protected static List<String> getPlayerNames() 
	{
		List<String> names = new ArrayList<String>();
		
		for(JTextField field: textFields) 
		{
			if(field.isEnabled())
				names.add(field.getText());
		}
		return names;
	}

	protected static List<Integer> getPlayerClassSelectionIndexes() 
	{
		List<Integer> playerClassSelectionIndexes = new ArrayList<Integer>();
		
		for(@SuppressWarnings("rawtypes") JComboBox box: comboBoxes) 
		{
			if(box.isEnabled())
				playerClassSelectionIndexes.add(box.getSelectedIndex());
		}
		
		return playerClassSelectionIndexes;
	}
}
