package nitka.employment.tests;

import java.util.ArrayList;

import java.util.Arrays;

import nitka.employment.tree.Branch;
import nitka.employment.tree.Tree;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    Tree tr;
    public TreeTest() {
    }

    @Before
    public void setUp() throws Exception {
        Branch root = new Branch();
        Branch child1 = new Branch();
        Branch child2 = new Branch();
        Branch child3 = new Branch();
        
        root.setLevel(1);
        root.setHeight(4);
        child1.setLevel(2);
        child2.setLevel(2);
        child1.setHeight(3);
        child2.setHeight(5);
        child3.setLevel(3);
        child3.setHeight(1);
        child1.setChildren(new ArrayList<Branch>(Arrays.asList(child3)));
        root.setChildren(new ArrayList<Branch>(Arrays.asList(child1,child2)));
        
        tr = new Tree();        
        tr.setRoot(root);
        
    }

    /**
     * @see Tree#calcHeight()
     */
    @Test
    public void testCalcHeight() {
        Assert.assertEquals((int)tr.calcHeight(), 9);
     
    }
}
