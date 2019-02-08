/**
 * 
 */
package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

/**
 * @author LAOUER Walid
 *
 */
public class GrillePotentiel {
	private GrillePlaces GP; 
	private Dictionnaire  dico;
	private List<Dictionnaire> motsPot;
	
	public GrillePotentiel(GrillePlaces grille , Dictionnaire dicoComplet) {
		this.GP=grille;
		this.dico=dicoComplet.copy();
		motsPot = new ArrayList<Dictionnaire>();
		for (Emplacement emplacement : grille.getPlaces()) {
			Dictionnaire dico = dicoComplet.copy();
			dico.filtreLongueur(emplacement.size());
			int i = 0;
			for (Case c : emplacement.getCase()) {
				if (!(c.isPleine() || c.isVide())) {
					//dico.filtreParLettre(c.getChar(), i);
				}
				i++;
			}
			motsPot.add(dico);
		}	
	}

	public boolean isDead() {
		boolean b = false;
		for (Dictionnaire dictionnaire : motsPot) {
			if(dico.size() == 0) {
				return true;
			}
		}
		return b;
	}

	/**
	 * @return
	 */
	public Dictionnaire getMotsPot() {
		// TODO Auto-generated method stub
		return dico;
	}
	
	
	
	}

