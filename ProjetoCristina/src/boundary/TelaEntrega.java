package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
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

import control.ControleTelaEntregas;
import control.MotoristaControle;
import control.ValidarData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class TelaEntrega extends JFrame {

	private JPanel contentPane;
	private MaskFormatter mascara;
	private JComboBox cbCliente, cbProduto;
	private JFormattedTextField txtData;
	public void setLblcontrol(String lblcontrol) {
		this.lblcontrol.setText(lblcontrol);
	}

	private JLabel lblcontrol;
	public JComboBox getCbProduto() {
		return cbProduto;
	}

	private ControleTelaEntregas con=new ControleTelaEntregas(getCbCliente(), getCbProduto(), getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
	private JTable table;
	private JTextField txtQuantidade;
	private JTextField textFieldRegiao;

	public JTable getTable() {
		return table;
	}

	/**
	 * Create the frame.
	 */
	public TelaEntrega() {
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
				con.ler();

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setTitle("Cadastro de Entrega");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(646, 487);
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

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(20, 80, 126, 16);
		contentPane.add(lblProduto);

		try {
			mascara = new MaskFormatter("##/##/####");
			mascara.setValidCharacters("0123456789");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setVisible(true);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaEntrega.class.getResource("/images/limpar.png")));
		btnLimpar.setBounds(503, 391, 110, 32);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
				con.limpar(); 		
			}
		});
		getContentPane().add(btnLimpar);

		JButton btnGravar = new JButton("Salvar");
		btnGravar.setIcon(new ImageIcon(TelaEntrega.class.getResource("/images/save.png")));
		btnGravar.setBounds(42, 391, 110, 32);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtData.getText().equals("")||txtQuantidade.getText().equals("")){
					lblcontrol.setForeground(Color.red);
					lblcontrol.setText("Preencha os campos");
					lblcontrol.setIcon(new ImageIcon(this.getClass().getResource("/images/atencao.gif")));
					
				}else{
					lblcontrol.setForeground(Color.black);
					lblcontrol.setText("");
					lblcontrol.setIcon(new ImageIcon(this.getClass().getResource("/images/check.png")));
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
				con.gravar();
				lblcontrol.setText(con.retornaString());
				}
			}
		});
		getContentPane().add(btnGravar);

		cbCliente = new JComboBox();
		cbCliente.setBounds(20, 47, 180, 20);
		contentPane.add(cbCliente);

		cbProduto = new JComboBox();
		cbProduto.setBounds(20, 109, 180, 20);
		contentPane.add(cbProduto);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 144, 600, 211);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Fabricante", "Descri\u00E7\u00E3o", "Peso", "Volume", "Data", "Quantidade"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(TelaEntrega.class.getResource("/images/adicionar.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
				con.preencher();
			}
		});
		btnAdicionar.setBounds(503, 104, 117, 28);
		contentPane.add(btnAdicionar);
		
		 txtData = new JFormattedTextField(mascara);
		txtData.setBounds(232, 109, 70, 19);
		contentPane.add(txtData);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addKeyListener(new KeyAdapter() {
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
		txtQuantidade.setBounds(365, 109, 70, 19);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblData = new JLabel("Data de entrega");
		lblData.setBounds(233, 81, 107, 15);
		contentPane.add(lblData);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(365, 81, 120, 15);
		contentPane.add(lblQuantidade);
		
		 lblcontrol = new JLabel("");
		lblcontrol.setBounds(190, 400, 200, 15);
		contentPane.add(lblcontrol);
		
		textFieldRegiao = new JTextField();
		textFieldRegiao.setBounds(232, 48, 318, 19);
		contentPane.add(textFieldRegiao);
		textFieldRegiao.setColumns(10);


	}

	public JTextField getTextFieldRegiao() {
		return textFieldRegiao;
	}

	public JFormattedTextField getFormattedTextField() {
		return txtData;
	}

	public JTextField getTextField() {
		return txtQuantidade;
	}

	public JComboBox getCbCliente() {
		return cbCliente;
	}
}
