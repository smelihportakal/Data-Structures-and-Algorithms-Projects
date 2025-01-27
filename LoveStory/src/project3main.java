import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class project3main {

    public static void main(String[] args) throws FileNotFoundException {

        Locale.setDefault(new Locale("en","US"));
        String inputFileName = args[0];
        //String inputFileName = "input.txt";

        File in = new File(inputFileName);
        Scanner scanner = new Scanner(in);

        String outputFileName = args[1];
        //
        // String outputFileName = "output.txt";
        PrintStream out = new PrintStream(outputFileName);
        ArrayList<String> inputArray = new ArrayList<String>();



        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            inputArray.add(data);
        }

        int timeLimit = Integer.parseInt(inputArray.remove(0));
        int cityCount = Integer.parseInt(inputArray.remove(0));

        String[] cities = inputArray.remove(0).split(" ");
        String mecnunCity = cities[0];
        String leylaCity = cities[1];

        HashMap<String,City> leftCities = new HashMap<>(); // id begin with c
        HashMap<String,HoneymoonCity> rightCities = new HashMap<>(); // id begin with d
        
        MinWeightedPath minWeightedPath = new MinWeightedPath();
        MinSpanningTree minSpanningTree = new MinSpanningTree();

        //System.out.println("here");

        int honeyCount=0;

        for (int i =0; i < cityCount; i++) {
            String parsingData = inputArray.remove(0);

            String[] parts = parsingData.split(" ");

            String cityID = parts[0];

            HashMap<HoneymoonCity,Integer> hNeighbours = new HashMap<>();

            if (cityID.charAt(0) == 'c') {

                HashMap<City,Integer> neighbours = new HashMap<>();

                if (!cityID.equals(leylaCity)) {

                    for (int j = 1; j < parts.length; j +=2) {

                        String id = parts[j];

                        if (!leftCities.containsKey(id)) {
                            City newCity = new City(id,null);
                            leftCities.put(id, newCity );
                        }

                        neighbours.put(leftCities.get(id), Integer.parseInt(parts[j+1]));
                    }

                } else {

                    HoneymoonCity nCity = new HoneymoonCity(cityID);
                    rightCities.put(cityID,nCity);

                    for (int j = 1; j < parts.length; j +=2) {

                        String id = parts[j];
                        if (id.startsWith("c")) {
                            continue;
                        }

                        HoneymoonCity newCity = new HoneymoonCity(id);
                        rightCities.put(id,newCity);

                        rightCities.get(id).addNeighbour(rightCities.get(cityID), Integer.parseInt(parts[j+1]));
                        rightCities.get(cityID).addNeighbour(rightCities.get(id), Integer.parseInt(parts[j+1]));
                    }



                    nCity.cost = 0;

                    minSpanningTree.pqHCities.add(nCity);
                    honeyCount += 1;

                }


                if (cityID.equals(mecnunCity)) {



                    if (!leftCities.containsKey(cityID)) {
                        City newCity = new City(cityID,neighbours);
                        newCity.distanceToRoot = 0;
                        leftCities.put(cityID, newCity);

                    } else {
                        leftCities.get(cityID).neighbours = neighbours;
                        leftCities.get(cityID).distanceToRoot = 0;
                    }
                } else {
                    if (!leftCities.containsKey(cityID)) {
                        City newCity = new City(cityID,neighbours);
                        leftCities.put(cityID, newCity);
                    } else {
                        leftCities.get(cityID).neighbours = neighbours;
                    }
                }
                
                minWeightedPath.addCity(leftCities.get(cityID));

            } else if (cityID.charAt(0) == 'd'){

                honeyCount +=1;

                if (!rightCities.containsKey(cityID)) {

                    HoneymoonCity hCity = new HoneymoonCity(cityID);
                    rightCities.put(cityID, hCity);

                }


                for (int j = 1; j < parts.length; j +=2) {

                    String id = parts[j];

                    if (!rightCities.containsKey(id)){

                        HoneymoonCity newCity = new HoneymoonCity(id);
                        rightCities.put(id,newCity);

                    }
                    rightCities.get(id).addNeighbour(rightCities.get(cityID), Integer.parseInt(parts[j+1]));
                    rightCities.get(cityID).addNeighbour(rightCities.get(id), Integer.parseInt(parts[j+1]));
                }

            }

        }

        //System.out.println("here");
        minWeightedPath.algorithm();
        //System.out.println("finished");
        minSpanningTree.algorithm();


        //for (String a : leftCities.keySet()) {
        //    System.out.println(a + " " + leftCities.get(a).distanceToRoot);
        //}

        City s = leftCities.get(leylaCity);
        //System.out.println(s.id);
        int length = s.distanceToRoot;
        Stack<String> stack = new Stack<String>();
        stack.push(s.id);
        boolean isReachable = false;

        while (s.parent != null) {
            //out.print(s.parent.id + " ");
            stack.push(s.parent.id);
            if (s.parent.id.equals(mecnunCity)) {
                isReachable = true;

            }
            s = s.parent;
        }

        boolean isMarried = true;

        if (length > timeLimit) {
            isMarried = false;
        }

        if (isReachable) {
            while (!stack.isEmpty()) {
                out.print(stack.pop() + " ");
            }
            out.println("");
            //out.println(length);
        } else {
            out.println("-1");
        }




        if (!isReachable) {

            out.println("-1");
        } else if (!isMarried) {

            out.println("-1");
        } else if (minSpanningTree.count < honeyCount) {
            out.println("-2");
        } else {
            out.println(2 * minSpanningTree.totalCost);
        }

        for (String c : rightCities.keySet()) {
            //out.println(c);
        }
    }

}
