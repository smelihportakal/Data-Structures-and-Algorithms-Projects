import java.util.HashMap;

public class HoneymoonCity implements Comparable<HoneymoonCity>{

    String id;
    HoneymoonCity parent;
    Integer cost;
    HashMap<HoneymoonCity,Integer> neighbours = new HashMap<HoneymoonCity,Integer>();
    Boolean isVisited = false;

    public HoneymoonCity(String id) {
        this.id = id;
        cost = Integer.MAX_VALUE;
    }

    public void addNeighbour(HoneymoonCity city, int weight) {

        if (neighbours.containsKey(city)) {
            if (weight < neighbours.get(city)) {
                neighbours.replace(city,weight);
            }
        } else {
            neighbours.put(city,weight);
        }

    }

    public int compareTo(HoneymoonCity o) {
        if (this.cost < o.cost) {
            return -1;
        } else {
            return 1;
        }

    }

}
