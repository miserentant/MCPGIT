
public class PortionSet {
    
    private /*@ spec_public @*/ int[] positions;
    private /*@ spec_public @*/ int size;
    private /*@ spec_public @*/ final int capacity;    
    //@ghost public int lastBegin;
    
    /*@ public invariant positions != null;
    @ public invariant positions.length == 2*capacity;
    @ public invariant 0 <= size;
    @ public invariant size <= capacity;
    @ public invariant size*2 <= positions.length; // redundant
    @ public invariant (\forall int i; 0 <= i && i < 2*size-1; positions[i] < positions[i+1]);
    @ public invariant size >= 1 ==> begin(size-1) <= lastBegin; */
    
    /*@ requires max >= 0;
      @ ensures positions.length == max*2;
      @ ensures size == 0;
      @ ensures capacity == max; */
    public /*@ pure @*/ PortionSet(int max) {
        positions = new int[max*2];
        capacity = max;
        size = 0;
    }
    
    /*@ ensures \result <==> (\exists int i; 0 <= i && i < size; begin(i) <= n && n < end(i)); @*/
    public /*@ pure @*/ boolean contains(int n) {
        boolean result = false;
        //@ loop_invariant 0 <= i && i <= size;
        //@ loop_invariant result <==> (\exists int k; 0 <= k && k < i; begin(k) <= n && n < end(k));
        //@ decreases size - i;
        for (int i = 0; !result && i < size; i++) {
            if (begin(i) <= n && n < end(i)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    /*@ requires size < capacity;
      @ requires lastBegin <= begin && begin < end;
      @ ensures begin(size-1) <= begin && end <= end(size-1);
      @ modifies size, positions[*], lastBegin;
      @ ensures (\forall int i; 0 <= i && i < size*2-2; positions[i] == \old(positions[i]));
      @ ensures size == \old(size) ==> (begin(size-1) == \old(begin(size-1)) && end(size-1) == Math.max(\old(end(size-1)), end));
      @ ensures size == \old(size)+1 ==> (begin(size-1) == begin && end(size-1) == end); */
    public void add(int begin, int end) {
        if (size == 0) {
            addInterval(begin, end);
        } else {
            if (begin <= end(size-1)){
                //@ assert begin <= end(size-1) && begin(size-1) <= end; // OpenJML en aura besoin...
                updateLastInterval(begin, end);
            } else {
                addInterval(begin, end);
            }
        }
    }
    
    /*@ requires begin < end;
      @ requires size >= 1 ==> end(size-1) < begin;
      @ requires size < capacity;
      @ ensures size == \old(size)+1;
      @ ensures positions[size*2-2] == begin && positions[size*2-1] == end;
      @ modifies size, positions[*], lastBegin;
      @ ensures (\forall int i; 0 <= i && i < \old(size)*2; positions[i] == \old(positions[i])); */
    private void addInterval(int begin, int end) {
        positions[size*2] = begin;
        positions[size*2+1] = end;
        size++;
        //@ set lastBegin = begin;
    }
    
    /*@ requires size >= 1;
      @ requires begin < end;
      @ requires begin(size-1) <= begin;
      @ ensures positions[2*size-1] == Math.max(\old(positions[2*size-1]), end);
      @ modifies positions[size*2-1]; */
    private void updateLastInterval(int begin, int end) {
        positions[size*2-1] = end >= end(size-1) ? end : end(size-1);
    }

    // Une méthode annotée "helper" ne doit pas garantir les invariants de classe (post).
    // En contrepartie, ils ne sont pas non plus garantis lors de l'appel (pre).
    // Cela permet d'appeler begin(int) et end(int) à l'intérieur de fonctions qui cassent (temporairement) les invariants.
    // Vous pouvez simplement ignorer ce mot-clé car vous n'en avez pas besoin ailleurs.
    
    // Les deux méthodes suivantes sont complètement spécifiées.
    // Vous ne devez normalement pas y toucher.

	/*@ private normal_behavior
	  @   requires size*2 <= positions.length;
	  @   requires 0 <= i && i < size;
	  @   ensures \result == positions[i*2];
	  @   modifies \nothing;
	  @ pure helper */
	public int begin(int i) {
		return positions[i*2];
	}
    
	/*@ private normal_behavior
	  @   requires size*2 <= positions.length;
	  @   requires 0 <= i && i < size;
	  @   ensures \result == positions[i*2+1];
	  @   modifies \nothing;
	  @ pure helper */
	public int end(int i) {
		return positions[i*2+1];
	}
}
