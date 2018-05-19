package menjacnica;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import menjacnica.sistemskeoperacije.SOKonvertuj;
import menjacnica.sistemskeoperacije.SOSacuvajUFajl;
import menjacnica.sistemskeoperacije.SOUcitaj;
import main.Valuta;

public class Menjacnica {
	private static LinkedList<Valuta> valute;
	
	public static void ucitaj() {
		valute=SOUcitaj.izvrsi();
	}

	public static void konvertuj() {
		SOKonvertuj.izvrsi(valute);	
	}

	public static void sacuvajUFajl(Gson gson, JsonObject obj) {
		SOSacuvajUFajl.izvrsi(gson,obj);
	}
	

}
