package wordCount.dsForStrings;

public class SelfBalancingBinarySearchTree
{
    private SBBSTNode root,clonedRoot=null	;
    SBBSTNode node=new SBBSTNode();
    SBBSTNode clonedNode;
    public int distinctCount=0,totalWords=0,characterCount=0;

    /* Constructor */
    public SelfBalancingBinarySearchTree()
    {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }

    /* Make the tree logically empty */
    public void clear()
    {
        root = null;
    }
    /* Function to insert data */
    public void insert(String data)
    {
        root = insert(data, root);
    }
    /* Function to get height of node */
    private int height(SBBSTNode t )
    {
        return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    private String max(String lhs, String rhs)
    {
        return (lhs.compareTo(rhs)>0) ? lhs : rhs;
    }
    /* Function to insert data recursively */
    private SBBSTNode insert(String x, SBBSTNode t)
    {
        if (t == null){
            t = new SBBSTNode(x);
            //distinctCount++;
        }
        else if (x.compareTo(t.data)<0)
        {
        	//distinctCount++;
            t.left = insert( x, t.left );
            if (height( t.left ) - height( t.right ) == 2)
                if (x.compareTo(t.left.data)<0)
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if (x.compareTo(t.data)>0)
        {
        	//distinctCount++;
            t.right = insert( x, t.right );
            if (height( t.right ) - height( t.left ) == 2)
                if (x.compareTo(t.right.data)>0)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
        { // Duplicate; do nothing
        	
        	t.count++;
        }
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    
    public void insertCloned(SBBSTNode x)
    {
        clonedRoot = insertCloned(x, clonedRoot);
    }
    private SBBSTNode insertCloned(SBBSTNode x,SBBSTNode t)
    {
    	//SBBSTNode t=root;
        if (t == null){
            t = x;
            //distinctCount++;
        }
        else if (x.data.compareTo(t.data)<0)
        {
        	//distinctCount++;
            t.left = insertCloned( x, t.left );
            if (height( t.left ) - height( t.right ) == 2)
                if (x.data.compareTo(t.left.data)<0)
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if (x.data.compareTo(t.data)>0)
        {
        	//distinctCount++;
            t.right = insertCloned( x, t.right );
            if (height( t.right ) - height( t.left ) == 2)
                if (x.data.compareTo(t.right.data)>0)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
        { // Duplicate; do nothing
        	
        	//t.count++;
        }
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    
    private int max(int height, int height2) {
		// TODO Auto-generated method stub
    	return (height < height2) ? height : height2;
	}

	/* Rotate binary tree node with left child */     
    private SBBSTNode rotateWithLeftChild(SBBSTNode k2)
    {
        SBBSTNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private SBBSTNode rotateWithRightChild(SBBSTNode k1)
    {
        SBBSTNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private SBBSTNode doubleWithLeftChild(SBBSTNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private SBBSTNode doubleWithRightChild(SBBSTNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(SBBSTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(String val)
    {
        return search(root, val);
    }
    private boolean search(SBBSTNode r, String val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            String rval = r.data;
            if (val.compareTo(rval)<0)
                r = r.left;
            else if (val.compareTo(rval)>0)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(SBBSTNode r)
    {
        if (r != null)
        {
            inorder(r.left);
          // System.out.println(r.data +" ");
           //System.out.println(r.count);
            totalWords+=r.count;
            distinctCount++;
            characterCount+=((r.data).length())*(r.count);
            inorder(r.right);
        }
    }
    public void inorderClone()
    {
        inorderClone(clonedRoot);
    }
    private void inorderClone(SBBSTNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            //return r;
            //System.out.println(r.data +" ");
            //System.out.println(r.count);
             totalWords+=r.count;
             distinctCount++;
             characterCount+=((r.data).length())*(r.count);
            inorder(r.right);
           
        }
		
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(SBBSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    
    public void preorderClone() throws CloneNotSupportedException
    {
        preorderClone(root);
    }
    private SBBSTNode preorderClone(SBBSTNode r) throws CloneNotSupportedException
    {
        if (r != null)
        {
            //System.out.print(r.data +" ");
        	//return r;
        	clonedNode=(SBBSTNode)node.clone(r);
        	node.registerObserver(clonedNode);
        	insertCloned(clonedNode);
            preorderClone(r.left);             
            preorderClone(r.right);
        }
		return r;
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(SBBSTNode r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }

	public void updateCount() {
		// TODO Auto-generated method stub
		inorderUpdate();
	}

	public void inorderUpdate()
	{
		inorderUpdate(root);
	}
	private void inorderUpdate(SBBSTNode r) {
		// TODO Auto-generated method stub
		 if (r != null)
	        {
	            inorderUpdate(r.left);
	            r.count+=2;
	            node.notifyObservers();
	            inorderUpdate(r.right);
	           
	        }
	}

	
    private void displayBST(SBBSTNode r)
    {
        if (r != null)
        {
            displayBST(r.left);
            //return r;
            System.out.println(r.data +" ");
            System.out.println(r.count);
            
            displayBST(r.right);
           
        }
		
    }
	
	public void displayBST() {
		// TODO Auto-generated method stub
		displayBST(root);
	}

	
    private void displayBackupBST(SBBSTNode r)
    {
        if (r != null)
        {
            displayBackupBST(r.left);
            //return r;
            System.out.println(r.data +" ");
            System.out.println(r.count);
            
            displayBackupBST(r.right);
           
        }
		
    }
    
	public void displayBackupBST() {
		// TODO Auto-generated method stub
		displayBackupBST(clonedRoot);
	}


	   
}