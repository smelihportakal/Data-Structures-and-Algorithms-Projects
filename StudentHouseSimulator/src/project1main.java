import java.io.*;
import java.util.*;

public class project1main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<House> housePQ = new ArrayList<>();
        ArrayList<Student> studentPQ = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        String inputFileName = args[0];
//      String inputFileName = "input.txt";
        File in = new File(inputFileName);


        Scanner scanner = new Scanner(in);

        String outputFileName = args[1];
//      String outputFileName = "output.txt";
        PrintStream out = new PrintStream(outputFileName);


        int id;
        int duration;
        double rating;
        String name;
        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "h":
                    id = scanner.nextInt();
                    duration = scanner.nextInt();
                    rating = Double.parseDouble(scanner.next());


                    House h = new House(id, duration, rating);
                    housePQ.add(h);
                    break;
                case "s":
                    id = scanner.nextInt();
                    name = scanner.next();
                    duration = scanner.nextInt();
                    rating = Double.parseDouble(scanner.next());

                    Student s = new Student(id, name, duration, rating);
                    studentPQ.add(s);
                    break;
            }
        }


        Collections.sort(housePQ);
        Collections.sort(studentPQ);

        for (int i = 0; i < 8; i ++) {
            for (Student s:studentPQ) {

                if ((s.getDuration() > 0) & (!s.getHoused())) {

                    for (House h: housePQ) {
                        if ((h.getDuration() <= 0) & (h.getRating() >= s.getRating())) {

                            h.setDuration(s.getDuration());
                            s.setHoused(true);

                            break;
                        }
                    }
                }

                s.passSemester();
                if ((s.getDuration() <= 0) & (!s.getHoused())) {
                    students.add(s);
                    s.setHoused(true);
                }

            }


            studentPQ.removeIf(student -> student.getHoused());

            studentPQ.removeIf(student -> student.getDuration() == 0);


            for (House h: housePQ) {
                if (h.getDuration() > 0) {

                    h.passSemester();
                }
            }
        }





        Collections.sort(students);
        for (Student s: students) {

            out.println(s.getName());

        }


    }
}
