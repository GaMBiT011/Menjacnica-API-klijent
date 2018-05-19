package menjacnica.sistemskeoperacije;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gui.kontroler.GUIKontroler;
import menjacnica.Menjacnica;
import main.Valuta;
public class SOKonvertuj {
	public static void izvrsi(LinkedList<Valuta> valute) {
		int index1 = GUIKontroler.gp.getComboBox().getSelectedIndex();
		String skraceni1 = valute.get(index1).getCurrencyId();
		int index2 = GUIKontroler.gp.getComboBox_1().getSelectedIndex();
		String skraceni2 = valute.get(index2).getCurrencyId();
		String url = "http://free.currencyconverterapi.com/api/v3/convert?q=" + skraceni1 + "_" + skraceni2;
		String content;
		try {
			content = util.URLConnectionUtil.getContent(url);
			Gson gson = new GsonBuilder().create();
			JsonObject contentJson = gson.fromJson(content, JsonObject.class);
			JsonObject resultsJson = contentJson.get("results").getAsJsonObject();
			JsonObject queryJson = contentJson.get("query").getAsJsonObject();
			int count = queryJson.get("count").getAsInt();
			if (count != 0) {
				JsonObject konverzijaJson = resultsJson.get(skraceni1 + "_" + skraceni2).getAsJsonObject();
				double kurs = konverzijaJson.get("val").getAsDouble();

				if (GUIKontroler.gp.getTxtIznosIz().getText() != null) {
					try {
					double iznos = Integer.parseInt(GUIKontroler.gp.getTxtIznosIz().getText());
					GUIKontroler.gp.getTxtIznosU().setText(String.valueOf(iznos * kurs));
					Date datum = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSSSSS");
					String datumS = format.format(datum);

					gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
					JsonObject obj = new JsonObject();
					obj.addProperty("datumVreme", datumS);
					obj.addProperty("izValute", skraceni1);
					obj.addProperty("uValutu", skraceni2);
					obj.addProperty("kurs", kurs);
					Menjacnica.sacuvajUFajl(gson,obj);
					}catch(NumberFormatException n) {
						JOptionPane.showMessageDialog(null, "Nedozvoljen unos!", "GRESKA", JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Kurs nije pronadjen.", "GRESKA", JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

}
