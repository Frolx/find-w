package com.spring.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;




import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.spring.test.frlx.SiteLink;

public class Util {
	
	public static void downloadPage(String url) throws IOException {
		
		URL link = new URL(url);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));
		String line = "";
		
		while ((line = reader.readLine()) != null) {
//			System.out.println("DOM### ->" + line);
			//parseLink(line);
		}
		
		reader.close();
	}
	
	public static SiteLink<String> parseLink(String data) throws IOException {
		Document doc = Jsoup.connect(data).get();
		Elements links = doc.select("a[href]");
		
		SiteLink<String> siteLink = new SiteLink<String>(data);
		
		for (Element link : links) {
			siteLink.addChildLink(new SiteLink<String>(link.attr("href")));
			System.out.println(link.attr("href").toString());
		}
		return siteLink;
	}
	
	public static void parseLink(SiteLink<String> siteLink, int level) throws IOException {
		if(level <= 1) {
			String linkString = siteLink.getLink();
			if(!linkString.contains("http://") && !linkString.contains("https://")) {
				if(linkString.startsWith("/")) {
					linkString = "http://data.black3dsnake.com" + linkString;					
				} else {
					linkString = "http://data.black3dsnake.com/" + linkString;
				}
			}
			Document doc = Jsoup.connect(linkString).get();
			Elements links = doc.select("a[href]");
			
			for (Element link : links) {
				System.out.println("Level: " + level + " :" + link.attr("href").toString());
				SiteLink<String> child = new SiteLink<String>(link.attr("href"));
				parseLink(child, level + 1);
				siteLink.addChildLink(child);
				
			}
		}
	}
	
	
	public static void backTrack() {
		
	}
}
