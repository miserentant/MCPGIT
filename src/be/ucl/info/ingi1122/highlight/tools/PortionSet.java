package be.ucl.info.ingi1122.highlight.tools;
import java.util.ArrayList;
public class PortionSet {
	public ArrayList<Portion> MyArray;
	public int number;
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
	

}
