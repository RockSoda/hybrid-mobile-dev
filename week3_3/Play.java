package week3_3;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] in = new int[3];
        FermiGame player = new FermiGame();
        while(true) {
            System.out.println("Guess the three numbers: ");
            for (int i = 0; i < in.length; i++) {
                in[i] = sc.nextInt();
                sc.nextLine();
            }
            player.setGuess(in);
            player.toString();
            String input;
            while (true) {
                System.out.println("\nOnce more ?(Y/N) ");
                input = sc.nextLine();
                if (!input.equalsIgnoreCase("N") && !input.equalsIgnoreCase("Y")) {
                    System.out.println("Invalid Input");
                } else break;;
            }
            if(input.equalsIgnoreCase("N")){
                System.out.println("See You");
                break;
            }

        }
    }
}
