package week4_3;

import java.util.Scanner;

public class Play {
    public static Scanner sc = new Scanner(System.in);
    public static Tally tally = new Tally();
    public static ProcessHint aHint;
    public static boolean breaker = false;


    public static void menu() {
        String input;

        while (true) {
            System.out.println("Continue?");
            input = sc.nextLine();
            if (!input.equalsIgnoreCase("N") && !input.equalsIgnoreCase("Y")) {
                System.out.println("Invalid Input");
            } else break;
        }

            if (input.equalsIgnoreCase("N")) {
                System.out.println("Tally:");
                System.out.print("Words you guessed correctly: " + tally.getcWord() + "\n");
                System.out.print("Incorrect guesses you made for all games: " + tally.getInGuess());
                breaker = true;
            } else if (input.equalsIgnoreCase("Y")) {
                System.out.println("Good Luck This Round");
            }

    }


    public static void main(String[] args) {
        while (true) {
            aHint = new ProcessHint();
            System.out.println(aHint);
            while (true) {
                String input = sc.nextLine();
                aHint.setInput(input);
                System.out.println(aHint);
                if (aHint.checkWin()) {
                    System.out.println("Bingo! You won.");
                    tally.setcWord(1);
                    tally.setInGuess(aHint.getCounter());
                    menu();
                    break;
                }
                if (aHint.getCounter() == 10) {
                    System.out.println("Sorry, You lost.");
                    tally.setInGuess(aHint.getCounter());
                    menu();
                    break;
                }
            }
            if(breaker) {
                break;
            }
        }
    }
}