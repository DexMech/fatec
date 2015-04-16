package boundary;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtCEP;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtCNPJ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private MaskFormatter cpf;
	private MaskFormatter cnpj;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCliente() throws ParseException {
		cpf = new MaskFormatter("###.###.###-##");
		cnpj = new MaskFormatter("##.###.###/####-##");
		
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 437, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 8, 342, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 55, 86, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(283, 104, 46, 14);
		contentPane.add(lblCep);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("(99)9999-9999");
		txtTelefone.setBounds(66, 52, 94, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(322, 101, 86, 20);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 101, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(66, 98, 166, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblN = new JLabel("N°");
		lblN.setBounds(259, 55, 46, 14);
		contentPane.add(lblN);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(281, 52, 127, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtCPF = new JFormattedTextField(cpf);
		txtCPF.setBounds(241, 146, 166, 20);
		//contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);
		txtCPF.setVisible(true);
		
		txtCNPJ = new JFormattedTextField(cnpj);
		txtCNPJ.setBounds(241, 146, 166, 20);
		//contentPane.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		contentPane.add(txtCNPJ);
		txtCNPJ.setVisible(false);
		
		JLabel lblJanelaDeEntrega = new JLabel("Janela de Entrega");
		lblJanelaDeEntrega.setBounds(10, 196, 103, 14);
		contentPane.add(lblJanelaDeEntrega);
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 221, 263, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxSegunda = new JCheckBox("Segunda");
		chckbxSegunda.setBounds(16, 7, 97, 23);
		panel.add(chckbxSegunda);
		
		JCheckBox chckbxTerca = new JCheckBox("Terca");
		chckbxTerca.setBounds(16, 31, 97, 23);
		panel.add(chckbxTerca);
		
		JCheckBox chckbxQuarta = new JCheckBox("Quarta");
		chckbxQuarta.setBounds(16, 57, 97, 23);
		panel.add(chckbxQuarta);
		
		JCheckBox chckbxQuinta = new JCheckBox("Quinta");
		chckbxQuinta.setBounds(16, 83, 97, 23);
		panel.add(chckbxQuinta);
		
		JCheckBox chckbxSexta = new JCheckBox("Sexta");
		chckbxSexta.setBounds(164, 7, 97, 23);
		panel.add(chckbxSexta);
		
		JCheckBox chckbxSabado = new JCheckBox("Sabado");
		chckbxSabado.setBounds(164, 31, 97, 23);
		panel.add(chckbxSabado);
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		chckbxDomingo.setBounds(164, 57, 97, 23);
		panel.add(chckbxDomingo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(35, 362, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(304, 362, 89, 23);
		contentPane.add(btnLimpar);
		
		JRadioButton rdbtnCpf = new JRadioButton("CPF");
		rdbtnCpf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCPF.setVisible(true);
				txtCNPJ.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnCpf);
		rdbtnCpf.setBounds(10, 144, 77, 25);
		contentPane.add(rdbtnCpf);
		
		JRadioButton rdbtnCnpj = new JRadioButton("CNPJ");
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
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaInicial();
			}
		});
		btnNewButton.setBounds(154, 361, 103, 25);
		contentPane.add(btnNewButton);
		
		setVisible(true);
	}
}
