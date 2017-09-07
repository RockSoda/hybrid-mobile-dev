package week2_4;



import java.util.Scanner;

public class Start {

    public static int limit;
    public static int[] getScore(boolean[] b, long[] t){
        int[] score = new int[5];
        for(int i = 0; i<score.length; i++){
            score[i] = 0;
        }

        for(int i = 0; i<b.length; i++){
            if(b[i]){
                if(t[i]<=limit){
                    score[0]++;
                }else score[1]++;
            }else if(t[i]<=limit){
                score[2]++;
            }else score[3]++;
        }

        score[4] = score[0]*10+score[1]*6+score[2]*3;
        return score;
    }


    public static void main(String[] args) {
        boolean[] result = new boolean[10];
        long[] time = new long[10];
        Scanner sc = new Scanner(System.in);

        while (true){
            String input;
            while (true){
                System.out.print("Do you want to set the time limit? If no the default time limit will be 30s (Y/N) ");
                input = sc.nextLine();
                if(!input.equalsIgnoreCase("N") && !input.equalsIgnoreCase("Y")){
                    System.out.println("Invalid Input");
                }else break;
            }
            if(input.equalsIgnoreCase("N")){
                limit = 30;
            }else if(input.equalsIgnoreCase("Y")){
                System.out.print("Input the time limit: ");
                input = sc.nextLine();
                limit = Integer.parseInt(input);
            }
            for(int i = 0; i<10; i++){
                System.out.println("Question "+(i+1));
                Fraction f1 = new Fraction();
                Fraction f2 = new Fraction();
                Question exercise = new Question(f1, f2);
                System.out.print(exercise.getOperater());
                long startTime = System.currentTimeMillis();
                input = sc.nextLine();
                long endTime   = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                result[i] = exercise.checkAns(input);
                time[i] = totalTime/1000;
            }
            int[] gradeList = getScore(result,time);
            System.out.println("Correct Answers and Under Time Limit : " + gradeList[0]);
            System.out.println("Correct Answers but Over Time Limit : " + gradeList[1]);
            System.out.println("Wrong Answers but Under Time Limit : " + gradeList[2]);
            System.out.println("Wrong Answers and Over Time Limit : " + gradeList[3]);
            System.out.println("Total Points :" + gradeList[4]);
            while (true){
                System.out.println("Restart?(Y/N)");
                input = sc.nextLine();
                if(!input.equalsIgnoreCase("N") && !input.equalsIgnoreCase("Y")){
                    System.out.println("Invalid Input");
                }else break;
            }
            if(input.equalsIgnoreCase("N")){
                System.out.println("See You");
                break;
            }else if(input.equalsIgnoreCase("Y")){
                System.out.println("Good Luck This Round");
            }
        }

    }
}