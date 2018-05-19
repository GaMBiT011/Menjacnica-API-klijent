package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import gui.kontroler.GUIKontroler;
import main.Valuta;

public class MenjacnicaGUI extends JFrame {

	private JFrame frmMenjacnica;
	private JPanel panel;
	private JLabel lblIzValuteZemlje;
	private JLabel lblUValutuZemlje;
	private JLabel lblIznos;
	private JLabel label;
	private JTextField txtIznosIz;
	private JTextField txtIznosU;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JButton btnKonvertuj;

	public MenjacnicaGUI() {
		initialize();

	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setLblIzValuteZemlje(JLabel lblIzValuteZemlje) {
		this.lblIzValuteZemlje = lblIzValuteZemlje;
	}

	public void setLblUValutuZemlje(JLabel lblUValutuZemlje) {
		this.lblUValutuZemlje = lblUValutuZemlje;
	}

	public void setLblIznos(JLabel lblIznos) {
		this.lblIznos = lblIznos;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public void setTxtIznosIz(JTextField txtIznosIz) {
		this.txtIznosIz = txtIznosIz;
	}

	public void setTxtIznosU(JTextField txtIznosU) {
		this.txtIznosU = txtIznosU;
	}

	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public void setBtnKonvertuj(JButton btnKonvertuj) {
		this.btnKonvertuj = btnKonvertuj;
	}

	public JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setHorizontalAlignment(SwingConstants.LEFT);
			lblIznos.setBounds(55, 109, 90, 25);
		}
		return lblIznos;
	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Iznos:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setBounds(286, 114, 90, 25);
		}
		return label;
	}

	public JTextField getTxtIznosIz() {
		if (txtIznosIz == null) {
			txtIznosIz = new JTextField();
			txtIznosIz.setBounds(55, 145, 100, 20);
			txtIznosIz.setColumns(10);
		}
		return txtIznosIz;
	}

	public JTextField getTxtIznosU() {
		if (txtIznosU == null) {
			txtIznosU = new JTextField();
			txtIznosU.setColumns(10);
			txtIznosU.setBounds(286, 145, 100, 20);
		}
		return txtIznosU;
	}

	public JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(286, 83, 100, 20);
		}
		return comboBox_1;
	}

	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(55, 83, 100, 20);
		}
		return comboBox;
	}

	public JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.konvertuj();
				}
			});
			btnKonvertuj.setBounds(180, 200, 89, 23);
		}
		return btnKonvertuj;
	}

	public JFrame getFrmMenjacnica() {
		return frmMenjacnica;
	}

	public void setFrmMenjacnica(JFrame frmMenjacnica) {
		this.frmMenjacnica = frmMenjacnica;
	}

	public JLabel getLblIzValuteZemlje() {
		if (lblIzValuteZemlje == null) {
			lblIzValuteZemlje = new JLabel("Iz valute zemlje:");
			lblIzValuteZemlje.setBounds(55, 44, 100, 25);
		}
		return lblIzValuteZemlje;
	}

	public JLabel getLblUValutuZemlje() {
		if (lblUValutuZemlje == null) {
			lblUValutuZemlje = new JLabel("U valutu zemlje:");
			lblUValutuZemlje.setBounds(286, 44, 100, 25);
		}
		return lblUValutuZemlje;
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblIzValuteZemlje());
			panel.add(getLblUValutuZemlje());
			panel.add(getLblIznos());
			panel.add(getLabel());
			panel.add(getTxtIznosIz());
			panel.add(getTxtIznosU());
			panel.add(getComboBox_1());
			panel.add(getComboBox());
			panel.add(getBtnKonvertuj());
		}
		return panel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmMenjacnica(new JFrame());
		getFrmMenjacnica().setTitle("Menjacnica");
		getFrmMenjacnica().addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				GUIKontroler.ucitaj();
			}
		});
		getFrmMenjacnica().setBounds(100, 100, 450, 300);
		getFrmMenjacnica().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmMenjacnica().getContentPane().add(getPanel(), BorderLayout.CENTER);
		getFrmMenjacnica().setLocationRelativeTo(null);
	}

}
