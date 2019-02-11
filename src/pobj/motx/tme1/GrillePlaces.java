package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.Dictionnaire;

/**
 * @author LAOUER Walid
 *
 */
public class GrillePlaces {
	private Grille g;
	private List<Emplacement> places;
	private int h;

	/**
	 * @param Constructeur de grille place , permet de determiner le nombre de lignes horizontaux
	 */
	public GrillePlaces(Grille grille) {
		g = grille;
		places = new ArrayList<Emplacement>();
		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		h = places.size();
		System.out.println(h);
		for (int i = 0; i < grille.nbCol(); i++) {
			cherchePlaces(getCol(i));
		}

	}

	/**
	 * @return la place dans la liste
	 */
	public List<Emplacement> getPlaces() {
		return places;
	}

	/**
	 * @return le nombre de lignes horizontaux
	 */
	public int getNbHorizontal() {
		return h;
	}
	
	/**
	 * @return le nombre de lignes Verticaux
	 */
	public int getNbVertical() {
		return places.size()-h;
	}

	/**
	 * @param lig
	 * @return les cases qui constitue une ligne 
	 */
	private List<Case> getLig(int lig) {
		List<Case> ligne = new ArrayList<Case>();
		for (int i = 0; i < g.nbCol(); i++) {
			ligne.add(g.getCase(lig, i));
		}
		return ligne;
	}

	/**
	 * @param col
	 * @return les cases qui constitue une colonne
	 */
	private List<Case> getCol(int col) {
		List<Case> coll = new ArrayList<Case>();
		for (int i = 0; i < g.nbLig(); i++) {
			coll.add(g.getCase(i, col));
		}
		return coll;
	}

	/**
	 * @param cases
	 * Cherche les mots dans la liste de cases fournie
	 * Ajoute les emplacements de mot dans place
	 */
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for (Case c : cases) {
			if (!c.isPleine())
				e.add(c);
			else {
				if (e.size() > 1)
					places.add(e);
				e = new Emplacement();
			}
		}
		if (e.size() > 1)
			places.add(e);
	}
	
	public GrillePlaces fixer(int m, String soluce) {
		Grille newGrille=g.copy();
		List<Case> cases = this.getPlaces().get(m).getCase();
		int i=0;
		for (Case ele : cases){
			char lettre=soluce.charAt(i);
			newGrille.getCase(ele.getLig(), ele.getCol()).setChar(lettre);
			i++;
		}
		GrillePlaces newGp=new GrillePlaces (newGrille);
		return newGp;
	}

}
