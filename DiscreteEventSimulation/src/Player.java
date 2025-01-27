

public class Player implements Comparable<Player> {
    int id;
    int skillLevel;
    static double tqremainingtime = 0;
    double tqservicetime = 0;
    double mservicetime = 0;
    double enterTQ;
    double quitTQ;
    double enterPQ;
    double quitPQ;
    double enterMQ;
    double quitMQ;
    double totalWaitingTimeInMQ = 0;
    double totalWaitingTimeInPQ = 0;
    int massageNo = 0;


    boolean isBusy;
    Physiotherapist physiotherapist = null;

    public Player(int id , int skillLevel) {
        this.id = id;
        this.skillLevel = skillLevel;
        isBusy = false;
    }

    @Override
    public int compareTo(Player o) {
        if (this.tqservicetime != 0) {

            if (Math.abs(this.tqservicetime-o.tqservicetime) < 0.0000000001 ) {

                if (Math.abs(this.enterPQ - o.enterPQ) < 0.0000000001) {
                    if (this.id < o.id) return -1;
                    if (this.id > o.id) return 1;
                }
                else if (this.enterPQ < o.enterPQ) return -1;
                else if (this.enterPQ > o.enterPQ) return 1;

            } else if (this.tqservicetime < o.tqservicetime) {
                return 1;
            } else if (this.tqservicetime > o.tqservicetime) {
                return -1;
            }

        } else {

            if (this.skillLevel > o.skillLevel) {
                return -1;
            } else if (this.skillLevel < o.skillLevel) {
                return 1;
            } else {
                if (Math.abs(this.enterMQ - o.enterMQ) < 0.0000000001) {
                    if (this.id < o.id) return -1;
                    if (this.id > o.id) return 1;
                }
                else if (this.enterMQ < o.enterMQ) return -1;
                else if (this.enterMQ > o.enterMQ) return 1;

            }
        }


        return 0;
    }

    public void massageNumber() {
       massageNo += 1;
    }

    public void increaseWaitingTimeMQ(double waitingTime) {
        totalWaitingTimeInMQ += waitingTime;
    }

    public void increaseWaitingTimePQ(double waitingTime) {
        totalWaitingTimeInPQ += waitingTime;
    }

    public void attachPhysiotherapist(Physiotherapist physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public void tqservice(double serviceTime) {
        tqservicetime = serviceTime;
    }

    public void setMservicetime(double mservicetime) {
        this.mservicetime = mservicetime;
    }

    public void setEnterTQ(double enterTQ) {
        this.enterTQ = enterTQ;
    }

    public void setQuitTQ(double quitTQ) {
        this.quitTQ = quitTQ;
    }

    public void setEnterPQ(double enterPQ) {
        this.enterPQ = enterPQ;
    }

    public void setQuitPQ(double quitPQ) {
        this.quitPQ = quitPQ;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setEnterMQ(double enterMQ) {
        this.enterMQ = enterMQ;
    }

    public static double getTqremainingtime() {
        return tqremainingtime;
    }
}
