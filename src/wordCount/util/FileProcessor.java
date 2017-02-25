package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import wordCount.driver.*;

public class FileProcessor {
	
	static String str=null;
	FileReader fr;
	static BufferedReader br;
	FileWriter fw;
	static BufferedWriter bw;
	public void initiateFileProcessing()
	{
		try{
			fr=new FileReader(Driver.inputFile);
			/*File outputFile=new File(outputFile);
			if(!outputFile.exists())
			{
				outputFile.createNewFile();
			}*/
			br=new BufferedReader(fr);
			fw=new FileWriter(Driver.outputFile);
			bw=new BufferedWriter(fw);
			
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}	
		catch(IOException e)
			{
			e.printStackTrace();
			}

	}
	//public 
	

	public static  String readOneLine() {
		// TODO Auto-generated method stub
		try{
			str=br.readLine();
			return str;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}
	
	public static void writeIntoFile(int totalWords,int distinctwords,int characterCount){
		try{
			bw.write("Total words: "+totalWords+"\n"+"Distinct words: "+distinctwords+"\n"+"Character count: "+characterCount);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void closeFiles() {
		// TODO Auto-generated method stub
		try {
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
