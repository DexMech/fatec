package testing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.json.JSONObject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JFormattedTextField;

public class TestaGeolocalizacao extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
private JFormattedTextField txtOrigem;
private JFormattedTextField txtDestino;
private MaskFormatter mascara;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestaGeolocalizacao frame = new TestaGeolocalizacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestaGeolocalizacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chama();
				
				
			}
		});
		
		
		btnCalcular.setBounds(386, 305, 117, 25);
		contentPane.add(btnCalcular);
		
		lblNewLabel = new JLabel("origin");
		lblNewLabel.setBounds(48, 31, 70, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(48, 142, 70, 15);
		contentPane.add(lblNewLabel_1);
		try {
			mascara = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 txtOrigem = new JFormattedTextField(mascara);
		txtOrigem.setBounds(48, 77, 125, 25);
		contentPane.add(txtOrigem);
		
		 txtDestino = new JFormattedTextField(mascara);
		txtDestino.setBounds(52, 200, 121, 25);
		contentPane.add(txtDestino);
	}
	private void chama(){
	 String s = "http://maps.googleapis.com/maps/api/distancematrix/json?origins="+ txtOrigem.getText()+"&destinations="+ txtDestino.getText()+"&mode=driving&language=pt-BR&sensor=false";
	  try {
		URLEncoder.encode(s, "UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
		// TODO Auto-generated catch block
		es.printStackTrace();
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
