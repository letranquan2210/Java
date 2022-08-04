
public class StudentReport extends Student {

    private int totalJava;
    private int totalNet;
    private int totalC;

    public StudentReport() {
        totalJava = totalNet = totalC = 0;
    }

    public StudentReport(String id, int totalJava, int totalNet, int totalC) {
        super.getId();
        this.totalJava = totalJava;
        this.totalNet = totalNet;
        this.totalC = totalC;
    }

    public int getTotalJava() {
        return totalJava;
    }

    public void setTotalJava(int totalJava) {
        this.totalJava = totalJava;
    }

    public int getTotalNet() {
        return totalNet;
    }

    public void setTotalNet(int totalNet) {
        this.totalNet = totalNet;
    }

    public int getTotalC() {
        return totalC;
    }

    public void setTotalC(int totalC) {
        this.totalC = totalC;
    }

    @Override
    public String toString() {
        return String.format("%-20s/n%-20s%-20d\n%-20s%-20d\n%-20s%-20d\n", getName(), "Java", getTotalJava(), ".Net", getTotalNet(), "C/C++", getTotalC());
    }

    @Override
    public int compareTo(Student t) {
        return super.compareTo(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSemester(int semester) {
        super.setSemester(semester); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSemester() {
        return super.getSemester(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCourse(String course) {
        super.setCourse(course); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCourse() {
        return super.getCourse(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(String id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

}
