import java.util.PriorityQueue;

public class MinWeightedPath {

    PriorityQueue<City> pqCities = new PriorityQueue<City>();

    public void algorithm(){

        while (!pqCities.isEmpty()) {
            City x = pqCities.poll();

            neighboursd(x);

        }

    }

    public void neighboursd(City s) {

        if (s.neighbours != null){
            for (City i: s.neighbours.keySet()) {
                if (!i.isVisited) {
                    int distanceToRoot = s.distanceToRoot + s.neighbours.get(i);

                    if (distanceToRoot < i.distanceToRoot) {
                        i.distanceToRoot = distanceToRoot;
                        i.parent = s;
                        pqCities.remove(i);
                        pqCities.add(i);
                    }
                }

            }

        }
        s.isVisited = true;

    }

    public void addCity(City c) {
        pqCities.add(c);
    }
}
