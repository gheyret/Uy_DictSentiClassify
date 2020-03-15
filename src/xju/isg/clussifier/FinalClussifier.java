package xju.isg.clussifier;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.net.ssl.SSLContext;

import xju.isg.emoModel.Model;
import xju.isg.io.FileRW;

public class FinalClussifier {

	private static Model model = new Model();
	private static HashMap<String, Float> sentHashMap;
	private static ArrayList<String> posWords;
	private static ArrayList<String> negWords;
	private static HashMap<String, Float> degWords;
	private static ArrayList<String> butWords;
	private static ArrayList<String> mainWords;
	
	private static String encoding = "UTF-8";
	private static String log_basic = "log/log_err_basic.txt";
	private static String log_degree = "log/log_err_degree.txt";
	private static String log_but = "log/log_err_but.txt";
	private static String log_mainPart = "log/log_err_mainPart.txt";
	
	private static void Initialize()
	{
		sentHashMap = model.getSentHashMap();
		posWords = model.getPosWordsList();   // 注意：需要按照字符长度排序词典
		negWords = model.getNegWordsList();   // 注意：需要按照字符长度排序词典
		degWords = model.getDegMap();
		butWords = model.getButWordsList();
		mainWords = model.getMainPartWordsList();
	}
	
	public static void main(String[] args) 
	{
		Initialize();
//		getBasicModeEmo((float)0.43);
//		getMainPartModelEmo((float)0.43);
//		getDegreeModelEmo((float)0, 1);
//		getButModelEmo((float)0.45, 1, 1);
		
//		getButNoDegModelEmo((float)0.45, 1);
		
		
//		for(float i = 0f; i <= 2.1f; i = i + 0.1f)
//		{
//			getDegreeModelEmo((float)0.21, 2, i); 
//		}
		
		
		//  (5)  否定词   不包含程度副词   Nodeg
//		PrintWriter pwWeight = FileRW.setWriter("log/log_weight_butNoDegree.txt", encoding);
//		DecimalFormat df = new DecimalFormat("#.00");
//		float big = 0;
//		float a = 0;
//		for (int no = 0; no <= 5; no++) 
//		{ 
//			for(float i = (float) 0.00; i <= (float)1.0; i= i + (float)0.01)
//			{
//				i = Float.valueOf(df.format(i));
//				SOP("stemWeight = "+i + "\tnoSpace = " + no + "\t\t\tBig = " + big);
//				a = getButNoDegModelEmo(i, no);
//				pwWeight.println(i+"="+no+"="+a);
//				if(big < a)
//					big = a;
//			}
//		}
//		SOP("Big = "+big);
//		pwWeight.close();
		
		//  	   old max : 0.45=1=2=0.7292715 
		//  (4) 否定词       max : stemWeith = 0.43~0.45    degSpace = 1     noSpace = 0        0.7275014
//		PrintWriter pwWeight = FileRW.setWriter("log/log_weight_NoSpace-2.txt", encoding); 
//		DecimalFormat df = new DecimalFormat("#.00"); 
//		float big = 0; 
//		float a = 0; 
//		for (int no = 0; no <= 5; no++) 
//		{ 
//			for (int ds = 1; ds < 6; ds++) 
//			{ 
//				for (float i = (float) 0.0; i <= (float) 1.0; i = i + (float) 0.01) 
//				{ 
//					i = Float.valueOf(df.format(i)); 
//					SOP("stemWeight = " + i + "\tdegSpace = " + ds + "\tnoSpace = " + no + "\t\t\tBig = " + big); 
//					a = getButModelEmo(i, ds, no); 
//					pwWeight.println(i + "=" + ds + "=" + no + "=" + a); 
//					if (big < a) 
//						big = a; 
//				} 
//			} 
//		} 
//		pwWeight.close(); 
//		SOP("Big = "+big); 
		
		
		//  (3) degree    max : stemWeith = 0.43~0.45    0.7308552
//		PrintWriter pwWeight = FileRW.setWriter("log/log_weight_Degree.txt", encoding);
//		DecimalFormat df = new DecimalFormat("#.00");
//		float big = 0;
//		float a = 0;
//		for(int ds = 1; ds <= 3; ds++)
//		{
//			for(float i = (float) 0.0; i <= (float)1.0; i= i + (float)0.01) 
//			{
//				i = Float.valueOf(df.format(i));
//				SOP("stemWeight = "+i + "\tdegSpace = " + ds + "\t\t\tBig = " + big);
//				a = getDegreeModelEmo(i, ds);
//				pwWeight.println(i+"="+ds+"="+a);
//				if(big < a)
//					big = a;
//			}
//		}
//		SOP("Big = "+big);
//		pwWeight.close();
		
		
		//	 (2) mainPart    max : stemWeith = 0.34 ~ 0.49      0.7193963
//		PrintWriter pwWeight = FileRW.setWriter("log/log_weight_MainPart.txt", encoding);
//		DecimalFormat df = new DecimalFormat("#.00");
//		float big = 0;
//		float a = 0;
//		for(float i = (float) 0.0; i <= (float)1.0; i= i + (float)0.01)
//		{
//			i = Float.valueOf(df.format(i));
//			a = getMainPartModelEmo(i);
//			SOP("stemWeight = "+i+ "\t\tAcc = " + a);
//			pwWeight.println(i+"="+a);
//			if(big < a)
//				big = a;
//		}
//		SOP("Big = "+big);
//		pwWeight.close();
		
		
		//  (1) basic   max : stemWeith = 0.34 ~ 0.49     0.71948946
//		PrintWriter pwWeight = FileRW.setWriter("log/log_weight_Basic.txt", encoding);
//		DecimalFormat df = new DecimalFormat("#.00");
//		float big = 0;
//		float a = 0;
//		for(float i = (float) 0.0; i <= (float)1.0; i= i + (float)0.01)
//		{
//			i = Float.valueOf(df.format(i));
//			SOP("stemWeight = "+i);
//			a = getBasicModeEmo(i);
//			pwWeight.println(i+"="+a);
//			if(big < a)
//				big = a;
//		}
//		SOP("Big = "+big);
//		pwWeight.close();
		
		
		java.awt.Toolkit.getDefaultToolkit().beep(); 
		java.awt.Toolkit.getDefaultToolkit().beep(); 
		java.awt.Toolkit.getDefaultToolkit().beep(); 
	}
	
