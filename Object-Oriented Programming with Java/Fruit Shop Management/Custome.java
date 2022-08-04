
import java.util.ArrayList;

public class Custome extends ArrayList<Fruit> {

    private String customerName;
    private int total;

    public Custome() {
    }

    public Custome(String customerName, int total) {
        this.customerName = customerName;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
