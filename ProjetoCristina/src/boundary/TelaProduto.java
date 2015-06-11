/**
 * @author Stefanie Lima
 * Tela de cadastro de produtos*/

package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import control.MotoristaControle;
import control.ProdutoControle;

import javax.swing.JScrollPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;

import java.awt.Font;

public class TelaProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField tfNome;
	private JTextField tfFabricante;
	private JTextField tfKg;
	private JTextField tfVolume;
	
	private JLabel lblFabricante;	
	private JLabel lblDescritivo;
	private JLabel lblPeso;	
	private JLabel lblKg;	
	private JLabel lblVolume;
	private JLabel lblMeCubico;
	private JLabel lblNome;
	private JLabel lblFornecedor;
	
	private JTextArea taDescritivo;
	private JScrollPane scrollPane;
	
	private JLabel lblAvisoProduto;
	private JTextField tfFornecedor;
	private JButton btnBusca;
	private JButton btnDeletar;
	private JButton btnAtualizar;

	public TelaProduto() {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(560, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 20, 68, 20);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNome.setBounds(113, 19, 378, 23);
		tfNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfNome.setBackground(Color.white);
				lblNome.setForeground(Color.black);
			}
		});
		tfNome.setText("");
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabricante.setBounds(10, 60, 89, 20);
		contentPane.add(lblFabricante);
		
		tfFabricante = new JTextField();
		tfFabricante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFabricante.setBounds(113, 59, 378, 23);
		tfFabricante.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfFabricante.setBackground(Color.white);
				lblFabricante.setForeground(Color.black);
			}
		});
		tfFabricante.setText("");
		contentPane.add(tfFabricante);
		tfFabricante.setColumns(10);
		
		lblDescritivo = new JLabel("Descritivo");
		lblDescritivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescritivo.setBounds(20, 154, 89, 20);
		contentPane.add(lblDescritivo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 179, 446, 129);
		contentPane.add(scrollPane);
		
		taDescritivo = new JTextArea();
		scrollPane.setViewportView(taDescritivo);
		taDescritivo.setFont(new Font("Monospaced", Font.PLAIN, 14));
		taDescritivo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				taDescritivo.setBackground(Color.white);
				lblDescritivo.setForeground(Color.black);
			}
		});
		taDescritivo.setText("");
		taDescritivo.setLineWrap(true);
		
		lblPeso = new JLabel("Peso (não ultrapassar 2 t)");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeso.setBounds(20, 324, 200, 20);
		contentPane.add(lblPeso);
		
		tfKg = new JTextField();
		tfKg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfKg.setBounds(20, 344, 71, 23);
		tfKg.setText("");
		tfKg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {							
				if (!tfKg.getText().isEmpty()){
					if (Float.parseFloat(tfKg.getText()) > 2000.0)
						lblAvisoProduto.setVisible(true);
					else
						lblAvisoProduto.setVisible(false);
				}
			}
		});
		tfKg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))
                {
                    getToolkit().beep();
                    e.consume();
                }
			}
		});
		tfKg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfKg.setBackground(Color.white);
				lblKg.setForeground(Color.black);
				lblAvisoProduto.setVisible(false);
				lblPeso.setForeground(Color.black);
			}
		});
		contentPane.add(tfKg);
		tfKg.setColumns(10);
		
		lblKg = new JLabel("Kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKg.setBounds(98, 344, 45, 20);
		contentPane.add(lblKg);
		
		tfVolume = new JTextField();
		tfVolume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfVolume.setBounds(284, 344, 71, 23);
		tfVolume.addKeyListener(new KeyAdapter() {
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
		tfVolume.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfVolume.setBackground(Color.white);
				lblVolume.setForeground(Color.black);
			}
		});
		tfVolume.setText("");
		contentPane.add(tfVolume);
		tfVolume.setColumns(10);
		
		lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVolume.setBounds(284, 324, 68, 20);
		contentPane.add(lblVolume);
		
		lblMeCubico = new JLabel("m\u00B3");
		lblMeCubico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeCubico.setBounds(365, 344, 24, 20);
		contentPane.add(lblMeCubico);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(20, 397, 123, 32);
		btnSalvar.setIcon(new ImageIcon(TelaProduto.class.getResource("/images/save.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoControle pc = new ProdutoControle();
				
				if(valido()){
					pc.InstanciaProdutoControle(tfNome.getText(), tfFabricante.getText(), tfFornecedor.getText(), taDescritivo.getText(), 
							Float.parseFloat(tfKg.getText()), Float.parseFloat(tfVolume.getText()));
					
					pc.gravar("src/BD/Produtos");
					limpar();
					limpaFormatacao();
				}
			}
		});
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(155, 397, 123, 32);
		btnLimpar.setIcon(new ImageIcon(TelaProduto.class.getResource("/images/limpar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				limpaFormatacao();
			}
		});
		contentPane.add(btnLimpar);
		
		lblAvisoProduto = new JLabel("Produto está acima de 2t");
		lblAvisoProduto.setBounds(20, 368, 200, 16);
		lblAvisoProduto.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAvisoProduto.setForeground(Color.RED);
		lblAvisoProduto.setVisible(false);
		contentPane.add(lblAvisoProduto);
		
		lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFornecedor.setBounds(10, 105, 99, 20);
		contentPane.add(lblFornecedor);
		
		tfFornecedor = new JTextField();
		tfFornecedor.setText("");
		tfFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFornecedor.setColumns(10);
		tfFornecedor.setBounds(113, 104, 378, 23);
		contentPane.add(tfFornecedor);
		
		btnBusca = new JButton("");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoControle pc = new ProdutoControle();
				String produto[] = null;				
				
				try {
					produto = pc.ler("src/BD/Produtos" ,tfNome.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if (produto[0] == null){
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
				} else {
					tfNome.setText(produto[0]);
					tfFabricante.setText(produto[1]);
					tfFornecedor.setText(produto[2]);
					taDescritivo.setText(produto[3]);
					tfKg.setText(produto[4]);
					tfVolume.setText(produto[5]);
				}
			}
		});
		btnBusca.setIcon(new ImageIcon(TelaMotorista.class.getResource("/images/busca.png")));
		btnBusca.setBounds(503, 17, 31, 23);
		contentPane.add(btnBusca);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoControle pc = new ProdutoControle();
				
				try {
					pc.deletar(tfNome.getText(), "src/BD/Produtos");
					JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Houve um erro ao deletar o produto", "Erro", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setIcon(new ImageIcon(TelaMotorista.class.getResource("/images/red-x.png")));
		btnDeletar.setBounds(284, 397, 123, 32);
		contentPane.add(btnDeletar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] novasInformacoes = new String[6];
				ProdutoControle pc = new ProdutoControle();
				
				novasInformacoes[0] = tfNome.getText();
				novasInformacoes[1] = tfFabricante.getText();
				novasInformacoes[2] = tfFornecedor.getText();
				novasInformacoes[3] = taDescritivo.getText();
				novasInformacoes[4] = tfKg.getText();
				novasInformacoes[5] = tfVolume.getText();
								
				try {
					pc.atualizar(tfNome.getText(), novasInformacoes, "src/BD/Produtos");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.setIcon(new ImageIcon(TelaMotorista.class.getResource("/images/atualizar.png")));
		btnAtualizar.setBounds(419, 397, 119, 32);
		contentPane.add(btnAtualizar);
		
		setVisible(true);
	}
	
	public boolean valido(){
		boolean valido = true;
		
		if(tfNome.getText().isEmpty()){
			
			lblNome.setForeground(Color.RED);
			tfNome.setBackground(new Color(255,250,205));
			valido = false;
		}

		if(tfFabricante.getText().isEmpty()){
			
			lblFabricante.setForeground(new Color(255,69,0));
			tfFabricante.setBackground(new Color(255,250,205));
			valido = false;
		}
		
		if(tfFornecedor.getText().isEmpty()){
			
			lblFornecedor.setForeground(new Color(255,69,0));
			tfFornecedor.setBackground(new Color(255,250,205));
			valido = false;
		}

		if(taDescritivo.getText().isEmpty()){
			
			taDescritivo.setBackground(new Color(255,250,205));
			lblDescritivo.setForeground(new Color(255,69,0));
			valido = false;
		}

		if(tfKg.getText().isEmpty()){
		
			
			lblPeso.setForeground(new Color(255,69,0));
			tfKg.setBackground(new Color(255,250,205));
			valido = false;
		} else if (Float.parseFloat(tfKg.getText()) > 2000.0){
			valido = false;
		}

		if(tfVolume.getText().isEmpty()){
			
			lblVolume.setForeground(new Color(255,69,0));
			tfVolume.setBackground(new Color(255, 250, 205));						
			valido = false;
		}
		
		return valido;
	}
	
	public void limpar(){
		tfNome.setText("");
		tfFabricante.setText("");
		tfFornecedor.setText("");
		tfKg.setText("");
		tfVolume.setText("");
		taDescritivo.setText("");
		
		limpaFormatacao();
	}
	
	public void limpaFormatacao(){
		
		tfNome.setBackground(Color.white);
		lblNome.setForeground(Color.black);
		
		tfFabricante.setBackground(Color.white);
		lblFabricante.setForeground(Color.black);
		
		tfFornecedor.setBackground(Color.white);
		lblFornecedor.setForeground(Color.black);
		
		taDescritivo.setBackground(Color.white);
		lblDescritivo.setForeground(Color.black);

		tfKg.setBackground(Color.white);
		lblKg.setForeground(Color.black);
		
		tfVolume.setBackground(Color.white);
		lblVolume.setForeground(Color.black);
		
		lblAvisoProduto.setVisible(false);
		lblPeso.setForeground(Color.black);
	}
}
