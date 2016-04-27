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
			try {
				tabportion[i] = portionset.getElem(i);
			}
			catch (ArrayIndexOutOfBoundsException e) {System.out.println("cherche élément en dehors du tableau");}
		}
		return tabportion;
	}
	/*
	 * @pre prend un texte et une liste de mots en parametre
	 * @post renvoie true si tous les mots se trouve dans le texte
	 */
	public static boolean correspond(char[] texte, char[][] mots) {
		boolean trouve = false;
		int motTrouve = 0;
		int tailleM = mots[0].lenght();
		for (int i=0; i< mots.lenght()-1; i++){
			if (oneMath(texte, mots[i]) == true){motTrouve ++;}
		}
		if (motTrouve == tailleM)
		{
			trouve = true;
		}
		return trouve;
	}
	/*
	 * @pre prend un texte et un mots a chercher en parametre
	 * @post renvoie true si le mot se trouve dans le texte
	*/
	public boolean oneMatch(char[] texte, char[] mot){
		boolean match = false;
		int tailleM = mot.lenght();
		int tailleT = texte.lenght();
		for (int i=0; i<(tailleT-tailleM-1) && match == false; i++) {
			if(texte[i] == mot[0]) {
				match = compare(i,texte,mot);
			}
		}
		return match;
	}
	
	/*
	 * @pre prend un texte, une position p dans ce texte et un mot en argument
	 * @post renvoit true si le mot se trouve a la position p du texte
	 */
	 public boolean compare(int position, char[] texte, char[] mot){
	 	boolean idem = false;
	 	boolean dansMot = true;
	 	int caractereTrouve = 0;
	 	int tailleM = mot.lenght();
	 	int tailleT = texte.lenght();
	 	for (int i = position; i<(tailleT-tailleM-1) && i<tailleM && dansMot == true; i++){
	 		if (texte[i] == mot[i]) {caractereTrouve ++;}
	 		else {dansMot = false;}
	 	}
	 	if (caractereTrouve == tailleM) {idem = true;}
	 	return idem;
	 }
	
}
