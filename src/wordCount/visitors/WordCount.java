package wordCount.visitors;

import wordCount.dsForStrings.SelfBalancingBinarySearchTree;
import wordCount.util.FileProcessor;

public class WordCount {
	SelfBalancingBinarySearchTree sbbst;
	FileProcessor fp=new FileProcessor();
	
	public WordCount(SelfBalancingBinarySearchTree sbbstTemp){
		sbbst=sbbstTemp;
	}
	
	public WordCount() {
		// TODO Auto-generated constructor stub
	}

	public void countWords() {
		// TODO Auto-generated method stub
	
		sbbst.inorder();
		//System.out.println("**********");
		/*System.out.println("Total Words: "+sbbst.totalWords );
		System.out.println("Distinct Word Count: "+sbbst.distinctCount);
		System.out.println("Character Count: "+sbbst.characterCount);*/
		fp.initiateFileProcessing();
		fp.writeIntoFile(sbbst.totalWords,sbbst.distinctCount,sbbst.characterCount);
		fp.closeFiles();
	}

	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}
}
