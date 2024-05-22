import java.awt.Color;

public enum Couleur {
	
	BLANC  (255, 255, 255),
	JAUNE  (255, 255,   0),
	ROUGE  (255,   0,   0),
	ORANGE (255, 165,   0),
	VIOLET (128,   0, 128),
	BRUN   (165,  42,  42),
	VERT   (  0, 128,   0),
	NOIR   (  0,   0,   0);

	private int r;
	private int v;
	private int b;

	Couleur( int r, int v, int b)
	{
		this.r = r;
		this.v = v;
		this.b = b;
	}

	public Color getColor()
	{
		return new Color(this.r, this.v, this.b);
	}

	public String getSymbole()
	{
		String sRet;

		switch (this)
		{
			case BLANC ->
			{
				sRet = "sesame.png";
			}
			case JAUNE ->
			{
				sRet = "curcuma.png";
			}
			case ROUGE ->
			{
				sRet = "paprika.png";
			}
			case ORANGE ->
			{
				sRet = "safran.png";
			}
			case VIOLET ->
			{
				sRet = "sumac.png";
			}
			case BRUN ->
			{
				sRet = "cannelle.png";
			}
			case VERT ->
			{
				sRet = "cardamine.png";
			}
			case NOIR ->
			{
				sRet = "poivre.png";
			}
			default ->
			{
				sRet = null;
			}
		}
		return sRet;
	}
	
	public static int getNbCouleur()
	{
		return Couleur.values().length;
	}

	public static Couleur valueOf( int ordinal)
	{
		if ( ordinal >= 0 && ordinal <= Couleur.values().length)
		{
			return Couleur.values()[ordinal];
		}
		return null;
	}
}