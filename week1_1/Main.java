package week1_1;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
            Account user = new Account(0, getTime.outMonth(), 0, 0);
            String detail = "";
            int choice;
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("1. Deposit");
                System.out.println("2. Check Balance");
                System.out.println("3. Quit & Save Transition Detail");
                System.out.println("4. Import week1_1.Account Information");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.print("Enter the amount you want to save: ");
                    int amount = sc.nextInt();
                    detail = detail + user.savingAccount(amount);
                    System.out.println("Process Succeed");
                } else if (choice == 2) {
                    detail = detail + user.checkingAccount();
                } else if (choice == 3) {
                    IO.out(detail, "detail_"+ getTime.outTime() +".txt");
                    IO.out(user.output(), "info.in");
                    System.out.println("See you !");
                    break;
                } else if (choice == 4) {
                        String info;
                        info = IO.in();
                        String[] arr;
                        arr = info.split("\n");
                        user = new Account(Double.parseDouble(arr[0]), arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
                        System.out.println("Process Succeed");
                    } else {
                    System.out.println("Invalid input, try again");
                }


            }
    }
}