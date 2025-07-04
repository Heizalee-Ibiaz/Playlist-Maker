//Heizalee C. Ibiaz    BSCpE 3

//REFERENCES:
//Bro Code.Bro Code. (2020, September 14). Java GUI: Full Course ☕ (FREE). Youtube URL https://www.youtube.com/watch?v=Kmgo00avvEw&t=347s
//BoostMyTool. BoostMyTool. (2021, June 9). Install and Use WindowBuilder with Eclipse IDE 2021. Youtube URL https://www.youtube.com/watch?v=7HChmKwOUzw

package midtermsdll;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class playlistmaker extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Playlist playlist;
	private JLabel currentsong;
	
	private JPanel bg;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public playlistmaker() {
		// declare Playlist class as playlist so that we can call it here
		playlist = new Playlist();
		
		// icons
		setTitle("MY TREASURE PLAYLIST MAKER");
		ImageIcon tmap = new ImageIcon("trsrlogo.jpg");
		setIconImage(tmap.getImage());
		
		//frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 25, 892, 669);
		bg = new JPanel();
		bg.setBackground(Color.BLACK);
		bg.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(bg);
		bg.setLayout(null);
		
		JPanel screen = new JPanel();
		screen.setBounds(10, 11, 472, 301);
		bg.add(screen);
		screen.setLayout(null);
		
		JLabel treasure = new JLabel("");
		treasure.setBounds(0, 66, 385, 225);
		screen.add(treasure);
		
		// bg image 
		ImageIcon reboot = new ImageIcon("bonabona.jpg");
		
		treasure.setIcon(reboot);
		treasure.setOpaque(false);
		treasure.setBounds(0, 0, 472, 296);
		
		
		
		JPanel panelone = new JPanel();
		panelone.setBounds(10, 307, 858, 204);
		bg.add(panelone);
		panelone.setLayout(null);
		
		// declaring currentsong as new Jlabel and it will take note what the user inputted 
		currentsong = new JLabel("Add your favorite song :");
		currentsong.setFont(new Font("Tahoma", Font.BOLD, 30));
		currentsong.setBounds(53, 70, 623, 36);
		panelone.add(currentsong);
		
		// title
		JLabel iwyltitle = new JLabel("my treasure playlist < currently making >");
		iwyltitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		iwyltitle.setBounds(267, 30, 443, 29);
		panelone.add(iwyltitle);
		
		JPanel paneltwo = new JPanel();
		paneltwo.setBackground(Color.DARK_GRAY);
		paneltwo.setBounds(10, 510, 858, 114);
		bg.add(paneltwo);
		paneltwo.setLayout(null);
		
		// --------------------------- NEXT BUTTON -----------------------
		JButton nextbuttontrsr = new JButton("Next");
		nextbuttontrsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlist.nextSong();
				updatecurrentsong();
			}
		});
		nextbuttontrsr.setForeground(Color.WHITE);
		nextbuttontrsr.setBackground(new Color(0, 0, 0));
		nextbuttontrsr.setFont(new Font("Tahoma", Font.BOLD, 20));
		nextbuttontrsr.setBounds(302, 11, 131, 92);
		paneltwo.add(nextbuttontrsr);
		
		// --------------------------- PREVIOUS BUTTON -----------------------
		JButton previousbuttontrsr = new JButton("Previous");
		previousbuttontrsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlist.prevSong();
				updatecurrentsong();
			}
		});
		previousbuttontrsr.setForeground(new Color(255, 255, 255));
		previousbuttontrsr.setBackground(new Color(0, 0, 0));
		previousbuttontrsr.setFont(new Font("Tahoma", Font.BOLD, 20));
		previousbuttontrsr.setBounds(20, 11, 131, 92);
		paneltwo.add(previousbuttontrsr);
		
		// --------------------------- REMOVE BUTTON -----------------------
		JButton removebuttontrsr = new JButton("Delete");
		removebuttontrsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlist.removeCurrentSong();
				updatecurrentsong();
			}
		});
		removebuttontrsr.setBounds(161, 11, 131, 92);
		paneltwo.add(removebuttontrsr);
		removebuttontrsr.setForeground(Color.WHITE);
		removebuttontrsr.setBackground(Color.BLACK);
		removebuttontrsr.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		// --------------------------- ADD AT BEGINNING BUTTON -----------------------
		JButton addbuttonbegtrsr = new JButton("Add at Beginning");
		addbuttonbegtrsr.setBounds(606, 11, 231, 33);
		paneltwo.add(addbuttonbegtrsr);
		addbuttonbegtrsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titlesong = JOptionPane.showInputDialog("Enter Song title: ");
				if (titlesong != null && !titlesong.isEmpty()) {
					playlist.addSongAtBeginning(titlesong);
					updatecurrentsong();
					
				}	
			}
		});
		
		
		addbuttonbegtrsr.setForeground(new Color(255, 255, 255));
		addbuttonbegtrsr.setBackground(new Color(0, 0, 0));
		addbuttonbegtrsr.setFont(new Font("Tahoma", Font.BOLD, 20));
		

		// --------------------------- ADD AT POSITION BUTTON -----------------------
		JButton addbuttonpostrsr = new JButton("Add at Position");
		addbuttonpostrsr.setBounds(606, 45, 231, 28);
		paneltwo.add(addbuttonpostrsr);
		addbuttonpostrsr.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String titlesong = JOptionPane.showInputDialog("Enter Song title: ");
		        if (titlesong != null && !titlesong.isEmpty()) {
		            String positionStr = JOptionPane.showInputDialog("Enter the position to add the song: ");
		            if (positionStr != null && !positionStr.isEmpty()) {
		                try {
		                    int position = Integer.parseInt(positionStr);
		                    playlist.addSongAtPosition(titlesong, position);
		                    updatecurrentsong();
		                } catch (NumberFormatException ex) {
		                    JOptionPane.showMessageDialog(null, "Invalid position. Please enter a valid integer.");
		                }
		            }
		        }
		    }
		});		
		
		addbuttonpostrsr.setFont(new Font("Tahoma", Font.BOLD, 20));
		addbuttonpostrsr.setForeground(new Color(255, 255, 255));
		addbuttonpostrsr.setBackground(new Color(0, 0, 0));
		

		// --------------------------- ADD AT END BUTTON -----------------------
		
		JButton addbuttonendtrsr = new JButton("Add at End");
		addbuttonendtrsr.setBounds(606, 75, 231, 28);
		paneltwo.add(addbuttonendtrsr);
		addbuttonendtrsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titlesong = JOptionPane.showInputDialog("Enter Treasure Song title: ");
				if (titlesong != null && !titlesong.isEmpty()) {
					playlist.addSongAtEnd(titlesong);
					updatecurrentsong();
				
				}
			}
		});
		addbuttonendtrsr.setBackground(new Color(0, 0, 0));
		addbuttonendtrsr.setForeground(new Color(255, 255, 255));
		addbuttonendtrsr.setFont(new Font("Tahoma", Font.BOLD, 20));
		

		// --------------------------- SEARCH BUTTON -----------------------
		JButton searchbuttontrsr = new JButton("Search");
		searchbuttontrsr.setBounds(454, 11, 131, 92);
		paneltwo.add(searchbuttontrsr);
		searchbuttontrsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titlesong = JOptionPane.showInputDialog("Enter Treasure Song title to search: ");
                if (titlesong != null && !titlesong.isEmpty()) {
                    Songplay foundSong = playlist.searchSong(titlesong);
                    if (foundSong != null) {
                        JOptionPane.showMessageDialog(null, "Treasure Song found: " + foundSong.title);
                    } else {
                        JOptionPane.showMessageDialog(null, "Treasure song not found.");
                    }
                }
            }
        });
		
		searchbuttontrsr.setBackground(new Color(0, 0, 0));
		searchbuttontrsr.setForeground(new Color(255, 255, 255));
		searchbuttontrsr.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		// --------------------DESIGNS------------------
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.DARK_GRAY);
		panel3.setBounds(481, 11, 387, 310);
		bg.add(panel3);
		panel3.setLayout(null);
		
		JLabel title = new JLabel("playlist.");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 32));
		title.setBounds(20, 82, 260, 96);
		panel3.add(title);
		
		JLabel playlistmaker = new JLabel("make your own playlist and add your favorite songs!");
		playlistmaker.setForeground(Color.WHITE);
		playlistmaker.setFont(new Font("Tahoma", Font.ITALIC, 15));
		playlistmaker.setBounds(20, 156, 351, 36);
		panel3.add(playlistmaker);
		
		JLabel trsr = new JLabel("MY TREASURE ");
		trsr.setForeground(Color.WHITE);
		trsr.setFont(new Font("Tahoma", Font.BOLD, 40));
		trsr.setBounds(22, 46, 365, 85);
		panel3.add(trsr);
		
		JLabel creatorname = new JLabel("Heizalee C. Ibiaz");
		creatorname.setFont(new Font("Tahoma", Font.ITALIC, 8));
		creatorname.setForeground(new Color(255, 255, 255));
		creatorname.setBounds(320, 273, 110, 14);
		panel3.add(creatorname);
	}
	

	// --------------------------- UPDATE CURRENT SONG -----------------------
	private void updatecurrentsong() {
		currentsong.setText("Current Song: "  + playlist.getCurrentSong());
    }


	// --------------------------- TO RUN -----------------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new playlistmaker().setVisible(true);
                
           
            }
        });
    }
}


