package wordCount.visitors;

import wordCount.dsForStrings.SBBSTNode;

public class WordCountVisitor implements Visitor{

	@Override
	public void visit(Populate populate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(WordCount wordCount) {
		// TODO Auto-generated method stub
		wordCount.countWords();
	}

	@Override
	public void visit(SBBSTNode node) {
		// TODO Auto-generated method stub
		
	}

}
