package wordCount.dsForStrings;

import java.util.ArrayList;
import java.util.Scanner;

import wordCount.visitors.Populate;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCount;

/* Class SBBSTNode */
public class SBBSTNode implements Cloneable,Subject,Observer
{    
    SBBSTNode left, right;
    ArrayList<Observer> observers = new ArrayList<Observer>();
    String data;
    int height;
    int count;
    int isChanged;
    SelfBalancingBinarySearchTree sbbst;
    static SelfBalancingBinarySearchTree sbbstCloned=new SelfBalancingBinarySearchTree();
    static SBBSTNode node;

    /* Constructor */
    public SBBSTNode()
    {
        left = null;
        right = null;
        data = null;
        height = 0;
        count=1;
        isChanged=0;
    }
    /* Constructor */
    public SBBSTNode(String word)
    {
        left = null;
        right = null;
        data = word;
        height = 0;
        count=1;
        isChanged=0;
    }
	public SBBSTNode(SelfBalancingBinarySearchTree sbbstTemp) {
		// TODO Auto-generated constructor stub
		sbbst=sbbstTemp;
	}
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}    
	
	public Object clone(SBBSTNode r) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//call inorder and get each node and call clone on it.//do not use inorder use preorder instead
		//then call modify method in driver and update count and is changed in some nodes and 
		//by using observer update backup clones
		
		SBBSTNode cloned=(SBBSTNode)r.clone();
		//sbbstCloned.insertCloned(cloned);
	
		return cloned;
	}
	public void cloneNode(SBBSTNode r) {
		// TODO Auto-generated method stub
		node=r;
	}
	@Override
	public void update(int count) {
		// TODO Auto-generated method stub
		this.count=count;
	}
	
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer o: observers)
		{
			o.update(this.count);
		}
	}
}