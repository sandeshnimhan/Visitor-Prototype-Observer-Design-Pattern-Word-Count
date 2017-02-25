package wordCount.visitors;

import wordCount.dsForStrings.SBBSTNode;
import wordCount.dsForStrings.SelfBalancingBinarySearchTree;

public class CloneVisitor implements Visitor{

	SelfBalancingBinarySearchTree sbbst;
	public CloneVisitor(SelfBalancingBinarySearchTree sbbstTemp) {
		// TODO Auto-generated constructor stub
		sbbst=sbbstTemp;
	}

	@Override
	public void visit(Populate populate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(WordCount wordCount) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void visit(SBBSTNode node)  {
		// TODO Auto-generated method stub
		try {
			sbbst.preorderClone();
			sbbst.inorderClone();
			//node.clone(node);
		} 
		catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
