package pobj.motx.tme1;

/**
 * @author LAOUER Walid
 *
 */
public class Grille {
	private Case Case[][] ;
	private int h, l;

	/**
	 * @param hauteur
	 * @param largeur
	 * Constructeur d'une Grille : Matrice de case
	 */
	public Grille(int hauteur, int largeur) {
		h = hauteur;
		l = largeur;
		Case = new Case[hauteur][largeur];
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				Case[i][j] = new Case(i, j, ' ');
			}
		}
	}

	public Case getCase(int lig, int col) {
		if (Case[lig][col].getLig() == lig && Case[lig][col].getCol() == col) {
			return Case[lig][col];
		} else
			return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}

	/**
	 * @return la hauteur de la grille
	 */
	public int nbLig() {
		return h;
	}

	/**
	 * @return la longueur de la grille
	 */
	public int nbCol() {
		return l;
	}

	/**
	 * @return Une copie de la grille courante
	 */
	public Grille copy() {
		Grille Grille2 = new Grille(nbLig(), nbCol());
		for (int i = 0; i < nbLig(); i++) {
			for (int j = 0; j < nbCol(); j++) {
				Grille2.getCase(i, j).setChar(getCase(i, j).getChar());
			}

		}
		return Grille2;
	}

}
