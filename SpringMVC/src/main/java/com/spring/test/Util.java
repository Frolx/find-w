package com.spring.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Util {
	
	public static void downloadPage(String url) throws IOException {
		
		URL link = new URL(url);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
		String line = "";
		
		while ((line = reader.readLine()) != null) {
			System.out.println("DOM### ->" + line);
			//parseLink(line);
		}
		
		reader.close();
	}
	
	public static void parseLink(String data) throws IOException {
		Document doc = Jsoup.connect(data).get();
		Elements links = doc.select("a[href]");
		
		for (Element link : links) {

		}
		
	}
	
	
	public static void backTrack() {
		
	}
}
