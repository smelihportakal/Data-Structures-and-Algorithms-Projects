
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int duration;
    private double rating;
    private boolean isHoused;

    public Student(int id, String name, int duration, double rating) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this.isHoused = false;
    }

    public int compareTo(Student s) {
        if (id < s.id)
            return -1;
        else if(id > s.id)
            return 1;
        return 0;
    }

    public void passSemester() {

        duration -=1;
    }

    public String getName() {
        return name;
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

    public void setHoused(boolean housed) {
        this.isHoused = housed;
    }

    public boolean getHoused() {
        return isHoused;
    }
}
