/**
 * @author Tiago Santos
 *  
 * Tela responsável pelo cadastro de clientes*/

package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.ClienteControle;
import control.Geolocalizacao;

public class TelaCliente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuffer buffer = new StringBuffer();
	private String indent= "";
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCEP;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtCNPJ;
	private JFormattedTextField txtCelular;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private MaskFormatter cpf;
	private MaskFormatter cep;
	private MaskFormatter cnpj;
	private MaskFormatter tel;
	private MaskFormatter cel;
	
	JLabel lblNome = new JLabel("Nome:");
	JLabel lblTelefone = new JLabel("Telefone:");
	JLabel lblCep = new JLabel("CEP:");
	JLabel lblBairro = new JLabel("Bairro:");
	JLabel lblN = new JLabel("N°");
	JLabel lblEndereco = new JLabel("Endereço:");
	JLabel lblCelular = new JLabel("Celular:");
	
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

	JLabel lblAvisoDia;	
	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCliente() throws ParseException {
		cep = new MaskFormatter("#####-###");
		cpf = new MaskFormatter("###.###.###-##");
		cnpj = new MaskFormatter("##.###.###/####-##");
		tel = new MaskFormatter("(##)####-####");
		cel = new MaskFormatter("(##)#####-####");
		
		cep.setValidCharacters("0123456789");
		cpf.setValidCharacters("0123456789");
		cnpj.setValidCharacters("0123456789");
		tel.setValidCharacters("0123456789");
		cel.setValidCharacters("0123456789");
		
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(606, 506);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 20, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(90, 15, 419, 25);
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNome.setBackground(Color.white);
				lblNome.setForeground(Color.black);
			}
		});
		txtNome.setText("");
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 141, 86, 17);
		contentPane.add(lblTelefone);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCep.setBounds(354, 100, 46, 22);
		contentPane.add(lblCep);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEndereco.setBounds(90, 54, 310, 25);
		txtEndereco.setText("");
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		txtEndereco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtEndereco.setBackground(Color.white);
				lblEndereco.setForeground(Color.black);
			}
		});
		
		txtTelefone = new JFormattedTextField(tel);
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setBounds(90, 137, 116, 25);
		txtTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtTelefone.setBackground(Color.white);
				lblTelefone.setForeground(Color.black);
			}
		});
		txtTelefone.setValue("");
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCEP = new JFormattedTextField(cep);
		txtCEP.setBounds(400, 99, 109, 25);
		txtCEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtCEP.setBackground(Color.white);
				lblCep.setForeground(Color.black);
			}
		});
		txtCEP.setValue("");
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBairro.setBounds(10, 98, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBairro.setBounds(90, 99, 210, 25);
		txtBairro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtBairro.setBackground(Color.white);
				lblBairro.setForeground(Color.black);
			}
		});
		txtBairro.setText("");
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblN.setBounds(418, 54, 17, 29);
		contentPane.add(lblN);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumero.setBounds(448, 54, 62, 25);
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
		txtNumero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNumero.setBackground(Color.white);
				lblN.setForeground(Color.black);
			}
		});
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCPF = new JFormattedTextField(cpf);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCPF.setBounds(246, 185, 127, 25);
		txtCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtCPF.setBackground(Color.white);
				rdbtnCnpj.setForeground(Color.black);
				rdbtnCpf.setForeground(Color.black);
			}
		});
		txtCPF.setValue("");
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);
		txtCPF.setVisible(true);
		
		txtCNPJ = new JFormattedTextField(cnpj);
		txtCNPJ.setBounds(246, 185, 127, 20);
		txtCNPJ.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtCNPJ.setBackground(Color.white);
			}
		});
		txtCNPJ.setValue("");
		txtCNPJ.setColumns(10);
		contentPane.add(txtCNPJ);
		txtCNPJ.setVisible(false);
		
		JLabel lblJanelaDeEntrega = new JLabel("Janela de Entrega");
		lblJanelaDeEntrega.setBounds(178, 231, 143, 14);
		contentPane.add(lblJanelaDeEntrega);
		panel.setBounds(93, 256, 362, 130);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		chckbxSegunda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		chckbxSegunda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoDia.setVisible(false);
			}
		});
		chckbxSegunda.setBounds(16, 7, 97, 23);
		panel.add(chckbxSegunda);
		chckbxTerca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		chckbxTerca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoDia.setVisible(false);
			}
		});
		chckbxTerca.setBounds(16, 31, 97, 23);
		panel.add(chckbxTerca);
		chckbxQuarta.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
		chckbxQuarta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoDia.setVisible(false);
			}
		});
		chckbxQuarta.setBounds(16, 57, 97, 23);
		panel.add(chckbxQuarta);
		chckbxQuinta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		chckbxQuinta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoDia.setVisible(false);
			}
		});
		chckbxQuinta.setBounds(16, 83, 97, 23);
		panel.add(chckbxQuinta);
		chckbxSexta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		chckbxSexta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoDia.setVisible(false);
			}
		});
		chckbxSexta.setBounds(257, 7, 97, 23);
		panel.add(chckbxSexta);
		chckbxSabado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		chckbxSabado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoDia.setVisible(false);
			}
		});
		chckbxSabado.setBounds(257, 31, 97, 23);
		panel.add(chckbxSabado);
		chckbxDomingo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		chckbxDomingo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoDia.setVisible(false);
			}
		});
		chckbxDomingo.setBounds(257, 57, 97, 23);
		panel.add(chckbxDomingo);
		
		lblAvisoDia = new JLabel("Selecione ao menos um dia da semana");
		lblAvisoDia.setBounds(10, 108, 251, 16);
		panel.add(lblAvisoDia);
		lblAvisoDia.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAvisoDia.setForeground(Color.RED);
		lblAvisoDia.setVisible(false);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(57, 419, 103, 32);
		btnSalvar.setIcon(new ImageIcon(TelaCliente.class.getResource("/images/save.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteControle cc = new ClienteControle();
				if(validar()){ // chama o metodo validador
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
					
					cc.InstanciarCliente(txtNome.getText(),txtEndereco.getText(), Integer.parseInt(txtNumero.getText()), txtTelefone.getValue().toString(), 
							txtCelular.getValue().toString(), txtBairro.getText(), txtCEP.getValue().toString(), indent, buffer.toString());
					
					try{
						Geolocalizacao geo = new Geolocalizacao();
						geo.pesquisa(txtCEP.getText());
						cc.gravar();
						limpar();
						LimpaFormatacao();
					}catch(IOException f){
						f.printStackTrace();
					}
									
				}
				buffer.delete(0, buffer.length());
				
			}
		});
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(286, 419, 127, 32);
		btnLimpar.setIcon(new ImageIcon(TelaCliente.class.getResource("/images/limpar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpaFormatacao();
				limpar();
			}
		});
		contentPane.add(btnLimpar);
		rdbtnCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCpf.setBounds(60, 183, 77, 25);
		
		
		rdbtnCpf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCPF.setVisible(true);
				txtCNPJ.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnCpf);
		rdbtnCpf.setSelected(true);
		contentPane.add(rdbtnCpf);
		rdbtnCnpj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCnpj.setBounds(146, 183, 86, 25);
		
		
		rdbtnCnpj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCPF.setVisible(false);
				txtCNPJ.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnCnpj);
		contentPane.add(rdbtnCnpj);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		lblEndereco.setBounds(10, 60, 77, 17);
		contentPane.add(lblEndereco);
		
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(327, 141, 62, 17);
		contentPane.add(lblCelular);
		
		txtCelular = new JFormattedTextField(cel);
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCelular.setColumns(10);
		txtCelular.setBounds(393, 137, 116, 25);
		contentPane.add(txtCelular);
		
		
		
		setVisible(true);
	}
	
	/*
	 * Metodo validador
	 */
	public boolean validar(){
		boolean tudocerto = true;
		
		if(txtNome.getText().isEmpty()){
			
			txtNome.setBackground(new Color(255,250,205));
			lblNome.setForeground(new Color(255,69,0));
			tudocerto = false;
		}
		
		if(txtEndereco.getText().isEmpty()){
			
			txtEndereco.setBackground(new Color(255,250,205));
			lblEndereco.setForeground(new Color(255,69,0));
			tudocerto = false;
		}
		
		if(txtTelefone.getValue().toString().isEmpty()){
			
			txtTelefone.setBackground(new Color(255,250,205));
			lblTelefone.setForeground(new Color(255,69,0));			
			tudocerto = false;
		}
		
		if(txtCelular.getValue().toString().isEmpty()){
			
			txtCelular.setBackground(new Color(255,250,205));
			lblCelular.setForeground(new Color(255,69,0));			
			tudocerto = false;
		}

		if(txtNumero.getText().isEmpty()){
				
			txtNumero.setBackground(new Color(255,250,205));
			lblN.setForeground(new Color(255,69,0));
			tudocerto = false;
		}

		if(txtBairro.getText().isEmpty()){
			
			txtBairro.setBackground(new Color(255,250,205));
			lblBairro.setForeground(new Color(255,69,0));
			tudocerto = false;
		}

		if(txtCEP.getValue().toString().isEmpty()){
			
			txtCEP.setBackground(new Color(255,250,205));
			lblCep.setForeground(new Color(255,69,0));
			tudocerto = false;
		}
		
		if(txtCNPJ.getValue().toString().isEmpty() && txtCPF.getValue().toString().isEmpty()){
			
			txtCPF.setBackground(new Color(255,250,205));
			rdbtnCpf.setForeground(new Color(255,69,0));
			txtCNPJ.setBackground(new Color(255,250,205));
			rdbtnCnpj.setForeground(new Color(255,69,0));
			tudocerto = false;
		}

		if(chckbxDomingo.isSelected()==false && chckbxQuarta.isSelected()==false && chckbxQuinta.isSelected()==false && chckbxSabado.isSelected()==false 
				 && chckbxSegunda.isSelected()==false && chckbxSexta.isSelected()==false && chckbxTerca.isSelected()==false){
			lblAvisoDia.setVisible(true);
			tudocerto = false;
			
		}
		
		return tudocerto;
	}
	
	public void LimpaFormatacao(){
		txtTelefone.setBackground(Color.WHITE);
		lblTelefone.setForeground(Color.black);
		
		txtCelular.setBackground(Color.WHITE);
		lblCelular.setForeground(Color.black);
		
		txtBairro.setBackground(Color.white);				
		lblBairro.setForeground(Color.black);
		
		txtEndereco.setBackground(Color.white);				
		lblEndereco.setForeground(Color.black);
		
		txtCEP.setBackground(Color.white);
		lblCep.setForeground(Color.black);
		
		txtCNPJ.setBackground(Color.white);
		rdbtnCnpj.setForeground(Color.black);
		txtCPF.setBackground(Color.white);
		rdbtnCpf.setForeground(Color.BLACK);
		
		txtNumero.setBackground(Color.white);
		lblN.setForeground(Color.black);
		
		txtNome.setBackground(Color.white);
		lblNome.setForeground(Color.black);
		
	}
	
	public void limpar(){
		txtTelefone.setValue("");
		txtCelular.setValue("");
		txtEndereco.setText("");
		txtBairro.setText("");
		txtCEP.setValue("");
		txtCNPJ.setValue("");							
		txtCPF.setValue("");				
		txtNome.setText("");
		txtNumero.setText("");
		chckbxSegunda.setSelected(false);
		chckbxTerca.setSelected(false);
		chckbxQuarta.setSelected(false);
		chckbxQuinta.setSelected(false);
		chckbxSexta.setSelected(false);
		chckbxSabado.setSelected(false);
		chckbxDomingo.setSelected(false);
		lblAvisoDia.setVisible(false);
	}
}
