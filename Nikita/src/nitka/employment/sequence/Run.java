package nitka.employment.sequence;

import nitka.employment.tree.Tree;

public class Run {

    public static void main(String[] args) {
        // Check 1st task (Parameters in SeqRepeat class)
        SeqRepeat sr = new SeqRepeat();
        sr.ClearRepeats();
        
        // Check 2nd task (Parameters in DistribRepeat class)
        DistribRepeat dr = new DistribRepeat();
        dr.ClearRepeats();
        
        
        // Check 3rd task (Parameters in Tree class)
        Tree tree = new Tree();
        tree.print();
        tree.printHeight();
        tree.draw();
    }
}
