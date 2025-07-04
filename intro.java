//Heizalee C. Ibiaz    BSCpE 3

// REFERENCES:
//Bro Code.Bro Code. (2020, September 14). Java GUI: Full Course ☕ (FREE). Youtube URL https://www.youtube.com/watch?v=Kmgo00avvEw&t=347s
//BoostMyTool. BoostMyTool. (2021, June 9). Install and Use WindowBuilder with Eclipse IDE 2021. Youtube URL https://www.youtube.com/watch?v=7HChmKwOUzw

package midtermsdll;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class intro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel backgrounder;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) { // call the playlistmaker class to run
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playlistmaker mainframe = new playlistmaker();
					mainframe.setVisible(true);
					this.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public intro() { 
		
		// icons and designs
		setTitle("MY TREASURE PLAYLIST MAKER");
		ImageIcon tmap = new ImageIcon("trsrlogo.jpg");
		setIconImage(tmap.getImage());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 25, 892, 669);
		backgrounder = new JPanel();
		backgrounder.setBackground(new Color(0, 0, 0));
		backgrounder.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(backgrounder);
		backgrounder.setLayout(null);
		
		JPanel board1 = new JPanel();
		board1.setBackground(Color.DARK_GRAY);
		board1.setBounds(10, 11, 858, 611);
		backgrounder.add(board1);
		board1.setLayout(null);
		
		JPanel paneltrsr = new JPanel();
		paneltrsr.setBackground(Color.DARK_GRAY);
		paneltrsr.setBounds(0, 0, 858, 370);
		board1.add(paneltrsr);
		paneltrsr.setLayout(null);
		
		JLabel trsrpanel = new JLabel("");
		trsrpanel.setBackground(new Color(192, 192, 192));
		trsrpanel.setBounds(0, 0, 857, 467);
		paneltrsr.add(trsrpanel);
		
		// bg icon
		ImageIcon trejo = new ImageIcon("trejolover.jpg");
		
		trsrpanel.setIcon(trejo);
		trsrpanel.setOpaque(false);
		trsrpanel.setBounds(0, 0, 857, 467);
		
		// ---------------------- START BUTTON -----------------------
		JButton startbuttontrsr = new JButton("START");
		startbuttontrsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == startbuttontrsr) {
	        		playlistmaker welcome = new playlistmaker();
	        		welcome.setVisible(true);
	        		this.setVisible(false);
				}
			}

			private void setVisible(boolean b) {
				
			}
		});
		startbuttontrsr.setForeground(new Color(255, 255, 255));
		startbuttontrsr.setBackground(new Color(0, 0, 0));
		startbuttontrsr.setFont(new Font("Tahoma", Font.BOLD, 30));
		startbuttontrsr.setBounds(324, 510, 220, 60);
		board1.add(startbuttontrsr);
		
		JLabel createlabel = new JLabel("Create your own playlist and add your treasure songs!");
		createlabel.setForeground(new Color(255, 255, 255));
		createlabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		createlabel.setBounds(254, 464, 397, 24);
		board1.add(createlabel);
		
		JLabel treasureplaylist = new JLabel("MY TREASURE PLAYLIST");
		treasureplaylist.setForeground(new Color(255, 255, 255));
		treasureplaylist.setFont(new Font("Tahoma", Font.BOLD, 35));
		treasureplaylist.setBounds(216, 391, 452, 73);
		board1.add(treasureplaylist);
	}
}
