package wordCount.visitors;

import wordCount.dsForStrings.SBBSTNode;

public class PopulateVisitor implements Visitor{

	@Override
	public void visit(Populate populate) {
		// TODO Auto-generated method stub
		populate.populateDataStructure();
	}

	@Override
	public void visit(WordCount wordCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SBBSTNode node) {
		// TODO Auto-generated method stub
		
	}

}