	private static float getButNoDegModelEmo(float stemWeight, int noSpace)
	{
		float rang = (float)0.5; 
//		PrintWriter pw = FileRW.setWriter("log/trainBig0-5.txt", encoding); 
		
		float a = 0;
 		float b = 0;
		float c = 0;
		float d = 0;
//		PrintWriter  pwBut = FileRW.setWriter(log_but, encoding);  // 创建 basic 的 log 文件 
		Iterator it = sentHashMap.entrySet().iterator(); 
		while (it.hasNext()) 
		{
			Map.Entry entry = (Entry) it.next(); 
			String[] threeElimentSet = entry.getKey().toString().trim().split(" +"); 
			float posScore = 0; 
			float negScore = 0; 
//			float stemWeight = (float)0.31; // 选择 1 或者 0.5~1 之间的数字 ，0.82 的时候较高 
//			String errorLog = ""; // 情感词 和 ID 写入到 log 中
//			String butLog = "";  // 否定词 写入到 log 中
			ArrayList<String[]> ftSets = null;
			//判断是否有 转折词 
			ftSets = MainPartSpliter(threeElimentSet);
			if (ftSets == null)   //  没有转折性连词
			{
				for (int i = 0; i < threeElimentSet.length; i++) 
				{
					String wordOrigin = threeElimentSet[i].split("=")[0]; 
					String wordProperty = threeElimentSet[i].split("=")[1]; 
					String wordStem = threeElimentSet[i].split("=")[2]; 
					String[] basicResult = getButWordsNoDegEmo(threeElimentSet, i, wordOrigin, wordProperty, wordStem, stemWeight, noSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals(""))
						{
							posScore = posScore + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScore = negScore + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] + "\t\t";  // log
//						if(!basicResult[7].equals(""))
//							butLog = butLog + basicResult[7] + "\t\t";
					}
				}
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(posScore + negScore));
				if(bool == 1)
				{
//					if((posScore + negScore) > rang) 
//						pw.println("Pos情感分数 = " + String.valueOf(posScore + negScore) + "\t" + entry.getKey()); 
					a = a + 1;
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(posScore + negScore) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwBut.println("程度词 = " + degLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 3)
				{
					c = c + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(posScore + negScore) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals("")) 
//						pwBut.println("程度词 = " + degLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 4)
				{
					d = d + 1;
//					if((posScore + negScore) < (-1)*rang) 
//						pw.println("Neg情感分数 = " + String.valueOf(posScore + negScore) + "\t" + entry.getKey()); 
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
//				if((posScore + negScore) < (-1)*rang || (posScore + negScore) > rang) 
//					pw.println("情感分数 = " + String.valueOf(posScore + negScore) + "\t" + entry.getKey()); 
			}  // 无转折，if结束 
			else if (ftSets != null)   //  有转折性连词 
			{ 
				String mainPartLog = "转折词= " + (ftSets.get(0).length) + ":" + threeElimentSet[ftSets.get(0).length];  // log 里面 记录 转折词 信息 
				float sum = 0;
				float frontScore = 0;
				float tailScore = 0;
				float posScoreTempF = 0;
				float negScoreTempF = 0;
				float posScoreTempT = 0;
				float negScoreTempT = 0;
				for (int i = 0; i < ftSets.get(0).length; i++) 
				{
					String wordOrigin = ftSets.get(0)[i].split("=")[0]; 
					String wordProperty = ftSets.get(0)[i].split("=")[1]; 
					String wordStem = ftSets.get(0)[i].split("=")[2]; 
					String[] basicResult = getButWordsNoDegEmo(ftSets.get(0), i, wordOrigin, wordProperty, wordStem, stemWeight, noSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempF = posScoreTempF + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempF = negScoreTempF + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] + "\t\t";  // log
//						if(!basicResult[7].equals(""))
//							butLog = butLog + basicResult[7] + "\t\t";
					}
				}
				for (int i = 0; i < ftSets.get(1).length; i++) 
				{
					String wordOrigin = ftSets.get(1)[i].split("=")[0]; 
					String wordProperty = ftSets.get(1)[i].split("=")[1]; 
					String wordStem = ftSets.get(1)[i].split("=")[2]; 
					String[] basicResult = getButWordsNoDegEmo(ftSets.get(1), i, wordOrigin, wordProperty, wordStem, stemWeight, noSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempT = posScoreTempT + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempT = negScoreTempT + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] +"\t\t";  // log
//						if(!basicResult[7].equals(""))
//							butLog = butLog + basicResult[7] + "\t\t";
					}
				}
				
				frontScore = posScoreTempF + negScoreTempF;
				tailScore = posScoreTempT + negScoreTempT;
				float mainPartWeight = getMainPartWeight(frontScore, tailScore);  // 重点： 计算 转折 句子的 情感权重值 
				if (tailScore != (float)0)  //  两个句子的 情感 Score 通过下面 规则 合并起来 
					sum = tailScore;
				else if (tailScore == (float)0 && frontScore != (float)0)
					sum = frontScore * (float)(-1);
				else
					sum = 0; // 合并 结束
				
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(sum * mainPartWeight));
				if(bool == 1)
				{
					a = a + 1;
//					if((sum * mainPartWeight) > rang)
//						pw.println("Pos情感分数 = " + String.valueOf(sum * mainPartWeight) + "\t" + entry.getKey());
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(sum * mainPartWeight) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwBut.println("程度词 = " + degLog);
//					pwBut.println(mainPartLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 3)
				{
					c = c + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(sum * mainPartWeight) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwBut.println("程度词 = " + degLog);
//					pwBut.println(mainPartLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 4)
				{
					d = d + 1;
//					if((sum * mainPartWeight) < (-1)*rang)
//						pw.println("Neg情感分数 = " + String.valueOf(sum * mainPartWeight) + "\t" + entry.getKey());
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
//				if((sum * mainPartWeight) < (-1)*rang || (sum * mainPartWeight) > rang)
//					pw.println("情感分数 = " + String.valueOf(sum * mainPartWeight) + "\t" + entry.getKey());
			} // 有转折，if结束
			
		} //  for sent 循环 结束
		
		float posP = a / (a + c);
		float posR = a / (a + b);
		float posF = (2 * posP * posR) / (posP + posR);
		float negP = d / (d + b);
		float negR = d / (d + c);
		float negF = (2 * negP * negR) / (negP + negR);
		float Accuracy = (a + d) / (a + b + c + d);
		
		SOP("posP = " + posP + "\t\tposR = " + posR + "\t\tposF = " + posF);
		SOP("negP = " + negP + "\t\tnegR = " + negR + "\t\tnegF = " + negF);
		SOP("\t\t\t\t\t\tAcuuracy = " + Accuracy); 
//		pwBut.close();
//		pw.close();
//		SOP("HashMap = " + sentHashMap.size() + "\t\tABCD = " + (a + b + c + d));
		return Accuracy;
	}
	
