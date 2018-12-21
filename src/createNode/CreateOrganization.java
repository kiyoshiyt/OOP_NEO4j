package createNode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import objects.Organization;

public class CreateOrganization extends CreateNode {
	ArrayList<Organization> listOrganization = new ArrayList<>();

	public CreateOrganization(int maxNode) {
		super(maxNode);
		this.maxNode = maxNode;
		if (maxNode > 40)
			this.maxNode = 40;
	}

	//
	@Override
	public void createToCSV(String fileName) {
		Random rand = new Random();
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/data/OrganizationTest.txt"), "UTF-8"));
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "Unicode"));

			String str;
			Organization organization = null;
			Date timeGet = new Date();
			int i = 0;
			while ((str = in.readLine()) != null) {
				String s[] = str.split("\\|"); // Ä‘á»�c dá»¯ liá»‡u trong
												// notepad ngÄƒn cÃ¡ch nhau
												// bá»Ÿi dáº¥u |
				String name = s[0];
				String active = s[1];
				String description = s[2];
				int idNode = 200000000 + i;
				organization = new Organization(idNode, name, active, listLinks[rand.nextInt(listLinks.length)],
						timeGet, description);
				listOrganization.add(organization);
				i++;
			}

			out.write("");
			out.append("organizationId:ID(Organization)" + ",");
			out.append("name" + ",");
			out.append("active" + ",");
			out.append("listLink" + ",");
			out.append("timeGet" + ",");
			out.append("description" + ",");
			out.append("\r\n");
			Organization o;
			for (int j = 0; j < maxNode; j++) {
				o = listOrganization.get(j);
				out.append(String.valueOf(o.getId()) + ",");
				out.append(o.getName() + ",");
				out.append(o.getActive() + ",");
				out.append(o.getDescription() + ",");
				out.append(o.getLink() + ",");
				out.append(o.getTimeGet().toString());
				out.append("\r\n");
				out.flush();
			}

			out.flush();
			out.close();

			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {

		long begin = Calendar.getInstance().getTimeInMillis();
		// some code.....

		CreateOrganization cp = new CreateOrganization(30);
		cp.createToCSV("src/database/Organization.csv");
		System.out.println("Sinh thanh cong");

		//
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("time to run: " + (end - begin) + " ms!");

	}

}
