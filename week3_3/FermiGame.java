package week3_3;

import java.util.Random;

public class FermiGame {
    private Random R = new Random();
    private int[] nums = new int[3];
    private int[] guess = new int[3];
    public FermiGame(){
        for(int i = 0; i<nums.length; i++){
            nums[i] = R.nextInt(9);
        }
    }

    private String[] hint(){
        String[] h = new String[3];
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length; j++){
                if(guess[i] == nums[j] && i == j){
                    h[i] = "Fermi";
                }else if(guess[i] == nums[j] && i != j && h[i] == null){
                    h[i] = "Pico";
                }
            }
            if(h[i] == null){
                h[i] = "Nano";
            }
        }
        bubbleSort(h);

        return h;
    }

    private String[] bubbleSort(String[] arr) {
        int n = arr.length;
        String temp = "";
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1].charAt(0) > arr[j].charAt(0)){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }

    public void setGuess(int[] guess){
        this.guess[0] = guess[0];
        this.guess[1] = guess[1];
        this.guess[2] = guess[2];
    }

    public String toString(){
        String[] STR = hint();
        for(int i = 0; i<nums.length; i++){
            System.out.print(STR[i] + " ");
        }

        return "";
    }

}
