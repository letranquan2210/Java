
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Caculator Program =====");
            int choice;
            do {
                System.out.println("1. Normal caculator ");
                System.out.println("2. BMI Caculator");
                System.out.println("3. Exit");
                choice = checkInput();
                switch (choice) {
                    case 1:
                        Ncal();
                        break;
                    case 2:
                        bmiCal();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.err.println("Invalid choice!!!");
                        break;
                }
            } while (choice > 3 || choice < 1);
        }
    }

    public static String operator() {
        String s;
        Scanner sc = new Scanner(System.in);
        while (true) {
            s = sc.next();
            if (s.matches("[*+-/=^]")) {
                break;
            } else {
                System.err.println("Please Input: + , - , * , / , ^");
            }
        }
        return s;
    }

    public static void Ncal() {
        double a, b;
        String operator;
        System.out.println("===== Normal Caculator =====");
        System.out.println("Enter a number: ");
        a = checkCal();
        do {
            System.out.println("Enter operator: ");
            operator = operator();
            if (operator.equals("=")) {
                System.out.println("Result: " + a);
                break;
            }
            System.out.println("Enter Number: ");
            b = checkCal();
            switch (operator) {
                case "+":
                    a = a + b;
                    break;
                case "-":
                    a = a - b;
                    break;
                case "*":
                    a = a * b;
                    break;
                case "/":
                    try {
                        if (b == 0) {
                            throw new ArithmeticException("Division by 0!!");
                        } else {
                            a = a / b;
                        }
                    } catch (ArithmeticException e) {
                        System.out.println("Division by 0!!");
                    }
                    break;
                case "^":
                    a = Math.pow(a, b);
                default:
                    break;
            }
            System.out.println("Memory: " + (a));

        } while (!operator.equals('='));
    }

    public static void bmiCal() {
        double w, h, bmi;
        System.out.println("===== BMI Caculator =====");
        System.out.println("Enter Weight(Kg): ");
        w = checkDouble();
        System.out.println("Enter Height(cm): ");
        h = checkDouble();
        bmi = w / ((h / 100) * (h / 100));
        System.out.println("BMI number: " + bmi);
        if (bmi < 19) {
            System.out.println("BMI status: Under-standard");
        } else if (bmi >= 19 && bmi < 25) {
            System.out.println("BMI status: Standard");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("BMI status: Overweight");
        } else if (bmi >= 30 && bmi < 40) {
            System.out.println("BMI status: Fat");
        } else if (bmi >= 40) {
            System.out.println("BMI status: very Fat");
        }
    }

    public static double checkDouble() {
        double d;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                String s = sc.next();
                d = Double.parseDouble(s);
                if (d < 0) {
                    System.err.println("Must be possitive number!!!");
                } else {
                    return d;
                }
            } catch (Exception e) {
                System.err.println("Must be a number!!");
            }
        } while (true);
    }

    public static double checkCal() {
        double d;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                String s = sc.next();
                d = Double.parseDouble(s);
                return d;
            } catch (Exception e) {
                System.err.println("Must be a number!!");
            }
        } while (true);
    }

    public static int checkInput() {
        int d;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                String s = sc.next();
                d = Integer.parseInt(s);
                return d;
            } catch (Exception e) {
                System.err.println("Must be a number!!");
            }
        } while (true);
    }
}
