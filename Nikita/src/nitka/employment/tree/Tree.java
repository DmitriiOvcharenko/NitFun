package nitka.employment.tree;

public class Tree {
    
    protected static int MAX_BRANCES = 4;   // Maximum number of branches beginning form parent
    protected static int MAX_BRANCH_HEIGHT = 5;  // Maximum height of one branch
    protected static int MAX_LEVEL = 5; // Maximum number of branch levels in the tree
    
    private Branch root;
    private Integer treeHeight;
    
    public Tree() {
        treeHeight = null; // the hight is unknown
        root = new Branch(); // generate the tree
        root.populate(1);
    }
    
    public Tree(Branch root) {
        treeHeight = null; // the hight is unknown
        this.root = root;
    }
    
    public void print(){
        System.out.println("This is a statistical information about generated tree");
        root.print();
    }
    
    public void draw(){
        System.out.println("This is how the tree looks like. Copy-paste this output in some text editor and check the height");
        if(treeHeight == null); // if the height is unknown - we can not draw
            calcHeight();
        root.draw();
        System.out.println();// new line;
    }
    
    public void printHeight(){
        System.out.println("The height of the highest branch of the tree is " + calcHeight());
    }
    
    public Integer calcHeight(){
        return root.calcHeight(0);
    }
    
    
    
    
    protected void setHeightIfLess(Integer height){
        if(treeHeight<height)
            treeHeight = height;
    }

    public void setRoot(Branch root) {
        this.root = root;
    }
}
