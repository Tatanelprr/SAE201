import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plateau {
	
	private final int NB_PIECE_MAX = 8;
	private int nbPiece;

	private final int NB_COL_MAX = 5;
	private final int NB_LIG_MAX = 3;
	private List<List<Epice>> plateau;

	private int score;
	private String detailScore;

	public Plateau()
	{
		this.plateau = new ArrayList<>(NB_LIG_MAX);
        for (int i = 0; i < NB_LIG_MAX; i++) 
		{
            List<Epice> ligne = new ArrayList<>(NB_COL_MAX);
            for (int j = 0; j < NB_COL_MAX; j++) 
			{
                ligne.add(null);
            }
			plateau.add(ligne);
		}
		this.nbPiece = 0;
		this.score = 0;
		this.detailScore = "";
	}

	public int getScore()
	{
		return this.score;
	}

	public int getNbPiece()
	{
		return this.nbPiece;
	}

	public String getDetailScore()
	{
		return this.detailScore;
	}

	public boolean ajouterRessource( Jeton r )
	{
		if (r.getType() instanceof Piece)
		{
			Piece piece = (Piece) r.getType();
			if ( (piece.getValeur() + this.nbPiece) <= this.NB_PIECE_MAX)
			{
				this.nbPiece += piece.getValeur();
				return true;
			}
			return false;
		}
		else if (r.getType() instanceof Epice)
		{
			Epice epice = (Epice) r.getType();
			int i = 2;

			for (int j = 0; j < NB_COL_MAX; j++)
			{
				if ( plateau.get(i).get(j) == null )
				{
					plateau.get(i).set(j, epice);
					return true;
				}
			}

			for (i = 1; i < (NB_LIG_MAX); i++) 
			{
				for (int j = 0; j < NB_COL_MAX; j++) 
				{
					if ( plateau.get(i).get(j) == epice && plateau.get(i - 1).get(j) == null)
					{
						plateau.get(i - 1).set(j, epice);
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}

	public void score()
	{
		int i;
		int j = 0;

		if ( this.nbPiece > 1)
		{
			this.score += this.nbPiece * this.nbPiece;
		}

		for (i = 0; i < NB_LIG_MAX; i++) 
		{
            int casesRemplies = 0;

            for (j = 0; j < NB_COL_MAX; j++) 
			{
                if (plateau.get(i).get(j) != null) 
				{
                    casesRemplies++;
                }
            }
            switch (casesRemplies) {
				case 0:
					this.score += 0;
				case 1:
					this.score += 0;
				case 2:
					this.score += 2;
				case 3:
					this.score += 5;
				case 4:
					this.score += 9;
				case 5:
					this.score += 14;
				default:
					this.score += 0;
					break;
			}
        }

			for (j = 0; j < NB_COL_MAX; j++)
			{
				int casesRemplies = 0;

				for (i = 0; i < NB_LIG_MAX; i++)
				{
					if (plateau.get(i).get(j) != null)
					{
						casesRemplies++;
					}
				}
				switch (casesRemplies) {
					case 0:
						this.score += 0;
					case 1:
						this.score += 0;
					case 2:
						this.score += 2;
					case 3:
						this.score += 10;
					default:
						this.score += 0;
						break;
				}
			}
	}

	public String toString() {
		String sRet;
		String sep = "+-----";
	
		sRet = "";
		for (int j = 0; j < NB_LIG_MAX; j++) 
		{
			for (int i = 0; i < NB_COL_MAX; i++) 
			{
				sRet += sep;
			}
			sRet += "+ \n";
			for (int i = 0; i < NB_COL_MAX; i++) 
			{
				sRet += "| ";
				if (plateau.get(j).get(i) == null) 
				{ 
					sRet += "    ";
				} 
				else 
				{
				sRet += plateau.get(j).get(i).getLibCourt(); 
				sRet += " ";
				}
			}
			sRet += "|\n";
		}

		for (int i = 0; i < NB_COL_MAX; i++) 
		{
			sRet += sep;
		}
		sRet += "+";
	
		return sRet;
	}


	public void triColonne()
	{

	}
}