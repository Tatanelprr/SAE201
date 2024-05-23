import java.util.ArrayList;
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
            ArrayList<Epice> ligne = new ArrayList<>(NB_COL_MAX);
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
		this.score();
		return this.score;
	}

	public Epice getEpice(int i, int j)
	{
		return this.plateau.get(i).get(j);
	}

	public int getNB_LIG_MAX()
	{
		return this.NB_LIG_MAX;
	}

	public int getNB_COL_MAX()
	{
		return this.NB_COL_MAX;
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
						this.triColonnes(i - 1, j);
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

		this.detailScore = "Detail :\n	";
		this.detailScore += ( String.format("%-15s", "Pieces ") + ": ");

		if ( this.nbPiece > 1)
		{
			this.score += this.nbPiece * this.nbPiece;
			this.detailScore += (this.nbPiece * this.nbPiece) + " pt\n	";
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
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 1:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 2:
					this.score += 2;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 2 + "  pt\n	";
					break;
				case 3:
					this.score += 10;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 10 + " pt\n	";
					break;
				default:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 0 + "  pt\n	";
					break;
			}
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
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 1:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 2:
					this.score += 2;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 2 + "  pt\n	";
					break;
				case 3:
					this.score += 5;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 5 + "  pt\n	";
					break;
				case 4:
					this.score += 9;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 9 + "  pt\n	";
					break;
				case 5:
					this.score += 14;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 14 + " pt\n	";
					break;
				default:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 0 + "  pt\n	";
					break;
			}
        }
	}

	public String toString() {
		String sRet;
		String sep = "+-----";
	
		sRet = "";
		for (int i = 0; i < NB_LIG_MAX; i++) 
		{
			for (int j = 0; j < NB_COL_MAX; j++) 
			{
				sRet += sep;
			}
			sRet += "+ \n";
			for (int j = 0; j < NB_COL_MAX; j++) 
			{
				sRet += "| ";
				if (plateau.get(i).get(j) == null) 
				{ 
					sRet += "    ";
				} 
				else 
				{
				sRet += plateau.get(i).get(j).getLibCourt(); 
				sRet += " ";
				}
			}
			sRet += "|\n";
		}

		for (int j = 0; j < NB_COL_MAX; j++) 
		{
			sRet += sep;
		}
		sRet += "+";
	
		return sRet;
	}


	public void triColonnes(int i, int j)
	{
		if (j > 0 && i >= 0)
		{
			while (j > 0 && plateau.get(i).get(j - 1) == null)
			{
				for (int i2 = 0; i2 < NB_LIG_MAX; i2++) 
				{
					Epice tmp = this.plateau.get(i2).get(j - 1);
					this.plateau.get(i2).set(j - 1, this.plateau.get(i2).get(j));
					this.plateau.get(i2).set(j,   tmp);	
				}
				j--;
			}
		}
	}

}