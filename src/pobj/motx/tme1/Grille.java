package pobj.motx.tme1;

public class Grille {
	private Case Case[][];
	private int h , l;
	
	public Grille(int hauteur , int largeur) {
		h=hauteur;
		l=largeur;
		Case=new Case[hauteur][largeur];
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				Case[i][j]=new Case(i, j, ' ');
			}
		}
	}
	
	public Case getCase(int lig, int col){
		if (Case[lig][col].getLig() == lig && Case[lig][col].getCol() == col) {
			return Case[lig][col];
		}
		else return null;
	}
	
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	public int nbLig() {
		return h;
	}
	public int nbCol() {
		return l;
	}
	
	public Grille copy() {
		Grille Grille2 = new Grille(nbLig(),nbCol());
		for (int i = 0; i < nbLig(); i++) {
			for (int j = 0; j < nbCol(); j++) {
				Grille2.getCase(i, j).setChar(getCase(i, j).getChar());
			}
			
		}
		return Grille2;
	}
	

}
