package week2_4;

import java.util.Random;

public class Question {
    private Fraction frac1;
    private Fraction frac2;
    private int operater;
    private double ans;

    Question(Fraction frac1, Fraction frac2){
        this.frac1 = frac1;
        this.frac2 = frac2;
    }
    public String getOperater(){
        Random operaterR = new Random();
        operater = operaterR.nextInt(4);
        if(operater == 0){
            return add();
        }else if(operater == 1){
            return subtract();
        }else if(operater == 2){
            return divide();
        }else{
            return multiply();
        }
    }

    private String add(){
        calculate();
        return "("+frac1.getNumerator()+"/"+frac1.getDenominator()+")"+"+"+"("+frac2.getNumerator()+"/"+frac2.getDenominator()+")"+" = ";

    }
    private String subtract(){
        calculate();
        return "("+frac1.getNumerator()+"/"+frac1.getDenominator()+")"+"-"+"("+frac2.getNumerator()+"/"+frac2.getDenominator()+")"+" = ";

    }
    private String divide(){
        calculate();
        return "("+frac1.getNumerator()+"/"+frac1.getDenominator()+")"+"/"+"("+frac2.getNumerator()+"/"+frac2.getDenominator()+")"+" = ";

    }
    private String multiply(){
        calculate();
        return "("+frac1.getNumerator()+"/"+frac1.getDenominator()+")"+"*"+"("+frac2.getNumerator()+"/"+frac2.getDenominator()+")"+" = ";

    }

    private void calculate(){
        double answer;
        if(operater == 0){
            answer = (frac1.getNumerator()/frac1.getDenominator()) + (frac2.getNumerator()/frac2.getDenominator()) ;
        }else if(operater == 1){
            answer = (frac1.getNumerator()/frac1.getDenominator()) - (frac2.getNumerator()/frac2.getDenominator()) ;
        }else if (operater == 3){
            answer = (frac1.getNumerator()/frac1.getDenominator()) * (frac2.getNumerator()/frac2.getDenominator()) ;
        }else {
            answer = (frac1.getNumerator()/frac1.getDenominator()) / (frac2.getNumerator()/frac2.getDenominator()) ;
        }

        ans = answer/0.00001-(answer/0.00001%1);
    }

    private boolean checkInput(String ans){
        for(int i = 0; i<ans.length(); i++){
            if(ans.charAt(i) == '/'){
                return true;
            }
        }
        return false;
    }

    public boolean checkAns(String input){
        if(!checkInput(input)){
            input = input + "/1";
        }
        String[] nums;
        nums = input.split("/");
        double fracIn = Double.parseDouble(nums[0])/Double.parseDouble(nums[1]);
        return this.ans == fracIn/0.00001-(fracIn/0.00001%1);
    }


}
