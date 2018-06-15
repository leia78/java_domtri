import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Pseudos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private ArrayList<Joueur> joueurs;
	private JCheckBox IAs[];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pseudos frame = new Pseudos();
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
	public Pseudos() {
		IAs=new JCheckBox[4];
		joueurs=new ArrayList<Joueur>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		JLabel lblNombreDeJoueur = new JLabel("Nombre de joueur");
		lblNombreDeJoueur.setBounds(46, 56, 122, 16);
		contentPane.add(lblNombreDeJoueur);
	
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(3, 2, 4, 1));
		((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
		spinner.setValue(2);
		spinner.setBounds(169, 51, 34, 26);
		contentPane.add(spinner);
		
		
		textField = new JTextField();
		textField.setBounds(73, 121, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		
		
		
		
		
		
		
		
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(73, 159, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 196, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(73, 231, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		JLabel lblEntrezVotrePseudo = new JLabel("Entrez votre pseudo");
		lblEntrezVotrePseudo.setBounds(73, 93, 130, 16);
		contentPane.add(lblEntrezVotrePseudo);
		lblEntrezVotrePseudo.setVisible(false);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		IAs[0]=chckbxNewCheckBox;
		chckbxNewCheckBox.setBounds(226, 122, 28, 23);
		contentPane.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setVisible(false);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(226, 160, 28, 23);
		contentPane.add(chckbxNewCheckBox_1);
		IAs[1]=chckbxNewCheckBox_1;
		chckbxNewCheckBox_1.setVisible(false);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(226, 197, 28, 23);
		IAs[2]=chckbxNewCheckBox_2;
		contentPane.add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.setVisible(false);

		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(226, 232, 28, 23);
		IAs[3]=chckbxNewCheckBox_3;
		contentPane.add(chckbxNewCheckBox_3);
		chckbxNewCheckBox_3.setVisible(false);

		
		JLabel lblIa = new JLabel("  IA");
		lblIa.setBounds(226, 93, 28, 16);
		contentPane.add(lblIa);
		lblIa.setVisible(false);

		
		JButton btnChoisir = new JButton("choisir");
		btnChoisir.setBounds(217, 51, 87, 29);
		contentPane.add(btnChoisir);
		
		JButton btnOk = new JButton("ok");
		btnOk.setBounds(327, 243, 117, 29);
		contentPane.add(btnOk);
		btnOk.setVisible(false);
		
		
		
		
		
		btnChoisir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblEntrezVotrePseudo.setVisible(true);
				lblIa.setVisible(true);
				btnOk.setVisible(true);

				if( spinner.getValue().equals(2))
						{
					textField.setVisible(true);
					textField_1.setVisible(true);
					chckbxNewCheckBox_1.setVisible(true);
					chckbxNewCheckBox.setVisible(true);
					
					
					textField_2.setVisible(false);
					chckbxNewCheckBox_2.setVisible(false);
					textField_3.setVisible(false);
					chckbxNewCheckBox_3.setVisible(false);
					

						}
				else if (spinner.getValue().equals(3)) {
					
					textField.setVisible(true);
					textField_1.setVisible(true);
					chckbxNewCheckBox_1.setVisible(true);
					chckbxNewCheckBox.setVisible(true);
					textField_2.setVisible(true);
					chckbxNewCheckBox_2.setVisible(true);
					textField_3.setVisible(false);
					chckbxNewCheckBox_3.setVisible(false);
					
				}
				else {
					textField.setVisible(true);
					textField_1.setVisible(true);
					chckbxNewCheckBox_1.setVisible(true);
					chckbxNewCheckBox.setVisible(true);
					textField_2.setVisible(true);
					chckbxNewCheckBox_2.setVisible(true);
					textField_3.setVisible(true);
					chckbxNewCheckBox_3.setVisible(true);										
				}
				}
						
			});
	
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tabPseudo[]= {textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText()};
				for (int i=0;i<Integer.valueOf(spinner.getValue().toString());i++) {
					System.out.println(tabPseudo[i]+" "+IAs[i].isSelected());
					joueurs.add(new Joueur(tabPseudo[i], IAs[i].isSelected()));
				}
			}
		});
		
	}

	public ArrayList<Joueur> getJoueur() {
		return joueurs;
	}

	public void setJoueur(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
}