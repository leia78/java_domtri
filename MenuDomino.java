import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class MenuDomino extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDomino frame = new MenuDomino();
					
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
	public MenuDomino() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMultiPlayer = new JButton("Multiplayer");
	
		btnMultiPlayer.setBounds(160, 112, 146, 29);
		contentPane.add(btnMultiPlayer);
		btnMultiPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pseudos pseudo= new Pseudos();
				dispose();
				pseudo.setVisible(true);

			}
		});
		
		
		
		
		
		
		JButton btnScores = new JButton("Scores");
		btnScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			


				
			}
		});
		btnScores.setBounds(160, 153, 146, 29);
		contentPane.add(btnScores);
		
		JButton btnQitter = new JButton("Retour");
		btnQitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu=new Menu();
				dispose();
				menu.setVisible(true);

			}
		});
		btnQitter.setBounds(160, 194, 146, 29);
		contentPane.add(btnQitter);
		
		JButton btnSingleLayer = new JButton("Single Player");
		btnSingleLayer.setBounds(160, 70, 146, 29);
		contentPane.add(btnSingleLayer);
		
	
		
		
	}

}
