
import java.util.*;

public class generericDoctors {

    Validate v = new Validate();
    private final List<Doctors> listDoctors;

    public generericDoctors() {
        listDoctors = new ArrayList<>();
    }

    public void add(Doctors d) {
        listDoctors.add(d);
    }

    public void add() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        System.out.print("Enter a list doctor numbers\n--------------------\n(1 - Continue,0 - exit) : ");
        String number = in.next();
        while (!number.equalsIgnoreCase("0")) {
            if (number.equalsIgnoreCase("1")) {
                System.out.print("Enter Code: ");
                String code = in.next();
                while (checkDupplicate(code) == true) {
                    System.out.println("Enter code again: ");
                    code = in.next();
                }

                System.out.print("Enter Name: ");
                String name = in.next();
                System.out.print("Enter Specialization: ");
                String spec = in.next();
                System.out.println("Enter Availability: ");
                int avai = v.checkInt("");
                listDoctors.add(new Doctors(code, name, spec, avai));
            }
            System.out.print("Enter a list doctor numbers\n--------------------\n(1 - Continue,0 - exit) :");
            number = in.next();
        }
    }

    public void display() {
        int n = listDoctors.size();
        for (int i = 0; i < n; i++) {
            Doctors d = listDoctors.get(i);
            System.out.printf("%-20s%-20s%-20s%-20s\n",d.getCode(),d.getName(),d.getSpec(),d.getAvai());
//            System.out.println(d.getCode() + "\t" + d.getName() + "\t" + d.getSpec() + "\t" + d.getAvai());
        }
    }

    public void delete(String remove) {
        boolean find = false;
        for (int i = 0; i < listDoctors.size(); i++) {
            if (listDoctors.get(i).getCode().equalsIgnoreCase(remove)) {
                find = true;
                listDoctors.remove(i);
            }
        }
        if (find == false) {
            System.out.println("Data is not exists so it is not delete");
        }
    }

    public void update(String updateCode) {
        Scanner sc = new Scanner(System.in);
        int n = listDoctors.size();
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Doctors d = listDoctors.get(i);
            if (d.getCode().equalsIgnoreCase(updateCode)) {
                find = true;
                delete(updateCode);
                System.out.print("Enter New Name: ");
                String nameNew = sc.next();
                System.out.print("Enter Specialization: ");
                String specNew = sc.next();
                System.out.println("Enter Availability: ");
                int avaiNew = v.checkInt("");
                listDoctors.add(new Doctors(updateCode, nameNew, specNew, avaiNew));
            }
        }
        if (find == false) {
            System.out.println("Data is not exists so it is not delete");
        }
    }

    public boolean checkDupplicate(String check) {
        int n = listDoctors.size();
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Doctors d = listDoctors.get(i);
            if (d.getCode().equalsIgnoreCase(check)) {
                find = true;
                System.out.println(check + " is exist in list");
                break;
            }
        }
        return find;
    }

    public void search(String name) {
        int n = listDoctors.size();
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Doctors d = listDoctors.get(i);
            if (d.getCode().equalsIgnoreCase(name)) {
                find = true;
                System.out.println(d.getCode() + "\t" + d.getName() + "\t" + d.getSpec() + "\t" + d.getAvai());
            }
        }
        if (find == false) {
            System.out.println("Given date is not exists");
        }

    }

}
