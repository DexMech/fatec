/**
 * @author Arthur Gomes
 * 
 * Tela responsável por cadastrar motorista e seu respectivo caminhão*/

package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import control.CaminhaoControle;
import control.CarroceriaControle;
import control.MotoristaControle;
import control.ValidarData;

public class TelaMotorista extends JFrame{
	CaminhaoControle cam = new CaminhaoControle();
	CarroceriaControle car = new CarroceriaControle();
	private JTextField textField;
	private JFormattedTextField textField_1;
	private JFormattedTextField textField_2;
	private JFormattedTextField textField_4;
	private JFormattedTextField textField_5;
	private final String veiculo [] = {"Toco", "Truck", "Carreta 2 Eixos", "Carreta Baú", "Carreta 3 Eixos", "Carreta Cavalo Truckado", "Carreta Cavalo Truckado Baú",
										"Bi-trem(Treminhão) - 7 eixos"};
	private final String carroceria[] = {"Carroceria tipo sider tamanho padrão", "Carroceria tipo sider semi reboque ", 
										"Carroceria tipo baú(4.000 kg)", "Carroceria tipo baú(6.000 kg)", 
										"Carroceria tipo baú semi reboque", "Dry Van(20)", "Bulk(20)", "Ventilated", 
										"Open Top(20)", "Reefer(20)", "Platform(20)", "Dry Van(40)", "Bulk(40)", 
										"Dry High Cube", "Open Top(40)", "Reefer(40)", "Port Hole", "Platform(40)", "Flat Track"};
	private JTextField textField_6;
	private JFormattedTextField textField_7;
	private JFormattedTextField textField_3;
	private JTextField textField_9;
	private JTextField textField_8;
	
	private MaskFormatter tel;
	private MaskFormatter cel;
	private MaskFormatter data;
	private MaskFormatter placa;
	private MaskFormatter cnh;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	/**
	 * @wbp.nonvisual location=283,714
	 */
	
	public TelaMotorista() throws ParseException{
		tel = new MaskFormatter("(##)####-####");
		cel = new MaskFormatter("(##)#####-####");
		data = new MaskFormatter("##/##/####");
		placa = new MaskFormatter("UUU-####");
		cnh = new MaskFormatter("###########");
		
		tel.setValidCharacters("0123456789");
		cel.setValidCharacters("0123456789");
		data.setValidCharacters("0123456789");
		placa.setValidCharacters("0123456789ASDFGHJKLZXCVBNMQWERTYUIOP");
		
		setSize(384,640);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cadastro de Motorista");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		final JLabel lblContainer = new JLabel("Carroceria:");
		lblContainer.setBounds(10, 305, 152, 14);
		getContentPane().add(lblContainer);
		
		final JLabel lblNewLabel = new JLabel("Preencha o campo \"Nome\"");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 49, 348, 16);
		lblNewLabel.setVisible(false);
		getContentPane().add(lblNewLabel);
		
		final JLabel lblPreenchaOCampo = new JLabel("Preencha o campo \"CNH\"");
		lblPreenchaOCampo.setForeground(Color.RED);
		lblPreenchaOCampo.setBounds(10, 118, 152, 16);
		lblPreenchaOCampo.setVisible(false);
		getContentPane().add(lblPreenchaOCampo);
		
		final JLabel lblNewLabel_1 = new JLabel("Preencha o campo \"data\"");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(188, 118, 170, 16);
		lblNewLabel_1.setVisible(false);
		getContentPane().add(lblNewLabel_1);
		
		final JLabel lblNewLabel_3 = new JLabel("Validade da CNH incoerente");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(188, 118, 170, 16);
		lblNewLabel_3.setVisible(false);
		getContentPane().add(lblNewLabel_3);
		
		final JLabel lblPreenchaOCampo_1 = new JLabel("Preencha ambos os campos \"Telefone 1\" e \"Celular\"");
		lblPreenchaOCampo_1.setForeground(Color.RED);
		lblPreenchaOCampo_1.setBounds(10, 188, 362, 16);
		lblPreenchaOCampo_1.setVisible(false);
		getContentPane().add(lblPreenchaOCampo_1);
		
		final JLabel lblNewLabel_2 = new JLabel("Preencha o campo \"N\u00FAmero da Placa\"");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(126, 437, 240, 16);
		lblNewLabel_2.setVisible(false);
		getContentPane().add(lblNewLabel_2);
		
		final JLabel label_1 = new JLabel("Preencha o campo \"Cidade\"");
		label_1.setForeground(Color.RED);
		label_1.setBounds(126, 476, 256, 16);
		label_1.setVisible(false);
		getContentPane().add(label_1);
		
		final JLabel label_2 = new JLabel("Preencha o campo \"Estado\"");
		label_2.setForeground(Color.RED);
		label_2.setBounds(126, 522, 256, 16);
		label_2.setVisible(false);
		getContentPane().add(label_2);
		
