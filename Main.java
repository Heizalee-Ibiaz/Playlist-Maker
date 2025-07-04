//Heizalee C. Ibiaz    BSCpE 3

// REFERENCES:
//Bro Code.Bro Code. (2020, September 14). Java GUI: Full Course ☕ (FREE). Youtube URL https://www.youtube.com/watch?v=Kmgo00avvEw&t=347s
//BoostMyTool. BoostMyTool. (2021, June 9). Install and Use WindowBuilder with Eclipse IDE 2021. Youtube URL https://www.youtube.com/watch?v=7HChmKwOUzw

package midtermsdll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) { // call the intro class to run 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro welcome = new intro();
					welcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
