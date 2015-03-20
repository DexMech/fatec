package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.json.JSONObject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Testaaa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testaaa frame = new Testaaa();
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
	public Testaaa() {
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
		
		textField = new JTextField();
		textField.setBounds(48, 58, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(48, 165, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("origin");
		lblNewLabel.setBounds(48, 31, 70, 15);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(48, 142, 70, 15);
		contentPane.add(lblNewLabel_1);
	}
	private void chama(){
	 String s = "http://maps.googleapis.com/maps/api/distancematrix/json?origins="+ textField.getText()+"&destinations="+ textField_1.getText()+"&mode=driving&language=pt-BR&sensor=false";
	 s += URLEncoder.encode( "UTF-8");
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
