package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import control.ControlaBackup;
import java.awt.Color;
import java.awt.Font;

public class TelaBackup extends JFrame {
 private  ControlaBackup backup;  
	private JPanel contentPane;
	private JTextArea textAreaBackup;
	private JLabel labelBackup;
	private JButton btnRecuperar;
	private JButton btnLimpar;

	public JLabel getLabelBackup() {
		return labelBackup;
	}

	public JTextArea getTextAreaBackup() {
		return textAreaBackup;
	}

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaBackup() {
		setTitle("Tela de Backups e Restauração");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalvarBackup = new JButton("Salvar Backup");
		btnSalvarBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 backup = new ControlaBackup(getTextAreaBackup(),getLabelBackup());
			backup.salvar();
			}
		});
		btnSalvarBackup.setBounds(417, 12, 157, 25);
		contentPane.add(btnSalvarBackup);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 67, 539, 380);
		contentPane.add(scrollPane);
		
		textAreaBackup = new JTextArea();
		scrollPane.setColumnHeaderView(textAreaBackup);
		
		 labelBackup = new JLabel("");
		 labelBackup.setFont(new Font("Arial", Font.BOLD, 9));
		 labelBackup.setForeground(Color.RED);
		labelBackup.setBounds(45, 428, 200, 50);
		contentPane.add(labelBackup);
		
		btnRecuperar = new JButton("Escolher Arquivos");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backup = new ControlaBackup(getTextAreaBackup(),getLabelBackup());
				backup.escolher();
			}
		});
		btnRecuperar.setBounds(35, 12, 157, 25);
		contentPane.add(btnRecuperar);
		
		JButton btnRecuperar_1 = new JButton("Recuperar");
		btnRecuperar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backup = new ControlaBackup(getTextAreaBackup(),getLabelBackup());
				backup.recuperar();	
			}
		});
		btnRecuperar_1.setBounds(224, 11, 157, 27);
		contentPane.add(btnRecuperar_1);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backup = new ControlaBackup(getTextAreaBackup(),getLabelBackup());
				backup.limpar();
			}
		});
		btnLimpar.setBounds(480, 472, 100, 27);
		contentPane.add(btnLimpar);
	}
}
