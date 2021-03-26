
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person{

            LinkedList<course> Scores = new LinkedList<course>();
            Scanner scn = new Scanner(System.in);

    public Student(int id, String firstName, String lastName, LinkedList<course> scores) {
        super(id, firstName, lastName);
        Scores = scores;
    }

    public Student(Scanner scn, LinkedList<course> scores) {
        super(scn);
        Scores = scores;
    }

    public Student(Scanner scn) {
        super(scn);

    }

    public Student(int id, String firstName, String lastName, Status status) {
        super(id,firstName,lastName,status.UNKNOWN);
    }

    @Override
    protected Person input(int id, String firstName, String lastName, Status status) {
        return null;
    }

    // public Student(int id, String dd, String ff, status nobody) {

    //}

    public void insertNewScore(String courseName, int Value){
        course c = new course(courseName, Value);
        Scores.add(c);
    }
    public int getAverageScore(){
       int avgScore = 0;
        int counter =0;

        for (course s : Scores){
            avgScore+=s.value;
            counter++;
        }
        if (avgScore <= 0)
            return 0;
        else {
            avgScore = avgScore / counter;
            return avgScore;
        }
    }

    @Override
    public String toString() {
        System.out.print("Student, ");
        return super.toString()+ ", average = " + this.getAverageScore();
    }
}






