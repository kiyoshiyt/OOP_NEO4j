package createNode;
/*
 * tao thuc the ra file csv
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public abstract class CreateNode {
	//quy uoc:Tao id cua Person :100 tr+ 1,2,3...
	//quy uoc: id cua organization :200 tr+ 1,2,3...
	//quy uoc: id cua Event :300 tr+ 1,2,3...
	//quy uoc: id cua Time :400 tr+ 1,2,3...
	//quy uoc: id cua Country :500 tr+ 1,2,3...
	//quy uoc: id cua Location :600 tr+ 1,2,3...
	
	int maxNode; //so thuc the toi da duoc tao ra
	
	public CreateNode(int maxNode){
		this.maxNode=maxNode;
	}
	
	// danh sach cac trang trich rut
	protected String[] listLinks = {"https://dulich.vnexpress.net/","https://dantri.com.vn/", "vnexpress.net", "tuoitre.vn", "http://vietnamnet.vn/",
            "https://www.vietnamplus.vn/", "https://vtc.vn/", "https://www.24h.com.vn/", "http://kenh14.vn/"
	};
	// doc file vao list
	public  void readFile(String file,List<String> list){

		try {BufferedReader in = new BufferedReader(
				   new InputStreamReader(
		                      new FileInputStream(file), "UTF-8"));
		 
				String str;
		 
				while ((str = in.readLine()) != null) {
					list.add(str);
				}
		 
		                in.close();
			    }
			    catch (UnsupportedEncodingException e)
			    {
					System.out.println(e.getMessage());
			    }
			    catch (IOException e)
			    {
					System.out.println(e.getMessage());
			    }
			    catch (Exception e)
			    {
					System.out.println(e.getMessage());
			    }
		}
	// sinh ra file .csv
	public abstract void createToCSV(String fileName);
}
