
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class project2main {

    public static void main(String[] args) throws FileNotFoundException {


        Locale.setDefault(new Locale("en","US"));
        String inputFileName = args[0];
        //String inputFileName = "input_5.txt";

        File in = new File(inputFileName);
        Scanner scanner = new Scanner(in);

        String outputFileName = args[1];
        //String outputFileName = "output.txt";
        PrintStream out = new PrintStream(outputFileName);

        int numberOfPlayers;
        int id;
        int skillLevel;
        int numberOfArriving;
        char type;
        double atSecond;
        double serviceTime;
        int numOfPt;
        int numOfTc;
        int numOfM;

        Queue<Event> eventPQ = new PriorityQueue<>();

        ArrayList<Player> players = new ArrayList<>();
        Training training = new Training();
        Physiotherapy physiotherapy = new Physiotherapy();
        Massage massage = new Massage();

        numberOfPlayers = scanner.nextInt();

        for (int i = 0 ; i < numberOfPlayers; i++ ) {
            id = scanner.nextInt();
            skillLevel = scanner.nextInt();
            Player newPlayer = new Player(id,skillLevel);
            players.add(newPlayer);
        }

        numberOfArriving = scanner.nextInt();

        for (int i = 0; i < numberOfArriving; i ++) {
            type = scanner.next().charAt(0);
            id = scanner.nextInt();
            atSecond = scanner.nextDouble();
            serviceTime = scanner.nextDouble();
            Player player = players.get(id);

            Event event = new Event(type,player,atSecond,serviceTime);
            eventPQ.add(event);
        }

        numOfPt = scanner.nextInt();

        for (int i = 0; i < numOfPt; i ++) {
            serviceTime = scanner.nextDouble();
            Physiotherapist physiotherapist = new Physiotherapist(i,serviceTime);
            physiotherapy.addPhysiotherapist(physiotherapist);
        }

        numOfTc = scanner.nextInt();
        training.availableTrCoach(numOfTc);
        numOfM = scanner.nextInt();
        massage.availableMasseurNumber(numOfM);


        double totalTime = 0;
        int canceledAttemps = 0;
        int invalidAttemps = 0;

        while (!eventPQ.isEmpty()) {
            Event event = eventPQ.poll();
            totalTime = event.atSecond;
            if (event.type == 't') {
                // going Training

                if (event.player.isBusy) {
                    canceledAttemps += 1;
                } else {
                    Event newEvent = training.doTraining(event.player, totalTime, event.serviceTime);


                    if (newEvent != null) {
                        eventPQ.add(newEvent);
                    }
                }

            } else if (event.type == 'p') {
                // going physiotherapy

                if (!training.trainingQueue.isEmpty()) {
                    Event newevent = training.trainingService(totalTime);
                    eventPQ.add(newevent);
                } else {
                    training.availableTrCoach(1);
                }

                Event newEvent = physiotherapy.doPhysiotherapy(event.player, totalTime);

                if (newEvent != null) {
                    eventPQ.add(newEvent);
                }


            } else if (event.type == 'f') {

                Event newEvent = physiotherapy.finishPhysiotherapy(event.player,totalTime);
                if (newEvent != null) {
                    eventPQ.add(newEvent);
                }
            } else if (event.type == 'm') {


                if (event.player.massageNo == 3) {

                    invalidAttemps += 1;
                } else if (event.player.isBusy) {

                    canceledAttemps += 1;
                } else {
                    Event newEvent = massage.doMassage(event.player, totalTime,event.serviceTime);

                    if (newEvent != null) {
                        eventPQ.add(newEvent);
                    }

                }

            } else if (event.type == 'q') {

                Event newEvent = massage.quitMassage(event.player, totalTime);

                if (newEvent != null) {
                    eventPQ.add(newEvent);
                }

            }

        }


        out.println(training.maxLength);
        out.println(physiotherapy.maxLength);
        out.println(massage.maxLengthMQ);

        out.println(training.averageWaitingTQ());
        out.println(physiotherapy.averageWaitingTimeInPQ());

        out.println(massage.averageWaitingTimeInMQ());

        out.println(training.averageTrainingTime());

        out.println(physiotherapy.averagePhysiotherapyTime());

        out.println(massage.averageMassageTime());

        out.println(physiotherapy.averageTurnaroundTime());

        out.println(physiotherapy.maxWaitingPlayer());

        out.println(massage.minWaitingPlayer());

        out.println(invalidAttemps);
        out.println(canceledAttemps);

        out.printf("%.3f",totalTime);


    }
}
