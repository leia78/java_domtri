import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
class MaFenetre extends JFrame
{
	public MaFenetre()
	{
		setTitle("titre");
		setBounds(0,0,1100,900);
		
		JPanel pan = new JPanel();
		Container page = getContentPane();

		page.setLayout(new BorderLayout());
		pan.setLayout(new FlowLayout());

 
		BoutonTrio[] bouton = new BoutonTrio[9];
		for(int i=0; i<9; i++)
		{
			bouton[i] = new BoutonTrio(""+i,"00_helo/1_1_1.png");
			bouton[i].setPreferredSize(new Dimension(75, 75));
			bouton[i].setBorderPainted(false);
			pan.add(bouton[i]);
			
		}
		page.add(pan,BorderLayout.SOUTH);	
	}
}
 
public class Main
{
	public static void main(String args[])
	{
		MaFenetre fen = new MaFenetre();
		fen.setVisible(true);
	}
}