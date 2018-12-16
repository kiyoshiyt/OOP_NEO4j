package CreateRelationship;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class MatchPersonEvent extends CreateRelationship {
	
    public MatchPersonEvent(int maxNode1, int maxNode2) throws IOException {
		super(maxNode1, maxNode2);
		
	}

	Writer participation = new FileWriter("src/database/participation.csv");
    Writer opening = new FileWriter("src/database/opening.csv");
    

   

    public Writer RandomReferences() {
        int rd = new Random().nextInt(2);
        if (rd == 0) return participation;
        return opening;
    }


    public static void main(String[] args) throws IOException {
        MatchPersonEvent test = new MatchPersonEvent(1000, 50);
        test.CreateRelationship(20);
    }

    @Override
    public void CreateRelationship(int tong) {
        try {
        	participation.write("startNode,endNode\n");
        	opening.write("startNode,endNode\n");
           
            for (int i = 0; i < tong; i++) {
                RandomReferences().write((new Random().nextInt(maxNode1) + 100000000) + "," +
                        (new Random().nextInt(maxNode2) + 300000000) + "\n");
            }
            participation.close();
            opening.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
