package nitka.employment.sequence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SeqRepeat {
    
    private List<Integer> source;
    private List<Integer> dest;
        
    private static int MAX_INT = 6;  // Maximum value of list element
    private static int SEQ_IN_LIST = 6; // Parameter for counstructor - maximum number of subseq. to generate
    private static int MAX_SEQ = 3; // Search parameter. Maximum number of repeated number to delete from source list
    private static int MAX_SEQ_LIM = 4; // Parameter for constructor - maximum number of numbers in subseq. to generate
    
    
    
    public SeqRepeat() {
        Random rand = new Random();
        source = new ArrayList<Integer>();
        
        for (int i=0;i<SEQ_IN_LIST;i++){ // We build list as number of subsequences
            Integer seqLimit = rand.nextInt(MAX_SEQ_LIM);
            Integer value = rand.nextInt(MAX_INT);         
            for (int j=0;j<seqLimit;j++)
                source.add(value);
        }
          
        System.out.println("Source list is: " + source);
    }
    
    
    
    public void ClearRepeats(){
        dest = new ArrayList<Integer>();
        
        Integer lastValue = source.get(0); // initializaiton
        Integer floatNumber = 1;
        for(int i=1; i<source.size();i++){
            if( source.get(i).equals(lastValue)) // increase number of repeats
                floatNumber++;
            
            else{                                // if sequence of repeats ends
                if (floatNumber < MAX_SEQ ){     // check if sequence is allowed to copy
                    for (int j=i-floatNumber;j<i;j++)
                        dest.add( source.get(j));
                }                                // else we do nothing
                floatNumber = 1;                 // and reinitialize floats
                lastValue =  source.get(i);
            }        
        }
        if (floatNumber < MAX_SEQ )              // don't forget about last sequence we could face
            for (int j=source.size()-floatNumber;j<source.size();j++)
                dest.add( source.get(j));
            
            
        System.out.println("Dest list is:   " + dest);
    }

}
