package gui.kontroler;

import java.awt.EventQueue;

import gui.MenjacnicaGUI;
import menjacnica.Menjacnica;


public class GUIKontroler {
	public static Menjacnica sistem;
	public static MenjacnicaGUI gp;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gp = new MenjacnicaGUI();
					gp.getFrmMenjacnica().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void ucitaj() {
		sistem.ucitaj();
	}
	public static void konvertuj() {
		sistem.konvertuj();
	}
	
	

}
