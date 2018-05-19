package menjacnica.sistemskeoperacije;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class SOSacuvajUFajl {
	public static void izvrsi(Gson gson, JsonObject obj) {
		try {
			JsonArray log = null;
			FileReader reader = new FileReader("data/log.json");
			log = gson.fromJson(reader, JsonArray.class);
			FileWriter writer = new FileWriter("data/log.json");
			if (log == null)
				log = new JsonArray();
			log.add(obj);
			writer.write(gson.toJson(log));
			writer.close();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
