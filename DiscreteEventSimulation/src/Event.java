
public class Event implements Comparable<Event>{
    char type;
    Player player;
    double atSecond;
    double serviceTime;

    public Event(char type, Player player, double atSecond, double serviceTime ) {
        this.type = type;
        this.player = player;
        this.atSecond = atSecond;
        this.serviceTime = serviceTime;
    }

    public int compareTo(Event o) {
        if (Math.abs(this.atSecond - o.atSecond) < 0.0000000001 ){
            if (this.type != o.type) {
                if (this.type == 'f') {
                    return -1;
                } else if (o.type == 'f') {
                    return  1;
                } else if (this.type == 'p') {
                    return -1;
                } else if (o.type == 'p') {
                    return  1;
                } else if (this.type == 'q') {
                    return -1;
                } else if (o.type == 'q') {
                    return 1;
                } else {
                    if (this.player.id < o.player.id) return -1;
                    if (this.player.id > o.player.id) return 1;
                    else return 0;
                }

            } else {
                if (this.player.id < o.player.id) return -1;
                if (this.player.id > o.player.id) return 1;
                else return 0;
            }
        }
        else if (this.atSecond < o.atSecond) return -1;
        else return 1;
    }

    public Player getPlayer() {
        return player;
    }


}
