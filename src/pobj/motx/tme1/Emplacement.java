package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	private List<Case> lettres;

	public Emplacement() {
		
		lettres = new ArrayList<Case>();
		//this.lettres=lettres;
		
	}
	
	public String toString() {
		String mot="";
		for (int i = 0; i < lettres.size(); i++) {
			mot+=lettres.get(i);
			
		}
		return mot;
	}
	
	public int size() {
		return lettres.size();
		
	}

	public void add(Case cases) {
		// TODO Auto-generated method stub
		lettres.add(cases);
		
	}
	
	

}
