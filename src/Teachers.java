import java.util.Scanner;

class Teacher extends Person {

    private int wage;

    public Teacher(int id, String firstName, String lastName, int wage, Status status) {
        super(id, firstName, lastName, status);
        this.wage=wage;
    }

    @Override
    public Person input(int id, String firstName, String lastName, Status status) { //i modified protected  to public
        return null;
    }

    public Teacher(int id, String firstName, String lastName, int wage) { //here was commend out before
        super(id, firstName, lastName );
        this.wage = wage;
    }
    public Teacher(Scanner scn){
        super(scn);
    }


    @Override
    public String toString() {
        System.out.print("Teacher, ");
        return super.toString() + ", wage = " + this.wage;

    }

    @Override
    public void input(Scanner scn) {

        super.input(scn);
        System.out.println("please enter teacher monthly wage: ");
        this.wage =scn.nextInt();
    }

}


