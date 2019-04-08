package RPSLS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class Driver extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlayer_2;
	String h = "";
	int l = 0, w = 0, t = 0, outOf = 3, w1 = 0, w2 = 0, t2 = 0;
	private JTextField txtPlayer;
	private JTextField txtPlayer_1;
	Player p1, p2;
	JLabel lblNoScoresYet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver frame = new Driver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Driver() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Driver.class.getResource("/RPSLS/she.png")));
		setTitle("Rock Paper Scissors Lizard Spock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("<html>Are you ready to play a game of <span style=\"color: purple;\"><i>Rock-Paper-Scissors-Lizard-Spock?</i></span> Similar to the classic game of Rock-Paper-Scissors, Rock-Paper-Scissors-Lizard-Spock is a game where players face each other and battle using hand gestures. This game adds two new moves - Lizard and Spock. Can you successfully defeat the Big Bang Theory cast in their own game? Make a choice and press the button to start!  <br><br></html>");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.menu);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Player Vs. Computer", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Rock (beats Scissors and Lizard, weak to Paper and Spock)", "Paper (beats Rock and Spock, weak to Scissors and Lizard)", "Scissors (beats Paper and Lizard, weak to Spock and Rock)", "Lizard (beats Paper and Spock, weak to Scissors and Rock)", "Spock (beats Scissors and Rock, weak to Paper and Lizard)"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list, BorderLayout.CENTER);
		list.setValueIsAdjusting(true);
		list.setBorder(new TitledBorder(null, "Choices", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBackground(SystemColor.menu);
		
		JLabel label = new JLabel("<html>No scores yet.</html>");
		panel.add(label, BorderLayout.EAST);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEnterYourName = new JLabel("      Enter your name here:      ");
		panel_2.add(lblEnterYourName, BorderLayout.WEST);
		
		txtPlayer_2 = new JTextField();
		txtPlayer_2.setText("Player 1");
		panel_2.add(txtPlayer_2, BorderLayout.CENTER);
		txtPlayer_2.setColumns(10);
		
		
		JButton button = new JButton("Make Your Move");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/////////////////////
				// Single Player Game
				/////////////////////
				
				String x = (String) list.getSelectedValue(), k = "", j = txtPlayer_2.getText();
				Choice y = Choice.Rock, z = null;
				switch (x) {
				case "Rock (beats Scissors and Lizard, weak to Paper and Spock)":
					y = Choice.Rock;
					break;
				case "Paper (beats Rock and Spock, weak to Scissors and Lizard)":
					y = Choice.Paper;
					break;
				case "Scissors (beats Paper and Lizard, weak to Spock and Rock)":
					y = Choice.Scissors;
					break;
				case "Lizard (beats Paper and Spock, weak to Scissors and Rock)":
					y = Choice.Lizard;
					break;
				case "Spock (beats Scissors and Rock, weak to Paper and Lizard)":
					y = Choice.Spock;
					break;
				}
				double qq = Math.random();
				if (qq <= .2) {
					z = Choice.Rock;
				} else if (qq <= .4) {
					z = Choice.Paper;
				} else if (qq <= .6) {
					z = Choice.Scissors;
				} else if (qq <= .8) {
					z = Choice.Lizard;
				} else {
					z = Choice.Spock;
				}
				
				double pp = Math.random();
				if (pp  <= .2) {
					k = "Penny";
				} else if (pp <= .4) {
					k = "Howard";
				} else if (pp <= .6) {
					k = "Raj";
				} else if (pp <= .8) {
					k = "Leonard";
				} else {
					k = "Sheldon";
				} 
				
				Player you = new Human(j, y);
				Player yourOpponent = new Opponent(k, z, "null.jpg");
				
				
				if (y.win(z)) {
					h = you.getName() + " beat " + yourOpponent.getName() + "'s <i>" + z.getName() + "</i> with your <i>" + y.getName() + "</i>.";
					w++;
				} else if (y == z) {
					h = "Both players chose <i>" + z.getName() + "</i>. No one wins."; 
 				} else {
					h = you.getName() + "'s <i>" + y.getName() + "</i> lost to " + yourOpponent.getName() + "'s <i>" + z.getName() + "</i>.";
					l++;
				}
				t++;
				
				label.setText("<html>" + h + "<br><br><span style=\"color: navy;\">Wins: " + w + "</span><br><span style=\"color: maroon;\">Losses: " + l + "</span><br><span style=\"color: green;\">Total Games: "+ t +"</span>");
				
				////////////////
				// End of game
				////////////////
				
			}
		});
		panel.add(button, BorderLayout.SOUTH);
		button.setToolTipText("Game made by Blake Chambers and Gabe Pinto");
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Player Vs. Player", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		txtPlayer = new JTextField();
		txtPlayer.setToolTipText("");
		txtPlayer.setText("Player 1");
		panel_3.add(txtPlayer, BorderLayout.NORTH);
		txtPlayer.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setValueIsAdjusting(true);
		list_1.setBorder(new TitledBorder(null, "Choices", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list_1.setBackground(SystemColor.menu);
		panel_3.add(list_1, BorderLayout.CENTER);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		txtPlayer_1 = new JTextField();
		txtPlayer_1.setToolTipText("");
		txtPlayer_1.setText("Player 2");
		txtPlayer_1.setColumns(10);
		panel_4.add(txtPlayer_1, BorderLayout.NORTH);
		
		JList list_2 = new JList();
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setValueIsAdjusting(true);
		list_2.setBorder(new TitledBorder(null, "Choices", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list_2.setBackground(SystemColor.menu);
		panel_4.add(list_2, BorderLayout.CENTER);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//////////////////////
				// Player One Choice
				//////////////////////
				
				String listChoice = (String) list_1.getSelectedValue(), playerOneName = "";
				Choice playerOneChoice = null;
				
				switch (listChoice) {
				case "Rock":
					playerOneChoice = Choice.Rock;
					break;
				case "Paper":
					playerOneChoice = Choice.Paper;
					break;
				case "Scissors":
					playerOneChoice = Choice.Scissors;
					break;
				case "Lizard":
					playerOneChoice = Choice.Lizard;
					break;
				case "Spock":
					playerOneChoice = Choice.Spock;
					break;					
				}
				playerOneName = txtPlayer.getText();
				p1 = new Human(playerOneName, playerOneChoice);
				
				list_1.clearSelection();
				list_1.setEnabled(false);
				
				if (!list_1.isEnabled() && !list_2.isEnabled()) {
					runMultiplayerGame();
					list_1.setEnabled(true);
					list_2.setEnabled(true);
				}
				
			}
		});
		panel_3.add(btnChoose, BorderLayout.SOUTH);
		
		
		JButton btnNewButton = new JButton("Choose");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//////////////////////
				// Player Two Choice
				//////////////////////
				
				String listChoice = (String) list_2.getSelectedValue(), playerTwoName = "";
				Choice playerTwoChoice = null;
				
				switch (listChoice) {
				case "Rock":
					playerTwoChoice = Choice.Rock;
					break;
				case "Paper":
					playerTwoChoice = Choice.Paper;
					break;
				case "Scissors":
					playerTwoChoice = Choice.Scissors;
					break;
				case "Lizard":
					playerTwoChoice = Choice.Lizard;
					break;
				case "Spock":
					playerTwoChoice = Choice.Spock;
					break;					
				}
				playerTwoName = txtPlayer_1.getText();
				p2 = new Human(playerTwoName, playerTwoChoice);
				
				list_2.clearSelection();
				list_2.setEnabled(false);
				
				if (!list_1.isEnabled() && !list_2.isEnabled()) {
					runMultiplayerGame();
					list_1.setEnabled(true);
					list_2.setEnabled(true);
				}
				
			}
		});
		panel_4.add(btnNewButton, BorderLayout.SOUTH);
		
		
		
		
		lblNoScoresYet = new JLabel("No scores yet.");
		lblNoScoresYet.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNoScoresYet, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Settings", null, panel_5, null);
		
		JLabel lblBestOutOf = new JLabel("Best out of how many games?");
		panel_5.add(lblBestOutOf);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(3), new Integer(1), null, new Integer(2)));
		spinner.setValue(outOf);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int outOf = (int) spinner.getValue();
			}
		});
		((DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
		panel_5.add(spinner);
	}
	
	public void runMultiplayerGame() {
		String result = "";
		if (p1.getChoice().win(p2.getChoice())) {
			result = "<html>" + p1.getName() + " chose <i>" + p1.getChoice() + "</i>.<br><br>" + p2.getName() + " chose <i>" + p2.getChoice() + "</i>.<br><br>" + p1.getChoice() + " beats " + p2.getChoice() + ".<br><br> " + p1.getName() + " wins!";
			w1++;
		} else if (p1.getChoice() == p2.getChoice()) {
			result = "<html>" + p1.getName() + " and " + p2.getName() + " chose <i>" + p1.getChoice() + "</i>.<br><br> The game ends in a tie.</html>";
		} else if (p2.getChoice().win(p1.getChoice())) {
			result = "<html>" + p1.getName() + " chose <i>" + p1.getChoice() + "</i>.<br><br>" + p2.getName() + " chose <i>" + p2.getChoice() + "</i>.<br><br>" + p2.getChoice() + " beats " + p1.getChoice() + ".<br><br> " + p2.getName() + " wins!";
			w2++;
		}
		t2++;
		
		if(t2 >= outOf && w1 > w2) {
			result += "<br><br><span style=\"color: green;\">Overall, " + p1.getName() + " wins the game! </span></html>";
		} else if(t2 >= outOf && w1 < w2) {
			result += "<br><span style=\"color: green;\">" + p2.getName() + " wins the game! </span></html>";
		}
		lblNoScoresYet.setText(result);
	}
}