	private static String[] getButWordsNoDegEmo(String[] ft, int index, String wordOrigin,String wordProperty, String wordStem, float stemWeight, int noSpace)
	{															  //   0	   1        2         3        4         5        6         7
		String[] result = new String[]{"","","","","","","",""};  // index, posWord, posScore, negWord, negScore, degWord, degScore, butWord
		float posScore = 0;
		float negScore = 0;
		float deg = 1;
		float but = 1;
		float FrontNeg = 0;
		
		boolean bReturn = false;
		
		for (int i = 0; i < posWords.size(); i++)  //  检查 正面词
		{
			if (wordOrigin.equals(posWords.get(i).trim()))  // 找到正面次  +1
			{
				for (int b = index, butLock = 1; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				posScore = posScore + 1;
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore * deg * but);
				bReturn = true;
				break;
			}
			else if (posWords.get(i).equals(wordStem.trim()))  //  lock = +0.5 or +1
			{
				for (int b = index, butLock = 0; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				posScore = posScore + 1 - stemWeight;
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore * deg * but);
				break;
			}
		}  //  正面词 检查 结束
		
		if(bReturn) return result;  
		
		FrontNeg = 0;
		for(int i = 0; i < negWords.size(); i++)  //  检查是否是 负面词
		{
			if(wordOrigin.equals(negWords.get(i).trim()))  //  -2
			{
				for (int b = index, butLock = 1; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				negScore = negScore - 2;
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore * deg * but);
				break;
			}
			else if (negWords.get(i).equals(wordStem.trim()))  //  lock = -0.5 or -1
			{
				for (int b = index, butLock = 0; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				negScore = negScore - stemWeight - 1;
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore * deg * but);
				break;
			}
		}
		
		return result;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static float getButModelEmo(float stemWeight, int degSpace, int noSpace) 
	{
//		PrintWriter pw = FileRW.setWriter("log/Basic0-5.txt", encoding); 
		float rang = (float)1.5; 
		int count = 0; 
		int allCount = 0; 
		
		float a = 0;
 		float b = 0;
		float c = 0;
		float d = 0;
//		PrintWriter  pwBut = FileRW.setWriter(log_but, encoding);  // 创建 basic 的 log 文件 
		Iterator it = sentHashMap.entrySet().iterator(); 
		while (it.hasNext()) 
		{
			Map.Entry entry = (Entry) it.next(); 
			String[] threeElimentSet = entry.getKey().toString().trim().split(" +"); 
			float posScore = 0; 
			float negScore = 0; 
//			float stemWeight = (float)0.31; // 选择 1 或者 0.5~1 之间的数字 ，0.82 的时候较高 
//			String errorLog = ""; // 情感词 和 ID 写入到 log 中
//			String degLog = "";  // 程度词 写入到 log 中
//			String butLog = "";  // 否定词 写入到 log 中
			ArrayList<String[]> ftSets = null;
			//判断是否有 转折词 
			ftSets = MainPartSpliter(threeElimentSet);
			if (ftSets == null)   //  没有转折性连词
			{
				for (int i = 0; i < threeElimentSet.length; i++) 
				{
					String wordOrigin = threeElimentSet[i].split("=")[0]; 
					String wordProperty = threeElimentSet[i].split("=")[1]; 
					String wordStem = threeElimentSet[i].split("=")[2]; 
					String[] basicResult = getButWordsEmo(threeElimentSet, i, wordOrigin, wordProperty, wordStem, stemWeight, degSpace, noSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals(""))
						{
							posScore = posScore + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScore = negScore + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] + "\t\t";  // log
//						if(!basicResult[7].equals(""))
//							butLog = butLog + basicResult[7] + "\t\t";
					}
				}
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(posScore + negScore));
				if(bool == 1)
				{
					if((posScore + negScore) > rang) 
					{
						count++;
//						pw.println("Pos情感分数 = " + String.valueOf(posScore + negScore) + "\t" + entry.getKey()); 
					}
					a = a + 1;
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(posScore + negScore) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwBut.println("程度词 = " + degLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 3)
				{
					c = c + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(posScore + negScore) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals("")) 
//						pwBut.println("程度词 = " + degLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 4)
				{
					if((posScore + negScore) < (-1)*rang) 
					{
						count++;
//						pw.println("Neg情感分数 = " + String.valueOf(posScore + negScore) + "\t" + entry.getKey()); 
					}
					d = d + 1;
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
				if((posScore + negScore) < (-1)*rang || (posScore + negScore) > rang) 
				{
					allCount++;
//					pw.println("情感分数 = " + String.valueOf(posScore + negScore) + "\t" + entry.getKey()); 
				}
			}  // 无转折，if结束 
			else if (ftSets != null)   //  有转折性连词 
			{ 
				String mainPartLog = "转折词= " + (ftSets.get(0).length) + ":" + threeElimentSet[ftSets.get(0).length];  // log 里面 记录 转折词 信息 
				float sum = 0;
				float frontScore = 0;
				float tailScore = 0;
				float posScoreTempF = 0;
				float negScoreTempF = 0;
				float posScoreTempT = 0;
				float negScoreTempT = 0;
				for (int i = 0; i < ftSets.get(0).length; i++) 
				{
					String wordOrigin = ftSets.get(0)[i].split("=")[0]; 
					String wordProperty = ftSets.get(0)[i].split("=")[1]; 
					String wordStem = ftSets.get(0)[i].split("=")[2]; 
					String[] basicResult = getButWordsEmo(ftSets.get(0), i, wordOrigin, wordProperty, wordStem, stemWeight, degSpace, noSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempF = posScoreTempF + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempF = negScoreTempF + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] + "\t\t";  // log
//						if(!basicResult[7].equals(""))
//							butLog = butLog + basicResult[7] + "\t\t";
					}
				}
				for (int i = 0; i < ftSets.get(1).length; i++) 
				{
					String wordOrigin = ftSets.get(1)[i].split("=")[0]; 
					String wordProperty = ftSets.get(1)[i].split("=")[1]; 
					String wordStem = ftSets.get(1)[i].split("=")[2]; 
					String[] basicResult = getButWordsEmo(ftSets.get(1), i, wordOrigin, wordProperty, wordStem, stemWeight, degSpace, noSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempT = posScoreTempT + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempT = negScoreTempT + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] +"\t\t";  // log
//						if(!basicResult[7].equals(""))
//							butLog = butLog + basicResult[7] + "\t\t";
					}
				}
				
				frontScore = posScoreTempF + negScoreTempF;
				tailScore = posScoreTempT + negScoreTempT;
				float mainPartWeight = getMainPartWeight(frontScore, tailScore);  // 重点： 计算 转折 句子的 情感权重值 
				if (tailScore != (float)0)  //  两个句子的 情感 Score 通过下面 规则 合并起来 
					sum = tailScore;
				else if (tailScore == (float)0 && frontScore != (float)0)
					sum = frontScore * (float)(-1);
				else
					sum = 0; // 合并 结束
				
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(sum * mainPartWeight));
				if(bool == 1)
				{
					a = a + 1;
					if((sum * mainPartWeight) > rang)
					{
						count++;
//						pw.println("Pos情感分数 = " + String.valueOf(sum * mainPartWeight) + "\t" + entry.getKey());
					}
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(sum * mainPartWeight) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwBut.println("程度词 = " + degLog);
//					pwBut.println(mainPartLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 3)
				{
					c = c + 1;
//					pwBut.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(sum * mainPartWeight) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwBut.println("程度词 = " + degLog);
//					pwBut.println(mainPartLog);
//					if(!butLog.equals(""))
//						pwBut.println("否定词 = " + butLog); 
				}
				else if(bool == 4)
				{
					if((sum * mainPartWeight) < (-1)*rang)
					{
						count++;
//						pw.println("Neg情感分数 = " + String.valueOf(sum * mainPartWeight) + "\t" + entry.getKey());
					}
					d = d + 1;
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
				if((sum * mainPartWeight) < (-1)*rang || (sum * mainPartWeight) > rang)
				{
					allCount++;
//					pw.println("情感分数 = " + String.valueOf(sum * mainPartWeight) + "\t" + entry.getKey());
				}
			} // 有转折，if结束
			
		} //  for sent 循环 结束
		
		float posP = a / (a + c);
		float posR = a / (a + b);
		float posF = (2 * posP * posR) / (posP + posR);
		float negP = d / (d + b);
		float negR = d / (d + c);
		float negF = (2 * negP * negR) / (negP + negR);
		float Accuracy = (a + d) / (a + b + c + d);
		
		SOP("posP = " + posP + "\t\tposR = " + posR + "\t\tposF = " + posF);
		SOP("negP = " + negP + "\t\tnegR = " + negR + "\t\tnegF = " + negF);
		SOP("Acuuracy = " + Accuracy); 
//		pwBut.close();
//		pw.close();
		SOP("HashMap = " + sentHashMap.size() + "\t\tABCD = " + (a + b + c + d));
		SOP(rang + "=" + allCount + "=" + count + "=" + ((float)count / (float)allCount) + "=" + ((float)allCount / (a + b + c + d)));
		return Accuracy;
	}
	
