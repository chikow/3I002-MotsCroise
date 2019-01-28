package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {
	private Grille g;
	private List<Emplacement> places;
	private int h;
	
	public GrillePlaces (Grille grille) {
		g=grille;
		places=new ArrayList<Emplacement>();
		for (int i = 0; i < grille.nbLig(); i++) {
			 cherchePlaces(getLig(i));
		}
		h=places.size();
		//System.out.println(h);
		
	}
	
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	public int getNbHorizontal() {
		return 0;
	}
	
	private List<Case> getLig (int lig){
		List<Case> ligne = new ArrayList<Case>();
		for (int i = 0; i < g.nbCol(); i++) {
			ligne.add(g.getCase(lig, i));
		}
		return ligne;
	}
	
	private List<Case> getCol (int col){
		List<Case> coll = new ArrayList<Case>();
		for (int i = 0; i < g.nbLig(); i++) {
			coll.add(g.getCase(i,col));
		}
		return coll;
	}
	
	 private void cherchePlaces(List<Case> cases) {
		 Emplacement e = new  Emplacement();
		 for (int i = 0; i < cases.size(); i++) {
			if(!cases.get(i).isPleine()) {
				e.add(cases.get(i));
			}
			if(e.size()>1) {
				places.add(e);
			}
		}
		 
	 }

}
