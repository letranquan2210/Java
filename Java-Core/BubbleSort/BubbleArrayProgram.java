
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleArrayProgram {

    public static void main(String[] args) throws IOException {
        BubbleArray b = new BubbleArray();
        Scanner sc = new Scanner(System.in);
        double numberArray[] = null;

        Validator v = new Validator();
        while (true) {
            System.out.println("==========================");
            displayMenu();
            int choice = v.checkchoice("Your Choice: ");
            switch (choice) {
                case 1:
                    numberArray = b.inputArray();
                    break;
                case 2:
                    System.out.println("====Ascending====");
                    numberArray = b.bubbleSortAsc(numberArray);
                    b.displayArray(numberArray);
                    break;
                case 3:
                    System.out.println("====Descending====");
                    numberArray = b.bubbleSortDesc(numberArray);
                    b.displayArray(numberArray);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("1.	 Input items of the array\n"
                + "2.    Sort the array in ascending order\n"
                + "3.   Sort the array in descending order\n"
                + "4.   Exit"
        );
    }
}
