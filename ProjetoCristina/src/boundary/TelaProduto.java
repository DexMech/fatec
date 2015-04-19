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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import control.ProdutoControle;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	
	private JTextArea taDescritivo;
	private JScrollPane scrollPane;
	
	private JLabel lblAvisoProduto;

	public TelaProduto() {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(482, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 13, 45, 20);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(46, 13, 410, 20);
		tfNome.setText("");
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(10, 54, 68, 20);
		contentPane.add(lblFabricante);
		
		tfFabricante = new JTextField();
		tfFabricante.setBounds(88, 54, 368, 20);
		tfFabricante.setText("");
		contentPane.add(tfFabricante);
		tfFabricante.setColumns(10);
		
		lblDescritivo = new JLabel("Descritivo");
		lblDescritivo.setBounds(10, 106, 61, 20);
		contentPane.add(lblDescritivo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 446, 129);
		contentPane.add(scrollPane);
		
		taDescritivo = new JTextArea();
		scrollPane.setViewportView(taDescritivo);
		taDescritivo.setText("");
		taDescritivo.setLineWrap(true);
		
		lblPeso = new JLabel("Peso (n\u00E3o pode ultrapassar 2 t)");
		lblPeso.setBounds(10, 265, 200, 20);
		contentPane.add(lblPeso);
		
		tfKg = new JTextField();
		tfKg.setText("");
		tfKg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (Float.parseFloat(tfKg.getText()) > 2000.0)
					lblAvisoProduto.setVisible(true);
				else
					lblAvisoProduto.setVisible(false);
			}
		});
		tfKg.setBounds(10, 292, 71, 20);
		contentPane.add(tfKg);
		tfKg.setColumns(10);
		
		lblKg = new JLabel("Kg");
		lblKg.setBounds(88, 292, 45, 20);
		contentPane.add(lblKg);
		
		tfVolume = new JTextField();
		tfVolume.setText("");
		tfVolume.setBounds(283, 292, 71, 20);
		contentPane.add(tfVolume);
		tfVolume.setColumns(10);
		
		lblVolume = new JLabel("Volume");
		lblVolume.setBounds(264, 184, 46, 20);
		contentPane.add(lblVolume);
		
		lblMeCubico = new JLabel("m\u00B3");
		lblMeCubico.setBounds(366, 292, 24, 20);
		contentPane.add(lblMeCubico);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 343, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoControle pc = new ProdutoControle();
				
				if(valido() == true){
					pc.InstanciaProdutoControle(tfNome.getText(), tfFabricante.getText(), taDescritivo.getText(), 
							Float.parseFloat(tfKg.getText()), Float.parseFloat(tfVolume.getText()));
					
					try{
						pc.gravar();
					}catch(IOException s2){
						s2.printStackTrace();
					}
					
				}
			}
		});
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(367, 343, 89, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnLimpar);
		
		lblAvisoProduto = new JLabel("Produto está acima de 2t");
		lblAvisoProduto.setForeground(Color.RED);
		lblAvisoProduto.setBounds(10, 314, 200, 16);
		lblAvisoProduto.setVisible(false);
		contentPane.add(lblAvisoProduto);
		
		setVisible(true);
	}
	
	public boolean valido(){
		boolean valido = false;
		
		if(tfNome.getText().isEmpty()){
			
			lblNome.setForeground(Color.RED);
			tfNome.setBackground(Color.yellow);
			
		}else if(tfFabricante.getText().isEmpty()){
			
			lblFabricante.setForeground(new Color(255,69,0));
			tfFabricante.setBackground(Color.yellow);
			
		}else if(taDescritivo.getText().isEmpty()){
			
			taDescritivo.setBackground(Color.yellow);
			lblDescritivo.setForeground(new Color(255,69,0));
			
		}else if(tfKg.getText().isEmpty()){
		
			
			lblNome.setForeground(new Color(255,69,0));
			tfNome.setBackground(Color.yellow);
			
		}else if(tfVolume.getText().isEmpty()){
			
			lblVolume.setForeground(new Color(255,69,0));
			tfVolume.setBackground(Color.yellow);						
			
		}else{
			valido = true;
		}
		
		return valido;
	}
}