	private static String[] getButWordsEmo(String[] ft, int index, String wordOrigin,String wordProperty, String wordStem, float stemWeight, int degSpace, int noSpace)
	{															  //   0	   1        2         3        4         5        6         7
		String[] result = new String[]{"","","","","","","",""};  // index, posWord, posScore, negWord, negScore, degWord, degScore, butWord
		float posScore = 0;
		float negScore = 0;
		float deg = 1;
		float but = 1;
		float FrontNeg = 0;
		
		boolean bReturn = false;
		
		for (int i = 0; i < posWords.size(); i++)  //  检查 正面词
		{
			if (wordOrigin.equals(posWords.get(i).trim()))  // 找到正面次  +1
			{
				for (int b = index, butLock = 1; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				if(index > 0)  //  判断 程度副词
				{
					for(int d = index - 1, degLock = 1; d >= 0 && d < index && degLock <= degSpace; d--, degLock++)
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				posScore = posScore + 1;
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore * deg * but);
				bReturn = true;
				break;
			}
			if (posWords.get(i).equals(wordStem.trim()))  //  lock = +0.5 or +1
			{
				for (int b = index, butLock = 0; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				if(index > 0)  //  判断 程度副词 是否存在
				{
					for(int d = index - 1, degLock = 1; d >= 0 && d < index && degLock <= degSpace; d--, degLock++)
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				posScore = posScore + 1 - stemWeight;
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore * deg * but);
				break;
			}
		}  //  正面词 检查 结束
		
		if(bReturn) return result;  
		
		FrontNeg = 0;
		for(int i = 0; i < negWords.size(); i++)  //  检查是否是 负面词
		{
			if(wordOrigin.equals(negWords.get(i).trim()))  //  -2
			{
				for (int b = index, butLock = 1; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				if(index > 0)  //  判断 程度副词 是否存在
				{
					for(int d = index - 1, degLock = 1; d >= 0 && d < index && degLock <= degSpace; d--, degLock++)
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				negScore = negScore - 2;
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore * deg * but);
				break;
			}
			if (negWords.get(i).equals(wordStem.trim()))  //  lock = -0.5 or -1
			{
				for (int b = index, butLock = 0; b < ft.length && butLock <= noSpace; b++, butLock++)  // 判断 是否有 否定词 
				{
					String Origin = ft[b].split("=")[0]; 
					String Property = ft[b].split("=")[1]; 
					String Stem = ft[b].split("=")[2]; 
					if(Origin.length() < Stem.length())
						Origin = Stem;
					String suffx = Origin.substring(Stem.length()); 
					String[] butResult = getButWordInfo(Origin,Property,suffx); 
					if(butResult == null) continue; 
					else if(butResult[0].equals("1"))  
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
					else if(butResult[0].equals("2")) 
					{ 
						but = but * (float)-1; 
						result[7] = butResult[1]; 
					} 
				}
				
				if(index > 0)  //  判断 程度副词 
				{
					for(int d = index - 1, degLock = 1; d >= 0 && d < index && degLock <= degSpace; d--, degLock++)
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				negScore = negScore - stemWeight - 1;
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore * deg * but);
				break;
			}
		}
		
		return result;
	}
	
	private static String[] getButWordInfo(String Origin, String Property, String suffx)
	{
		HashSet<String> butWords = new HashSet<String>();butWords.add("ئەمەس"); 
		String[] butSuffx = {"مى","مە","ما"};
		if(butWords.contains(Origin))
			return new String[]{"1",Origin}; 
		else if(Property.equals("V")) 
			for (int i = 0; i < butSuffx.length; i++) 
				if(suffx.contains(butSuffx[i]) && !suffx.contains("مەن") && !suffx.contains("مىز") && !suffx.contains("ماقچى") && !suffx.contains("مەكچى"))
					return new String[] {"2", butSuffx[i]};
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static float getDegreeModelEmo(float stemWeight, int degSpace)
	{
//		PrintWriter pw = FileRW.setWriter("log/deg_rant1-0.txt", encoding); 
//		float rang = (float)1.0; 
		int count = 0;
		int allCount = 0;
		
 		float a = 0;
 		float b = 0;
		float c = 0;
		float d = 0;
//		PrintWriter  pwDegree = FileRW.setWriter(log_degree, encoding);  // 创建 basic 的 log 文件
		Iterator it = sentHashMap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry entry = (Entry) it.next(); 
			String[] threeElimentSet = entry.getKey().toString().trim().split(" +"); 
			float posScore = 0; 
			float negScore = 0; 
//			float stemWeight = (float)0.07; // 选择 1 或者 0.5~1 之间的数字 ，0.61 的时候较高 
//			int degSpace = 1;  //  程度副词 要从 当前次的前几个词中查询
			
//			String errorLog = ""; // 情感词 和 ID 写入到 log 中
//			String degLog = "";  // 程度词 写入到 log 中
			ArrayList<String[]> ftSets = null;
			//判断是否有 转折词 
			ftSets = MainPartSpliter(threeElimentSet);
			if (ftSets == null)   //  没有转折性连词
			{
				for (int i = 0; i < threeElimentSet.length; i++) 
				{
					String wordOrigin = threeElimentSet[i].split("=")[0]; 
					String wordProperty = threeElimentSet[i].split("=")[1]; 
					String wordStem = threeElimentSet[i].split("=")[2]; 
					String[] basicResult = getDegreeWordsEmo(threeElimentSet, i, wordOrigin, wordStem, stemWeight, degSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals(""))
						{
							posScore = posScore + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScore = negScore + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] + "\t\t";  // log
					}
				}
				
				float acc = posScore + negScore;
				
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(acc));
				if(bool == 1)
				{
//					if(acc > rang) 
//						count++;
					a = a + 1;
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwDegree.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwDegree.println("程度词 = " + degLog);
				}
				else if(bool == 3)
				{
					c = c + 1;
//					pwDegree.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals("")) 
//						pwDegree.println("程度词 = " + degLog);
				}
				else if(bool == 4)
				{
//					if(acc < (-1)*rang) 
//						count++;
					d = d + 1;
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
//				if(acc < (-1)*rang || acc > rang) 
//				{
//					allCount++;
//					pw.println("情感分数 = " + String.valueOf(acc) + "\t" + entry.getKey());
//				}
			}  // 无转折，if结束
			else if (ftSets != null)   //  有转折性连词
			{
				String mainPartLog = "转折词= " + (ftSets.get(0).length) + ":" + threeElimentSet[ftSets.get(0).length];  // log 里面 记录 转折词 信息
				float sum = 0;
				float frontScore = 0;
				float tailScore = 0;
				float posScoreTempF = 0;
				float negScoreTempF = 0;
				float posScoreTempT = 0;
				float negScoreTempT = 0;
				for (int i = 0; i < ftSets.get(0).length; i++) 
				{
					String wordOrigin = ftSets.get(0)[i].split("=")[0]; 
					String wordProperty = ftSets.get(0)[i].split("=")[1]; 
					String wordStem = ftSets.get(0)[i].split("=")[2]; 
					String[] basicResult = getDegreeWordsEmo(ftSets.get(0), i, wordOrigin, wordStem, stemWeight, degSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempF = posScoreTempF + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempF = negScoreTempF + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] + "\t\t";  // log
					}
				}
				for (int i = 0; i < ftSets.get(1).length; i++) 
				{
					String wordOrigin = ftSets.get(1)[i].split("=")[0]; 
					String wordProperty = ftSets.get(1)[i].split("=")[1]; 
					String wordStem = ftSets.get(1)[i].split("=")[2]; 
					String[] basicResult = getDegreeWordsEmo(ftSets.get(1), i, wordOrigin, wordStem, stemWeight, degSpace); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempT = posScoreTempT + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempT = negScoreTempT + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
//						if(!basicResult[5].equals(""))
//							degLog = degLog + basicResult[5] + ":" +basicResult[6] +"\t\t";  // log
					}
				}
				
				frontScore = posScoreTempF + negScoreTempF;
				tailScore = posScoreTempT + negScoreTempT;
				float mainPartWeight = getMainPartWeight(frontScore, tailScore);  // 重点： 计算 转折 句子的 情感权重值 
				if (tailScore != (float)0)  //  两个句子的 情感 Score 通过下面 规则 合并起来 
					sum = tailScore;
				else if (tailScore == (float)0 && frontScore != (float)0)
					sum = frontScore * (float)(-1);
				else
					sum = 0; // 合并 结束
				
				float acc = sum * mainPartWeight;
				
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(acc));
				if(bool == 1)
				{
//					if(acc > rang) 
//						count++;
					a = a + 1;
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwDegree.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwDegree.println("程度词 = " + degLog);
//					pwDegree.println(mainPartLog);
				}
				else if(bool == 3)
				{
					c = c + 1;
//					pwDegree.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
//					if(!degLog.equals(""))
//						pwDegree.println("程度词 = " + degLog);
//					pwDegree.println(mainPartLog);
				}
				else if(bool == 4)
				{
//					if(acc < (-1)*rang) 
//						count++;
					d = d + 1;
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
//				if(acc < (-1)*rang || acc > rang) 
//				{
//					allCount++;
//					pw.println("情感分数 = " + String.valueOf(acc) + "\t" + entry.getKey());
//				}
			} // 有转折，if结束
			
		} //  for sent 循环 结束
		
		float posP = a / (a + c);
		float posR = a / (a + b);
		float posF = (2 * posP * posR) / (posP + posR);
		float negP = d / (d + b);
		float negR = d / (d + c);
		float negF = (2 * negP * negR) / (negP + negR);
		float Accuracy = (a + d) / (a + b + c + d);
		
		SOP("posP = " + posP + "\t\tposR = " + posR + "\t\tposF = " + posF);
		SOP("negP = " + negP + "\t\tnegR = " + negR + "\t\tnegF = " + negF);
		SOP("Acuuracy = " + (float)100 * Accuracy); 
//		pwDegree.close();
//		pw.close();
//		SOP(rang + "=" + allCount + "=" + count + "=" + ((float)100 * (float)count / (float)allCount) + "=" + ((float)100 * (float)allCount / (a + b + c + d)));
		return (float)100 * Accuracy;
	}
	
