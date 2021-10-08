package Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;

public class BankingSystem {
    Scanner sc = new Scanner(System.in);
    String name;
    BigInteger mobileNo;
    String address;
    double withdraw;
    double deposit;
   final String IFSC = "SBIA05571";
    long accountNo;
    long typeAccountNo;
    double previousTransaction;
    ArrayList <Double> transaction =new ArrayList<>();
    int pin;
    double currentBalance = 0;

    void greeting() {
        System.out.println("***Welcome to the Bank Of Aurangabad***");
    }

    void welcome() {
        System.out.println("Choose the option from below:");
        System.out.println("1) Create Account \n2) Exit");
        int userInput = sc.nextInt();
        
        switch (userInput) {
            case 1:
                getData();
                break;
            case 2:
                System.out.println("Thank you ! visit again");
                break;
            default:
                System.out.println("*****PLEASE ENTER VALID INPUT*****");
                welcome();
        }
    }

    void getData() {
        System.out.println("---PLEASE ENTER YOUR NAME---");
        sc.nextLine();
        name = sc.nextLine();
        System.out.println("---PLEASE ENTER YOUR ADDRESS---");
        address = sc.nextLine();
        getNumber();
    }

    void getNumber() {
        System.out.println("PLEASE ENTER YOUR 10 DIGIT MOBILE NUMBER");
        mobileNo = sc.nextBigInteger();
        String c = String.valueOf(mobileNo);
        if (c.length() == 10) {
            System.out.println("YOUR MOBILE NUMBER IS UPDATED");
            getPin();
        } else {
            System.out.println("Enter valid mobile number");
            getNumber();
        }
    }

    void getPin() {
        System.out.println("ENTER YOUR 4 DIGIT PIN NUMBER FOR YOUR NEW BANK ACCOUNT");
        pin = sc.nextInt();
        String k = String.valueOf(pin);
        if (k.length() == 4) {
            System.out.println("Your Pin Is Generated");
            System.out.println("***DO NOT SHARE YOUR ATM PIN***");
            AccountInfo();
        } else {
            System.out.println("Invalid  Please Enter 4 Digit");
            getPin();
        }
    }

    void AccountInfo() {

        System.out.println(name + " Congratualations! Your bank account Successfully created ");
        System.out.println("your IFSC code is :" + IFSC);
        accountNo = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        System.out.println("Your AccountNo is :" + accountNo);
        transaction();
    }

    void transaction() {
        System.out.println("================================================================================");
        System.out.println("Choose the option from below:");
        System.out.println("================================================================================");
        System.out.println(
                "1)For Balance Check \n2)For Deposit\n3)For Withdraw Balance\n4)Account Info\n5)Previous Transaction\n6)For Pin Change\n7)For Exit");
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1:
                balanceCheck();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                display();
                break;
            case 5:
                previousTransaction();
            case 6:
                pinChange();
                break;
            case 7:
                System.out.println("Thank You! For using Our Service Visit Again");
                break;
        }
    }

    void balanceCheck() { // case 1
        System.out.println("Please Enter Your 4 Digit Password");
        int userInput = sc.nextInt();
        if (userInput == pin) {
            System.out.println("Your current balance is :" + currentBalance);
            repeat();
        } else {
            System.out.println("Please Enter Valid Password");
            balanceCheck();
        }
    }

    void repeat() {
        System.out.println("==============================================================");
        System.out.println("1)For continue\n2)For exit");
        int input = sc.nextInt();
        if (input == 1) {
            transaction();
        } else {
            System.out.println("Thank you! Visit Again");
        }

    }

    void deposit() { // case 2
        System.out.println("Enter the amount you want to deposit");
        deposit = sc.nextInt();
        System.out.println("Enter your 10 digit Account no");
        typeAccountNo = sc.nextLong();
        if (typeAccountNo == accountNo) {
            currentBalance = currentBalance + deposit;
            System.out.println(name + " Your amount is  successfully deposited");
            previousTransaction = +deposit;
            transaction.add(+deposit);
            repeat();
        } else {
            System.out.println("Please Enter Correct Account Number");
            deposit();
        }
    }

    void withdraw() { // case 3
        System.out.println("Enter Your 4 Digit Pin");
        int pass = sc.nextInt();
        if (pass == pin) {
            System.out.println("Please enter the withdrawal amount in multiple 100,200,500");
            withdraw = sc.nextInt();
            if (withdraw >= 100 && withdraw % 100 == 0 && withdraw <= currentBalance) {
                currentBalance = currentBalance - withdraw;
                previousTransaction = -withdraw;
                transaction.add(-withdraw);
                System.out.println(name + " your transaction succesfully processed");
                repeat();
            } else {
                System.out.println("Enter valid amount");
                withdraw();
            }
        } else {
            System.out.println("Please Enter Valid Pin");
            withdraw();
        }
    }

    void display() {
        System.out.println("Account Holder's Details is");
        System.out.println("Your Address is :" + address);
        System.out.println("Your Name is :" + name);
        System.out.println("Your Mobile Number is :" + mobileNo);
        System.out.println("Your Account Number is :" + accountNo);
        System.out.println("Your IFSC Code is :" + IFSC);
        System.out.println("Your Account Balance is :" + currentBalance);
        repeat();
    }

    void previousTransaction() {
        System.out.println("Enter your 4 digit Pin");
        int PIN = sc.nextInt();
        if (PIN == pin) {
            System.out.println("- denotes withdraw amount and + denotes deposit amount");
            System.out.println("Your previous transactions is "+transaction);
            // if (previousTransaction > 0) {
            //     System.out.println("Amount Deposited :" + previousTransaction);
                
            //     repeat();
            // } else if (previousTransaction < 0) {
            //     System.out.println("Amount Debited :" + Math.abs(previousTransaction));
            //     repeat();
            // } else {
            //     System.out.println("No transaction Occured");
            //     repeat();
            // }
        } else {
            System.out.println("Enter valid Pin");
            previousTransaction();
        }
    }

    void pinChange() {
        System.out.println("Please Enter old pin");
        int oldPin = sc.nextInt();
        if (oldPin == pin) {
            System.out.println("Enter new pin");
            int newPin = sc.nextInt();
            String leng = String.valueOf(newPin);
            if (leng.length() == 4) {
                System.out.println("Your Pin Is updated");
                pin = newPin;
                repeat();
            } else {
                System.out.println("Invalid  Please Enter 4 Digit");
                pinChange();
            }
        } else {
            System.out.println("You Entered Incorrect pin !please enter correct pin");
            pinChange();

        }
    }

    public static void main(String[] args) {
        BankingSystem BAO = new BankingSystem();
        BAO.greeting();
        BAO.welcome();
    }
}
