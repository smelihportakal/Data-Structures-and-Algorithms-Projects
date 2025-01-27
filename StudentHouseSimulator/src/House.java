public class House implements Comparable<House> {
    private int id;
    private int duration;
    private double rating;

    public House(int id, int duration, double rating) {
        this.id = id;
        this.duration = duration;
        this.rating = rating;
    }

    public void passSemester() {
        if (duration > 0) {
            duration -= 1;
        }

    }

    public int compareTo(House h) {
        if (id < h.id)
            return -1;
        else if(id > h.id)
            return 1;
        return 0;
    }

    public int getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
