import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDomino = new JButton("Domino");
		btnDomino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDomino menu = new MenuDomino();
				dispose();
				menu.setVisible(true);

			}
		});
		
	
		btnDomino.setBounds(5, 5, 94, 268);
		contentPane.add(btnDomino);

		
		
		JButton btnTriominos = new JButton("Triominos");
		btnTriominos.setBackground(new Color(255, 255, 255));
		btnTriominos.setForeground(new Color(0, 0, 0));
		btnTriominos.setBounds(351, 5, 94, 268);
		contentPane.add(btnTriominos);
		btnTriominos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDomino menu = new MenuDomino();
				dispose();
				menu.setVisible(true);

			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/cyrine/Desktop/Capture d’écran 2018-06-11 à 02.23.56.png"));
		lblNewLabel.setBounds(5, 0, 440, 273);
		contentPane.add(lblNewLabel);
	}
}
