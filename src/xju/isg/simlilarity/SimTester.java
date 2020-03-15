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
import java.util.Scanner;
import java.util.Vector;

public class SimTester {

	/**
	 * @param args
	 * @author 阿吉
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		String fileA = args[0];  //  购买的预料
		String fileB = args[1];  //  原有的预料
		
		String log = "log.txt";
		String statistics = "show.txt";
		
		String mergePath = null;
		int merge = Integer.valueOf(args[2].trim());
		if(merge == 1)
		{
			System.out.print("Please input merged file save path >>");
			Scanner in = new Scanner(System.in);
			mergePath = in.nextLine();
			mergePath = mergePath.replaceAll(" ", "").trim();
		}
		//  step1 : read corpus.
		Vector<String> vec1 = readFile(fileA, "utf-8");
		Vector<String> vec2 = readFile(fileB, "utf-8");
		//  step2 : test corpus similarity.
		TestVecSim(vec1, vec2, log);
		//  step3 : statistics and show results.
		Statistics(vec1, vec2, log, statistics);
		//  step4 : merge two corpus to one text file if necessary.
		if(merge == 1)
			MergeSent(vec1, vec2, log, mergePath);
		
		System.out.println("Done!");
		Toolkit.getDefaultToolkit().beep(); 
	}
	
	private static void MergeSent(Vector<String> vec1, Vector<String> vec2, String log, String mergePath)
	{
		Vector<String> vecLog = readFile(log, "utf-8");
		PrintWriter pw = setWriter(mergePath, "utf-8");
		
		ArrayList<Integer> sameID = new ArrayList<Integer>();
		
		for(int i = 0; i < vecLog.size(); i++)
		{
			if(vecLog.get(i).contains("completely the same"))
			{
				sameID.add(Integer.valueOf(vecLog.get(i).split(",")[0].replaceAll("A", "")) - 1);
			}
		}
		
		for(int i = 0; i < vec2.size(); i++)
			pw.println(vec2.get(i));
		
		for(int i = 0; i < vec1.size(); i++)
		{
			if(!sameID.contains(i))
				pw.println(vec1.get(i)); 
		}
		
		pw.close();
	}
	
	private static void Statistics(Vector<String> vec1, Vector<String> vec2, String log, String statistics)
	{
		Vector<String> vecLog = readFile(log, "UTF-8");
		PrintWriter pw = setWriter(statistics, "UTF-8");
		pw.println("SHOW RESULT: \r\n");
		pw.println("File A has : " + vec1.size() + " sentences.");
		pw.println("File B has : " + vec2.size() + " sentences.");
		
		int three = 0, four = 0, five = 0, AinB = 0, BinA = 0, same = 0;
		for(int i = 0; i < vecLog.size(); i++)
		{
			String info = vecLog.get(i).split("===")[1].trim();
			switch (info) {
			case "completely the same":{
				++same;
				break;
			}
			case "inclusion A>B":{
				++BinA;
				break;
				}
			case "inclusion B>A":{
				++AinB;
				break;
			}
			case "has 3 the same words":{
				++three;
				break;
			}
			case "has 4 the same words":{
				++four;
				break;
			}
			case "has 5 the same words":{
				++five;
				break;
			}
			default:
				break;
			}
		}
		
		double threePer = 100.0 * ( Double.valueOf(three) / Double.valueOf(vec1.size())); 
		double fourPer = 100.0 * ( Double.valueOf(four) / Double.valueOf(vec1.size())); 
		double fivePer = 100.0 * ( Double.valueOf(five) / Double.valueOf(vec1.size())); 
		double BinAPer = 100.0 * ( Double.valueOf(BinA) / Double.valueOf(vec1.size())); 
		double AinBPer = 100.0 * ( Double.valueOf(AinB) / Double.valueOf(vec2.size())); 
		double samePer = 100.0 * ( Double.valueOf(same) / Double.valueOf(vec1.size())); 
		int diffSent = vec1.size() + vec2.size() - same; 
		pw.println("Count of two corpus has 3 same words : " + three + " sentences. Percentage of total : " + threePer + "%"); 
		pw.println("Count of two corpus has 4 same words : " + four + " sentences. Percentage of total : " + fourPer + "%"); 
		pw.println("Count of two corpus has 5 same words : " + five + " sentences. Percentage of total : " + fivePer + "%");  
		pw.println("Count of sentence Ai includes sentence Bj : " + BinA + " . Percentage of total : " + BinAPer + "%"); 
		pw.println("Count of sentence Bi includes sentence Aj : " + AinB + " . Percentage of total : " + AinBPer + "%"); 
		pw.println("Completely same sentences count of two corpus : " + same + " . Percentage of total : " + samePer + "%"); 
		pw.println("After merged same sentences, it has : " + diffSent + " different sentences in two corpus."); 
		
		pw.close(); 
	} 
	
	private static void TestVecSim(Vector<String> vec1, Vector<String> vec2, String log) 
	{
		PrintWriter pw = setWriter(log, "utf-8");
		for(int i = 0; i < vec1.size(); i++)
		{
			String[] words1 = vec1.get(i).split(" ");
			for(int j = 0; j < vec2.size(); j++)
			{
				boolean bool = false;
				int sim = 0;
				String[] words2 = vec2.get(j).split(" ");
				sim = WordsSim(words1, words2);
				if(sim < 3)
					continue;
				if(sim == words1.length && sim == words2.length)
				{
					// completely the same
					pw.println("A" + (i+1) + ",B" + (j+1) + "===completely the same"); 
					bool = true;
				}
				if((sim == words1.length || sim == words2.length) && words1.length != words2.length)
				{
					// inclusion
					if(words1.length > words2.length)
						pw.println("A" + (i+1) + ",B" + (j+1) + "===inclusion A>B");
					else if(words1.length < words2.length)
						pw.println("A" + (i+1) + ",B" + (j+1) + "===inclusion B>A");
					else
						pw.println("CODE ERROR 1");
					bool = true;
				}
				if(sim == 3)
				{
					// has 3 the same words
					pw.println("A" + (i+1) + ",B" + (j+1) + "===has 3 the same words");
					bool = true;
				}
				if(sim == 4)
				{
					// has 4 the same words
					pw.println("A" + (i+1) + ",B" + (j+1) + "===has 4 the same words");
					bool = true;
				}
				if(sim == 5)
				{
					// has 5 the same words
					pw.println("A" + (i+1) + ",B" + (j+1) + "===has 5 the same words");
					bool = true;
				}
				if(bool) break;
			}
		}
		pw.close();
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
		return simWords;
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
