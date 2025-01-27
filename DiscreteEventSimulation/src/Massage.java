import java.util.PriorityQueue;
import java.util.Queue;

public class Massage {
    Queue<Player> massageQueue = new PriorityQueue<>();

    double totalWaitingTime = 0;
    double totalServiceTime = 0;
    int allEnters = 0;
    int maxLengthMQ = 0;
    int availableMasseur = 0;
    double minWaitingTime = -1;
    int minWaitingID = -1;

    public Event doMassage(Player player, double totalTime, double serviceTime) {
        Event newEvent = null;

        player.setEnterMQ(totalTime);
        player.setBusy(true);
        player.massageNumber();
        player.setMservicetime(serviceTime);
        totalServiceTime += serviceTime;
        allEnters += 1;

        if ((massageQueue.isEmpty()) & (availableMasseur > 0)) {
            double atTime = totalTime + serviceTime;
            newEvent = new Event('q',player,atTime,0);
            availableMasseur -= 1;

        } else {
            player.setMservicetime(serviceTime);
            addPlayerMQ(player);
        }

        return newEvent;
    }

    public Event quitMassage(Player player, double totalTime) {
        Event newEvent = null;
        player.setBusy(false);
        player.setEnterMQ(0);
        if (player.massageNo == 3) {
            if (minWaitingID != -1) {
                if (Math.abs(player.totalWaitingTimeInMQ - minWaitingTime) < 0.0000000001) {
                    if (player.id < minWaitingID) {
                        minWaitingTime = player.totalWaitingTimeInMQ;
                        minWaitingID = player.id;
                    }
                } else  if (player.totalWaitingTimeInMQ < minWaitingTime) {
                    minWaitingTime = player.totalWaitingTimeInMQ;
                    minWaitingID = player.id;
                }
            } else {
                minWaitingTime = player.totalWaitingTimeInMQ;
                minWaitingID = player.id;
            }
        }

        if (massageQueue.isEmpty()) {
            availableMasseur += 1;
        } else {
            Player player1 = massageQueue.poll();
            double waitingTime = totalTime - player1.enterMQ;
            player1.increaseWaitingTimeMQ(waitingTime);
            totalWaitingTime += waitingTime;

            double atTime = totalTime + player1.mservicetime;
            newEvent = new Event('q', player1, atTime, 0 ) ;
        }

        return newEvent;
    }

    public void availableMasseurNumber(int number) {
        availableMasseur += number;
    }

    public void addPlayerMQ(Player player) {
        massageQueue.add(player);

        if (massageQueue.size() > maxLengthMQ) {
            maxLengthMQ = massageQueue.size();
        }
    }

    public String averageWaitingTimeInMQ() {
        String rtn = String.format("%.3f",totalWaitingTime / allEnters);
        return rtn;
    }

    public String averageMassageTime() {
        String rtn = String.format("%.3f",totalServiceTime / allEnters);
        return rtn;
    }

    public String minWaitingPlayer() {
        String rtn;
        if (minWaitingTime == -1) {
            rtn = minWaitingID + " " + -1;
        } else {
            rtn = minWaitingID + " " + String.format("%.3f",minWaitingTime);
        }
        return rtn;
    }

}
