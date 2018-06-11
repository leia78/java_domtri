package menu_domino;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Pioche {
	
	protected ArrayList<Pion> m_lpioche = new ArrayList<Pion>();
	protected ArrayList<Pion> m_ljoueur = new ArrayList<Pion>();
	protected int m_nombrejoueur = 0;
	protected int m_taille = m_lpioche.size();
	
	public Pioche(int nombre)
	{
		this.m_nombrejoueur = nombre;
	}
	public Pioche(ArrayList<Pion> pioche,int taille )
	{
		this.m_lpioche=pioche;
		this.m_taille=taille;
	}

	public ArrayList<Pion> getM_lpioche() {
		return m_lpioche;
	}

	public void setM_lpioche(ArrayList<Pion> m_lpioche) {
		this.m_lpioche = m_lpioche;
	}

	public int getM_taille() {
		return m_taille;
	}

	public void setM_taille(int m_taille) {
		this.m_taille = m_taille;
	}
	
	
	 
	public void initlistetrio()       //la fonction qui initialise
	{
		int a = 0,b = 0, c = 0;
			for(int i = 0 ; i < 56 ; i++)
			{
				
				Pion p= new Pion();
				
				p.m_lnum.add(new Integer(a));
				p.m_lnum.add(new Integer(b));
			    p.m_lnum.add(new Integer(c));
			    
			    /*creation d'un pion*/
				//m_lpioche.addp.get(m_lnum);
			    
			    m_lpioche.add(p);
			    //System.out.println("pion " + i);
			   // System.out.println(p.m_lnum.get(0));
			    // System.out.println(p.m_lnum.get(1));
			    //System.out.println(p.m_lnum.get(2));
			    
			    if(c==5)
		        {
		            a+=1; b=a; c=a;
		        }
		        else if(b==c)
		        {
		            b+=1; c=a;
		        }
		        else
		        {
		            c++;
		        }
			    
			    //System.out.println(m_lpioche.size());
			    //System.out.println(m_lpioche.isEmpty());
			}
			
			
	}	
			
			
	 public ArrayList<Pion> distrib()   //la fonction qui distribue les pions
	  	{
		 Collections.shuffle(m_lpioche); // melange
		 //System.out.println(m_lpioche.isEmpty());
		 	if(m_nombrejoueur ==2)
		 	{
		 		for(int j=0 ; j<9 ; j++)
		 		{
		 			m_ljoueur.add(m_lpioche.get(j)); //ajoute dans le jeu du joueur
		 			m_lpioche.remove(j); //retire de la pioche
		 			//System.out.println(m_lpioche.size());
		 			
		 		}
		 	}
		 		
		 	else
		 	{
		 		for(int j=0 ; j<7 ; j++)
		 		{
		 			m_ljoueur.add(m_lpioche.get(j));
		 			m_lpioche.remove(j);
		 			//System.out.println(m_lpioche.size());
		 			
		 		}
		 		
		 	}
		 		/*for(int j=0;j<9;j++)
		 		{
		 			System.out.println("*****************");
		 			System.out.println(m_ljoueur.get(j).m_lnum.get(0));
		 			System.out.println(m_ljoueur.get(j).m_lnum.get(1));
		 			System.out.println(m_ljoueur.get(j).m_lnum.get(2));
		 		}*/
			return m_ljoueur;
			
		 		
		 		
		 		
		 	
	  			
	  		
	  	}	 
		        
		         
		      
		        
		
		
			
			

	
	
	
	
}
		
			
			

	
	
	
	



