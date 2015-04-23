/**
 * @author Arthur Gomes
 * 
 * Tela de cadastro de motorista, veículo e carroceria*/

package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import control.CaminhaoControle;
import control.CarroceriaControle;
import control.ComboBoxItens;
import control.MotoristaControle;
import control.ValidarData;

public class TelaMotorista extends JFrame implements ComboBoxItens{
	CaminhaoControle cam = new CaminhaoControle();
	CarroceriaControle car = new CarroceriaControle();
	private JTextField textNome;
	private JFormattedTextField textCNH;
	private JFormattedTextField textValidadeInicio;
	private JFormattedTextField textTelefone;
	private JFormattedTextField textCelular;
	private JTextField textPesoCaminhao;
	private JFormattedTextField textPlaca;
	private JFormattedTextField textValidadeFim;
	private JTextField textCidade;

	private MaskFormatter tel;
	private MaskFormatter cel;
	private MaskFormatter data;
	private MaskFormatter placa;
	private MaskFormatter cnh;
	private JTextField textLargura;
	private JTextField textAltura;
	private JTextField textComprimento;
	private JTextField textPeso;
	private JTextField textVolume;
	private JLabel lblAvisoNome;
	private JLabel lblAvisoCNH;
	private JLabel lblAvisoData;
	private JLabel lblAvisoData_2;
	private JLabel lblAvisoTelefone;
	private JLabel lblAvisoPlaca;
	private JLabel lblAvisoCidade;
	private final JComboBox cbCaminhao;
	private final JComboBox cbCarroceria;
	private final JComboBox cbEstado;

	/**
	 * @wbp.nonvisual location=283,714
	 */

