
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    Validator v = new Validator();
    private final List<Student> listStudent;
    private final List<StudentReport> listStudentReport;

    public StudentManagement() {
        listStudent = new ArrayList<>();
        listStudentReport = new ArrayList<>();
    }

    public void add(Student s) {
        listStudent.add(s);
    }

    public void add(StudentReport sr) {
        listStudentReport.add(sr);
    }

    //add information of stundet
    public void create() throws IOException  {
        Scanner in = new Scanner(System.in);
        boolean addMore = false;
        do {
            do {
                System.out.println("Enter ID:");
                String id = v.checkString("");
                System.out.println("Enter name: ");
                String name = v.checkString("");
                do {
                    if (checkDupplicate(id, name) != -1) {
                        System.out.printf("ID [%s] is existed with Name [%s], please Enter again!\n",
                                listStudent.get(checkDupplicate(id, name)).getId(),
                                listStudent.get(checkDupplicate(id, name)).getName());
                        System.out.println("Enter ID:");
                        id = v.checkString("");
                        System.out.println("Enter name: ");
                        name = v.checkString("");
                    }
                } while (checkDupplicate(id, name) != -1);
                System.out.println("Enter course: ");
                String course = v.checkString("");
                do {
                    if (!course.equalsIgnoreCase("java") && !course.equalsIgnoreCase(".net") && !course.equalsIgnoreCase("C/C++")) {
                        System.out.println("There are only three courses: Java, .Net, C/C++). ");
                        course = v.checkString("");
                    }
                } while (!course.equalsIgnoreCase("java") && !course.equalsIgnoreCase(".net") && !course.equalsIgnoreCase("C/C++"));

                System.out.println("Enter semester: ");
                int semester = v.checkInt("");
                if (checkSameInfo(id, semester, course) == false) {
                    listStudent.add(new Student(id, name, course, semester));
                } else {
                    System.out.println("Student had existed in data, please enter again:\n");
                }
            } while (listStudent.size() < 3);
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
            String check = in.next();
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

    // 1 student only had 1 kind of course in 1 semester
    // Other hand, 1 student can learn all course in 1 semester
    public boolean checkSameInfo(String checkId, int checkSemester, String checkCourse) {
        boolean sameInfor = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equalsIgnoreCase(checkId) && listStudent.get(i).getSemester() == checkSemester && listStudent.get(i).getCourse().equalsIgnoreCase(checkCourse)) { //if same id, semester and course
                sameInfor = true;
                break;
            } else {
                sameInfor = false;
            }
        }
        return sameInfor;
    }

    public int checkDupplicate(String checkId, String checkName) {
        int n = listStudent.size();
        int Ret = -1;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            Student s = listStudent.get(i);
            if (s.getId().equalsIgnoreCase(checkId) && !s.getName().equalsIgnoreCase(checkName)) {
                find = true;
                Ret = i;
                break;
            }
        }
        return Ret;
    }

    public void displayStudent() {
        int n = listStudent.size();
        System.out.printf("%-20s%-20s%-10s%-10s\n", "ID", "Name", "Course", "Semester");
        for (int i = 0; i < n; i++) {
            Student s = listStudent.get(i);
            System.out.printf("%-20s%-20s%-10s%-10s\n", s.getId(), s.getName(), s.getCourse(), s.getSemester());
        }
    }

    public void search(String name) {
        int n = listStudent.size();
        boolean find = false;
        System.out.printf("%-20s%-20s%-10s%-10s\n", "ID", "Name", "Course", "Semester");
        for (int i = 0; i < n; i++) {
            Student s = listStudent.get(i);
            if (s.getName().equalsIgnoreCase(name)) {
                find = true;
                System.out.printf("%-10s%-20s%-10s%-10d\n", s.getId(), s.getName(), s.getCourse(), s.getSemester());;
                Comparator<Student> nameSort = new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return s.getName().compareToIgnoreCase(o1.getName());
                    }
                };
            }
        }
        if (find == false) {
            System.out.println("Name is not exists in data");
        }
    }

    public void deleteById(String remove) {
        boolean find = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equalsIgnoreCase(remove)) {
                find = true;
                listStudent.remove(i);
                System.out.printf("Delete id: [%s] is Successfull!", remove);
            }
        }
        if (find == false) {
            System.out.println("Data is not exists so it is not delete");
        }
    }

    public void updateById(String update) {
        Scanner sc = new Scanner(System.in);
        boolean find = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId().equals(update)) {
                find = true;
                System.out.println("Enter new name: ");
                String newName = v.checkString2("");
                if (!newName.equals("")) {
                    listStudent.get(i).setName(newName);
                }
                System.out.println("Enter new course: ");
                String newCourse = v.checkString2("");
                if (!newName.equals("")) {
                    listStudent.get(i).setCourse(newCourse);
                } else {
                    do {
                        if (!newCourse.equalsIgnoreCase("java") && !newCourse.equalsIgnoreCase(".net") && !newCourse.equalsIgnoreCase("C/C++")) {
                            System.out.println("There are only three courses: Java, .Net, C/C++). ");
                            newCourse = v.checkString("");
                        }
                    } while (!newCourse.equalsIgnoreCase("java") && !newCourse.equalsIgnoreCase(".net") && !newCourse.equalsIgnoreCase("C/C++"));
                }
                System.out.println("Enter new semester - Press 0 to skip:  ");
                int newSemester = v.checkInt("");
                if (newSemester != 0) {
                    listStudent.get(i).setSemester(newSemester);
                }
            }
        }
    }

    public void report() {
        System.out.println("========== Report Student ============");
        for (int i = 0; i < listStudent.size(); i++) {
            StudentReport sr = new StudentReport();
            sr.setId(listStudent.get(i).getId());
            if (sr.getCourse().equalsIgnoreCase("Java") == true) {
                sr.setTotalJava(sr.getTotalJava() + 1);
            } else if (sr.getCourse().equalsIgnoreCase(".Net") == true) {
                sr.setTotalNet(sr.getTotalNet() + 1);
            } else {
                sr.setTotalC(sr.getTotalC() + 1);
            }
            listStudentReport.add(sr);
        }
        //print out result
        for (int i = 0; i < listStudentReport.size(); i++) {
            System.out.println("Student: " + listStudentReport.get(i).getName());
            System.out.println("Java: " + listStudentReport.get(i).getTotalJava());
            System.out.println(".Net: " + listStudentReport.get(i).getTotalNet());
            System.out.println("C/C++: " + listStudentReport.get(i).getTotalC());
            System.out.println();
        }
    }

    //---------REPORT---------//
    public void report2() {
        boolean dupPer;
        System.out.println("-----------Report-----------");
        ArrayList<StudentReport> reportList = new ArrayList<>();
        //calculate total course
        for (int i = 0; i < listStudent.size(); i++) {
            StudentReport x = new StudentReport();
            x.setId(listStudent.get(i).getId());
            dupPer = checkRPList(x.getId(), reportList); //check if the id is already exist in report list
            if (dupPer == false) { //if that id is completely new the add it
                x.setName(listStudent.get(i).getName());
                x.setCourse(listStudent.get(i).getCourse());
                x.setSemester(listStudent.get(i).getSemester());
                x.setTotalJava(0);
                x.setTotalNet(0);
                x.setTotalC(0);
                if (x.getCourse().equalsIgnoreCase("Java") == true) {
                    x.setTotalJava(x.getTotalJava() + 1);
                } else if (x.getCourse().equalsIgnoreCase(".Net") == true) {
                    x.setTotalNet(x.getTotalNet() + 1);
                } else {
                    x.setTotalC(x.getTotalC() + 1);
                }
                reportList.add(x);
            } else { //if not then update the total count
                x.setCourse(listStudent.get(i).getCourse());
                for (int j = 0; j < reportList.size(); j++) {
                    if (x.getId().equalsIgnoreCase(reportList.get(j).getId()) == true) {
                        if (x.getCourse().equalsIgnoreCase("Java") == true) {
                            reportList.get(j).setTotalJava(reportList.get(j).getTotalJava() + 1);
                            break;
                        } else if (x.getCourse().equalsIgnoreCase(".Net") == true) {
                            reportList.get(j).setTotalNet(reportList.get(j).getTotalNet() + 1);
                            break;
                        } else {
                            reportList.get(j).setTotalC(reportList.get(j).getTotalC() + 1);
                            break;
                        }
                    }
                }
            }
        }
        //print out result
        for (int i = 0; i < reportList.size(); i++) {
            System.out.println("Student: " + reportList.get(i).getName());
            System.out.println("Java: " + reportList.get(i).getTotalJava());
            System.out.println(".Net: " + reportList.get(i).getTotalNet());
            System.out.println("C/C++: " + reportList.get(i).getTotalC());
            System.out.println();
        }
    }

    //CHECK FOR SAME PERSON IN REPORT LIST
    public boolean checkRPList(String id, ArrayList<StudentReport> reportList) {
        boolean dupPer = false;
        for (int i = 0; i < reportList.size(); i++) {
            if (id.equalsIgnoreCase(reportList.get(i).getId()) == true) {
                dupPer = true;
                break;
            } else {
                dupPer = false;
            }
        }
        return dupPer;
    }

}
