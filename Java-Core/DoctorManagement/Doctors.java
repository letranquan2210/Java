
public class Doctors {

    private String code, name, spec;
    private int avai;

    public Doctors() {
        code = name = spec = "";
        avai = 0;
    }

    public Doctors(String code, String name, String spec, int avai) {
        this.code = code;
        this.name = name;
        this.spec = spec;
        this.avai = avai;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getAvai() {
        return avai;
    }

    public void setAvai(int avai) {
        this.avai = avai;
    }

}
