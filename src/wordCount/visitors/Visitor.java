package wordCount.visitors;

import wordCount.dsForStrings.SBBSTNode;

public interface Visitor {
	public void visit(Populate populate);
	public void visit(WordCount wordCount);
	public void visit(SBBSTNode node);
}
