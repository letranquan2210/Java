
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentProgram {

    public static void main(String[] args) throws IOException {
        ArrayList<Student> studentList = new ArrayList<>();
        StudentManagement s = new StudentManagement();
        Scanner sc = new Scanner(System.in);

        Validator v = new Validator();
        while (true) {
            System.out.println("==========================");
            displayMenu();
            int choice = v.checkchoice("Your Choice: ");
            switch (choice) {
                case 1:
                    s.create();
                    System.out.println("\n======================\n");
                    s.displayStudent();
                    System.out.println("\n======================\n");
                    break;
                case 2:
                    System.out.println("Enter name to Search: ");
                    String nameSearch = v.checkString("");
                    s.search(nameSearch);
                    break;
                case 3:
                    System.out.println("Enter ID to Update: ");
                    String idUpdate = v.checkString("");
                    s.updateById(idUpdate);
                    break;
                case 4:
                    s.report2();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit"
        );
    }
}
