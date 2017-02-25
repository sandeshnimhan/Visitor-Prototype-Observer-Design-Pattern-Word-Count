package wordCount.visitors;

import wordCount.dsForStrings.SBBSTNode;
import wordCount.dsForStrings.SelfBalancingBinarySearchTree;

public class ObserverVisitor implements Visitor{

	SelfBalancingBinarySearchTree sbbst;
	public ObserverVisitor(SelfBalancingBinarySearchTree sbbstTemp) {
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
	public void visit(SBBSTNode node) {
		// TODO Auto-generated method stub
		sbbst.updateCount();
		sbbst.displayBST();
		System.out.println("************************************************************************************************************************");
		sbbst.displayBackupBST();
	}

}
