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

		filtrer(GP,dico);
		checkContrainte();
		propage();
	}
	
	
	
	public void filtrer(GrillePlaces grille , Dictionnaire dicoComplet) {
		Dictionnaire copie;
		for(Emplacement e:GP.getPlaces())
		{
			copie=dicoComplet.copy();
			copie.filtreLongueur(e.size());
			for(int i=0;i<e.size();i++)
			{
				if(!(e.getCase(i).isPleine())&&!(e.getCase(i).isVide()))
				{
					copie.filtreParLettre(e.getCase(i).getChar(),i);
				}
			}
			motsPot.add(copie);
		}
	}


	public boolean isDead() {
		
			for(Dictionnaire d:motsPot)
			{
				if(d.size()==0)
					return true;
			}
			return false;
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
		int m1=0;
		for(Emplacement e1:GP.getPlaces())
		{
			int m2=0;
			for(Emplacement e2:GP.getPlaces())
			{
				if(e1.isHorizontal()&& e2.isVertical())
				{
					for(int c1=0;c1<e1.size();c1++)
					{
						for(int c2=0;c2<e2.size();c2++)
						{
							if((e1.getCase(c1)==e2.getCase(c2))&&(e1.getCase(c1).isVide()))
							{
								contraintes.add(new CroixContrainte(m1,c1,m2,c2));
							}
						}
					}
				}
				m2++;
			}
			m1++;}
	}
	private boolean propage()
	{
		while(true)
		{
			int cpt=0;
			for(IContrainte ic: contraintes)
			{
				cpt=cpt+ic.reduce(this);
			}
			if(this.isDead())
			{
				return false;
			}
			if(cpt==0)
			{
				return true;
			}
		}
	}
	
	public GrillePlaces getGP() {
		return GP;
	}
}
