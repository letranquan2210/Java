
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        generericDoctors gd = new generericDoctors();
        Scanner sc = new Scanner(System.in);

        Validate v = new Validate();
        while (true) {
            System.out.println("==========================");
            gd.display();
            displayMenu();
            int choice = v.checkchoice("Your Choice: ");
            switch (choice) {
                case 1:
                    gd.add();
                    break;
                case 2:
                    System.out.println("Enter a code to Update: ");
                    String codeUpdate = sc.nextLine();
                    gd.update(codeUpdate);
                    break;
                case 3:
                    System.out.println("Enter a code to Delete: ");
                    String codeDelete = sc.nextLine();
                    gd.delete(codeDelete);
                    break;
                case 4:
                    System.out.println("Enter a code to Search: ");
                    String codeSearch = sc.nextLine();
                    gd.search(codeSearch);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("=====Doctor Managament====:\n"
                + "1.Add doctor\n"
                + "2.Update doctor\n"
                + "3.Delete doctor\n"
                + "4.Search doctor\n"
                + "5.Exit\n"
        );
    }
}
