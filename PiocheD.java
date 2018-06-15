import java.util.ArrayList;
import java.util.Iterator;

public class PiocheD
{
    private ArrayList<Domino> pioche_list = new ArrayList<Domino>();
    private PlateauDom plateau;


    public PiocheD(PlateauDom plateau)
    {
    	this.plateau = plateau;
    	
        for (int i  = 0; i < 7; ++i)
        {
            for (int j = i; j < 7; ++j)
            {
                //System.out.println("i = " + i + " , j = " + j);
                Domino dom = new Domino(i, j, plateau);
                pioche_list.add(dom);
            }
        }
        //print_pioche();
    }

    public void remove(int num)
    {
//        System.out.println("removing from pioche");
        pioche_list.remove(num);
    }

    public void print_pioche()
    {
        int i = 0;
        /*Object[] obj = pioche_hs.toArray();
        for (Object o : obj)
        {
            System.out.println(i++);
            //System.out.println(o.getClass());
        }*/
        Iterator<Domino> it = pioche_list.iterator();
        while(it.hasNext())
        {
            System.out.println(++i);
            Domino dom = it.next();
            System.out.println(dom.getVal1() + " : " + dom.getVal2());
        }
    }

	public ArrayList<Domino> getPioche_list() {
		return pioche_list;
	}

	public void setPioche_list(ArrayList<Domino> pioche_list) {
		this.pioche_list = pioche_list;
	}
    
    

}
