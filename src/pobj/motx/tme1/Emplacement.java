package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.CroixContrainte;
import pobj.motx.tme2.IContrainte;

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
	
	public List<Case> getCase() {
		return this.lettres;
	}

	/**
	 * @param mot
	 * @param x
	 * @param y
	 * @return
	 */
	public IContrainte intersection(Emplacement mot , int x , int y) {
		List<Case> h = this.lettres;
		List<Case> v = mot.getCase();
		for(int i = 0; i < h.size() ; i++){
			for(int j = 0; j < v.size() ; j++){
				if(h.get(i).sameCase(v.get(j)) == true){
					if(h.get(i).getChar() == ' ')
						return new CroixContrainte( x , i , y , j );
				}
			}
		}
		return null;
		
	}
	
	public boolean isVertical(){
		return (this.getCase(0).getLig())<(this.getCase(1).getLig());
	}
	
	public boolean isHorizontal(){
		return (this.getCase(0).getCol())<(this.getCase(1).getCol());
	}
	public Case getCase(int n){
		return lettres.get(n);
	}
	
	public boolean caseVide(){
		for(int i = 0 ; i<lettres.size() ; i++){
			if(lettres.get(i).isVide() == true){
				return true;
			}
		}
		return false;
	}

}
