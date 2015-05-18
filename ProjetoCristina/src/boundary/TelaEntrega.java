package boundary;
/**
 * @author Alex Carlos e Marcio augusto
 * @version 1.x
 * 
 * <ul><h3>Versões</h3>
 * 		<li>1.0 Criação da classe.</li>
 * </ul>*/
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
import java.awt.Font;


public class TelaEntrega extends JFrame {

	private JPanel contentPane;
	private MaskFormatter mascara;
	private JComboBox cbCliente, cbProduto;
	private JFormattedTextField txtData;
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
	 * Método Construtor da Classe
	 */
	public TelaEntrega() {
		/**
		 * WindowListener acionado quando a janela é aberta
		 */
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				/**
				 * Criação de uma instacia de ControleTelaEntregas
				 * @param  getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao()
				 */
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
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(20, 20, 56, 16);
		contentPane.add(lblCliente);

		Icon iconbuscar = new ImageIcon("images\\buscar.png");

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setIcon(new ImageIcon(TelaEntrega.class.getResource("/images/limpar.png")));
		btnLimpar.setBounds(490, 391, 110, 33);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		getContentPane().add(btnLimpar);

		JButton btnGravar = new JButton("Salvar");
		btnGravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravar.setIcon(new ImageIcon(TelaEntrega.class.getResource("/images/save.png")));
		btnGravar.setBounds(40, 391, 110, 33);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtData.getText().equals("")&&!txtQuantidade.getText().equals("")){
					con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
					con.gravar();
					limpar();
				}
			}
		});
		getContentPane().add(btnGravar);

		cbCliente = new JComboBox();
		cbCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCliente.setBounds(20, 40, 180, 28);
		contentPane.add(cbCliente);

		cbProduto = new JComboBox();
		cbProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbProduto.setBounds(20, 100, 180, 28);
		contentPane.add(cbProduto);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 144, 600, 211);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Fabricante", "Descri\u00E7\u00E3o", "Peso", "Volume", "Data", "Quantidade"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setIcon(new ImageIcon(TelaEntrega.class.getResource("/images/adicionar.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
				con.preencher();
			}
		});
		btnAdicionar.setBounds(483, 95, 117, 33);
		contentPane.add(btnAdicionar);
		
		 txtData = new JFormattedTextField(mascara);
		 txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(232, 100, 70, 28);
		contentPane.add(txtData);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		txtQuantidade.setBounds(365, 100, 70, 28);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblData = new JLabel("Data de entrega");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(233, 68, 107, 28);
		contentPane.add(lblData);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(365, 68, 120, 27);
		contentPane.add(lblQuantidade);
		
		textFieldRegiao = new JTextField();
		textFieldRegiao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldRegiao.setEditable(false);
		textFieldRegiao.setBounds(232, 40, 318, 28);
		contentPane.add(textFieldRegiao);
		textFieldRegiao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Região");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(232, 20, 70, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Separa");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
				con.separa();
			}
		});
		btnNewButton.setBounds(180, 391, 117, 33);
		contentPane.add(btnNewButton);


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
	
	public void limpar(){
		cbCliente.setSelectedIndex(0);
		cbProduto.setSelectedIndex(0);
		txtData.setText("");
		textFieldRegiao.setText("");
		txtQuantidade.setText("");
		con = new ControleTelaEntregas(getCbCliente(), getCbProduto(),getTable(),getTextField(),getFormattedTextField(),getTextFieldRegiao());
		con.limpar(); 	
	}
}
