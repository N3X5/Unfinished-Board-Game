package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import GUI.InputFrame.InputFrame;
import Player.Player;
import Tiles.Hexagon;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrame {

	public static JFrame frame;
	public static JPanel panel;
	public static JToggleButton tglbtnBuildBridge = new JToggleButton("Build Bridge");
	public static JToggleButton tglbtnBuildTunnel = new JToggleButton("Build Tunnel");
	public static JToggleButton tglbtnBuildHouse = new JToggleButton("Build House");
	public static JToggleButton tglbtnBuildCastle = new JToggleButton("Build Castle");
	public static JToggleButton tglbtnDemolishBuilding = new JToggleButton("Demolish Building");
	public static JToggleButton tglbtnUpgrageBuilding = new JToggleButton("Upgrage Building");
	public static NoneSelectedButtonGroup buildingButtonGroup = new NoneSelectedButtonGroup();
	private final JLabel lblNowPlaying = new JLabel("Now Playing:");
	public static JLabel currentPlayerLabel = new JLabel("");
	private final JButton btnShowResources = new JButton("Show Resources");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Hexagon.buildHexagList();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					new InputFrame();
					new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Card Game Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout());
		panel = new MainPanel();
		panel.setSize(new Dimension(800, 600));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hexagon.buildHexagList();
				MainFrame.panel.repaint();
			}
		});
		btnNewButton.setBounds(859, 21, 89, 23);
		panel.add(btnNewButton);
		
		tglbtnBuildBridge.setBounds(772, 55, 121, 23);
		panel.add(tglbtnBuildBridge);
		
		tglbtnBuildTunnel.setBounds(913, 55, 121, 23);
		panel.add(tglbtnBuildTunnel);
		
		tglbtnBuildHouse.setBounds(772, 89, 121, 23);
		panel.add(tglbtnBuildHouse);
		
		tglbtnBuildCastle.setBounds(913, 89, 121, 23);
		panel.add(tglbtnBuildCastle);
		
		buildingButtonGroup.add(tglbtnBuildBridge);
		buildingButtonGroup.add(tglbtnBuildTunnel);
		buildingButtonGroup.add(tglbtnBuildHouse);
		buildingButtonGroup.add(tglbtnBuildCastle);
		buildingButtonGroup.add(tglbtnUpgrageBuilding);
		buildingButtonGroup.add(tglbtnDemolishBuilding);
		tglbtnDemolishBuilding.setFont(new Font("Tahoma", Font.PLAIN, 10));

		tglbtnDemolishBuilding.setBounds(913, 123, 121, 23);
		panel.add(tglbtnDemolishBuilding);
		tglbtnUpgrageBuilding.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		tglbtnUpgrageBuilding.setBounds(772, 123, 121, 23);
		panel.add(tglbtnUpgrageBuilding);
		lblNowPlaying.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNowPlaying.setBounds(831, 558, 62, 14);
		
		panel.add(lblNowPlaying);
		currentPlayerLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		currentPlayerLabel.setBounds(902, 558, 132, 14);
		
		panel.add(currentPlayerLabel);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player.endTurnForPlayer();
				currentPlayerLabel.setText(Player.getPlayerOnTurn().getName());
			}
		});
		btnEndTurn.setBounds(859, 515, 89, 23);
		panel.add(btnEndTurn);
		btnShowResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = Player.getPlayerOnTurn();
				
				showMessage(player.getName()+" has:\n" +
						"Straw: " + player.getStrawCount() + 
						"\nStone: " + player.getStoneCount() +
						"\nOre: " + player.getOreCount() +
						"\nWood: " + player.getWoodCount());
			}
		});
		btnShowResources.setBounds(847, 481, 111, 23);
		
		panel.add(btnShowResources);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
		frame.setSize(1050, 640);
	}
	
	public static void hideFrame(boolean flag) { frame.setVisible(!flag); }

	public static void showMessage(String message) 
	{
		JOptionPane.showMessageDialog(frame, message);
	}
}
