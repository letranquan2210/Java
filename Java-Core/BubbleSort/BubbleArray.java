
public class BubbleArray {

    Validator v = new Validator();

    public double[] inputArray() {
        System.out.println("====Input Element====");
        //get array size
        int length = v.checkInt("");
        double[] arr = new double[length];

        //get array value
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter number %d:", i + 1);
            arr[i] = v.checkDouble("");
            System.out.println();
        }
        return arr;
    }

    //BUBBLESORT ASC
    public double[] bubbleSortAsc(double[] a) {
        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) { //check if the before number is bigger than the after
                        double temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("There is no value to sort");
        }
        return a;
    }
    //BUBBLESORT DESC

    public double[] bubbleSortDesc(double[] a) {
        try {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] < a[j]) { //check if the after number is bigger than the before
                        double temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("There is no value to sort");
        }
        return a;
    }

    //DISPLAY THE ARRAY
    public void displayArray(double[] a) {
        try {
            System.out.printf("[%f]", a[0]);
            for (int i = 1; i < a.length; i++) {
                System.out.printf("->[%f]", a[i]);
            }
            System.out.println();
        } catch (NullPointerException e) {

        }
    }
}
