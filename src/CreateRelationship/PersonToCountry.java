package CreateRelationship;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Random;

public class PersonToCountry extends CreateRelationship {
	public PersonToCountry(int maxNode1, int maxNode2) {
		super(maxNode1, maxNode2);
		// TODO Auto-generated constructor stub
	}

	public void CreateRelationship(int numRelationship) {
		// ghi ra file
		File fileDir = new File("src/database/visited.csv");

		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF-8"));
			out.write("");
			out.append(":START_ID(Person),year,:END_ID(Country)");
			out.append("\r\n");
			out.flush();
			Random rd = new Random();
			for (int i = 0; i < numRelationship; i++) {
				int startNode = 100000000 + rd.nextInt(maxNode1);
				String nam = String.valueOf(1900 + rd.nextInt(118));
				int endNode = 500000000 + rd.nextInt(maxNode2);

				out.append(String.valueOf(startNode) + ",");
				out.append(nam + ",");
				out.append(String.valueOf(endNode));
				out.append("\r\n");
				out.flush();
			}

			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};

	public static void main(String[] args) {
		PersonToCountry ptc = new PersonToCountry(15000000, 250);
		ptc.CreateRelationship(100);
		System.out.println("Done!");
	}
}
