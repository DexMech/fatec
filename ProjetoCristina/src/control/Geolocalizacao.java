package control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFormattedTextField;

public class Geolocalizacao extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JFormattedTextField txtOrigem;
	private JFormattedTextField txtDestino;
	private MaskFormatter mascara;



	/**
	 * pesquisa a distancia entre pontos
	 */
	public void pesquisa(ArrayList<String >a){
	
		for(String as:a){
			
			
		
		String s = "http://maps.googleapis.com/maps/api/distancematrix/json?origins="+ "03821-020"+"&destinations="+ as.replaceAll(" ", "+") +"&mode=driving&language=pt-BR&sensor=false";
		System.out.println(s);
	
		URL url = null;
		try {
			url = new URL(s);
		} catch (MalformedURLException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}

		// read from the URL
		Scanner scan = null;
		try {
			scan = new Scanner(url.openStream());
		} catch (IOException es) {
			
			es.printStackTrace();
		}
		String str = new String();
		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		// build a JSON object
		JSONObject obj = new JSONObject(str);
	;

		
		try{
		JSONObject res = obj.getJSONArray("rows").getJSONObject(0);
		JSONObject loc = res.getJSONArray("elements").getJSONObject(0);
		JSONObject d = loc.getJSONObject("distance");
		System.out.println("distancia: " + d.get("text")+" ou "+d.get("value")+" metros");
		}catch(JSONException ex){
			
			System.out.println("problema com o cep");
		}
		
		
			
			
		
		}
	}
}
