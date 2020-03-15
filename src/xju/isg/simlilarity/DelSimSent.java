package xju.isg.simlilarity;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

public class DelSimSent {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String path = "source/情感资源/neg_corpus.txt";
		String log2 = "log/log3.txt";
		String noSimSent = "source/情感资源/neg_corpus_noSim.txt";
		
		ArrayList<String> sameID = new ArrayList<String>();
		Vector<String> vec = readFile(path, "utf-8");
		for(int i = 0; i < vec.size(); i++)
		{
			if(sameID.contains(String.valueOf(i)))  // contains
				continue;
			String[] words1 = vec.get(i).split(" +");
			for(int j = i; j < vec.size() ; j++)
			{ 
				if(i == j)
					continue;
				if(sameID.contains(String.valueOf(j)))
					continue;
				String[] words2 = vec.get(j).split(" +");
				int sim = WordsSim(words1, words2);
				if(sim == 1)
					sameID.add(String.valueOf(j));
			}
		}
		
		PrintWriter pwLog = setWriter(log2, "utf-8");
		PrintWriter pwNoSimSent = setWriter(noSimSent, "utf-8"); 
		for(int i = 0; i < vec.size(); i++)
		{
			if(sameID.contains(String.valueOf(i)))
			{
				pwLog.println("ID：" + i + "===" + vec.get(i)); 
				continue;
			}
			pwNoSimSent.println(vec.get(i)); 
		} 
		pwLog.close();  
		pwNoSimSent.close(); 
		
		System.out.println("Done!"); 
		Toolkit.getDefaultToolkit().beep();  
	} 
	
	private static int WordsSim(String[] words1, String[] words2) 
	{ 
		int simWords = 0; 
		for(int i = 0; i < words1.length; i++)
		{
			boolean b = false;
			for(int j = 0; j < words2.length; j++)
			{
				if(words1[i].trim().hashCode() == words2[j].trim().hashCode())
				{
					simWords++;
					b = true;
					break;
				}
				if(b) break;
			}
		}
		if(simWords == words1.length && simWords == words2.length)
			return 1;
		else
			return 0;
	}
	
	private static synchronized Vector<String> readFile(String inPath, String encoding) {
		Vector<String> list = new Vector<String>();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(inPath) , encoding));
			String line = null;
			while((line = reader.readLine()) != null)
			{
				list.add(line);
			}
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	private static synchronized PrintWriter setWriter(String outfile, String encoding) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outfile), encoding)); 
		} catch(Exception e) {
			System.err.println("new writer error!");
			e.printStackTrace();
		}
		return writer;
	}
}