	public TelaMotorista() throws ParseException {
		tel = new MaskFormatter("(##)####-####");
		cel = new MaskFormatter("(##)#####-####");
		data = new MaskFormatter("##/##/####");
		placa = new MaskFormatter("UUU-####");
		cnh = new MaskFormatter("###########");

		tel.setValidCharacters("0123456789");
		cel.setValidCharacters("0123456789");
		data.setValidCharacters("0123456789");
		placa.setValidCharacters("0123456789ASDFGHJKLZXCVBNMQWERTYUIOP");

		setSize(388, 640);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cadastro de Motorista");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblContainer = new JLabel("Carroceria:");
		lblContainer.setBounds(10, 305, 152, 14);
		getContentPane().add(lblContainer);

		lblAvisoNome = new JLabel("Preencha o campo \"Nome\"");
		lblAvisoNome.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAvisoNome.setForeground(Color.RED);
		lblAvisoNome.setBounds(10, 49, 348, 16);
		lblAvisoNome.setVisible(false);
		getContentPane().add(lblAvisoNome);

		lblAvisoCNH = new JLabel("Preencha o campo \"CNH\"");
		lblAvisoCNH.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAvisoCNH.setForeground(Color.RED);
		lblAvisoCNH.setBounds(10, 118, 152, 16);
		lblAvisoCNH.setVisible(false);
		getContentPane().add(lblAvisoCNH);

		lblAvisoData = new JLabel("Preencha o campo \"data\"");
		lblAvisoData.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAvisoData.setForeground(Color.RED);
		lblAvisoData.setBounds(193, 118, 170, 16);
		lblAvisoData.setVisible(false);
		getContentPane().add(lblAvisoData);

		lblAvisoData_2 = new JLabel("Validade da CNH incoerente");
		lblAvisoData_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAvisoData_2.setForeground(Color.RED);
		lblAvisoData_2.setBounds(165, 118, 170, 16);
		lblAvisoData_2.setVisible(false);
		getContentPane().add(lblAvisoData_2);

		lblAvisoTelefone = new JLabel(
				"Preencha ambos os campos \"Telefone 1\" e \"Celular\"");
		lblAvisoTelefone.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAvisoTelefone.setForeground(Color.RED);
		lblAvisoTelefone.setBounds(10, 188, 362, 16);
		lblAvisoTelefone.setVisible(false);
		getContentPane().add(lblAvisoTelefone);

		lblAvisoPlaca = new JLabel("Preencha o campo \"N\u00FAmero da Placa\"");
		lblAvisoPlaca.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAvisoPlaca.setForeground(Color.RED);
		lblAvisoPlaca.setBounds(126, 437, 240, 16);
		lblAvisoPlaca.setVisible(false);
		getContentPane().add(lblAvisoPlaca);

		lblAvisoCidade = new JLabel("Preencha o campo \"Cidade\"");
		lblAvisoCidade.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAvisoCidade.setForeground(Color.RED);
		lblAvisoCidade.setBounds(126, 476, 256, 16);
		lblAvisoCidade.setVisible(false);
		getContentPane().add(lblAvisoCidade);

		cbCarroceria = new JComboBox(CARROCERIA);
		cbCarroceria.setBounds(84, 302, 274, 20);
		cbCarroceria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				car.setPeso(cbCarroceria.getSelectedItem().toString());
				car.setLargura(cbCarroceria.getSelectedItem().toString());
				car.setAltura(cbCarroceria.getSelectedItem().toString());
				car.setComprimento(cbCarroceria.getSelectedItem().toString());
				car.setVolume();

				if (car.getPeso() == 0)
					textPeso.setText("Sem peso");
				else
					textPeso.setText(""+car.getPeso());

				if (car.getLargura() == 0)
					textLargura.setText(" - ");
				else
					textLargura.setText(Double.toString(car.getLargura()));

				if (car.getAltura() == 0)
					textAltura.setText(" - ");
				else
					textAltura.setText(Double.toString(car.getAltura()));

				if (car.getComprimento() == 0)
					textComprimento.setText(" - ");
				else
					textComprimento.setText(Double.toString(car
							.getComprimento()));

				if (car.getVolume() == 0)
					textVolume.setText(" - ");
				else
					textVolume.setText(Double.toString(car.getVolume()));
			}
		});
		getContentPane().add(cbCarroceria);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblAvisoNome.setVisible(false);
			}
		});
		textNome.setBounds(10, 31, 348, 20);
		getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblCnh = new JLabel("CNH:");
		lblCnh.setBounds(10, 78, 46, 14);
		getContentPane().add(lblCnh);

		textCNH = new JFormattedTextField(cnh);
		textCNH.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoCNH.setVisible(false);
			}
		});
		textCNH.setBounds(10, 98, 86, 20);
		getContentPane().add(textCNH);
		textCNH.setValue("");
		textCNH.setColumns(10);

		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setBounds(165, 78, 64, 14);
		getContentPane().add(lblValidade);

		textValidadeInicio = new JFormattedTextField(data);
		textValidadeInicio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoData.setVisible(false);
				lblAvisoData_2.setVisible(false);
			}
		});
		textValidadeInicio.setBounds(163, 98, 74, 20);
		getContentPane().add(textValidadeInicio);
		textValidadeInicio.setValue("");
		textValidadeInicio.setColumns(10);

		JLabel lblAte = new JLabel("   at\u00E9");
		lblAte.setBounds(237, 101, 56, 14);
		getContentPane().add(lblAte);

		JLabel lblTelefone_1 = new JLabel("Telefone 1:");
		lblTelefone_1.setBounds(10, 147, 71, 14);
		getContentPane().add(lblTelefone_1);

		textTelefone = new JFormattedTextField(tel);
		textTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoTelefone.setVisible(false);
			}
		});
		textTelefone.setBounds(10, 165, 104, 20);
		getContentPane().add(textTelefone);
		textTelefone.setValue("");
		textTelefone.setColumns(10);

		JLabel lblTelefone_2 = new JLabel("Celular:");
		lblTelefone_2.setBounds(254, 147, 71, 14);
		getContentPane().add(lblTelefone_2);

		textCelular = new JFormattedTextField(cel);
		textCelular.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoTelefone.setVisible(false);
			}
		});
		textCelular.setColumns(10);
		textCelular.setBounds(237, 165, 104, 20);
		textCelular.setValue("");
		getContentPane().add(textCelular);

		JLabel lblTipoDeVeculo = new JLabel("Tipo de Caminh\u00E3o:");
		lblTipoDeVeculo.setBounds(10, 217, 134, 14);
		getContentPane().add(lblTipoDeVeculo);

		cbCaminhao = new JComboBox(VEICULO);
		cbCaminhao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cam.setCapacidadeCarga(cbCaminhao.getSelectedItem().toString());
				textPesoCaminhao.setText(Integer.toString(cam
						.getCapacidadeCarga()));
			}
		});
		cbCaminhao.setBounds(165, 217, 195, 20);
		getContentPane().add(cbCaminhao);

		JLabel lblCapacidadeDeCarga = new JLabel("Capacidade de carga:");
		lblCapacidadeDeCarga.setBounds(10, 260, 134, 14);
		getContentPane().add(lblCapacidadeDeCarga);

		textPesoCaminhao = new JTextField();
		textPesoCaminhao.setEditable(false);
		textPesoCaminhao.setBounds(156, 257, 64, 20);
		getContentPane().add(textPesoCaminhao);
		textPesoCaminhao.setColumns(10);
		textPesoCaminhao.setText(Integer.toString(16000));

		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(233, 260, 21, 14);
		getContentPane().add(lblKg);

		JLabel lblNumeroDaPlaca = new JLabel("Numero da placa:");
		lblNumeroDaPlaca.setBounds(10, 421, 104, 14);
		getContentPane().add(lblNumeroDaPlaca);

		textPlaca = new JFormattedTextField(placa);
		textPlaca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoPlaca.setVisible(false);
			}
		});
		textPlaca.setBounds(126, 418, 64, 20);
		getContentPane().add(textPlaca);
		textPlaca.setValue("");
		textPlaca.setColumns(10);

		JButton btnGravar = new JButton("Salvar");
		btnGravar.setIcon(new ImageIcon(TelaMotorista.class
				.getResource("/images/save.png")));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotoristaControle mc = new MotoristaControle();

				if (validar()) {
					mc.InstanciarMotoristaControle(textNome.getText(), textCNH
							.getValue().toString(), textValidadeInicio
							.getText(), textValidadeFim.getText(), textTelefone
							.getValue().toString(), textCelular.getValue()
							.toString());
					cam.InstanciarCaminhaoControle(cbCaminhao.getSelectedItem()
							.toString(), textPlaca.getText(), cbEstado.getSelectedItem().toString(), textCidade.getText());
					car.InstanciarCarroceriaControle(cbCarroceria
							.getSelectedItem().toString(),textAltura.getText(),textLargura.getText(),textComprimento.getText(),textPeso.getText(),textVolume.getText());
					try {
						mc.gravar();
						cam.gravar();
						car.gravar();
						limpar();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnGravar.setBounds(10, 560, 100, 32);
		getContentPane().add(btnGravar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaMotorista.class
				.getResource("/images/limpar.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					limpar();
			}
		});
		btnLimpar.setBounds(269, 560, 100, 32);
		getContentPane().add(btnLimpar);

		textValidadeFim = new JFormattedTextField(data);
		textValidadeFim.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoData.setVisible(false);
				lblAvisoData_2.setVisible(false);
			}
		});
		textValidadeFim.setColumns(10);
		textValidadeFim.setBounds(282, 98, 76, 20);
		textValidadeFim.setValue("");
		getContentPane().add(textValidadeFim);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 458, 46, 14);
		getContentPane().add(lblCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 502, 46, 14);
		getContentPane().add(lblEstado);

		textCidade = new JTextField();
		textCidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblAvisoCidade.setVisible(false);
			}
		});
		textCidade.setBounds(126, 455, 128, 20);
		getContentPane().add(textCidade);
		textCidade.setColumns(10);

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

		textLargura = new JTextField();
		textLargura.setEditable(false);
		textLargura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textLargura.setBounds(94, 335, 58, 20);
		textLargura.setText(Double.toString(2.46));
		getContentPane().add(textLargura);
		textLargura.setColumns(10);

		textAltura = new JTextField();
		textAltura.setEditable(false);
		textAltura.setColumns(10);
		textAltura.setBounds(94, 360, 58, 20);
		textAltura.setText(Double.toString(3));
		getContentPane().add(textAltura);

		textComprimento = new JTextField();
		textComprimento.setEditable(false);
		textComprimento.setColumns(10);
		textComprimento.setBounds(94, 388, 58, 20);
		textComprimento.setText(Double.toString(7.65));
		getContentPane().add(textComprimento);

		JLabel lblMm = new JLabel("m");
		lblMm.setBounds(162, 341, 46, 14);
		getContentPane().add(lblMm);

		JLabel lblM = new JLabel("m");
		lblM.setBounds(162, 363, 46, 14);
		getContentPane().add(lblM);

		JLabel lblKg_1 = new JLabel("kg");
		lblKg_1.setBounds(347, 338, 46, 14);
		getContentPane().add(lblKg_1);

		textPeso = new JTextField();
		textPeso.setEditable(false);
		textPeso.setBounds(252, 335, 85, 20);
		getContentPane().add(textPeso);
		textPeso.setText("Sem peso");
		textPeso.setColumns(10);

		JLabel label = new JLabel("m");
		label.setBounds(162, 391, 46, 14);
		getContentPane().add(label);

		textVolume = new JTextField();
		textVolume.setEditable(false);
		textVolume.setColumns(10);
		textVolume.setBounds(252, 363, 85, 20);
		textVolume.setText(Double.toString(56.457));
		getContentPane().add(textVolume);

		JLabel lblM_1 = new JLabel("m\u00B3");
		lblM_1.setBounds(347, 363, 46, 14);
		getContentPane().add(lblM_1);
		
		cbEstado = new JComboBox(ESTADOS);
		cbEstado.setBounds(126, 498, 209, 22);
		getContentPane().add(cbEstado);

		setVisible(true);
	}

	public boolean validar() {
		boolean confirm = true;
		ValidarData vd = new ValidarData();

		if (textNome.getText().isEmpty()) {
			lblAvisoNome.setVisible(true);
			confirm = false;
		}

		if (textCNH.getValue().toString().isEmpty()) {
			lblAvisoCNH.setVisible(true);
			confirm = false;
		}

		if (textValidadeInicio.getValue().toString().isEmpty()
				|| textValidadeFim.getValue().toString().isEmpty()) {
			lblAvisoData.setVisible(true);
			confirm = false;
		} else if (vd.isDataInsertedValid(textValidadeInicio.getValue()
				.toString(), textValidadeFim.getValue().toString())) {
			lblAvisoData.setVisible(false);
			lblAvisoData_2.setVisible(true);
			confirm = false;
		}

		if (textTelefone.getValue().toString().isEmpty()
				|| textCelular.getValue().toString().isEmpty()) {
			lblAvisoTelefone.setVisible(true);
			confirm = false;
		}

		if (textPlaca.getValue().toString().isEmpty()) {
			lblAvisoPlaca.setVisible(true);
			confirm = false;
		}

		if (textCidade.getText().isEmpty()) {
			lblAvisoCidade.setVisible(true);
			confirm = false;
		}

		return confirm;
	}
	
	public void limpar(){
		textNome.setText("");
		textCNH.setValue("");
		textValidadeInicio.setValue("");
		textValidadeFim.setValue("");
		textTelefone.setValue("");
		textCelular.setValue("");
		textPesoCaminhao.setText(Integer.toString(16000));
		cbCaminhao.setSelectedIndex(0);
		cbCarroceria.setSelectedIndex(0);
		textPlaca.setText("");
		cbEstado.setSelectedIndex(0);
		textCidade.setText("");
		textLargura.setText(Double.toString(2.46));
		textAltura.setText(Double.toString(3));
		textComprimento.setText(Double.toString(7.65));
		textPeso.setText("Sem peso");
		textVolume.setText(Double.toString(56.457));
	}
}
