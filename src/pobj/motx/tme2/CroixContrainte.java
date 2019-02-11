/**
 * 
 */
package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 *
 */
public class CroixContrainte implements IContrainte{

	private int m1,m2,c1,c2;
	
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.m2 = m2;
		this.c1 = c1;
		this.c2 = c2;
		
	}

	
	public int getM1() {
		return m1;
	}

	
	public int getM2() {
		return m2;
	}

	
	public int getC1() {
		return c1;
	}

	
	public int getC2() {
		return c2;
	}


	@Override
	public int reduce(GrillePotentiel grille) {
		EnsembleLettre ens1 = grille.getMotsPot().get(m1).charAt(c1);
		EnsembleLettre ens2 = grille.getMotsPot().get(m2).charAt(c2);
		EnsembleLettre s = ens1.intersection(ens2);
		int nb = 0;

		if (ens1.size() > s.size()) {
			nb += grille.getMotsPot().get(m1).filterParEnsembleDeLettrePo(c1, s);
		}

		if (ens2.size() > s.size()) {
			nb += grille.getMotsPot().get(m2).filterParEnsembleDeLettrePo(c2, s);
		}
		
		return nb;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (!(other instanceof CroixContrainte))
			return false;
		CroixContrainte o = (CroixContrainte) other;
		if (c1 != o.c1 || c2 != o.c2 ||m1 != o.m1 || m2 != o.m2)
			return false;

		return true;
	}
	
	
	
	


		
	

}
