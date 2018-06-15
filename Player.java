import java.util.ArrayList;

public class Player
{
	private ArrayList<Domino> hand_list = new ArrayList<>();
    private String name;
    private PlateauDom plateau;

    public Player(PiocheD pioche, String name_var, PlateauDom plateau)
    {
        name = name_var;
        this.plateau = plateau;
        
        for (int i = 0; i < 7; i++)
            draw(pioche);
    }

    public void setPlateau(PlateauDom plateau_var)
    {
        plateau = plateau_var;
    }

    public boolean draw(PiocheD pioche)
    {
        // add a domino from the pioche to the hand
//        System.out.println(name + " is picking a domino");
        int pick = (int)(Math.random() * pioche.getPiocheD_list().size());
//        System.out.println("number " + (int)(Math.random() * pioche.getPiocheD_list().size()));
        Domino dom = pioche.getPiocheD_list().get(pick);
        hand_list.add(dom);
//        System.out.println(dom.getVal1() + " : " + dom.getVal2());
        pioche.remove(pick);
        return (dom.isDouble());
    }

    
    public void dom_click(Domino dom)
    {
        int val = dom.getVal1();

        for (Domino domi : plateau.getDominoPlateau())
        {
            if ((domi.isJouableVal1() && domi.getVal1() == val)
             || (domi.isJouableVal2() && domi.getVal2() == val))
            {
                //domi.addfleche();
            }
        }
        val = dom.getVal2();

        for (Domino domi : plateau.getDominoPlateau())
        {
            if ((domi.isJouableVal1() && domi.getVal1() == val)
             || (domi.isJouableVal2() && domi.getVal2() == val))
            {
                //domi.addfleche();
            }
        }
    }



    public void show_hand()
    {
        System.out.println("player name : " + name);
        System.out.println("hand : ");
        for (Domino dom : hand_list)
            System.out.println(dom.getVal1() + " : " + dom.getVal2());
    }

	public ArrayList<Domino> getHand_list() {
		return hand_list;
	}

	public void setHand_list(ArrayList<Domino> hand_list) {
		this.hand_list = hand_list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
