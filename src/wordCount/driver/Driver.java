package wordCount.driver;

import wordCount.dsForStrings.SBBSTNode;
import wordCount.dsForStrings.SelfBalancingBinarySearchTree;

import wordCount.visitors.CloneVisitor;
import wordCount.visitors.ObserverVisitor;
import wordCount.visitors.Populate;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCount;
import wordCount.visitors.WordCountVisitor;

public class Driver {
	
	 public static String inputFile;
	 public static String outputFile;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int argsCount=args.length;
		if(argsCount!=3)
		{
			System.out.println("Please enter valid number of arguments.");
			System.exit(0);
		}
		inputFile=args[0];
		outputFile=args[1];
		int NUM_ITERATIONS=Integer.parseInt(args[2]);
		SelfBalancingBinarySearchTree sbbst=null;
		long startTime=System.currentTimeMillis();
			for(int i=0;i<NUM_ITERATIONS;i++)
			{
				sbbst=new SelfBalancingBinarySearchTree();
				Populate populate= new Populate(sbbst);
				WordCount wordCont=new WordCount(sbbst);
				//Clone clone=new Clone();
				
				Visitor populateVisitor=new PopulateVisitor();
				Visitor wordCountVisitor=new WordCountVisitor();
				
				populate.accept(populateVisitor);
				wordCont.accept(wordCountVisitor);
				
			}
		long finishTime=System.currentTimeMillis();
		long totalTime=(finishTime-startTime)/NUM_ITERATIONS;
   	System.out.println("Total Time Taken:" + totalTime);
		//sbbst=new SelfBalancingBinarySearchTree();
		SBBSTNode cloneNode=new SBBSTNode(sbbst);
		Visitor cloneVisitor=new CloneVisitor(sbbst);
		Visitor observerVisitor=new ObserverVisitor(sbbst);
		cloneNode.accept(cloneVisitor);
		cloneNode.accept(observerVisitor);
		System.out.println("Total Time Taken:" + totalTime);
			
	}

}
