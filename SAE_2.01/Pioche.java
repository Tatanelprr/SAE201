import java.util.*;

public class Pioche
{
	private ArrayList<Jeton> tabJeton;

	public Pioche()
	{
		this.tabJeton = new ArrayList<>();
		this.initPioche();
	}

	public Jeton tirerJeton()
	{
		if(this.tabJeton.get(0) != null)
		{
			return this.tabJeton.remove(0);
		}
		return null;
	}

	private void initPioche()	//Initialise la pioche selon l'exemple
	{
		this.tabJeton.add(new Jeton(Epice.POIVRE));
		this.tabJeton.add(new Jeton(Epice.SUMAC));
		this.tabJeton.add(new Jeton(Epice.CURCUMA));
		this.tabJeton.add(new Jeton(Epice.CARDAMONE));
		this.tabJeton.add(new Jeton(Piece.OR));
		this.tabJeton.add(new Jeton(Epice.SAFRAN));
		this.tabJeton.add(new Jeton(Epice.SESAME));
		this.tabJeton.add(new Jeton(Epice.POIVRE));
		this.tabJeton.add(new Jeton(Piece.ARGENT));
		this.tabJeton.add(new Jeton(Piece.ARGENT));
		this.tabJeton.add(new Jeton(Epice.PAPRIKA));
		this.tabJeton.add(new Jeton(Epice.SESAME));
		this.tabJeton.add(new Jeton(Epice.SAFRAN));
		this.tabJeton.add(new Jeton(Epice.SAFRAN));
		this.tabJeton.add(new Jeton(Epice.SAFRAN)); 
		this.tabJeton.add(new Jeton(Epice.CANNELLE));

		//Collections.shuffle(tabJeton); // Ici fonction permettant de mélanger la pioche (fonctionne)
	}

	public int getTaille()
	{
		return this.tabJeton.size();
	}
}