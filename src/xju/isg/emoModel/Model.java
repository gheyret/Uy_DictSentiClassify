package xju.isg.emoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import xju.isg.io.FileRW;

public class Model { 

	private static String posFile = "source/MovieResource/Movie_pos_stem.txt"; 
	private static String negFile = "source/MovieResource/Movie_neg_stem.txt"; 
	
	private static HashMap<String, Float> sentHashMap = new HashMap<String, Float>();  // save all the sentences with categories.
	/////////////////////////////////////////////////////////
	private final String posWords = "source/pos.txt"; 
	private final String negWords = "source/neg.txt"; 
	private final String degWords = "source/deg.txt"; 
	private final String butWords = "source/but.txt"; 
	private final String mainPartWords = "source/main.txt"; 
	///////////////////////////////////////////////////////// 
	private HashSet<String> posMap; 
	private HashSet<String> negMap; 
	private HashMap<String, Float> degMap; 
	private HashSet<String> butMap; 
	private HashSet<String> mainMap; 
	/////////////////////////////////////////////////////////
	private static ArrayList<String> posWordsList; 
	private static ArrayList<String> negWordsList; 
	private static ArrayList<String> butWordsList; 
	private static ArrayList<String> MainPartWordsList; 
	
	public Model() {
		ArrayList<String> posSent = FileRW.readFile(posFile, "utf-8");
		ArrayList<String> negSent = FileRW.readFile(negFile, "utf-8");
		for (int i = 0; i < posSent.size(); i++) { // 删除相同句子
			sentHashMap.put(posSent.get(i), (float)1);
		}
		for (int i = 0; i < negSent.size(); i++) { // 删除相同句子
			sentHashMap.put(negSent.get(i), (float)-1);
		}

		posMap = FileRW.loadWords(posWords);
		negMap = FileRW.loadWords(negWords);
		degMap = FileRW.loadWordsToHashMap(degWords);
		butMap = FileRW.loadWords(butWords);
		mainMap = FileRW.loadWords(mainPartWords);

		posWordsList = new ArrayList<String>();
		for (String s : posMap) {
			posWordsList.add(s);
		}
		negWordsList = new ArrayList<String>();
		for (String s : negMap) {
			negWordsList.add(s);
		}
		butWordsList = new ArrayList<String>();
		for (String s : butMap) {
			butWordsList.add(s);
		}
		MainPartWordsList = new ArrayList<String>();
		for (String s : mainMap) {
			MainPartWordsList.add(s);
		}
	}
	
	public ArrayList<String> getMainPartWordsList() { 
		return MainPartWordsList;
	}
	public ArrayList<String> getButWordsList() { 
		return butWordsList;
	}
	public ArrayList<String> getNegWordsList() { 
		String temp = "";
		for(int i = 0; i < negWordsList.size(); i++)
		{
			for(int j = i + 1; j < negWordsList.size(); j++)
			{
				if(negWordsList.get(j).length() > negWordsList.get(i).length())
				{
					temp = negWordsList.get(i);
					negWordsList.set(i, negWordsList.get(j));
					negWordsList.set(j, temp);
				}
			}
		}
		return negWordsList;
	}
	public ArrayList<String> getPosWordsList() { 
		String temp = "";
		for(int i = 0; i < posWordsList.size(); i++)
		{
			for(int j = i + 1; j < posWordsList.size(); j++)
			{
				if(posWordsList.get(j).length() > posWordsList.get(i).length())
				{
					temp = posWordsList.get(i);
					posWordsList.set(i, posWordsList.get(j));
					posWordsList.set(j, temp);
				}
			}
		}
		return posWordsList;
	}

	public HashMap<String, Float> getSentHashMap() { 
		return sentHashMap; 
	}

	public HashSet<String> getPosSet() { 
		return posMap;
	}
	public HashSet<String> getNegSet() { 
		return negMap;
	}
	public HashMap<String, Float> getDegMap() { 
		return degMap;
	}
	public HashSet<String> getButSet() { 
		return butMap;
	}
	public HashSet<String> getMainPartSet() { 
		return mainMap;
	}
}
