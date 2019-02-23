/**
 * 
 */
package pobj.motx.tme3;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme3.csp.ICSP;

/**
 * @author user
 *
 */
public class MotX implements ICSP {
	
	//private List<DicoVariable> ListDic = new ArrayList<DicoVariable>();
	private List<IVariable> dicoVar;
	private GrillePotentiel gp;
	
	public MotX(GrillePotentiel gp){
		Emplacement m;
		this.gp = gp;
		dicoVar = new ArrayList<IVariable>();
		for(int i = 0 ; i < gp.getGP().getPlaces().size() ; i++){
			m = gp.getGP().getPlaces().get(i);
			if(m.caseVide() == true){
				dicoVar.add(new DicoVariable(i,gp));
			}
		}
	}
	

	/* (non-Javadoc)
	 * @see pobj.motx.tme3.csp.ICSP#getVars()
	 */
	@Override
	public List<IVariable> getVars() {
		// TODO Auto-generated method stub
		return dicoVar;
	}

	/* (non-Javadoc)
	 * @see pobj.motx.tme3.csp.ICSP#isConsistent()
	 */
	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return !gp.isDead();
	}

	/* (non-Javadoc)
	 * @see pobj.motx.tme3.csp.ICSP#assign(pobj.motx.tme3.csp.IVariable, java.lang.String)
	 */
	@Override
	public ICSP assign(IVariable vi, String val) {
		DicoVariable dv;
		if(vi instanceof DicoVariable){
			dv = (DicoVariable) vi;
		}
		dv = (DicoVariable) vi;
		return new MotX( gp.fixer(dv.getIndex(), val) ) ;
	}
	
	public GrillePotentiel getGrillePot(){
		return gp;
	}
	
	

}
