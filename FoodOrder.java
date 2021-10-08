package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodOrder extends BankingSystem {
    String feedback;
    int price = 0;
    double totalBill = 0;
    Scanner sc = new Scanner(System.in);
    ArrayList<Double> order = new ArrayList<>();

    public void greeting() {
        System.out.println("Welcome to Anna's Restaurant");
    }

    void repeatOrder() {
        System.out.println("Choose Option from below");
        System.out.println(
                "1)for add another vegfood in your order \n2)for add another nonveg food in your order \n3)  for place your order");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                vegFood();
                break;
            case 2:
                nonVegFood();
                break;
            case 3:
                totalBill();
                break;
            default:
                System.out.println("Enter valid option");
                repeatOrder();
                break;

        }
    }

BankingSystem bs = new BankingSystem();

    void totalBill() {
        System.out.println("Your Acc"+ bs.accountNo);
        System.out.println(order);
        for (int i = 0; i < order.size(); i++) {
            totalBill = totalBill + order.get(i);

        }
        System.out.println("your total bill is " + totalBill);
        
    }

    // @Override
    // void getName() {
    // System.out.println("Please Enter Account Holder's Name");
    // String userName = sc.nextLine();
    // if (userName == name) {
    // getPin();
    // } else {
    // System.out.println("Enter valid Name");
    // getName();

    // }
    // }

    // @Override
    // public void getPin() {
    // System.out.println("Please Enter Your 4 Digit Pin");
    // int userPin = sc.nextInt();
    // if (userPin == pin) {
    // order();
    // } else {
    // System.out.println("Enter Correct Pin");
    // getPin();
    // }

    // }

    public void order() {
        System.out.println("Choose the option from below ");
        System.out.println("1)For Veg Food\n2)For Non-veg Food");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                vegFood();
                break;
            case 2:
                nonVegFood();
                break;
            default:
                System.out.println("Please Enter valid Input");
        }
    }

    public void vegFood() {
        System.out.println("Choose meals from below");
        System.out.println("1Paneer Tikka(120Rs)\n2Paneer Palak(110)\n3Shevbhaji(80)\n4Misal Paav(50)");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                price = 120;
                System.out.println("Number of meals");
                int meals = sc.nextInt();
                double Price = price * meals;
                order.add(Price);
                repeatOrder();
                break;

            case 2:
                price = 110;
                System.out.println("Number of meals");
                int noOfDish = sc.nextInt();
                double totalRs = price * noOfDish;
                order.add(totalRs);
                repeatOrder();
                break;

            case 3:
                price = 80;
                System.out.println("Number of meals");
                int meal = sc.nextInt();
                double total = price * meal;
                order.add(total);
                repeatOrder();
                break;

            case 4:
                price = 50;
                System.out.println("Number of meals");
                int items = sc.nextInt();
                double totalPrice = items * price;
                order.add(totalPrice);
                repeatOrder();
                break;

            default:
                System.out.println("You entered wrong input! please Enter valid input");
                vegFood();
                break;
        }
    }

    public void nonVegFood() {
        System.out.println("Choose meals from below");
        System.out.println(
                "1 Chcken Tikka Masala(120Rs)\n2Chicken Biryani(110)\n3Chicken Kolhapuri(80)\n4Chicken thali(50)");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                price = 120;
                System.out.println("Number of meals");
                int meals = sc.nextInt();
                double Price = price * meals;
                order.add(Price);
                repeatOrder();
                break;

            case 2:
                price = 110;
                System.out.println("Number of meals");
                int noOfDish = sc.nextInt();
                double total = price * noOfDish;
                order.add(total);
                repeatOrder();
                break;

            case 3:
                price = 80;
                System.out.println("Number of meals");
                int meal = sc.nextInt();
                double totalRs = price * meal;
                order.add(totalRs);
                repeatOrder();
                break;

            case 4:
                price = 50;
                System.out.println("Number of meals");
                int quantity = sc.nextInt();
                double bill = price * quantity;
                order.add(bill);
                repeatOrder();
                break;

            default:
                System.out.println("You entered wrong input! please Enter valid input");
                nonVegFood();
                break;

        }
    }

    public static void main(String[] args) {
        FoodOrder Fo = new FoodOrder();
        Fo.greeting();
        Fo.order();
    }

}
