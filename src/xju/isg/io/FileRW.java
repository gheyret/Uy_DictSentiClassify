package xju.isg.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FileRW {
	
	public static synchronized ArrayList<String> readFile(String inPath, String encoding) {
		ArrayList<String> list = new ArrayList<String>();
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
	
	public static synchronized PrintWriter setWriter(String outfile, String encoding) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outfile), encoding)); 
		} catch(Exception e) {
			System.err.println("new writer error!");
			e.printStackTrace();
		}
		return writer;
	}
	
	public static synchronized HashSet<String> loadWords(String path)
	{
		HashSet<String> hs = new HashSet<String>();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(path) , "utf-8"));
			String line = null;
			while((line = reader.readLine()) != null)
			{
				hs.add(line.trim());
			}
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return hs;
	}
	
	public static synchronized HashMap<String, Float> loadWordsToHashMap(String path)
	{
		HashMap<String, Float> hm = new HashMap<String, Float>();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(path) , "utf-8"));
			String line = null;
			while((line = reader.readLine()) != null)
			{
				hm.put(line.split("\t")[0].trim(), Float.valueOf(line.split("\t")[1].trim()));
			}
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return hm;
	}
}
