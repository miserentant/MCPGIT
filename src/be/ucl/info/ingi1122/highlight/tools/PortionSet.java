package be.ucl.info.ingi1122.highlight.tools;
import java.util.ArrayList;

public class PortionSet {
	
	private ArrayList<Portion> MyArray;
	
	public PortionSet(){
		MyArray = new ArrayList<Portion>();
		
	}
	
	public void Add(Portion p){
		if(p==null){return;}
		else if(MyArray.size()==0){
			MyArray.add(p);
			
		}
		else{
			Portion p1 = MyArray.get(MyArray.size()-1);
			if(inferieur(p1,p)){
			
			}
			else if(chevauchement(p1,p)){
				p1.end=p.end;
			}
			else{
				MyArray.add(p);
				
			}
		}
		
	}
	public boolean inferieur(Portion p1, Portion p2){
		return p2.getEnd()<=p1.getEnd();
	}
	public boolean chevauchement(Portion p1, Portion p2){
		 return p2.getBegin()<=p1.getEnd();
	}
	 public Portion[] toTab(){
	        Portion[] tabportion = new Portion[this.MyArray.size()];
	        tabportion = MyArray.toArray(tabportion);
	        System.out.println(MyArray.size());
	        return tabportion;
	    }
	/*
	 * @pre prend un indice positif ou nul en parametre 
	 * @post renvoi la portion a l'indice passe en parametre
	*/
	public Portion getElem(int position) {
		return MyArray.get(position);
	}
	public int getNumberElem(){
		return this.MyArray.size();
	}
	

}
