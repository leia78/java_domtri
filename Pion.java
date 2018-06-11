
import java.util.ArrayList;
import java.util.List;
 
public class Pion {
   
    protected ArrayList<Integer> m_lnum= new ArrayList<Integer>(); //liste de numero
    protected boolean m_pioche; //true si c'est au joueur, false si c'est une pioche
    protected String m_base; //en haut ou en bas
   
    public Pion(ArrayList<Integer> liste, boolean pioche , String base)
   
    {
        this.m_lnum=liste;
        this.m_pioche=pioche;
        this.m_base=base;
    }
 
    public ArrayList<Integer> getM_lnum() {
        return m_lnum;
    }
 
    public void setM_lnum(ArrayList<Integer> m_lnum) {
        this.m_lnum = m_lnum;
    }
 
    public boolean isM_pioche() {
        return m_pioche;
    }
 
    public void setM_pioche(boolean m_pioche) {
        this.m_pioche = m_pioche;
    }
 
    public String getM_pos() {
        return m_base;
    }
 
    public void setM_pos(String m_base) {
        this.m_base = m_base;
    }
    
    public void coteDispo() {
    	if
    }
    

}
