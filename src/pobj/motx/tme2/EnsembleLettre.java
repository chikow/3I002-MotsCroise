/**
 * 
 */
package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LAOUER Walid
 *
 */
public class EnsembleLettre {
	private List<Character> ensemble = new ArrayList<Character>();

	public EnsembleLettre(List<Character> ensemble) {
		this.ensemble = ensemble;
	}
	
	/**
	 * 
	 */
	public EnsembleLettre() {
		// TODO Auto-generated constructor stub
		ensemble = new ArrayList<Character>();
	}

	public void add(char c) {
		if (!ensemble.contains(c)) {
			ensemble.add(c);
		}
	}
	
	public int size() {
		return ensemble.size();
	}

	public List<Character> getEnsemble() {
		return ensemble;
	}
	
	public boolean contains(char c) {
		if(ensemble.contains(c)) {
			return true;
		}else
			return false;
	}
	
	public EnsembleLettre intersection(EnsembleLettre e2){
		List<Character> inter = new ArrayList<Character>();
		
		for(Character c1: this.getEnsemble()){
			if(e2.contains(c1)){
				inter.add(c1);
			}
		}
		return new EnsembleLettre(inter);
	}
	public void intersection(List<Character> b){
		ensemble.retainAll(b);
	}
	
	

}
