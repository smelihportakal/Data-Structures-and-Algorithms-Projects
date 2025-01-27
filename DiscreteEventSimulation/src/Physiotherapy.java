import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Physiotherapy {
    Queue<Physiotherapist> physiotherapistQueue = new PriorityQueue<>();
    Queue<Player> physiotherapyQueue = new PriorityQueue<>();

    int maxLength = 0;
    double totalWaitingInPQ = 0;
    int allEnters = 0;
    double totalPhysiotherapyTime = 0;
    double totalTurnaroundTime = 0;
    double maxWaitingTime = 0;
    int maxWaitingID = 0;


    public Event doPhysiotherapy(Player player, double totalTime) {
        Event newEvent = null;
        allEnters +=1;
        player.setEnterPQ(totalTime);
        if ((physiotherapyQueue.isEmpty()) & (!physiotherapistQueue.isEmpty())) {
            Physiotherapist physiotherapist = physiotherapistQueue.poll();
            double atTime = totalTime + physiotherapist.serviceTime;
            player.attachPhysiotherapist(physiotherapist);

            totalPhysiotherapyTime += physiotherapist.serviceTime;

            newEvent = new Event('f', player, atTime, 0);
        } else {

            addPlayer(player,totalTime);
        }

        return  newEvent;
    }

    public Event finishPhysiotherapy(Player player, double totalTime) {
        Event newEvent = null;

        addPhysiotherapist(player.physiotherapist);
        totalTurnaroundTime += totalTime - player.enterTQ;
        player.setBusy(false);
        player.tqservice(0);

        if (!physiotherapyQueue.isEmpty()) {
            Player player1 = physiotherapyQueue.poll();

            player1.setQuitPQ(totalTime);
            double waitingTime = totalTime - player1.enterPQ;
            player1.increaseWaitingTimePQ(waitingTime);

            if (Math.abs(player1.totalWaitingTimeInPQ - maxWaitingTime) < 0.0000000001) {
                if (player1.id < maxWaitingID) {
                    maxWaitingTime = player1.totalWaitingTimeInPQ;
                    maxWaitingID = player1.id;
                }
            } else if (player1.totalWaitingTimeInPQ > maxWaitingTime) {
                maxWaitingTime = player1.totalWaitingTimeInPQ;
                maxWaitingID = player1.id;
            }

            totalWaitingInPQ += waitingTime;

            Physiotherapist physiotherapist = physiotherapistQueue.poll();
            double atTime = totalTime + physiotherapist.serviceTime;
            player1.attachPhysiotherapist(physiotherapist);

            totalPhysiotherapyTime += physiotherapist.serviceTime;

            newEvent = new Event('f', player1, atTime, 0);
        }
        return newEvent;
    }

    public void addPlayer(Player player, double totalTime) {
        physiotherapyQueue.add(player);

        player.setEnterPQ(totalTime);

        if (physiotherapyQueue.size() > maxLength) {
            maxLength = physiotherapyQueue.size();
        }
    }

    public void addPhysiotherapist(Physiotherapist physiotherapist) {
        physiotherapistQueue.add(physiotherapist);
    }

    public String averageWaitingTimeInPQ(){
        String rtn = String.format("%.3f",totalWaitingInPQ / allEnters);
        return rtn;
    }

    public String averagePhysiotherapyTime() {
        String rtn = String.format("%.3f",totalPhysiotherapyTime / allEnters);
        return rtn;
    }

    public String averageTurnaroundTime() {
        String rtn = String.format("%.3f",totalTurnaroundTime / allEnters);
        return rtn;
    }

    public String maxWaitingPlayer() {
        String rtn = maxWaitingID + " " + String.format("%.3f",maxWaitingTime);
        return rtn;
    }

}
