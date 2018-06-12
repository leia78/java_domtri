import java.util.ArrayList;
 
public class Joueur {
   
    protected String m_pseudo;
    protected int m_score;
    protected boolean IA;
    protected ArrayList<Pion> m_lpion ;
   
   
    public Joueur(String pseudo, boolean IA)
    {
        this.m_pseudo=pseudo;
        this.m_score=0;
        this.IA = IA;
        this.m_lpion= null;
    }
   
    public Joueur(String pseudo, int score, ArrayList<Pion> lpion)
    {
        this.m_pseudo=pseudo;
        this.m_score=score;
        this.m_lpion=lpion;
        //le truc des pions aussi !
    }
 
    public String getM_pseudo() {
        return m_pseudo;
    }
 
    public void setM_pseudo(String m_pseudo) {
        this.m_pseudo = m_pseudo;
    }
 
    public int getM_score() {
        return m_score;
    }
 
    public void setM_score(int m_score) {
        this.m_score = m_score;
    }
 
    public ArrayList<Pion> getM_lpion() {
        return m_lpion;
    }
 
    public void setM_lpion(ArrayList<Pion> m_lpion) {
        this.m_lpion = m_lpion;
    }
 
}

