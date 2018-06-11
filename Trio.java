import java.awt.Graphics;
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


public class Trio extends JButton implements MouseListener{
	
	JPanel pan=new JPanel();
	private BufferedImage i111, rot;
    
	Trio(){
		try {
			i111 = ImageIO.read(new File("00_helo/1_1_1.png"));
			//rot = ImageIO.read(new File("00_helo/rot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addMouseListener(this);
	}


	public void paintComponent(Graphics g){
		g.drawImage(i111, 0, 0, null);
		this.setBounds(0,0,75,75);
		this.setBorderPainted(false);
		/*g.drawImage(rot, 0, 0, null);
		this.setBounds(100,100,75,75);
		this.setBorderPainted(false);*/
		/*
		ImageIcon myImage = new ImageIcon("00_helo/rot.png");
		JButton button = new JButton(myImage);
		button.setVisible(false);*/
	}

	public void mouseClicked(MouseEvent e) {
		
		System.out.println("Cliqué\n");
		new Rotation();

	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

/*
	public void rotation(){

		//this.setVisible(true);

		
	}*/
	
}
