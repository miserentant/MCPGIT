package be.ucl.info.ingi1122.highlight.tools;
import java.util.ArrayList;
public class PortionSet {
	private ArrayList<Portion> MyArray;
	private int number;
	public PortionSet(){
		MyArray = new ArrayList<Portion>();
		number=0;
	}
	
	public void Add(Portion p){
		if(number==0){
			MyArray.add(p);
			number++;
		}
		else{
			Portion p1 = MyArray.get(number);
			if(chevauchement(p1,p)){
				p1.end=p.end;
			}
			else{
				MyArray.add(p);
				number++;
			}
		}
		
	}
	public boolean chevauchement(Portion p1, Portion p2){
		 return p2.getBegin()<p1.getEnd();
	}
	
	/*
	 * @pre prend un indice positif ou nul en parametre 
	 * @post renvoi la portion a l'indice passe en parametre
	*/
	public Portion get(int position) {
		return MyArray[position];
	}
	public int getNumberElem(){
		return this.number;
	}
	

}
