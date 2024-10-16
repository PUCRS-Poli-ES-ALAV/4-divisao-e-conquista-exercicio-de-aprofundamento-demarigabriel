import java.io.BufferedWriter;
import java.util.HashMap;

public class Contador {

    private HashMap<Integer, Integer> nAndCounters;

    public void toCSV(String filename){
        filename = filename + ".csv";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("n,counter\n");
        for (Integer n : this.nAndCounters.keySet()) {
            writer.write(n + "," + this.nAndCounters.get(n) + "\n");
        }
    }

    public Contador() {
        this.nAndCounters = new HashMap<>();
    }

    public void startAgain() {
        this.nAndCounters = new HashMap<>();
    }

    public void increment(int n) {
        if (this.nAndCounters.containsKey(n)) {
            this.nAndCounters.put(n, this.nAndCounters.get(n) + 1);
        } else {
            this.nAndCounters.put(n, 1);
        }
    }
}