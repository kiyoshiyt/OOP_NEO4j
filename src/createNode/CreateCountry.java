package createNode;

import objects.Country;
import org.json.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CreateCountry extends CreateNode {

	public CreateCountry(int maxNode) {
		super(maxNode);
	}

	public JSONArray readFile(String file) throws JSONException {
		String jsonText = null;
		try {
			jsonText = new String(Files.readAllBytes(Paths.get(file)), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONObject(jsonText).getJSONObject("countries").getJSONArray("country");
	}

	@Override
	public void createToCSV(String fileName) {
		try {
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			out.write("countryId:ID(Country),name,capital,continent,link,timeGet\r\n");

			JSONArray jsonArray = readFile("src/data/countries.json.txt");
			for (int i = 0; i < maxNode; i++) {
				JSONObject json;
				if (i > 249) {
					json = jsonArray.getJSONObject(new Random().nextInt(250));
				} else
					json = jsonArray.getJSONObject(i);

				Country country = new Country(json.getString("countryName"), json.getString("capital"),
						json.getString("continentName"), listLinks[new Random().nextInt(listLinks.length)], new Date());

				out.write((i + 500000000) + ",");
				out.write(country.getCountryName() + ",");
				// out.write(country.getCountryCode() + ",");
				out.write(country.getCapital() + ",");
				out.write(country.getContinentName() + ",");
				// out.write(country.getLanguages() + ",");
				// out.write(String.valueOf(country.getArea()) + ",");
				// out.write(String.valueOf(country.getPopulation()) + ",");
				out.write(country.getLink() + ",");
				out.write(String.valueOf(country.getTimeGet()) + "");
				out.write("\r\n");
			}

			if (out != null)
				out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Parse xong");
	}

	public static void main(String[] args) {
		CreateCountry p = new CreateCountry(50);
		p.createToCSV("Countries.csv");
	}
}
