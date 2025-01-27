public class Physiotherapist implements Comparable<Physiotherapist>{
    int id;
    double serviceTime;

    public Physiotherapist(int id, double serviceTime) {
        this.id = id;
        this.serviceTime = serviceTime;
    }

    public int compareTo(Physiotherapist p) {
        if (this.id < p.id) {
            return -1;
        } else {
            return 1;
        }
    }



}
