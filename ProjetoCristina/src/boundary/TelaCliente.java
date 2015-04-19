/**
 * @author Tiago Santos
 *  
 * Tela responsável pelo cadastro de clientes*/

package boundary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.ClienteControle;

public class TelaCliente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuffer buffer = new StringBuffer();
	private String indent= "";
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCEP;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtCNPJ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private MaskFormatter cpf;
	private MaskFormatter cep;
	private MaskFormatter cnpj;
	private MaskFormatter tel;
	
	JLabel lblNome = new JLabel("Nome");
	JLabel lblTelefone = new JLabel("Telefone");
	JLabel lblCep = new JLabel("CEP");
	JLabel lblBairro = new JLabel("Bairro");
	JLabel lblN = new JLabel("N°");
	
	final JCheckBox chckbxSegunda = new JCheckBox("Segunda");
	final JCheckBox chckbxTerca = new JCheckBox("Terça");
	final JCheckBox chckbxQuarta = new JCheckBox("Quarta");
	final JCheckBox chckbxQuinta = new JCheckBox("Quinta");
	final JCheckBox chckbxSexta = new JCheckBox("Sexta");
	final JCheckBox chckbxSabado = new JCheckBox("Sábado");
	final JCheckBox chckbxDomingo = new JCheckBox("Domingo");
	
	JPanel panel = new JPanel();
	
	JRadioButton rdbtnCpf = new JRadioButton("CPF");
	JRadioButton rdbtnCnpj = new JRadioButton("CNPJ");

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCliente() throws ParseException {
		cep = new MaskFormatter("#####-###");
		cpf = new MaskFormatter("###.###.###-##");
		cnpj = new MaskFormatter("##.###.###/####-##");
		tel = new MaskFormatter("(##)####-####");
		
		cep.setValidCharacters("0123456789");
		cpf.setValidCharacters("0123456789");
		cnpj.setValidCharacters("0123456789");
		tel.setValidCharacters("0123456789");
		
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(437, 434);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 8, 342, 20);
		txtNome.setText("");
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		
		lblTelefone.setBounds(10, 55, 86, 14);
		contentPane.add(lblTelefone);
		
		
		lblCep.setBounds(283, 104, 46, 14);
		contentPane.add(lblCep);
		
		txtTelefone = new JFormattedTextField(tel);
		txtTelefone.setBounds(66, 52, 94, 20);
		txtTelefone.setValue("");
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCEP = new JFormattedTextField(cep);
		txtCEP.setBounds(322, 101, 86, 20);
		txtCEP.setValue("");
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		
		
		lblBairro.setBounds(10, 101, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(66, 98, 166, 20);
		txtBairro.setText("");
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		
		lblN.setBounds(259, 55, 46, 14);
		contentPane.add(lblN);
		
		txtNumero = new JTextField();
		txtNumero.setText("");
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))
                {
                    getToolkit().beep();
                    e.consume();
                }
			}
		});
		txtNumero.setBounds(281, 52, 127, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCPF = new JFormattedTextField(cpf);
		txtCPF.setBounds(241, 146, 166, 20);
		txtCPF.setValue("");
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);
		txtCPF.setVisible(true);
		
		txtCNPJ = new JFormattedTextField(cnpj);
		txtCNPJ.setBounds(241, 146, 166, 20);
		txtCNPJ.setValue("");
		txtCNPJ.setColumns(10);
		contentPane.add(txtCNPJ);
		txtCNPJ.setVisible(false);
		
		JLabel lblJanelaDeEntrega = new JLabel("Janela de Entrega");
		lblJanelaDeEntrega.setBounds(10, 197, 103, 14);
		contentPane.add(lblJanelaDeEntrega);
		
		
		panel.setBounds(66, 221, 263, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		chckbxSegunda.setBounds(16, 7, 97, 23);
		panel.add(chckbxSegunda);
				
		chckbxTerca.setBounds(16, 31, 97, 23);
		panel.add(chckbxTerca);
				
		chckbxQuarta.setBounds(16, 57, 97, 23);
		panel.add(chckbxQuarta);
				
		chckbxQuinta.setBounds(16, 83, 97, 23);
		panel.add(chckbxQuinta);
				
		chckbxSexta.setBounds(164, 7, 97, 23);
		panel.add(chckbxSexta);
				
		chckbxSabado.setBounds(164, 31, 97, 23);
		panel.add(chckbxSabado);
				
		chckbxDomingo.setBounds(164, 57, 97, 23);
		panel.add(chckbxDomingo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteControle cc = new ClienteControle();
				if(validar() == true){ // chama o metodo validador
					if(chckbxSegunda.isSelected()){
						buffer.append("Segunda;");
					}else {
						buffer.append("Nada;");
					}
					if(chckbxTerca.isSelected()){
						buffer.append("Terca;");
					}else {
						buffer.append("Nada;");
					}
					if(chckbxQuarta.isSelected()){
						buffer.append("Quarta;");
					}else {
						buffer.append("Nada;");
					}
					if(chckbxQuinta.isSelected()){
						buffer.append("Quinta;");
					}else {
						buffer.append("Nada;");
					}
					if(chckbxSexta.isSelected()){
						buffer.append("Sexta;");
					}else {
						buffer.append("Nada;");
					}
					if(chckbxSabado.isSelected()){
						buffer.append("Sabado;");
					}else {
						buffer.append("Nada;");
					}
					if(chckbxDomingo.isSelected()){
						buffer.append("Domingo;");
					}else {
						buffer.append("Nada;");
					}
					
					if(rdbtnCnpj.isSelected()==true){
						indent = "";
						indent = txtCNPJ.getValue().toString();
					}else if(rdbtnCpf.isSelected()==true){
						indent = "";
						indent = txtCPF.getValue().toString();
					}
					
					cc.InstanciarCliente(txtNome.getText(), Integer.parseInt(txtNumero.getText()), txtTelefone.getValue().toString(), 
							txtBairro.getText(), txtCEP.getValue().toString(), indent, buffer.toString());
					
					try{
						cc.gravar();
					}catch(IOException f){
						f.printStackTrace();
					}
									
				}
				buffer.delete(0, buffer.length());
				
			}
		});
		btnSalvar.setBounds(35, 362, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LimpaFormatacao();
				
				txtTelefone.setValue("");
				txtBairro.setText(" ");
				txtCEP.setValue("");
				txtCNPJ.setValue("");							
				txtCPF.setValue("");				
				txtNome.setText("");
				txtNumero.setText("");
				
			}
		});
		btnLimpar.setBounds(304, 362, 89, 23);
		contentPane.add(btnLimpar);
		
		
		rdbtnCpf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCPF.setVisible(true);
				txtCNPJ.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnCpf);
		rdbtnCpf.setBounds(10, 144, 77, 25);
		rdbtnCpf.setSelected(true);
		contentPane.add(rdbtnCpf);
		
		
		rdbtnCnpj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCPF.setVisible(false);
				txtCNPJ.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnCnpj);
		rdbtnCnpj.setBounds(105, 144, 86, 25);
		contentPane.add(rdbtnCnpj);
		
		setVisible(true);
	}
	
	/*
	 * Metodo validador
	 */
	public boolean validar(){
		boolean tudocerto = false;
		
		if(txtNome.getText().isEmpty()){
			
			txtNome.setBackground(Color.yellow);
			lblNome.setForeground(new Color(255,69,0));
			
		}else if(txtTelefone.getValue().toString().isEmpty()){
			
			txtTelefone.setBackground(Color.yellow);
			lblTelefone.setForeground(new Color(255,69,0));			
		
		}else if(txtNumero.getText().isEmpty()){
				
			txtNumero.setBackground(Color.yellow);
			lblN.setForeground(new Color(255,69,0));
			
		}else if(txtBairro.getText().isEmpty()){
			
			txtBairro.setBackground(Color.yellow);
			lblBairro.setForeground(new Color(255,69,0));
			
		}else if(txtCEP.getValue().toString().isEmpty()){
			
			txtCEP.setBackground(Color.yellow);
			lblCep.setForeground(new Color(255,69,0));
			
		}else if(chckbxDomingo.isSelected()==false && chckbxQuarta.isSelected()==false && chckbxQuinta.isSelected()==false && chckbxSabado.isSelected()==false 
				 && chckbxSegunda.isSelected()==false && chckbxSexta.isSelected()==false && chckbxTerca.isSelected()==false){
			
			panel.setBackground(new Color(255,69,0));
			chckbxDomingo.setBackground(new Color(255,69,0));
			chckbxSegunda.setBackground(new Color(255,69,0));
			chckbxTerca.setBackground(new Color(255,69,0));
			chckbxQuarta.setBackground(new Color(255,69,0));
			chckbxQuinta.setBackground(new Color(255,69,0));
			chckbxSexta.setBackground(new Color(255,69,0));
			chckbxSabado.setBackground(new Color(255,69,0));
			
		}else{
			tudocerto = true;
		}
		
		return tudocerto;
	}
	
	public void LimpaFormatacao(){
		txtTelefone.setBackground(Color.WHITE);
		lblTelefone.setForeground(Color.black);
		
		txtBairro.setBackground(Color.white);				
		lblBairro.setForeground(Color.black);
		
		txtCEP.setBackground(Color.white);
		lblCep.setForeground(Color.black);
		
		txtCNPJ.setBackground(Color.white);
		txtCPF.setBackground(Color.white);
		
		txtNumero.setBackground(Color.white);
		lblN.setForeground(Color.black);
		
		txtNome.setBackground(Color.white);
		lblNome.setForeground(Color.black);
		
	}
}
