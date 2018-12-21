package createNode;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import objects.Location;
import objects.Person;

import java.io.BufferedWriter;
import java.io.File;
public class CreateLocation extends CreateNode {
	public CreateLocation(int maxNode) {
		super(maxNode);
	}
//	private ArrayList <Location> createLocation(String fileName){
	private String[] listLinks = {"https://dulich.vnexpress.net/","https://dantri.com.vn/", "vnexpress.net", "tuoitre.vn", "http://vietnamnet.vn/",
            "https://www.vietnamplus.vn/", "https://vtc.vn/", "https://www.24h.com.vn/", "http://kenh14.vn/"
	};
	private String country = "Việt Nam";
	private  List<String> Location = new ArrayList <String>();
	public void createToCSV(String fileName) {

		try {
			readFile("src/data/Location.txt",Location);
			Random rd =new Random();
	
			File fileDir = new File(fileName);

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF-8"));
			out.write("");
			
			
			out.append("locationId:ID(Location)"+",");
			out.append("name"+",");
			out.append("country"+",");
			out.append("link"+",");
			out.append("timeGet"+"");
			out.append("\r\n");
			

			objects.Location p = new Location();
			for (int i = 0; i < maxNode; i++) {

				
				p.setId(600000000+i);
				p.setName(Location.get(rd.nextInt(Location.size())));
				p.setCountry(country);
				p.setLink(listLinks[ rd.nextInt(listLinks.length)]);
				p.setTimeget(new Date(2018));
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String timeGet= formatter.format(p.getTimeget().getDate());
				

				
				//ghi ra file
				out.append(
						String.valueOf(p.getId())+",");
				out.append(
						p.getName()+",");
				out.append(
						p.getCountry()+",");
				out.append(
						p.getLink()+",");
				out.append(
						timeGet);
				out.append("\r\n");
				out.flush();
				
				
			}
			
			try {
//				cn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.flush();
			out.close();

		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		long begin = Calendar.getInstance().getTimeInMillis();
		// some code.....
		
		CreateLocation cl =new CreateLocation(64);
		cl.createToCSV("src/database/CreateLocation.csv");
		System.out.println("Sinh thanh cong");
		
		//
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("time to run: " + (end - begin)+" ms!");

	}
}
