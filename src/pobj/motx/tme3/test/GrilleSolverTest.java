package pobj.motx.tme3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme1.GrillePlaces;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme3.adapt.MotX;
import pobj.motx.tme3.csp.CSPSolverCorrige;
import pobj.motx.tme3.csp.ICSP;

public class GrilleSolverTest {

	@Test
	public void testHard() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		// System.out.println(gp);
		// assertTrue(! gp.isDead());

		ICSP problem = new MotX(gp);
		CSPSolverCorrige solver = new CSPSolverCorrige();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}

}
