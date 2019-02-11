package pobj.motx.tme2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();

	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * 
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * 
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}

	/**
	 * Accès au i-eme mot du dictionnaire.
	 * 
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * 
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy() {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de
	 * filtrer pour ne pas perdre d'information.
	 * 
	 * @param len la longueur voulue
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}
	public int filtreParLettre(char c, int i) {
		int cpt=0;
		List<String> cible = new ArrayList<>();
		for(String mot : mots) {
			if (mot.charAt(i)==c) {
				cible.add(mot);
			}else 
				cpt++;
		}
		mots=cible;
		return cpt;
	}

	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico = new Dictionnaire();
		try (Stream<String> s = Files.lines(Paths.get(path))){
			s.forEach(dico::add);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return dico;
	}

	/**
	 * @param i
	 * @return
	 */
	public EnsembleLettre charAt(int i) {
		EnsembleLettre ens = new EnsembleLettre();
		for (String mot : mots) {
			ens.add(mot.charAt(i));
		}
		return ens;
	}

	/**
	 * @param s
	 * @param i
	 * @return
	 */
	public int filtreParLettre(EnsembleLettre s, int i) {
		// TODO Auto-generated method stub
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			char c = mot.charAt(i);
			if (s.contains(c)) {
				cible.add(mot);
			} else {
				cpt++;
			}
		}
		mots = cible;
		return cpt;
	}
	
	public int filterParEnsembleDeLettrePo(int i, EnsembleLettre ensembleLettre) {
		int cpt = 0;
		List<String> cible = new ArrayList<>();
		for (String mot : this.mots) {
			if (ensembleLettre.contains(mot.charAt(i))) {
				cible.add(mot);
			} else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	
	
	

}
