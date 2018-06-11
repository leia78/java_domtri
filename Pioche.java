package menu_domino;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Pioche {
	
	protected ArrayList<Pion> m_lpioche = new ArrayList<Pion>();
	protected int m_taille = m_lpioche.size();
	
	public Pioche()
	{
		
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
	
	public void initlistetrio()
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
			    //System.out.println(p.m_lnum.get(0));
			    //System.out.println(p.m_lnum.get(1));
			   // System.out.println(p.m_lnum.get(2));
			    
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
			    
			}
			
			 
		         Collections.shuffle(m_lpioche);
		         for(int i=0;i<56;i++)
		         {
		         System.out.println("pion num" + i);
		         System.out.println(m_lpioche.get(i).m_lnum.get(0));
		         System.out.println(m_lpioche.get(i).m_lnum.get(1));
		         System.out.println(m_lpioche.get(i).m_lnum.get(2));
		         }
		        
		      
		
			
		
		
			
			

	}
	
	
	
}


