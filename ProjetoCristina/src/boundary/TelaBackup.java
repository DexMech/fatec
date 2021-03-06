package boundary;
/**
 * @author Alex carlos
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import control.ControleBackup;

import java.awt.Color;
import java.awt.Font;

public class TelaBackup extends JFrame {
	private  ControleBackup backup;  
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
	 * Método Construtor da classe
	 */
	public TelaBackup() {
		setVisible(true);
		setTitle("Tela de Backups e Restauração");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalvarBackup = new JButton("Salvar Backup");
		btnSalvarBackup.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnSalvarBackup.setIcon(new ImageIcon(TelaBackup.class.getResource("/images/save.png")));
		btnSalvarBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backup = new ControleBackup(getTextAreaBackup(),getLabelBackup());
				backup.salvar();
			}
		});
		btnSalvarBackup.setBounds(417, 20, 157, 36);
		contentPane.add(btnSalvarBackup);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 75, 539, 380);
		contentPane.add(scrollPane);

		textAreaBackup = new JTextArea();
		scrollPane.setColumnHeaderView(textAreaBackup);

		labelBackup = new JLabel("");
		labelBackup.setIcon(new ImageIcon(""));
		labelBackup.setFont(new Font("Arial", Font.BOLD, 11));
		labelBackup.setForeground(Color.BLACK);
		labelBackup.setBounds(45, 451, 281, 27);
		contentPane.add(labelBackup);
		btnRecuperar = new JButton("Escolher Arquivos");
		btnRecuperar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backup = new ControleBackup(getTextAreaBackup(),getLabelBackup());
				backup.escolher();
			}
		});
		btnRecuperar.setBounds(35, 20, 157, 36);
		contentPane.add(btnRecuperar);

		JButton btnRecuperar_1 = new JButton("Recuperar");
		btnRecuperar_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnRecuperar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backup = new ControleBackup(getTextAreaBackup(),getLabelBackup());
				backup.recuperar();	
			}
		});
		btnRecuperar_1.setBounds(224, 20, 157, 36);
		contentPane.add(btnRecuperar_1);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaBackup.class.getResource("/images/limpar.png")));
		btnLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backup = new ControleBackup(getTextAreaBackup(),getLabelBackup());
				backup.limpar();
			}
		});
		btnLimpar.setBounds(454, 470, 117, 36);
		contentPane.add(btnLimpar);
	}
}