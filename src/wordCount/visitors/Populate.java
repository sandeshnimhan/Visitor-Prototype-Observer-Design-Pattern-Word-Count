package wordCount.visitors;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;


import wordCount.dsForStrings.SelfBalancingBinarySearchTree;
import wordCount.util.FileProcessor;

public class Populate {

	String str;
	int firstWord=1,count=0;
	FileProcessor fp=new FileProcessor();
	SelfBalancingBinarySearchTree sbbst;//=new SelfBalancingBinarySearchTree();
	
	public Populate(SelfBalancingBinarySearchTree sbbstTemp){
		sbbst=sbbstTemp;
	}
	
	public void populateDataStructure() {
		// TODO Auto-generated method stub
		fp.initiateFileProcessing();
		int length=0,i=0;
		while(true)
		{
			str=fp.readOneLine();
			if(str==null){
				//System.out.println("------");
				break;
				
			}
			else{
				//System.out.println(str);
				String[] line=str.split("\\s+");
				
				for(i=0;i<line.length;i++)
				{
					//System.out.println(line[i]);
					if(line[i].length()>0){
						sbbst.insert(line[i]);
						count++;
					}
					//length--;
					//i++;
				}
				//System.out.println(line.length);
				//while((length=line.length)>0 & i<=length-1)
				{
					
					//System.out.println(line[i]);
					
					//System.out.println(line[i]);
					
					/*while(true)
					{
						
						if(true){
						
						}
						
						else
						{
							System.out.println(line[i]);
							
						}
					
					}*/
					length--;
					i++;
					//System.out.println(length+"\n"+i);
				}
			}
		}
		//sbbst.inorder();
		//System.out.println("Total Words: "+ count);
		//sbbst.inorder();
		//System.out.println("Distinct Words: "+ sbbst.distinctCount);
		fp.closeFiles();
	}

	public void accept(Visitor visitor)
	{
		visitor.visit(this);
	}
}

