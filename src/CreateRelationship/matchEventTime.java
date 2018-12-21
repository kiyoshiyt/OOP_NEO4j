package CreateRelationship;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class matchEventTime extends CreateRelationship {
    Writer happen = new FileWriter("src/database/happen.csv");
    Writer organize = new FileWriter("src/database/organize.csv");
    Writer start = new FileWriter("src/database/start.csv");
    Writer end = new FileWriter("src/database/end.csv");

    public matchEventTime(int maxNode1, int maxNode2) throws IOException {
        super(maxNode1, maxNode2);
    }


    public Writer RandomReferences() {
        int rd = new Random().nextInt(4);
        if (rd == 0) return happen;
        if (rd == 1) return organize;
        if (rd == 2) return start;
        return end;
    }


    public static void main(String[] args) throws IOException {
        matchEventTime test = new matchEventTime(50, 365);
        test.CreateRelationship(40);
    }

    @Override
    public void CreateRelationship(int tong) {
        try {
            happen.write(":START_ID(Event),:END_ID(Time)\n");
            organize.write(":START_ID(Event),:END_ID(Time)\n");
            start.write(":START_ID(Event),:END_ID(Time)\n");
            end.write(":START_ID(Event),:END_ID(Time)\n");
            for (int i = 0; i < tong; i++) {
                RandomReferences().write((new Random().nextInt(maxNode1) + 300000000) + "," +
                        (new Random().nextInt(maxNode2) + 400000000) + "\n");
            }
            happen.close();
            organize.close();
            start.close();
            end.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