	private static String[] getDegreeWordsEmo(String[] ft, int index, String wordOrigin, String wordStem, float stemWeight, int degSpace)
	{														   //   0       1        2         3         4        5        6
		String[] result = new String[]{"","","","","","",""};  // index, posWord, posScore, negWord, negScore, degWord, degScore
		float posScore = 0;
		float negScore = 0;
		float deg = 1;
		boolean bReturn = false;
		
		for(int i = 0; i < posWords.size(); i++)  //  检查是否是 正面词
		{
			if(wordOrigin.equals(posWords.get(i).trim()))  //  +1
			{
				if(index > 0)  //  判断 程度副词 是否存在
				{
					for(int d = index - 1, ds = 1; d >= 0 && d < index && ds <= degSpace; d--, ds++)
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				posScore = posScore + 1;
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore * deg);
				bReturn = true;
				break;
			}
		}
		
		if (bReturn) return result;
		
		for(int i = 0; i < negWords.size(); i++)  //  检查是否是 负面词
		{
			if(wordOrigin.equals(negWords.get(i).trim()))  //  -1
			{
				if(index > 0)  //  判断 程度副词 是否存在
				{
					for(int d = index - 1, ds = 1; d >= 0 && d < index && ds <= degSpace; d--, ds++)
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				negScore = negScore - 2;
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore * deg);
				bReturn = true;
				break;
			}
		}
		
		if (bReturn) return result;
		
		for(int i = 0; i < posWords.size(); i++)  //  检查是否是 正面词
		{
			if (posWords.get(i).equals(wordStem.trim()))  //  lock = +0.5 or +1
			{
				if(index > 0)  //  判断 程度副词 是否存在
				{
					for(int d = index - 1, ds = 1; d >= 0 && d < index && ds <= degSpace; d--, ds++) 
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				posScore = posScore + 1 - stemWeight;   // 公式
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore * deg);
				bReturn = true;
				break;
			}
		}  //  正面词 检查 结束
		
		if (bReturn) return result;
		
		for(int i = 0; i < negWords.size(); i++)  //  检查是否是 负面词
		{
			if (negWords.get(i).equals(wordStem.trim()))  //  lock = -0.5 or -1 
			{
				if(index > 0)  //  判断 程度副词 是否存在
				{
					for(int d = index - 1, ds = 1; d >= 0 && d < index && ds <= degSpace; d--, ds++)
					{
						if(degWords.containsKey(ft[d].split("=")[0]))
						{
							deg = degWords.get(ft[d].split("=")[0]);
							result[5] = ft[d].split("=")[0];
							result[6] = String.valueOf(deg);
							break;
						}
						else if (degWords.containsKey(ft[d].split("=")[2]))
						{
							deg = degWords.get(ft[d].split("=")[2]);
							result[5] = ft[d].split("=")[2];
							result[6] = String.valueOf(deg);
							break;
						}
					}
				}
				negScore = negScore - stemWeight - 1;   // 公式    negScore - stemWeight - 2
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore * deg);
				bReturn = true;
				break;
			}
		}
		
