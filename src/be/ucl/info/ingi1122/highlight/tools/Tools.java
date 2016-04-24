package be.ucl.info.ingi1122.highlight.tools;

public class Tools {
	
	public Portion[] tabportion;
	public PortionSet portionset;

	public static Portion[] quoiSurligner(char[] texte, char[][] mots) {
		portionset = new PortionSet();
		boolean bool = correspond(texte, mots);
		if(!bool){
			return null
		}
		tabportion= new Portion[portionset.number];
		for(int i =0;i<portionset.number;i++){
			tabportion[i]=portionset.tab.get(i);
		}
		return tabportion;
	}
	
	public static boolean correspond(char[] texte, char[][] mots) {
		return true;
	}
	
}
