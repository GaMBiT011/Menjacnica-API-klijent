package menjacnica.sistemskeoperacije;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gui.kontroler.GUIKontroler;
import main.Valuta;

public class SOUcitaj {
	public static LinkedList<Valuta> izvrsi() {
		LinkedList<Valuta> valute = new LinkedList<Valuta>();
		try {
			
			String content = util.URLConnectionUtil.getContent("http://free.currencyconverterapi.com/api/v3/countries");
			Gson gson = new GsonBuilder().create();
			JsonObject contentJson = gson.fromJson(content, JsonObject.class);
			JsonObject resultsJson = contentJson.get("results").getAsJsonObject();

			for (Map.Entry<String, JsonElement> entry : resultsJson.entrySet()) {
				Valuta v = gson.fromJson(entry.getValue().getAsJsonObject(), Valuta.class);
				valute.add(v);

				GUIKontroler.gp.getComboBox().addItem(v.getName());
				GUIKontroler.gp.getComboBox_1().addItem(v.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valute;
	}
}
