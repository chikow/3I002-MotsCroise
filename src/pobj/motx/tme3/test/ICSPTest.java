/**
 * 
 */
package pobj.motx.tme3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme1.GrillePlaces;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme3.MotX;
import pobj.motx.tme3.csp.CSPSolver;

/**
 * @author LAOUER Walid
 *
 */
public class ICSPTest {

	@Test
	public void testMedium() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/medium.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille medium");
		
		 
			problem = (MotX) solution.solve(problem);
	//	}
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}
	
	@Test
	public void testEnonce() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/enonce.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille enonce");
		
		 
			problem = (MotX) solution.solve(problem);
		//}
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}
	
	@Test
	public void testSplit() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/split.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille split");
		
		 
			problem = (MotX) solution.solve(problem);
	//	}
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}
	
	@Test
	public void testReverse() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/reverse.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille reverse");
		
		 
			problem = (MotX) solution.solve(problem);
	
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}




	@Test
	public void testHard() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");
		

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();

		
		System.out.println("Test  du solver sur grille hard");
		
		 
			problem = (MotX) solution.solve(problem);
	
	
		System.out.println(problem.getGrillePot().getGP().getPlaces());

	}

	
	@Test
	public void testLarge() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille Large");
		
			problem = (MotX) solution.solve(problem);
	

	}

	@Test
	public void testLarge3() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large3.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille Large3");
		
	
			problem = (MotX) solution.solve(problem);
	
		
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}

	@Test
	public void testLarge2() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large2.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille Large2");
		
			problem = (MotX) solution.solve(problem);
		
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}

	@Test
	public void testLarge4() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large4.grl");

		assertEquals(20, gr.nbCol());
		assertEquals(20, gr.nbLig());

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
		System.out.println("Test  du solver sur grille Large4");
		
		 
			problem = (MotX) solution.solve(problem);
	//	}
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}
	
	@Test
	public void testEasy2() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/easy2.grl");


		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);

		System.out.println("Resolution de  grilleEasy2:");
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
	
			problem = (MotX) solution.solve(problem);

		
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}
	
	@Test
	public void testEasy() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		
		Grille gr = GrilleLoader.loadGrille("data/easy.grl");

		GrillePlaces grille = new GrillePlaces(gr);

		GrillePotentiel gp = new GrillePotentiel(grille, gut);


		System.out.println("Resolution de  GrilleEasy.");
		
		MotX problem = new MotX(gp);
		
		CSPSolver solution= new CSPSolver();
		
	
			problem = (MotX) solution.solve(problem);
	
		
		System.out.println(problem.getGrillePot().getGP().getPlaces());
	}
}



