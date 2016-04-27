package be.ucl.info.ingi1122.highlight.tools;

public class Tools {
	
	public Portion[] tabportion;
	public PortionSet portionset;

	public static Portion[] quoiSurligner(char[] texte, char[][] mots) {
		portionset = new PortionSet();
		boolean bool = correspond(texte, mots);
		if(!bool){
			System.out.println("No match found");
			return null;
		}
		tabportion = new Portion[portionset.getNumberElem()];
		for(int i =0; i<portionset.getNumberElem()-1; i++){
			tabportion[i] = portionset.getElem(i);
		}
		return tabportion;
	}
	/*
	 * @pre prend un texte et une liste de mots en parametre
	 * @post renvoie true si tout les mots se trouve dans le texte
	 */
	public static boolean correspond(char[] texte, char[][] mots) {
		boolean trouve = false;
		int caractereTrouve = 0;
		int motTrouve = 0;
		for (int i=0; i< mots.lenght()-1; i++){
			int taille = mots[i].lenght();
			if (oneMath(texte, mots[i])){motTrouve ++;}
			if (motTrouve == taille) {caractereTrouve++;}
		}
		if (caractereTrouve == mots.lenght())
		{
			trouve = true;
		}
		return trouve;
	}
	/*
	 * @pre prend un texte et un mots a chercher en parametre
	 * @post renvoie true si un le mot se trouve dans le texte
	 * PAS FINI
	*/
	public boolean oneMatch(char[] texte, char[] mot){
		boolean match = false;
		int tailleM = mot.lenght();
		int tailleT = texte.lenght();
		int caractereTrouve = 0;
		for (int i=0; i<(tailleT-tailleM-1)) {
				
		}
		return match;
	}
	
}
