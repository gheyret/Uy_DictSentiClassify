package xju.isg.utils;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import xju.isg.emoModel.Model;
import xju.isg.io.FileRW;

public class SortSentense { 

	/** 
	 * @param args 
	 */ 
	public static void main(String[] args) 
	{ 
		ArrayList<String> vec = FileRW.readFile("log/TwitterResult/rang05/no_rang05_train.txt", "utf-8");  
		PrintWriter pw = FileRW.setWriter("log/TwitterResult/rang05/no_rang05_train_rated.txt", "utf-8");  // _rated
		
		for (int i = 0; i < vec.size(); i++) 
		{ 
			for (int j = i; j < vec.size(); j++) 
			{ 
				float score1 = Float.valueOf(vec.get(i).replaceAll("情感分数 = ", "").replaceAll("\t.+", "")); 
				float score2 = Float.valueOf(vec.get(j).replaceAll("情感分数 = ", "").replaceAll("\t.+", "")); 
				String temp = ""; 
				if (Math.pow(score1,2) < Math.pow(score2,2)) 
				{
					temp = vec.get(i); 
					vec.set(i, vec.get(j)); 
					vec.set(j, temp); 
				} 
			} 
		} 
		
		for(String str : vec)
			pw.println(str); 
		pw.close();
		
		System.err.println("Done !");
	}
	
	
	
}
