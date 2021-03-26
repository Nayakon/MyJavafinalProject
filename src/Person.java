import java.util.Scanner;

public abstract class Person {
    public int id;
    private String firstName;
    private String lastName;
    private Status status;

    public Person(int id, String firstName, String lastName,Status status) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    //mainn constructor
    public Person(int id, String firstName, String lastName) {

        this(id, firstName, lastName,Status.UNKNOWN);
        }

    protected abstract Person input(int id, String firstName, String lastName, Status status);

    //unknown status constructor
    public Person(Scanner scn){
        input(scn);
    }


        @Override
    public String toString() {
        StringBuilder mystr = new StringBuilder();
          mystr.append(  "id = " );
          mystr.append(this.id );
           mystr.append(", first name = " );
            mystr.append(this.firstName) ;
             mystr.append(  ", last name = ");
              mystr.append(  this.lastName );
               mystr.append( ", status = " );
               mystr.append(this.status);
        return mystr.toString();
    }


    private void input(int id, String firstName, String lastName) {

    }

    public Person(int id,String firstName) { //id and name constructor
        this.id = id;
        this.firstName=firstName;
    }


    void input(Scanner scn) {
        int x = 0;
        System.out.println("Enter first Name: ");
        this.firstName = scn.next();

        System.out.println("Enter last Name: ");
        this.lastName = scn.next();

        System.out.println("Enter id: ");
        this.id = scn.nextInt();

        while (!(x < 5 && x > 0)) {
            System.out.println("Please enter 1 for single | 2 for married | 3 for divorced | 4 Don't know! ");
            x = scn.nextInt();

            if (x < 5 && x > 0){
                switch (x){
                    case 1:
                        System.out.println("Single ");
                        break;
                    case 2:
                        System.out.println("Married");
                        break;
                    case 3:
                        System.out.println("Divorced");
                        break;
                    case 4:
                        System.out.println("Unknow");
                        break;
                    default:
                        System.out.println("???");

                }
            }
        }
    }


}


