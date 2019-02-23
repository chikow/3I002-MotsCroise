/**
 * 
 */
package pobj.motx.tme3;

import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

/**
 * @author user
 *
 */
public class DicoVariable implements IVariable{
	private int index;
	private GrillePotentiel gp;

	
	public DicoVariable(int index, GrillePotentiel gp){
		this.index = index;
		this.gp = gp;
		
	}
	@Override
	public List<String> getDomain() {
	  return gp.getMotsPot().get(index).getMots();
	}
	
	
	
	public String toString(){
		return "";
	}
	public int getIndex() {
		return index;
	}
	
	

}
