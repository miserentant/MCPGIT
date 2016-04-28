package be.ucl.info.ingi1122.highlight.tools;



public class Tools {

	public static Portion[] quoiSurligner(char[] texte, char[][] mots) {
        


      
        PortionSet portionSet = matchSurligner(texte,mots);
           


        return portionSet.toTab();
	}

    public  static  PortionSet matchSurligner(char[] texte, char[][] mots){
        PortionSet result  = new PortionSet();
        int k;
        for(k=0;k<texte.length;k++){
        	int i=0;
        	while (i< mots.length){
        		if(k <= texte.length-mots[i].length){
        			if(compare(k,texte,mots[i])){
        				result.Add(new Portion(k,k+mots[i].length));
        			}
        		}
        		i++;
        	}
        }
        return result;
    }
	

	public static boolean correspond(char[] texte, char[][] mots) {

		for (int i=0; i< mots.length; i++){
			if ( oneMatch(texte, mots[i]) == false){return false;}
		}
		
		return true;
	}

	public static boolean oneMatch(char[] texte, char[] mot){
		 int i=0;
	        boolean match=false;
	        while(i <= texte.length-mot.length && !match){
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
