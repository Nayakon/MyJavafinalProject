import java.util.*;
public class Program{
    public static void main(String []args) {

        LinkedList<Person> people=new LinkedList<>();
        Scanner scn = new Scanner(System.in);
        Teacher teacher;
        Student student;
        String select;
        String selectInner;

        int id;
        Person myK;

        stubMenu(people);

        System.out.println("Welcome to the JAVA final Project: ");

        System.out.println();

        boolean mainLoop = true;
        while (mainLoop){
            printMainMenu();
            System.out.print("Enter your selection: ");// modified print to println
            select= scn.next();
            switch (select){
                case "1":
                    teacher = new Teacher(scn);
                    people.add(teacher);
                    break;
                case "2":
                    student =new Student(scn);
                    people.add(student);
                    break;
                case "3":
                    for (Person p : people){
                        System.out.println(p.toString());
                    }
                    break;
                case "4":
                    for (Person p: people){
                        if (p.getClass()==Teacher.class){
                            System.out.println(p.toString());
                        }
                    }
                    break;
                case "5":
                    for (Person p : people){
                        if (p.getClass() == Student.class){
                            System.out.println(p.toString());
                        }
                    }
                    break;
                case "6":
                    System.out.print(" Please enter teacher ID you wish to display: ");
                    id = scn.nextInt();
                    myK = (Person) searchById(people, id);
                    if (myK == null) {
                        System.out.println("Doesn't exists ");
                    }
                    else if (myK.getClass()==Teacher.class){
                        System.out.println(myK.toString());

                    }
                    else if (myK.getClass() == Student.class){
                        System.out.println(myK.id + " Not a Teacher ");
                    }
                    else {
                        System.out.println("Error, how can I help you? ");
                    }
                    break;
                case "7":
                    System.out.print("Please enter student ID you wish to display: ");
                    id = scn.nextInt();
                    myK= (Person) searchById(people, id);
                    if (myK == null){
                        System.out.println(" Doesn't exists ");
                    }
                    else if (myK.getClass()==Teacher.class){
                        System.out.println(myK.id + " Not a Student ");
                    }
                    else if (myK.getClass() == Student.class){
                        System.out.println(myK.toString());
                        Student mys = (Student)myK;

                        boolean innerLoop = true;

                        while (innerLoop){
                            printSubMenu();
                            System.out.print("Please enter your Selection: ");
                            selectInner = scn.next();

                            switch (selectInner){
                                case "1":
                                    for (course s : mys.Scores){
                                        System.out.println(" Course: " + s.courseName + "Score " + s.value);
                                    }
                                    break;
                                case "2":
                                    System.out.print("name of the Course: ");
                                    String c = scn.next();
                                    System.out.print("Score of the Course: ");
                                    int i = scn.nextInt();
                                    mys.insertNewScore(c,i);
                                    break;

                                case "3":
                                    System.out.println("The Average score of that student: ");
                                            break;
                                case "4":
                                    innerLoop = false;
                                    break;
                                default:
                                    System.out.println("i'm default " + selectInner);
                            }
                        }
                        System.out.println();
                    }
                    else {
                        System.out.println("Error please contact kon: ");}
                        myK = null;
                        break;
                case "8":
                    System.out.println("Show student by score range: ");
                    System.out.print("Please enter the minimum score you will like to search: ");
                    int minimum = scn.nextInt();
                    System.out.print("Please enter the maximum score you will like to search: ");
                    int maximum = scn.nextInt();

                    for (Person p : people){
                        if (p.getClass() ==Student.class){
                            Student s = (Student)p;
                            if (s.getAverageScore() <= maximum && s.getAverageScore() >= minimum){
                                System.out.println(p.toString());
                            }

                        }
                    }
                    break;
                case "9":
                    mainLoop = false;
                    break;
                default:
                    System.out.println("please enter number b/w 1-9 !");
            }
        }
    }

    private static void printSubMenu(){
        String menu;
    menu = "select a number to execute one of the following action: \n " +
            "1. to show all the scores of " + "\n " +
            "2. To insert a new course and score. " + "\n" +
            "3. To show Average scores of the student. " + "\n" +
            "4. To return to main Menu. " + " \n ";
        System.out.println(menu);

}
    private static void printMainMenu() {
        String menu= " Please type from  1-9 to execute. \n " +

                "1. Add Teacher - will read the user's input to create a new Teacher and add it to the list. \n " +
                "2. Add Student  - create a new student input and add to the list. \n " +
                "3. show all people - will be printed in the program(Teacher and Student). \n " +
                "4. To show All Teachers- will print all the teachers . \n " +
                "5. To Show all the students  - will print all the students info. \n " +
                "6. show Teacher by ID - will search and print a teach ID. \n " +
                "7. show Student by ID - will search and print a student ID. \n " +
                "8. show student by Score Range - print all student in a specific range \n " +
                "9. Quit - quit from the program. \n ";
        System.out.println(menu);

    }
    static Person searchById(LinkedList<Person> people, int id) {
        for (Person p : people){
            if (p.id ==id)return p;
        }
        return null;
        }
    private static void stubMenu(LinkedList<Person> people) {
        Teacher teacher = new Teacher(101,"jojo ","kon ",80,Status.MARRIED);
        people.add(teacher);
        teacher =new Teacher(202,"Levi ","Cohen ",7000, Status.SINGLE);
        people.add(teacher);

        teacher = new Teacher(203,"Gay ","Levi ",8000,Status.DIVORCED);
        people.add(teacher);
        teacher = new Teacher(204,"Naya ","kone ",9000,Status.UNKNOWN);
        people.add(teacher);

        Student student = new Student(303,"David ","Tawfig ", Status.UNKNOWN);
        student.insertNewScore("History ",90);//avg 90
        student.insertNewScore("History ",90);
        student.insertNewScore("History ",90);
        people.add(student);

        student = new Student(404, "Roi ","Tata ", Status.DIVORCED);
        student.insertNewScore("science ",89); //avg 92
        student.insertNewScore("science ",99);
        student.insertNewScore("science ", 87);
        people.add(student);

        student = new Student(505,"Adam ","Bob ", Status.SINGLE);
        student.insertNewScore("Social study ",80); //avg 80
        student.insertNewScore("Social study ", 80);
        student.insertNewScore("Social study ",80);
        people.add(student);

        student = new Student(606,"Peter ","Json ",Status.UNKNOWN);
        student.insertNewScore("English ",78); //avg 78
        student.insertNewScore("English ",78);
        student.insertNewScore("English ",78);
        people.add(student);



        //TODO!!
    }
}