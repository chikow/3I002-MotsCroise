package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LAOUER Walid
 *
 */
public class Emplacement {
	private List<Case> lettres;

	/**
	 * Constructeur de de la classe emplacement
	 */
	public Emplacement() {

		lettres = new ArrayList<Case>();
		// this.lettres=lettres;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String mot = "";
		for (int i = 0; i < lettres.size(); i++) {
			mot += lettres.get(i);

		}
		return mot;
	}

	/**
	 * @return taille de la liste
	 */
	public int size() {
		return lettres.size();

	}


	/**
	 * @param cases permet d'ajouter une nouvelle case
	 */
	public void add(Case cases) {
		// TODO Auto-generated method stub
		lettres.add(cases);

	}

}
