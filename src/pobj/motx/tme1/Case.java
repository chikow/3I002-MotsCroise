package pobj.motx.tme1;

/**
 * @author LAOUER Walid
 *
 */
public class Case {
	int lig;
	int col;
	char c;

	/**
	 * @param lig
	 * @param col
	 * @param c
	 * Constructeur d'une case 
	 */
	public Case(int lig, int col, char c) {
		this.lig = lig;
		this.col = col;
		this.c = c;
	}

	/**
	 * @return retourner le caractere de la case
	 */
	public char getChar() {
		return c;
	}

	/**
	 * @param c modifier le caractere de la case
	 */
	public void setChar(char c) {
		this.c = c;
	}

	/**
	 * @return la ligne de la case
	 */
	public int getLig() {
		return lig;
	}

	/**
	 * @return la colonne de la case
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @return répond vrai si la case est vide/blanche
	 */
	public boolean isVide() {
		if (this.getChar() == ' ') {
			return true;
		} else
			return false;
	}

	/**
	 * @return répond vrai si la case est pleine/noire
	 */
	public boolean isPleine() {
		if (this.getChar() == '*') {
			return true;
		} else
			return false;
	}
	
	

}
