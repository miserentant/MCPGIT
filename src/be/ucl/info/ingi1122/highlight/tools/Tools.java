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
	 * renvoie true si tout les mots se trouve dans le texte
	 */
	public static boolean correspond(char[] texte, char[][] mots) {
		boolean trouve = false;
		int nombreTrouve = 0;
		for (int i=0; i< mots.lenght()-1; i++){
			for (int j=0; j< mots[i].lenght()-1; j++){
				if (oneMath(texte, mots[i])){
					nombreTrouve ++;
				}
			}
		}
		if (nombreTrouve == mots.lenght())
		{
			trouve = true;
		}
		return trouve;
	}
	/*
	 * @pre prend un texte et un mots a chercher en parametre
	 * @post renvoie true si un le mot se trouve dans le texte
	*/
	public boolean oneMatch(char[] texte, char[] mot){
		return true;
	}
	
}
