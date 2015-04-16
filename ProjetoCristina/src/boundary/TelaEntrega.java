package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import control.MotoristaControle;
import control.ValidarData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;


public class TelaEntrega extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtProduto;
	private MaskFormatter mascara;
	private JFormattedTextField txtdata;

	/**
	 * Create the frame.
	 */
	public TelaEntrega() {
		setTitle("Cadastro de Entrega");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(20, 20, 56, 16);
		contentPane.add(lblCliente);
		
		Icon iconbuscar = new ImageIcon("images\\buscar.png");
		
		JButton btnBuscarCliente = new JButton(iconbuscar);
		btnBuscarCliente.setBounds(220, 42, 22, 22);
		contentPane.add(btnBuscarCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setEditable(false);
		txtCliente.setBounds(20, 40, 180, 27);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(20, 80, 56, 16);
		contentPane.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setEditable(false);
		txtProduto.setEnabled(false);
		txtProduto.setBounds(20, 100, 180, 27);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		JButton btnBuscarProduto = new JButton(iconbuscar);
		btnBuscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnBuscarProduto.setBounds(220, 102, 22, 22);
		contentPane.add(btnBuscarProduto);
		
		try {
			mascara = new MaskFormatter("##/##/####");
			mascara.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtdata = new JFormattedTextField(mascara);
		txtdata.setBounds(20, 160, 90, 27);
		contentPane.add(txtdata);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(20, 140, 56, 16);
		contentPane.add(lblData);
		
		setVisible(true);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProduto.setText("");
				txtCliente.setText("");
				txtdata.setValue("");
							}
		});
		btnLimpar.setBounds(152, 220, 90, 23);
		getContentPane().add(btnLimpar);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		btnGravar.setBounds(20, 220, 90, 23);
		getContentPane().add(btnGravar);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new TelaEntrega();
	}
	
	
}
