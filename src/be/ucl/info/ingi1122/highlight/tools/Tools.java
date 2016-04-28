package be.ucl.info.ingi1122.highlight.tools;
import com.sun.jmx.snmp.agent.SnmpUserDataFactory;

import javax.sound.sampled.Port;

public class Tools {
	
	public static Portion[] tabportion;
	public static PortionSet portionset;

	public static Portion[] quoiSurligner(char[] texte, char[][] mots) {
		
		boolean bool = correspond(texte, mots);
		if(!bool){
			System.out.println("No match found");
			return null;
		}
		portionset = portioncreate(texte,mots);
		tabportion = new Portion[portionset.getNumberElem()];
		for(int i =0; i<portionset.getNumberElem()-1; i++){
			try {
				tabportion[i] = portionset.getElem(i);
			}
			catch (ArrayIndexOutOfBoundsException e) {System.out.println("cherche élément en dehors du tableau");}
		}
		return tabportion;
	}
	public static PortionSet portioncreate(char [] texte, char[][] mots){
		PortionSet portionset = new PortionSet();
		int i,j;
		for(i=0;i<texte.length;i++){
			for(j=0;j<mots.length;j++){
				if(compare(i,texte,mots[j])){
					portionset.Add(new Portion(i,i+mots[j].length));
				}
			}
		}
		return portionset;
	
	}
	/*
	 * @pre prend un texte et une liste de mots en parametre
	 * @post renvoie true si tous les mots se trouve dans le texte
	 */
	
	public static boolean correspond(char[] texte, char[][] mots) {

		for (int i=0; i< mots.length-1; i++){
			if ( oneMatch(texte, mots[i]) == false){return false;}
		}
		
		return true;
	}

	public static boolean oneMatch(char[] texte, char[] mot){
		 int i=0;
	        boolean match=false;
	        while(i < texte.length-mot.length-1 && !match){
	            match= compare(i,texte,mot);
	            i++;
	        }
	        return match;
	}
	

	 /* @pre prend un texte, une position p dans ce texte et un mot en argument
	 * @post renvoit true si le mot se trouve a la position p du texte
	 */
    public static boolean compare(int position, char[] texte, char[] mot){
        int j=0;
        while (j< mot.length && texte[position+j]==mot[j]){
            j=j+1;
        }
        if (j == mot.length){
            return true;
        }
        else {
            return false;
        }
    }


	
}