		return result;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static float getMainPartModelEmo(float stemWeight) 
	{ 
//		PrintWriter pw = FileRW.setWriter("log/main_rang1-0.txt", encoding);  
//		float rang = (float)1.0; 
		int count = 0; 
		int allCount = 0; 
		
 		float a = 0; 
 		float b = 0; 
		float c = 0; 
		float d = 0; 
//		PrintWriter  pwMainPart = FileRW.setWriter(log_mainPart, encoding);  // 创建 basic 的 log 文件
		Iterator it = sentHashMap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry entry = (Entry) it.next(); 
			String[] threeElimentSet = entry.getKey().toString().trim().split(" +"); 
			float posScore = 0; 
			float negScore = 0; 
//			float stemWeight = (float)0.07; // 选择 1 或者 0.5~1 之间的数字 ，0.61 的时候较高 
			String errorLog = "";
			ArrayList<String[]> ftSets = null;
			//判断是否有 转折词 
			ftSets = MainPartSpliter(threeElimentSet);
			if (ftSets == null)   //  没有转折性连词
			{
				for (int i = 0; i < threeElimentSet.length; i++) 
				{
					String wordOrigin = threeElimentSet[i].split("=")[0]; 
					String wordProperty = threeElimentSet[i].split("=")[1]; 
					String wordStem = threeElimentSet[i].split("=")[2]; 
					String[] basicResult = getBasicWordsEmo(i, wordOrigin, wordStem, stemWeight); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScore = posScore + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScore = negScore + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
					}
				}
				
				float acc = posScore + negScore;
				
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(acc));
				if(bool == 1)
				{
//					if(acc > rang) 
//						count++;
					a = a + 1;
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwMainPart.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
				}
				else if(bool == 3)
				{
					c = c + 1;
//					pwMainPart.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
				}
				else if(bool == 4)
				{
//					if(acc < (-1)*rang) 
//						count++;
					d = d + 1;
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
//				if(acc < (-1)*rang || acc > rang) 
//				{
//					allCount++;
//					pw.println("情感分数 = " + String.valueOf(acc) + "\t" + entry.getKey()); 
//				}
			}  // 无转折，if结束
			else if (ftSets != null)   //  有转折性连词
			{
				String mainPartLog = "转折词= " + (ftSets.get(0).length) + ":" + threeElimentSet[ftSets.get(0).length];  // log 里面 记录 转折词 信息
				float sum = 0;
				float frontScore = 0;
				float tailScore = 0;
				float posScoreTempF = 0;
				float negScoreTempF = 0;
				float posScoreTempT = 0;
				float negScoreTempT = 0;
				for (int i = 0; i < ftSets.get(0).length; i++) 
				{
					String wordOrigin = ftSets.get(0)[i].split("=")[0]; 
					String wordProperty = ftSets.get(0)[i].split("=")[1]; 
					String wordStem = ftSets.get(0)[i].split("=")[2]; 
					String[] basicResult = getBasicWordsEmo(i, wordOrigin, wordStem, stemWeight); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempF = posScoreTempF + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempF = negScoreTempF + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
					}
				}
				for (int i = 0; i < ftSets.get(1).length; i++) 
				{
					String wordOrigin = ftSets.get(1)[i].split("=")[0]; 
					String wordProperty = ftSets.get(1)[i].split("=")[1]; 
					String wordStem = ftSets.get(1)[i].split("=")[2]; 
					String[] basicResult = getBasicWordsEmo(i, wordOrigin, wordStem, stemWeight); 
					if(!basicResult[0].equals("")) 
					{ 
						if(!basicResult[1].equals("")) 
						{
							posScoreTempT = posScoreTempT + Float.valueOf(basicResult[2]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
						}
						if(!basicResult[3].equals("")) 
						{
							negScoreTempT = negScoreTempT + Float.valueOf(basicResult[4]); 
//							errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t"; // log
						}
					}
				}
				
				frontScore = posScoreTempF + negScoreTempF;
				tailScore = posScoreTempT + negScoreTempT;
				float mainPartWeight = getMainPartWeight(frontScore, tailScore);  // 重点： 计算 转折 句子的 情感权重值 
				if (tailScore != (float)0)  //  两个句子的 情感 Score 通过下面 规则 合并起来 
					sum = tailScore;
				else if (tailScore == (float)0 && frontScore != (float)0)
					sum = frontScore * (float)(-1);
				else
					sum = 0; // 合并 结束
				
				float acc = sum * mainPartWeight;
				
				int bool = getAccuracy(entry.getValue().toString(), String.valueOf(acc));
				if(bool == 1)
				{
//					if(acc > rang) 
//						count++;
					a = a + 1;
				}
				else if(bool == 2)
				{
					b = b + 1;
//					pwMainPart.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
//					pwMainPart.println(mainPartLog);  //  log 里面 添加 转折 信息
				}
				else if(bool == 3)
				{	
					c = c + 1;
//					pwMainPart.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//							+ "情感值 = " + String.valueOf(acc) + "\t" + "情感词 = " + errorLog);
//					pwMainPart.println(mainPartLog);  //  log 里面 添加 转折 信息
				}
				else if(bool == 4)
				{
//					if(acc < (-1)*rang) 
//						count++;
					d = d + 1;
				}
				else {
					SEP("error");
					System.exit(0);
				}
				
//				if(acc < (-1)*rang || acc > rang) 
//				{
//					allCount++;
//					pw.println("情感分数 = " + String.valueOf(acc) + "\t" + entry.getKey()); 
//				}
			} // 有转折，if结束
			
		} //  for sent 循环 结束
		
		float posP = a / (a + c);
		float posR = a / (a + b);
		float posF = (2 * posP * posR) / (posP + posR);
		float negP = d / (d + b);
		float negR = d / (d + c);
		float negF = (2 * negP * negR) / (negP + negR);
		float Accuracy = (a + d) / (a + b + c + d);
		
		SOP("posP = " + posP + "\t\tposR = " + posR + "\t\tposF = " + posF);
		SOP("negP = " + negP + "\t\tnegR = " + negR + "\t\tnegF = " + negF);
		SOP("Acuuracy = " + (float)100 * Accuracy);
