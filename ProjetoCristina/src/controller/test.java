package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONObject;

public class test {
	
	

	public static void main(String[] args) {
		 String s = "http://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC|Seattle&destinations=San+Francisco|Victoria+BC&mode=bicycling&language=fr-FR&sensor=false";
 s += URLEncoder.encode( "UTF-8");
 URL url = null;
try {
	url = new URL(s);
} catch (MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 // read from the URL
 Scanner scan = null;
try {
	scan = new Scanner(url.openStream());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 String str = new String();
 while (scan.hasNext())
     str += scan.nextLine();
 scan.close();

 // build a JSON object
 JSONObject obj = new JSONObject(str);
 if (! obj.getString("status").equals("OK"))
     return;

 // get the first result
 JSONObject res = obj.getJSONArray("rows").getJSONObject(0);
 //System.out.println(res.getString("distance"));
 JSONObject loc = res.getJSONArray("elements").getJSONObject(0);
 JSONObject d = loc.getJSONObject("distance");
 System.out.println("distancia: " + d.get("text")+" ou "+d.get("value")+" metros");
}

	}


