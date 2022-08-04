
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {

    Validator v = new Validator();
    private final List<Fruit> listFruit;

    public ShopManagement() {
        listFruit = new ArrayList<>();
    }

    //Check exis if it is dupplicate return i else return -1
    public int checkExisID(String checkID) {
        int n = listFruit.size();
        int ret = -1;
        for (int i = 0; i < n; i++) {
            Fruit f = listFruit.get(i);
            if (f.getId().equalsIgnoreCase(checkID)) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    public void createFruit() throws IOException {
        Scanner in = new Scanner(System.in);
        boolean addMore = false;
        do {
            System.out.println("Enter fruit id: ");
            String fruitID = v.checkString("");
            do {
                if (checkExisID(fruitID) != -1) {
                    System.out.println("Fruit id is existed, enter again: ");
                    fruitID = v.checkString("");
                }
            } while (checkExisID(fruitID) != -1);
            System.out.println("Enter fruit price:  ");
            double fruitPrice = v.checkDouble("");
            System.out.println("Enter fruit quantity:  ");
            int fruitquantity = v.checkInt("");
            System.out.println("Enter fruit origin:  ");
            String fruitOrigin = v.checkString("");
            addMore = ynVal();
        } while (addMore == true);
    }

    //VALIDATE Y/N QUESTION
    public boolean ynVal() throws IOException {
        Scanner in = new Scanner(System.in);
        boolean ynCheck;
        boolean addMore = false;
        do {
            System.out.print("Do you want to continue (Y/N) ? ");
            String check = v.checkString("");
            if (check.equalsIgnoreCase("y")) {          //if y then return to adding student
                ynCheck = true;
                addMore = true;
            } else if (check.equalsIgnoreCase("n")) {   //if n then end the function
                ynCheck = true;
                addMore = false;
                System.out.println();
            } else {
                System.out.println("Wrong input. Please enter Y or N only");
                ynCheck = false;
            }
        } while (ynCheck == false);
        return addMore;
    }

    //Display all fruit
    public void displayAllFruit() {
        System.out.printf("%-20s%-20s%-10s%-10s%-10s\n", "ID", "Name", "Origin", "Quantity", "Price");
        for (int i = 0; i < listFruit.size(); i++) {
            Fruit f = listFruit.get(i);
            System.out.printf("%-20s%-20s%-10s%-10d%-10.2f", f.getId(), f.getName(), f.getOrigin(), f.getQuantity(), f.getPrice());
        }
    }

    //Input customer  orther item
    public void customerShopping() throws IOException {
        boolean addMore = false;
        System.out.println("List of Fruit===========");
        displayAllFruit();
        System.out.println("===========================");
        do {
            System.out.println("Enter item: ");
            int item = v.checkInt("");
            do {
                if (item <= 0 || item > listFruit.size()) {
                    System.out.println("Your select item is out of range, enter again: ");
                    item = v.checkInt("");
                }
            } while (item <= 0 || item > listFruit.size());
            System.out.printf("your select: %s ", listFruit.get(checkExisID(Integer.toString(item))).getName());
            System.out.println("Please input quantity: ");
            int ortherQuantity = v.checkInt("");
            do {
                if (ortherQuantity > listFruit.get(checkExisID(Integer.toString(item))).getQuantity()) {
                    System.out.printf("Maximum of %s is %d,enter quantity again: ", listFruit.get(checkExisID(Integer.toString(item))).getName(), listFruit.get(checkExisID(Integer.toString(item))).getQuantity());
                    ortherQuantity = v.checkInt("");
                }
            } while (ortherQuantity > listFruit.get(checkExisID(Integer.toString(item))).getQuantity());
            if (listFruit.get(checkExisID(Integer.toString(item))).getQuantity() == 0) {
                listFruit.remove(listFruit.get(checkExisID(Integer.toString(item))).getQuantity());
            }
            addMore = ynVal();
        } while (addMore == true);

    }

}
