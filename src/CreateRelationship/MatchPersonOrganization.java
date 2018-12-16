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

public class MatchPersonOrganization extends CreateRelationship {
	public MatchPersonOrganization(int maxNode1, int maxNode2) {
		super(maxNode1, maxNode2);
	}
	
	public void CreateRelationship (int numRelationship) {
		
		File fileDir = new File("src/database/belong.csv");
		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF-8"));
			out.write("");
			out.write("startNode,endNode");
			out.append("\r\n");
			out.flush();
			Random rand = new Random();
			for (int i = 0 ; i < numRelationship; i++) {
				int startNode = 100000000 + rand.nextInt(maxNode1);
				int endNode = 200000000 + rand.nextInt(maxNode2);
				
				out.append(String.valueOf(startNode)+ ",");
				out.append(String.valueOf(endNode));
				out.append("\r\n");
				out.flush();
			}
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
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatchPersonOrganization po = new MatchPersonOrganization(1000, 20);
		po.CreateRelationship(1000);
	}

}
