package createNode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import method.ConectionDB;
import objects.Person;

import java.io.BufferedWriter;
import java.io.File;


public class CreatePerson extends CreateNode {
	
	public CreatePerson(int maxNode) {
		super(maxNode);
		// TODO Auto-generated constructor stub
	}


	private String[] lastName={"Nguyễn","Trần","Lê","Phạm","Hoàng","Phan","Vũ","Đặng","Bùi","Đỗ","Hồ","Dương","Lý"};
	private String []listJob ={"Sinh viên","Giám đốc","Bảo vệ","Kỹ sư","Bác sĩ","Công nhân","Y tá","Nhân viên","Thanh tra","Luật sư"};
	private  List<String> manName = new ArrayList <String>();
	private  List<String> womanName = new ArrayList <String>();


	//Sinh gia lap
	public void createToCSV(String fileName) {

		try {
			readFile("src/data/man.txt",manName);
			readFile("src/data/woman.txt",womanName);
			Random rd =new Random();
	// ghi ra file		
			File fileDir = new File(fileName);

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF-8"));
			out.write("");
			
			
			out.append("id"+",");
			out.append("name"+",");
			out.append("man"+",");
			out.append("age"+",");
			out.append("job"+",");
			out.append("link"+",");
			out.append("timeGet"+"");
			out.append("\r\n");
			
		//	ConectionDB cn = new ConectionDB("bolt://localhost:7687","akiko","06081997");
			objects.Person p = new Person();
			for (int i = 0; i < maxNode; i++) {
//sinh ngáº«u nhiÃªn 1 Ä‘á»‘i tÆ°á»£ng
				
				p.setId(100000000+i);
				p.setAge(rd.nextInt(52)+18);
				p.setJob(listJob[ rd.nextInt(listJob.length)]);
				p.setLink(listLinks[ rd.nextInt(listLinks.length)]);
				p.setTimeget(new Date(2018));
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String timeGet= formatter.format(p.getTimeget().getDate());
				p.setMan(rd.nextBoolean());
				if(p.isMan()){
					p.setName(lastName[rd.nextInt(lastName.length)]+" "+manName.get(rd.nextInt(manName.size())));
				}else
					p.setName(lastName[rd.nextInt(lastName.length)]+" "+womanName.get(rd.nextInt(womanName.size())));
				//ghi ra file
				out.append(
						String.valueOf(p.getId())+",");
				out.append(
						p.getName()+",");
				out.append(
						String.valueOf(p.isMan())+",");
				out.append(
						p.getAge()+",");
				out.append(
						p.getJob()+",");
				out.append(
						p.getLink()+",");
				out.append(
						timeGet);
				out.append("\r\n");
				out.flush();
				
				//tao truc tiep tren graph;
//				System.out.println("CREATE (:PERSON { id: '"+p.getId()+"', name: '"+p.getName()+"', man:"+String.valueOf(p.isMan())+","
//						+ "age:"+p.getAge()+" ,"
//						+ "job: '"+p.getJob()+"',"
//						+ "link:'"+p.getLink()+"', "
//						+ "timeGet:"+timeGet+" })");
//				cn.execute("CREATE (:PERSON { id: '"+p.getId()+"', name: '"+p.getName()+"', man:"+String.valueOf(p.isMan())+","
//						+ "age:"+p.getAge()+" ,"
//						+ "job: '"+p.getJob()+"',"
//						+ "link:'"+p.getLink()+"', "
//						+ "timeGet:"+timeGet+" })");
				
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
	//sinh ngÃ¡ÂºÂ«u nhiÃƒÂªn thÃ¡Â»Â±c thÃ¡Â»Æ’ ngÃ†Â°Ã¡Â»ï¿½i
//	private Person createPerson(int id){
//		Random rd =new Random();
//		readFile("C:\\Users\\tt270\\workspace\\Neo4j\\src\\createNode\\man.txt",manName);
//		readFile("C:\\Users\\tt270\\workspace\\Neo4j\\src\\createNode\\woman.txt",womanName);
//		int man = manName.size();
//		int woman =womanName.size();
//		int l=lastName.length;
//		String name="";
//		boolean isMan=rd.nextBoolean();
//		if(isMan){
//			name=lastName[rd.nextInt(l)]+" "+manName.get(rd.nextInt(man));
//		}else
//			name=lastName[rd.nextInt(l)]+" "+womanName.get(rd.nextInt(woman));
//		int age=rd.nextInt(52)+18;
//		String job= listJob[ rd.nextInt(listJob.length)];
//		String link=listLinks[ rd.nextInt(listLinks.length)];
//		Date timeget= new Date();
//		Person p =new Person(id, name, isMan, age, job, link, timeget);
//		return p;
//	}


	public static void main(String[] args) {
		
		
		long begin = Calendar.getInstance().getTimeInMillis();
		// some code.....
		
		CreatePerson cp =new CreatePerson(4000);
		cp.createToCSV("src/data/CreatePerson.csv");
		System.out.println("Sinh thanh cong");
		
		//
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("time to run: " + (end - begin)+" ms!");

		
	}
}
