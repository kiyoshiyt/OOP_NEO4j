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

    public JSONArray readFile(String file) {
        String jsonText = null;
        try {
            jsonText = new String(Files.readAllBytes(Paths.get(file)), Charset.forName("UTF-8"));
            return new JSONObject(jsonText).getJSONObject("countries").getJSONArray("country");
        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }



    @Override
    public void createToCSV(String fileName) {
        try {
            Writer out = new FileWriter(fileName);
            out.write("idNode,name,capital,continent,link,timeGet\n");

            JSONArray jsonArray = readFile("src/data/Countries.json.txt");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);

                Country country = new Country(json.getString("countryName"),
                        i, json.getString("capital"), json.getString("continentName"),
                        listLinks[new Random().nextInt(listLinks.length)], new Date());

                out.write((i + 500000000) + ",");
                out.write(country.getCountryName() + ",");
//                out.write(country.getCountryCode() + ",");
                out.write(country.getCapital() + ",");
                out.write(country.getContinentName() + ",");
//                out.write(country.getLanguages() + ",");
//                out.write(String.valueOf(country.getArea()) + ",");
//                out.write(String.valueOf(country.getPopulation()) + ",");
                out.write(country.getLink() + ",");
                out.write(String.valueOf(country.getTimeGet()) + ",");
                out.write("\n");
            }

            if (out != null) out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Parse xong");
    }

    public static void main(String[] args) {
        CreateCountry p = new CreateCountry(250);
        p.createToCSV("src/database/Countries.csv");
    }
}

