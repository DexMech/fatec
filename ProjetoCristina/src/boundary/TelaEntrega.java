/**
 * @author Marcio Augusto
 * @author Danilo Santos
 * 
 * Tela responsável por ligar cliente aos seus produtos a serem entregues*/

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
	private JTextField textField;
	private JTextField txtPeso;
	private JTextField txtVolume;

	/**
	 * Create the frame.
	 */
	public TelaEntrega() {
		setTitle("Cadastro de Entrega");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 300);
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
		txtCliente.setBounds(20, 40, 180, 27);
		txtCliente.setEnabled(false);
		txtCliente.setEditable(false);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(20, 80, 56, 16);
		contentPane.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(20, 100, 180, 27);
		txtProduto.setEditable(false);
		txtProduto.setEnabled(false);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		JButton btnBuscarProduto = new JButton(iconbuscar);
		btnBuscarProduto.setBounds(220, 102, 22, 22);
		btnBuscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnBuscarProduto);
		
		try {
			mascara = new MaskFormatter("##/##/####");
			mascara.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtdata = new JFormattedTextField(mascara);
		txtdata.setBounds(20, 160, 56, 27);
		contentPane.add(txtdata);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(20, 140, 56, 16);
		contentPane.add(lblData);
		
		setVisible(true);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(152, 220, 90, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProduto.setText("");
				txtCliente.setText("");
				txtdata.setValue("");
							}
		});
		getContentPane().add(btnLimpar);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(20, 220, 81, 23);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		getContentPane().add(btnGravar);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(80, 141, 63, 14);
		contentPane.add(lblQuantidade);
		
		textField = new JTextField();
		textField.setBounds(84, 160, 63, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setBounds(152, 160, 48, 27);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(152, 141, 46, 14);
		contentPane.add(lblPeso);
		
		JLabel lblKg = new JLabel("Kg");
		lblKg.setBounds(203, 173, 22, 14);
		contentPane.add(lblKg);
		
		txtVolume = new JTextField();
		txtVolume.setEditable(false);
		txtVolume.setBounds(220, 160, 53, 27);
		contentPane.add(txtVolume);
		txtVolume.setColumns(10);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setBounds(220, 141, 46, 14);
		contentPane.add(lblVolume);
		
		JLabel lblM = new JLabel("m³");
		lblM.setBounds(276, 172, 22, 14);
		contentPane.add(lblM);
	}
}
