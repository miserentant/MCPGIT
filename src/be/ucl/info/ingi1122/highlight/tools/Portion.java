package be.ucl.info.ingi1122.highlight.tools;

public class Portion {
	public int begin;
	public int end;
	public Portion(int begin, int end){
		this.begin=begin;
		this.end = end;
	}

	int getBegin(){
		return this.begin;
	};

	int getEnd(){
		return this.end;
	};

}
