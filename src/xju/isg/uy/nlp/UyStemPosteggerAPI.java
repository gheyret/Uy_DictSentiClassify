package xju.isg.uy.nlp;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Vector;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UyStemPosteggerAPI {
	
	public static String getStr_Posteg(String txt) throws IOException
	{
		// 阿里云服务器：    60.205.213.149:80 
		// 实验室PC-2：    172.30.10.9:5000 
		
		OkHttpClient client = new OkHttpClient();
		String encodedURL = URLEncoder.encode(txt, "UTF-8");
		String trans = "";
		RequestBody body = new FormBody.Builder().add("content", "hello world")
				.build();
		Request request = new Request.Builder()
				.url("http://60.205.213.149:80/uypostegger?content=" + encodedURL)
				.post(body)
				.addHeader("content-type", "application/x-www-form-urlencoded")
				.addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "b7bd1412-774d-1733-0abf-4108c4be96ff").build();

		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				trans = response.body().string();
				System.out.println(trans);
				response.close();
			} else {
				throw new IOException("Unexpected code " + response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}
	
	public static String getStr_Stemteg(String txt) throws IOException
	{
		OkHttpClient client = new OkHttpClient();
		String encodedURL = URLEncoder.encode(txt, "UTF-8");
		String trans = "";
		RequestBody body = new FormBody.Builder().add("content", "hello world")
				.build();
		Request request = new Request.Builder()
				.url("http://60.205.213.149:80/uystemmer?content=" + encodedURL)
				.post(body)
				.addHeader("content-type", "application/x-www-form-urlencoded")
				.addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "b7bd1412-774d-1733-0abf-4108c4be96ff").build();

		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				trans = response.body().string();
				System.out.println(trans);
				response.close();
			} else {
				throw new IOException("Unexpected code " + response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}
	
	public static Vector<String> getStr_StemtegVic()
	{
		Vector<String> segResult = new Vector<String>();
		return segResult;
	}
	public static Vector<String> getStr_PostegVic()
	{
		Vector<String> posResult = new Vector<String>();
		return posResult;
	}
	
	public static String getSegPos(String txt) throws IOException
	{
		String posText = getStr_Posteg(txt);
		posText = posText.replaceAll("\\[\\[\\('*", "").replaceAll("'*\\)\\]\\]", "")
				.replaceAll("'", "").replaceAll(" ", "").replaceAll("\\),\\(", " ").replaceAll(",", "/");
		
		return posText;
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception 
	{
		String txt = "【hello】مەن ئۇيغۇر كادىر، ۋەتەنگە بولغان مىننەتدارلىق ھېسسىياتىم قەلبىمدە چوڭقۇر يىلتىز تارتتى. كىچىكىمدىن بىڭتۈەندە ئۆسۈپ چوڭ بولدۇم، دادام بالدۇر قازا قىلىپ كەتكەچكە، " +
				"گۈزەل بالىلىق ھاياتىم ئۇيغۇر، خەنزۇ قوشنىلارنىڭ ئۆزئارا قوللىشى ۋە ياردىمىدە ئۆتتى. قەلبىمدە ھەر مىللەت ئەسلىي بىر ئائىلە كىشىلىرى، دەپ قارايمەن.";
		
		String posText = getStr_Posteg(txt);
		String stemText = getStr_Stemteg(txt);
		
		posText = posText.replaceAll("\\[\\[\\('*", "").replaceAll("'*\\)\\]\\]", "")
				.replaceAll("'", "").replaceAll(" ", "").replaceAll("\\),\\(", " ").replaceAll(",", "/");
		stemText = stemText.replaceAll("\\[\\[\\('*", "").replaceAll("'*\\)\\]\\]", "")
				.replaceAll("'", "").replaceAll(" ", "").replaceAll("\\),\\(", " ").replaceAll(",", "/");
		
		System.out.println("\n" + posText + "\n" + stemText);
		System.out.println("\n" + posText.split(" +").length + "\n" + stemText.split(" +").length);
	}
	
}