		final JComboBox comboBox_1 = new JComboBox(carroceria);
		comboBox_1.setBounds(84, 302, 274, 20);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				car.setPeso(comboBox_1.getSelectedItem().toString());
				car.setLargura(comboBox_1.getSelectedItem().toString());
				car.setAltura(comboBox_1.getSelectedItem().toString());
				car.setComprimento(comboBox_1.getSelectedItem().toString());
				car.setVolume();
				
				if (car.getPeso() == 0)
					textField_13.setText("Sem peso");
				else
					textField_13.setText(Integer.toString(car.getPeso()));
				
				if (car.getLargura() == 0)
					textField_10.setText(" - ");
				else 
					textField_10.setText(Double.toString(car.getLargura()));
					
				if(car.getAltura() == 0)
					textField_11.setText(" - ");
				else
					textField_11.setText(Double.toString(car.getAltura()));
				
				if(car.getComprimento() == 0)
					textField_12.setText(" - ");
				else
					textField_12.setText(Double.toString(car.getComprimento()));
				
				if(car.getVolume() == 0)
					textField_14.setText(" - ");
				else
					textField_14.setText(Double.toString(car.getVolume()));
			}
		});
		getContentPane().add(comboBox_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 348, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCnh = new JLabel("CNH:");
		lblCnh.setBounds(10, 78, 46, 14);
		getContentPane().add(lblCnh);
		
		textField_1 = new JFormattedTextField(cnh);
		textField_1.setBounds(10, 98, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setValue("");
		textField_1.setColumns(10);
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setBounds(165, 78, 64, 14);
		getContentPane().add(lblValidade);
		
		textField_2 = new JFormattedTextField(data);
		textField_2.setBounds(163, 98, 74, 20);
		getContentPane().add(textField_2);
		textField_2.setValue("");
		textField_2.setColumns(10);
		
		JLabel lblAte = new JLabel("   at\u00E9");
		lblAte.setBounds(237, 101, 56, 14);
		getContentPane().add(lblAte);
		
		JLabel lblTelefone_1 = new JLabel("Telefone 1:");
		lblTelefone_1.setBounds(10, 147, 71, 14);
		getContentPane().add(lblTelefone_1);
		
		textField_4 = new JFormattedTextField(tel);
		textField_4.setBounds(10, 165, 104, 20);
		getContentPane().add(textField_4);
		textField_4.setValue("");
		textField_4.setColumns(10);
		
		JLabel lblTelefone_2 = new JLabel("Celular:");
		lblTelefone_2.setBounds(254, 147, 71, 14);
		getContentPane().add(lblTelefone_2);
		
		textField_5 = new JFormattedTextField(cel);
		textField_5.setColumns(10);
		textField_5.setBounds(237, 165, 104, 20);
		textField_5.setValue("");
		getContentPane().add(textField_5);
		
		JLabel lblTipoDeVeculo = new JLabel("Tipo de Caminh\u00E3o:");
		lblTipoDeVeculo.setBounds(10, 217, 134, 14);
		getContentPane().add(lblTipoDeVeculo);
		
		final JComboBox comboBox = new JComboBox(veiculo);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cam.setCapacidadeCarga(comboBox.getSelectedItem().toString());
				textField_6.setText(Integer.toString(cam.getCapacidadeCarga()));
			}
		});
		comboBox.setBounds(163, 214, 195, 20);
		getContentPane().add(comboBox);
		
		JLabel lblCapacidadeDeCarga = new JLabel("Capacidade de carga:");
		lblCapacidadeDeCarga.setBounds(10, 260, 134, 14);
		getContentPane().add(lblCapacidadeDeCarga);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(156, 257, 64, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		textField_6.setText(Integer.toString(16000));
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(233, 260, 21, 14);
		getContentPane().add(lblKg);
		
		JLabel lblNumeroDaPlaca = new JLabel("Numero da placa:");
		lblNumeroDaPlaca.setBounds(10, 421, 104, 14);
		getContentPane().add(lblNumeroDaPlaca);
		
		textField_7 = new JFormattedTextField(placa);
		textField_7.setBounds(126, 418, 64, 20);
		getContentPane().add(textField_7);
		textField_7.setValue("");
		textField_7.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotoristaControle mc = new MotoristaControle();
				ValidarData vd = new ValidarData();
				if(textField.getText().isEmpty())
					lblNewLabel.setVisible(true);
				else
					lblNewLabel.setVisible(false);
				if (textField_1.getValue().toString().isEmpty())
					lblPreenchaOCampo.setVisible(true);
				else
					lblPreenchaOCampo.setVisible(false);
				
				if (textField_2.getValue().toString().isEmpty() || textField_3.getValue().toString().isEmpty())
					lblNewLabel_1.setVisible(true);				
				else  if (vd.isDataInsertedValid(textField_2.getValue().toString(), textField_3.getValue().toString())){
					lblNewLabel_1.setVisible(false);
					lblNewLabel_3.setVisible(true);
				} else
					lblNewLabel_3.setVisible(false);
				
				if (textField_4.getValue().toString().isEmpty() || textField_5.getValue().toString().isEmpty())
					lblPreenchaOCampo_1.setVisible(true);
				else
					lblPreenchaOCampo_1.setVisible(false);
				if (textField_7.getValue().toString().isEmpty())
					lblNewLabel_2.setVisible(true);
				else
					lblNewLabel_2.setVisible(false);
				if (textField_8.getText().isEmpty())
					label_2.setVisible(true);
				else
					label_2.setVisible(false);
				if (textField_9.getText().isEmpty())
					label_1.setVisible(true);
				else
					label_1.setVisible(false);
				if (!textField.getText().isEmpty() && !textField_1.getValue().toString().isEmpty() && !textField_2.getText().isEmpty() &&
						!textField_3.getText().isEmpty() && !textField_4.getValue().toString().isEmpty() && 
						!textField_5.getValue().toString().isEmpty() && !textField_7.getText().isEmpty() && !textField_8.getText().isEmpty() &&
						!textField_9.getText().isEmpty() && !vd.isDataInsertedValid(textField_2.getValue().toString(), textField_3.getValue().toString())){
					mc.InstanciarMotoristaControle(textField.getText(), textField_1.getValue().toString(), textField_2.getText(), textField_3.getText(), 
							textField_4.getValue().toString(), textField_5.getValue().toString());
					cam.InstanciarCaminhaoControle(comboBox.getSelectedItem().toString(), textField_7.getText(), 
							textField_8.getText(), textField_9.getText());
					car.InstanciarCarroceriaControle(comboBox_1.getSelectedItem().toString());
					try {
						mc.gravar();
						cam.gravar();
						car.gravar();
					} catch (IOException e1) {
						// 	TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					lblNewLabel.setVisible(false);
					lblPreenchaOCampo.setVisible(false);
					lblNewLabel_1.setVisible(false);
					lblPreenchaOCampo_1.setVisible(false);
					lblNewLabel_2.setVisible(false);
					label_2.setVisible(false);
					label_1.setVisible(false);
				}
			}
		});
		btnGravar.setBounds(282, 569, 89, 23);
		getContentPane().add(btnGravar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setValue("");
				textField_2.setValue("");
				textField_3.setValue("");
				textField_4.setValue("");
				textField_5.setValue("");
				textField_6.setText(Integer.toString(16000));
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText(Double.toString(2.46));
				textField_11.setText(Double.toString(3));
				textField_12.setText(Double.toString(7.65));
				textField_13.setText("Sem peso");
				textField_14.setText(Double.toString(56.457));
			}
		});
		btnLimpar.setBounds(25, 569, 89, 23);
		getContentPane().add(btnLimpar);
		
		textField_3 = new JFormattedTextField(data);
		textField_3.setColumns(10);
		textField_3.setBounds(282, 98, 76, 20);
		textField_3.setValue("");
		getContentPane().add(textField_3);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 458, 46, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 502, 46, 14);
		getContentPane().add(lblEstado);
		
		textField_9 = new JTextField();
		textField_9.setBounds(126, 455, 128, 20);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(126, 499, 128, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblLargura = new JLabel("Largura:");
		lblLargura.setBounds(10, 338, 71, 14);
		getContentPane().add(lblLargura);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 363, 46, 14);
		getContentPane().add(lblAltura);
		
		JLabel lblComprimento = new JLabel("Comprimento:");
		lblComprimento.setBounds(10, 391, 87, 14);
		getContentPane().add(lblComprimento);
		
		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setBounds(193, 363, 74, 14);
		getContentPane().add(lblVolume);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(193, 341, 46, 14);
		getContentPane().add(lblPeso);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_10.setBounds(94, 335, 58, 20);
		textField_10.setText(Double.toString(2.46));
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(94, 360, 58, 20);
		textField_11.setText(Double.toString(3));
		getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(94, 388, 58, 20);
		textField_12.setText(Double.toString(7.65));
		getContentPane().add(textField_12);
		
		JLabel lblMm = new JLabel("m");
		lblMm.setBounds(162, 341, 46, 14);
		getContentPane().add(lblMm);
		
		JLabel lblM = new JLabel("m");
		lblM.setBounds(162, 363, 46, 14);
		getContentPane().add(lblM);
		
		JLabel lblKg_1 = new JLabel("kg");
		lblKg_1.setBounds(347, 338, 46, 14);
		getContentPane().add(lblKg_1);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setBounds(252, 335, 85, 20);
		getContentPane().add(textField_13);
		textField_13.setText("Sem peso");
		textField_13.setColumns(10);
		
		JLabel label = new JLabel("m");
		label.setBounds(162, 391, 46, 14);
		getContentPane().add(label);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(252, 363, 85, 20);
		textField_14.setText(Double.toString(56.457));
		getContentPane().add(textField_14);
		
		JLabel lblM_1 = new JLabel("m\u00B3");
		lblM_1.setBounds(347, 363, 46, 14);
		getContentPane().add(lblM_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaInicial();
			}
		});
		btnNewButton.setBounds(156, 568, 98, 25);
		getContentPane().add(btnNewButton);
		
		setVisible(true);
	}
	
	public boolean isFull(String text){
		return cam.getCapacidadeCarga() > Integer.parseInt(textField_6.getText());
	}
}
