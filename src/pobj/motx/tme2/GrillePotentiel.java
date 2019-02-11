/**
 * 
 */
package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrillePlaces;

/**
 * @author LAOUER Walid
 *
 */
public class GrillePotentiel {
	private GrillePlaces GP; 
	private Dictionnaire  dico;
	private List<Dictionnaire> motsPot;
	private List<IContrainte> contraintes;
	
	public GrillePotentiel(GrillePlaces grille , Dictionnaire dicoComplet) {
		this.GP=grille;
		this.dico=dicoComplet.copy();
		motsPot = new ArrayList<Dictionnaire>();
		contraintes = new ArrayList<>();
		for (Emplacement emplacement : grille.getPlaces()) {
			Dictionnaire dico = dicoComplet.copy();
			dico.filtreLongueur(emplacement.size());
			int i = 0;
			for (Case c : emplacement.getCase()) {
				if (!(c.isPleine() || c.isVide())) {
					dico.filtreParLettre(c.getChar(), i);
				}
				i++;
			}	
			motsPot.add(dico);
		}	
		//contrainte(GP);
		checkContrainte();
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
	public List<Dictionnaire> getMotsPot() {
		// TODO Auto-generated method stub
		return motsPot;
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		
		return new GrillePotentiel(GP.fixer(m, soluce), dico);
	}

	public List<IContrainte> getContraintes() {
		return contraintes;
	}
	
	
	  public void checkContrainte(){ 
		  IContrainte retour = null;
		  for( int i = 0 ; i< GP.getNbHorizontal() ; i++ ){ 
			  for( int j = GP.getNbHorizontal() ; j <
				  GP.getPlaces().size() ; j++ ){ retour = GP.getPlaces().get(i).intersection(GP.getPlaces().get(j) , i , j ); 
				  if( retour != null )
					  contraintes.add(retour);
				  } 
			  } 
		  }
	 

}

