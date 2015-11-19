package nitka.employment.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Branch {
    
    private Integer groundHeight;
    
    private List<Branch> children;
    private Integer height;
    private Integer level;
    public Branch() {
       this(1);        
    }
    
    public Branch (int level){
        Random rand = new Random();
        
        this.level = level;
        height = rand.nextInt(Tree.MAX_BRANCH_HEIGHT)+1; // height can not be less than 1
        children = new ArrayList<Branch>();
        int branchChildren = rand.nextInt(Tree.MAX_BRANCES);// number of branches can be less than 1
        if (level <= Tree.MAX_LEVEL)  // if tree is not full
            for(int i=0;i<branchChildren;i++) // populate children
                children.add(new Branch(level+1)); // at next level
    }
    
    public void print(){
        System.out.println(this);
        for(Branch child: children)
            child.print();
    }
    
    @Override
    public String toString(){
        return ("Branch level: "+ level + ", " + height + " meters high, has " + children.size() + " children");
    }
    
    
    protected Integer calcHeight(Integer parentHeight){
        setGroundHeightFromParent(parentHeight); // find height of branch form the ground
        int childHeight = 0;
        int maxHeight = 0;
        if(children.isEmpty()) // if this is the last level, it's time to collect results
            return getGroundHeight();
        else
            for(Branch child: children){  // if it has children, some recursion to drill deeper
                childHeight = child.calcHeight(getGroundHeight());  
                if (maxHeight<childHeight)
                    maxHeight=childHeight;
            }
            return maxHeight;
    }


    public void setGroundHeightFromParent(Integer parentGroundHeight) {
        this.groundHeight = parentGroundHeight + height;
    }

    public Integer getGroundHeight() {
        if (groundHeight == null)
            groundHeight = height;
        return groundHeight;
    }
    
    
    protected void draw(){
            System.out.println();
        for(int i=0;i<groundHeight-height;i++)
            System.out.print(" ");
        for(int i=0;i<height;i++)
            System.out.print("-");
        for(Branch child:children){
            child.draw();
        }
        
    }
}
