import java.util.LinkedList;
import java.util.Queue;

public class Training {
    int availableTrainingCoach = 0;
    Queue<Player> trainingQueue = new LinkedList<>();
    int maxLength = 0;
    double totalWaitingTimeTQ = 0;
    int allEnters = 0;
    double totalTrainingTime = 0;

    public void availableTrCoach(int number){

        availableTrainingCoach += number;
    }

    // do training
    public Event doTraining(Player player, double totalTime, double serviceTime) {
        Event newEvent = null;
        totalTrainingTime += serviceTime;
        player.setBusy(true);
        player.tqservice(serviceTime);
        player.setEnterTQ(totalTime);

        if ((trainingQueue.isEmpty()) & (availableTrainingCoach > 0)) {
            double atTime = totalTime + serviceTime;
            newEvent = new Event('p',player, atTime, serviceTime);
            availableTrainingCoach -= 1;
        } else {
            addPlayer(player,totalTime);

        }
        allEnters +=1;
        return newEvent;
    }

    // from training queue to training service
    public Event trainingService(double totalTime) {
       Player player = trainingQueue.poll();
       player.setQuitTQ(totalTime);
       totalWaitingTimeTQ += player.quitTQ - player.enterTQ;
       double atTime = totalTime + player.tqservicetime;
       Event event = new Event('p',player,atTime, player.tqservicetime);
       return event;
    }

    public void addPlayer(Player player, double totalTime) {
        trainingQueue.add(player);
        player.setEnterTQ(totalTime);
        if (trainingQueue.size() > maxLength) {
            maxLength = trainingQueue.size();
        }
    }

    public String averageWaitingTQ(){
        String rtn = String.format("%.3f",totalWaitingTimeTQ / allEnters);
        return rtn;
    }

    public String averageTrainingTime(){
        String rtn = String.format("%.3f",totalTrainingTime / allEnters);
        return rtn;
    }


    public int getAvailableTrainingCoach() {
        return availableTrainingCoach;
    }
}
