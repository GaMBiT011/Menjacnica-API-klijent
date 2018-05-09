package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import main.Valuta;
import util.URLConnectionUtil;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menjacnica extends JFrame {

	private JFrame frmMenjacnica;
	private JPanel panel;
	private JLabel lblIzValuteZemlje;
	private JLabel lblUValutuZemlje;
	private JLabel lblIznos;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private LinkedList<Valuta> valute;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JButton btnKonvertuj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menjacnica window = new Menjacnica();
					window.frmMenjacnica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menjacnica() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenjacnica = new JFrame();
		frmMenjacnica.setTitle("Menjacnica");
		frmMenjacnica.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
				String content =	util.URLConnectionUtil.getContent("http://free.currencyconverterapi.com/api/v3/countries");
				Gson gson = new GsonBuilder().create();
				JsonObject contentJson = gson.fromJson(content, JsonObject.class);
				JsonObject resultsJson = contentJson.get("results").getAsJsonObject();
				
				valute=new LinkedList<Valuta>();
				
				 for (Map.Entry<String,JsonElement> entry : resultsJson.entrySet()) {
					 Valuta v=gson.fromJson(entry.getValue().getAsJsonObject(), Valuta.class);
				     valute.add(v);
				 
				 comboBox.addItem(v.getName());
				 comboBox_1.addItem(v.getName());    
				 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frmMenjacnica.setBounds(100, 100, 450, 300);
		frmMenjacnica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenjacnica.getContentPane().add(getPanel(), BorderLayout.CENTER);
		frmMenjacnica.setLocationRelativeTo(null);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblIzValuteZemlje());
			panel.add(getLblUValutuZemlje());
			panel.add(getLblIznos());
			panel.add(getLabel());
			panel.add(getTextField());
			panel.add(getTextField_1());
			panel.add(getComboBox_1());
			panel.add(getComboBox());
			panel.add(getBtnKonvertuj());
		}
		return panel;
	}
	private JLabel getLblIzValuteZemlje() {
		if (lblIzValuteZemlje == null) {
			lblIzValuteZemlje = new JLabel("Iz valute zemlje:");
			lblIzValuteZemlje.setBounds(55, 44, 100, 25);
		}
		return lblIzValuteZemlje;
	}
	private JLabel getLblUValutuZemlje() {
		if (lblUValutuZemlje == null) {
			lblUValutuZemlje = new JLabel("U valutu zemlje:");
			lblUValutuZemlje.setBounds(286, 44, 100, 25);
		}
		return lblUValutuZemlje;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setHorizontalAlignment(SwingConstants.LEFT);
			lblIznos.setBounds(55, 109, 90, 25);
		}
		return lblIznos;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Iznos:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(286, 114, 90, 25);
		}
		return label;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(55, 145, 100, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(286, 145, 100, 20);
		}
		return textField_1;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(286, 83, 100, 20);
		}
		return comboBox_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(55, 83, 100, 20);
		}
		return comboBox;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnKonvertuj.setBounds(180, 200, 89, 23);
		}
		return btnKonvertuj;
	}
}
