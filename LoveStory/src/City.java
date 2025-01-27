import java.util.HashMap;

public class City implements Comparable<City> {

    String id;
    City parent;
    int distanceToRoot;
    HashMap<City,Integer> neighbours = new HashMap<>();
    Boolean isVisited = false;

    public City(String id, HashMap<City,Integer> neighbours) {
        this.id = id;
        this.neighbours = neighbours;
        distanceToRoot = Integer.MAX_VALUE;
    }

    public int compareTo(City o) {

        if (this.distanceToRoot < o.distanceToRoot) {
            return -1;
        } else {
            return 1;
        }

    }


}
