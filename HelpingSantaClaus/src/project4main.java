import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class project4main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Locale.setDefault(new Locale("en","US"));

        //String inputFileName = args[0];
        String inputFileName = "input.txt";

        File in = new File(inputFileName);
        Scanner scanner = new Scanner(in);

        //String outputFileName = args[1];
        //
        String outputFileName = "output.txt";
        PrintStream out = new PrintStream(outputFileName);

        ArrayList<String> inputArray = new ArrayList<String>();

        // Green Trains
        int numberGreenTrains = scanner.nextInt();
        int[] greenTrains = new int[numberGreenTrains];

        for (int i = 0; i < numberGreenTrains; i++) {
            greenTrains[i] = scanner.nextInt();
        }
        // Red Trains
        int numberRedTrains = scanner.nextInt();
        int[] redTrains = new int[numberRedTrains];

        for (int i = 0; i < numberRedTrains; i++) {
            redTrains[i] = scanner.nextInt();
        }

        // Green Reindeers
        int numberGreenReindeers = scanner.nextInt();
        int[] greenReindeers = new int[numberGreenReindeers];

        for (int i = 0; i < numberGreenReindeers; i++) {
            greenReindeers[i] = scanner.nextInt();
        }

        // Red Reindeers
        int numberRedReindeers = scanner.nextInt();
        int[] redReindeers = new int[numberRedReindeers];

        for (int i = 0; i < numberRedReindeers; i++) {
            redReindeers[i] = scanner.nextInt();
        }

        /*
        ArrayList<Integer> redReindeers = new ArrayList<>();
        int zeros = 0;

        for (int i = 0; i < numberRedReindeers; i++) {
            int ttt = scanner.nextInt();
            if (ttt == 0) {
                zeros +=1;
            } else {
                redReindeers.add(ttt);
            }
        }

        numberRedReindeers -= zeros;

        */

        // Bags
        int numberBags = scanner.nextInt();

        int gifsTob = 0;
        int gifsToc = 0;
        int gifsTod = 0;
        int gifsToe = 0;
        int gifsTobd = 0;
        int gifsTobe = 0;
        int gifsTocd = 0;
        int gifsToce = 0;
        int gifsToab = 0;
        int gifsToac = 0;
        int gifsToad = 0;
        int gifsToae = 0;
        int gifsToabd = 0;
        int gifsToabe = 0;
        int gifsToacd = 0;
        int gifsToace = 0;

        int numgifsa = 0;
        int numgifsab = numgifsa;
        int numgifsac = numgifsab;
        int numgifsad = numgifsac;
        int numgifsae = numgifsad;
        int numgifsabd = numgifsae;
        int numgifsabe = numgifsabd;
        int numgifsacd = numgifsabe;
        int numgifsace = numgifsacd;

        ArrayList<Integer> gifsa = new ArrayList<>();
        ArrayList<Integer> gifsab = new ArrayList<>();
        ArrayList<Integer> gifsac = new ArrayList<>();
        ArrayList<Integer> gifsad = new ArrayList<>();
        ArrayList<Integer> gifsae = new ArrayList<>();
        ArrayList<Integer> gifsabd = new ArrayList<>();
        ArrayList<Integer> gifsabe = new ArrayList<>();
        ArrayList<Integer> gifsacd = new ArrayList<>();
        ArrayList<Integer> gifsace = new ArrayList<>();


        int[] comingGifts = new int[18];

        for (int i = 0; i < 18 ; i++) {
            comingGifts[i] = 0;
        }

        int totalGift = 0;

        for (int i = 0; i < numberBags; i++) {
            String bag = scanner.next();
            int numOfGifs = scanner.nextInt();
            totalGift += numOfGifs;

            if (numOfGifs == 0){
                continue;
            }

            switch (bag) {
                case "a":
                    gifsa.add(numOfGifs);
                    numgifsa += 1;
                    break;
                case "b":
                    gifsTob += numOfGifs;
                    break;
                case "c":
                    gifsToc += numOfGifs;
                    break;
                case "d":
                    gifsTod += numOfGifs;
                    break;
                case "e":
                    gifsToe += numOfGifs;
                    break;
                case "bd":
                    gifsTobd += numOfGifs;
                    break;
                case "be":
                    gifsTobe += numOfGifs;
                    break;
                case "cd":
                    gifsTocd += numOfGifs;
                    break;
                case "ce":
                    gifsToce += numOfGifs;
                    break;
                case "ab":
                    gifsab.add(numOfGifs);
                    numgifsab += 1;
                    break;
                case "ac":
                    gifsac.add(numOfGifs);
                    numgifsac += 1;
                    break;
                case "ad":
                    gifsad.add(numOfGifs);
                    numgifsad += 1;
                    break;
                case "ae":
                    gifsae.add(numOfGifs);
                    numgifsae += 1;
                    break;
                case "abd":
                    gifsabd.add(numOfGifs);
                    numgifsabd += 1;
                    break;
                case "abe":
                    gifsabe.add(numOfGifs);
                    numgifsabe += 1;
                    break;
                case "acd":
                    gifsacd.add(numOfGifs);
                    numgifsacd += 1;
                    break;
                case "ace":
                    gifsace.add(numOfGifs);
                    numgifsace += 1;
                    break;
                default:
                    System.out.println("no macth");

            }
        }

        numgifsab += numgifsa;
        numgifsac += numgifsab;
        numgifsad += numgifsac;
        numgifsae += numgifsad;
        numgifsabd += numgifsae;
        numgifsabe += numgifsabd;
        numgifsacd += numgifsabe;
        numgifsace += numgifsacd;

        for (int i : greenTrains) {
            System.out.println(i);
        }

        for (int i : redTrains) {
            System.out.println(i);
        }
        for (int i : greenReindeers) {
            System.out.println(i);
        }
        for (int i : redReindeers) {
            System.out.println(i);
        }

        int indGT = 9 + numgifsace;
        int indGR = indGT + numberGreenTrains;
        int indRT = indGR + numberGreenReindeers;
        int indRR = indRT + numberRedTrains;
        int indFinal = indRR + numberRedReindeers;
        int numGreen = numberGreenReindeers +numberGreenTrains;
        int numRed = numberRedReindeers + numberRedTrains;

        List<Edge>[] graph = createGraph(indFinal + 1);

        int gifs = gifsTob;
        if (gifs !=0) {
            addEdge(graph,0,1,gifs);
            for (int i = indGT; i < indRT; i++){
                addEdge(graph,1,i,gifs);
            }
        }

        gifs = gifsToc;
        if (gifs != 0) {
            addEdge(graph,0,2,gifs);
            for (int i = indRT; i < indFinal; i++){
                addEdge(graph,2,i,gifs);
            }
        }

        gifs = gifsTod;
        if (gifs != 0) {
            addEdge(graph,0,3,gifs);
            for (int i = indGT; i < indGR; i++){
                addEdge(graph,3,i,gifs);
            }
            for (int i = indRT; i < indRR; i++){
                addEdge(graph,3,i,gifs);
            }
        }

        gifs = gifsToe;
        if (gifs != 0) {
            addEdge(graph,0,4,gifs);
            for (int i = indGR; i < indRT; i++){
                addEdge(graph,4,i,gifs);
            }

            for (int i = indRR; i < indFinal; i++){
                addEdge(graph,4,i,gifs);
            }
        }

        gifs = gifsTobd;
        if (gifs != 0) {
            addEdge(graph,0,5,gifs);
            for (int i = indGT; i < indGR; i++){
                addEdge(graph,5,i,gifs);
            }
        }

        gifs = gifsTobe;
        if (gifs != 0) {
            addEdge(graph,0,6,gifs);
            for (int i = indGR; i < indRT; i++){
                addEdge(graph,6,i,gifs);
            }
        }

        gifs = gifsTocd;
        if (gifs != 0) {
            addEdge(graph,0,7,gifs);
            for (int i = indRT; i < indRR; i++){
                addEdge(graph,7,i,gifs);
            }
        }

        gifs = gifsToce;
        if (gifs != 0) {
            addEdge(graph,0,8,gifs);
            for (int i = indRR; i < indFinal; i++){
                addEdge(graph,8,i,gifs);
            }
        }

        methsa(0, gifsa, indGT, indFinal, (List<Edge>[]) graph);

        methsa(numgifsa, gifsab, indGT, indRT, (List<Edge>[]) graph);

        methsa(numgifsab, gifsac, indRT, indFinal, (List<Edge>[]) graph);

        for (int i = 0; i < gifsad.size(); i++) {
            int v = 9 + numgifsac + i;
            addEdge(graph,0,v,gifsad.get(i));
            for (int j = indGT; j < indGR; j++) {
                addEdge(graph,v,j,1);
            }
            for (int j = indRT; j < indRR; j++) {
                addEdge(graph,v,j,1);
            }
        }

        for (int i = 0; i < gifsae.size(); i++) {
            int v = 9 + numgifsad + i;
            addEdge(graph,0,v,gifsae.get(i));
            for (int j = indGR; j < indRT; j++) {
                addEdge(graph,v,j,1);
            }
            for (int j = indRR; j < indFinal; j++) {
                addEdge(graph,v,j,1);
            }
        }

        methsa(numgifsae, gifsabd, indGT, indGR, (List<Edge>[]) graph);
        methsa(numgifsabd, gifsabe, indGR, indRT, (List<Edge>[]) graph);
        methsa(numgifsabe, gifsacd, indRT, indRR, (List<Edge>[]) graph);
        methsa(numgifsacd, gifsace, indRR, indFinal, (List<Edge>[]) graph);

        for (int i = 0; i < numberGreenTrains; i++) {
            int v = indGT + i;
            addEdge(graph,v,indFinal,greenTrains[i]);
        }

        for (int i = 0; i < numberGreenReindeers; i++) {
            int v = indGR + i;
            addEdge(graph,v,indFinal,greenReindeers[i]);
        }

        for (int i = 0; i < numberRedTrains; i++) {
            int v = indRT + i;
            addEdge(graph,v,indFinal,redTrains[i]);
        }

        for (int i = 0; i < numberRedReindeers; i++) {
            int v = indRR + i;
            addEdge(graph,v,indFinal,redReindeers[i]);
        }

        int o = 0;
        for (List<Edge> a: graph) {
            System.out.println("new" + o);

            o += 1;

            for (Edge b: a) {
                System.out.println(b.t + " " + b.rev);
            }
        }

        System.out.println("---------------------");
        for (Edge b: graph[0]) {
            System.out.println(b.t + " " + b.rev + " " + b.cap);
        }

        System.out.println("sonuc");
        int max = maxFlow(graph, 0, indFinal);
        System.out.println(max);
        System.out.println(totalGift-max);
        System.out.println(indFinal);

        System.out.println(indGT + " " + indGR + " " + indRT + " " + indRR+ " " + indFinal);


    }

    private static void methsa(int numgifsab, ArrayList<Integer> gifsac, int indRT, int indFinal, List<Edge>[] graph) {
        for (int i = 0; i < gifsac.size(); i++) {
            int v = 9 + numgifsab + i;
            addEdge(graph,0,v,gifsac.get(i));
            for (int j = indRT; j < indFinal; j++) {
                addEdge(graph,v,j,1);
            }
        }
    }

    static class Edge {
        int t, rev, cap, f;

        public Edge(int t, int rev, int cap) {
            this.t = t;
            this.rev = rev;
            this.cap = cap;
        }
    }

    public static List<Edge>[] createGraph(int nodes) {
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++)
            graph[i] = new ArrayList<>();
        return graph;
    }

    public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
        graph[s].add(new Edge(t, graph[t].size(), cap));
        graph[t].add(new Edge(s, graph[s].size() - 1, 0));
    }

    static boolean dinicBfs(List<Edge>[] graph, int src, int dest, int[] dist) {
        Arrays.fill(dist, -1);
        dist[src] = 0;
        int[] Q = new int[graph.length];
        int sizeQ = 0;
        Q[sizeQ++] = src;
        //System.out.println(sizeQ);
        for (int i = 0; i < sizeQ; i++) {
          //  System.out.println(sizeQ);
            int u = Q[i];
            //System.out.println(u);
            for (Edge e : graph[u]) {
                if (dist[e.t] < 0 && e.f < e.cap) {
                    dist[e.t] = dist[u] + 1;
                    Q[sizeQ++] = e.t;
                }
            }
        }
        System.out.println(dist[dest]);
        return dist[dest] >= 0;
    }

    static int dinicDfs(List<Edge>[] graph, int[] ptr, int[] dist, int dest, int u, int f) {
        if (u == dest)
            return f;
        for (; ptr[u] < graph[u].size(); ++ptr[u]) {
            Edge e = graph[u].get(ptr[u]);
            if (dist[e.t] == dist[u] + 1 && e.f < e.cap) {
                int df = dinicDfs(graph, ptr, dist, dest, e.t, Math.min(f, e.cap - e.f));
                if (df > 0) {
                    e.f += df;
                    graph[e.t].get(e.rev).f -= df;
                    return df;
                }
            }
        }
        return 0;
    }

    public static int maxFlow(List<Edge>[] graph, int src, int dest) {
        int flow = 0;
        int[] dist = new int[graph.length];
        while (dinicBfs(graph, src, dest, dist)) {
            int[] ptr = new int[graph.length];
            while (true) {
                int df = dinicDfs(graph, ptr, dist, dest, src, Integer.MAX_VALUE);
                if (df == 0)
                    break;
                flow += df;
            }
        }
        return flow;
    }
}
