package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import controller.ControlaLeituraEntrega;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;
import java.text.ParseException;

public class ConsultaEntrega extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JLabel labelControl;
	private JTextField txtCliente;
	private MaskFormatter mascara;
	private JFormattedTextField txtdata;
	
	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEntrega frame = new ConsultaEntrega();
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
	public ConsultaEntrega() {
		setTitle("Consulta de Entregas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 109, 637, 246);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Regi\u00E3o", "Cliente", "Caminh\u00E3o", "Data"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			new ControlaLeituraEntrega().sair();
			
			}
		});
		btnSair.setBounds(572, 385, 117, 25);
		contentPane.add(btnSair);
		
		JButton btnExportarCvs = new JButton("Exportar cvs");
		btnExportarCvs.setBounds(54, 385, 117, 25);
		contentPane.add(btnExportarCvs);
		
		JLabel labelCliente = new JLabel("Cliente");
		labelCliente.setBounds(51, 38, 57, 50);
		contentPane.add(labelCliente);
		try {
			mascara = new MaskFormatter("##/##/####");
			mascara.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtdata = new JFormattedTextField(mascara);
		txtdata.setBounds(398, 50, 122, 27);
		contentPane.add(txtdata);
		
		JLabel labelData = new JLabel("Data");
		labelData.setBounds(356, 38, 39, 50);
		contentPane.add(labelData);
		 labelControl = new JLabel("");
		 labelControl.setFont(new Font("Arial", Font.BOLD, 9));
		labelControl.setForeground(Color.RED);
		labelControl.setBounds(447, 6, 186, 15);
		contentPane.add(labelControl);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCliente.getText().isEmpty()||txtdata.getText().isEmpty()){
					
					labelControl.setText("*preencha os campos");
					
				}
				else{
				ControlaLeituraEntrega c = new ControlaLeituraEntrega();
				
			
				c.busca(txtCliente.getText(),txtdata.getText(),getTable());
				}
				
			}
		});
		btnBuscar.setBounds(572, 51, 117, 25);
		contentPane.add(btnBuscar);
		
		
		
		txtCliente = new JTextField();
		txtCliente.setBounds(110, 50, 122, 27);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControlaLeituraEntrega().limpar(getTable());
			}
		});
		btnLimpar.setBounds(431, 385, 117, 25);
		contentPane.add(btnLimpar);
		
		
		
	}

	public void setTxtCliente(JTextField txtCliente) {
		this.txtCliente = txtCliente;
	}

	public void setTxtdata(JFormattedTextField txtdata) {
		this.txtdata = txtdata;
	}
}
