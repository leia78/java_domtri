import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class Trio extends JButton implements ActionListener{
	
	private BufferedImage i111,vide, rot;
    
	Trio(){
		try {
			i111 = ImageIO.read(new File("00_helo/1_1_1.png"));
			vide = ImageIO.read(new File("00_helo/vide.png"));

			//rot = ImageIO.read(new File("00_helo/rot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addActionListener(this);
	}


	public void paintComponent(Graphics g){
		int posY = 630, posX=0;
		int nbpiont = 7; //a recuperer
		
		//PIONT JOUEUR
		switch(nbpiont)	//adapter affichage selon nombre de piont
		{
			case 7:
				posX = 50;
				break;
			case 6:
				posX = 100;
				break;
			case 5:
				posX = 150;
				break;
			case 4:
				posX = 200;
				break;
			case 3:
				posX = 270;
				break;
			case 2:
				posX = 320;
				break;
			case 1:
				posX = 400;
				break;
		}
		
		for(int i=0; i<nbpiont;i++){
			g.drawImage(i111, posX, posY, null);
			this.setBorderPainted(false);
			posX = posX+ 130;
		}
		//PIOCHE
		 int nbPioche=3; //a recuperer
		 
		 if(nbPioche>0)
		 {
			 g.drawImage(vide, 0, 0, null);
		 }

	}
	public void actionPerformed(ActionEvent e) {
			
		System.out.println("Cliqué\n");
		Rotation ro = new Rotation();
	}
	
	
}
