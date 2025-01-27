import java.util.HashMap;
import java.util.PriorityQueue;

public class MinSpanningTree {

    PriorityQueue<HoneymoonCity> pqHCities = new PriorityQueue<>();
    int totalCost = 0;
    int count = 0;

    public void algorithm() {


        while (!pqHCities.isEmpty()) {
            HoneymoonCity s = pqHCities.poll();

            totalCost += s.cost;

            //System.out.println(s.id + " " + s.cost + "what");

            if (!s.isVisited) {
                s.isVisited = true;
                count +=1;

                for (HoneymoonCity w : s.neighbours.keySet()) {
                    if (!w.isVisited) {
                        if (s.neighbours.get(w) < w.cost){
                            w.cost = s.neighbours.get(w);
                            w.parent = s;

                            if (pqHCities.contains(w)) {
                                pqHCities.remove(w);
                            }

                            pqHCities.add(w);

                        }
                    }
                }
            }

        }
    }

}