//		pwMainPart.close();
//		pw.close();
//		SOP(rang + "\t" + allCount + "\t" + count + "\t" + ((float)100 * (float)count / (float)allCount) + "\t" + ((float)100 * (float)allCount / (a + b + c + d)));
		return (float)100 * Accuracy;
	} 
	
	private static float getMainPartWeight(float front, float tail)  // 重点： 计算 转折 句子的 情感权重值 
	{
		if (front == (float)0 || tail == (float)0)
			return (float) 1.0;
		else if ((front > 0 && tail > 0) || (front < 0 && tail < 0))
			return (float) 0.5;
		else if((front > 0 && tail < 0) || (front < 0 && tail > 0))
			return (float) 2.0;
		else
			return (float) 1.0;
	}
	
	private static ArrayList<String[]> MainPartSpliter(String[] threeElimentSet) 
	{ 
		ArrayList<String[]> ftSets = new ArrayList<String[]>(); 
		String[] frontSet = null;
		String[] tailSet = null;
		for (int i = 1; i < threeElimentSet.length - 1; i++)  //  转折词 只出现在句中，才分句，在两头就不用分
		{ 
			boolean bool = false; 
			String wordOrigin = threeElimentSet[i].split("=")[0]; 
			for (int j = 0; j < mainWords.size(); j++) 
			{
				if (wordOrigin.equals(mainWords.get(j)))
				{
					frontSet = new String[i];
					tailSet = new String[threeElimentSet.length - i -1];
					for(int x = 0; x < i; x++)
						frontSet[x] = threeElimentSet[x];
					for(int y = i+1, t = 0; y < threeElimentSet.length; y++, t++)
						tailSet[t] = threeElimentSet[y];
					ftSets.add(frontSet);
					ftSets.add(tailSet); 
					bool = true;
					break;
				}
			}
			if(bool) break;
		}
		if(ftSets.size() == 0)
			return null;
		return ftSets;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
 	private static float getBasicModeEmo(float stemWeight)
	{
// 		PrintWriter pw = FileRW.setWriter("log/Basic1-0.txt", encoding);  
 		
// 		float rang = (float)1.0; 
		int count = 0;
		int allCount = 0;
 		
 		float a = 0;
 		float b = 0;
		float c = 0;
		float d = 0;
		
//		PrintWriter  pwBasic = FileRW.setWriter(log_basic, encoding);  // 创建 basic 的 log 文件
		Iterator it = sentHashMap.entrySet().iterator();
		while (it.hasNext()) 
		{
			float posScore = 0; 
			float negScore = 0; 
//			float stemWeight = (float)0.07; // 选择 1 或者 0.5~1 之间的数字 ，0.07 的时候较高 
//			String errorLog = "";
			
			Map.Entry entry = (Entry) it.next(); 
			String[] threeElimentSet = entry.getKey().toString().trim().split(" +"); 
			for(int i = 0; i < threeElimentSet.length; i++) 
			{
//				SOP(threeElimentSet[i]);
				String wordOrigin = threeElimentSet[i].split("=")[0]; 
				String wordStem = threeElimentSet[i].split("=")[2]; 
				String[] basicResult = getBasicWordsEmo(i, wordOrigin, wordStem, stemWeight); 
				if(!basicResult[0].equals("")) 
				{ 
					if(!basicResult[1].equals("")) 
					{
						posScore = posScore + Float.valueOf(basicResult[2]); 
//						errorLog = errorLog + basicResult[0] + ":" + basicResult[1] + ":" + basicResult[2] + "\t\t"; // log
					}
					if(!basicResult[3].equals("")) 
					{
						negScore = negScore + Float.valueOf(basicResult[4]); 
//						errorLog = errorLog + basicResult[0] + ":" + basicResult[3] + ":" + basicResult[4] + "\t\t";  // log
					}
				}
			}
			
			int bool = getAccuracy(entry.getValue().toString(), String.valueOf(posScore + negScore));
			if(bool == 1)
			{
//				if((posScore + negScore) > rang) 
//					count++;
				a = a + 1;
			}
			else if(bool == 2)
			{
				b = b + 1;
//				pwBasic.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//						+ "情感值 = " + String.valueOf(posScore + negScore) + "\t" + "情感词 = " + errorLog);
			}
			else if(bool == 3)
			{
				c = c + 1;
//				pwBasic.println("原情感 = " + entry.getValue().toString() + "\t" + entry.getKey() + "\r\n" 
//						+ "情感值 = " + String.valueOf(posScore + negScore) + "\t" + "情感词 = " + errorLog);
			}
			else if(bool == 4)
			{
//				if((posScore + negScore) < (-1)*rang) 
//					count++;
				d = d + 1;
			}
			else {
				SEP("error");
				System.exit(0);
			}
			
//			if((posScore + negScore) < (-1)*rang || (posScore + negScore) > rang) 
//			{
//				allCount++;
//				pw.println("情感分数 = " + String.valueOf(posScore + negScore) + "\t" + entry.getKey()); 
//			}
		}
		float posP = a / (a + c);
		float posR = a / (a + b);
		float posF = (2 * posP * posR) / (posP + posR);
		float negP = d / (d + b);
		float negR = d / (d + c);
		float negF = (2 * negP * negR) / (negP + negR);
		float Accuracy = (a + d) / (a + b + c + d);
		
		SOP("posP = " + posP + "\t\tposR = " + posR + "\t\tposF = " + posF); 
		SOP("negP = " + negP + "\t\tnegR = " + negR + "\t\tnegF = " + negF); 
		SOP("Acuuracy = " + ((float)100 * Accuracy)); 
//		pwBasic.close();
//		pw.close();
//		SOP(rang + "=" + allCount + "=" + count + "=" + ((float)100 * (float)count / (float)allCount) + "=" + ((float)100 * (float)allCount / (a + b + c + d)));
		
		return (float)100 * Accuracy;
	}
	
	private static String[] getBasicWordsEmo(int index, String wordOrigin, String wordStem , float stemWeight) //  lock = 1.0 or 0.5
	{
		String[] result = new String[]{"","","","",""};  // index, posWord, posScore, negWord, negScore
		float posScore = 0;
		float negScore = 0;
		boolean bReturn = false;
		
		for(int i = 0; i < posWords.size(); i++)  //  检查是否是 正面词
		{
			if(wordOrigin.equals(posWords.get(i).trim()))  //  +1
			{
				posScore = posScore + 1;
				
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore);
				bReturn = true;
				break;
			}
		}
		
		if (bReturn) return result;
		
		for(int i = 0; i < negWords.size(); i++)  //  检查是否是 负面词
		{
			if(wordOrigin.equals(negWords.get(i).trim()))  //  -1
			{
				negScore = negScore - 2;
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore);
				bReturn = true;
				break;
			}
		}
		
		if (bReturn) return result;
		
		for(int i = 0; i < posWords.size(); i++)  //  检查是否是 正面词
		{
			if (posWords.get(i).equals(wordStem.trim()))  //  lock = +0.5 or +1
			{
				posScore = posScore + 1 - stemWeight; 
				
				result[0] = String.valueOf(index);
				result[1] = posWords.get(i);
				result[2] = String.valueOf(posScore);
				bReturn = true;
				break;
			}
		}
		
		if (bReturn) return result;
		
		for(int i = 0; i < negWords.size(); i++)  //  检查是否是 负面词
		{
			if (negWords.get(i).equals(wordStem.trim()))  //  lock = -0.5 or -1
			{
				negScore = negScore - stemWeight - 1;  //  negScore - stemWeight - 2
				result[0] = String.valueOf(index);
				result[3] = negWords.get(i);
				result[4] = String.valueOf(negScore);
				bReturn = true;
				break;
			}
		}
		
		if (bReturn) return result;
		
		return result;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static int getAccuracy(String right, String temp)
	{
		float S = Float.valueOf(right);
		float R = Float.valueOf(temp);
		if (S > 0 && R > 0)
			return 1; // a++
		else if (S < 0 && R < 0)
			return 4; // d++
		else if (S > 0 && !(R > 0))
			return 3; // c++
		else if (S < 0 && !(R < 0))
			return 2; // b++
		else 
			return 0;
	}
	
	public static void SOP(Object obj)
	{
		System.out.println(obj);
	}
	public static void SEP(Object obj)
	{
		System.err.println(obj);
	}
}




