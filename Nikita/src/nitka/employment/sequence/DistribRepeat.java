package nitka.employment.sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DistribRepeat {
    
    private List<Integer> source;
    private List<Integer> dest;
        
    private static int MAX_INT = 6;  // Maximum value of list element
    private static int LIST_SIZE = 16; // Parameter for counstructor 
    private static int MAX_REPEAT = 3; // Search parameter. Maximum number of repeated number to delete from source list
    
    
    public DistribRepeat() {
        Random rand = new Random();
        source = new ArrayList<Integer>();
        
        for (int i=0;i<LIST_SIZE;i++){ // We build list 
             source.add((Integer)rand.nextInt(MAX_INT));
        }
          
        System.out.println("Source list is: " + source);
        
    }
    
    public void ClearRepeats(){
         Map<Integer,Integer> repeats = new HashMap<Integer,Integer>();
         dest = new ArrayList<Integer>();
        
         for(Integer i: source){
             if(repeats.get(i)==null)
                 repeats.put(i,1);
             else
                 repeats.put(i,repeats.get(i)+1);
         }
         for(Integer i: source){
             if(repeats.get(i)<MAX_REPEAT)
                 dest.add(i);
         }
        System.out.println("Dest list is:   " + dest);
    }
}
