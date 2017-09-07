package week2_4;

import java.util.Random;

public class Fraction {
    private double numerator;
    private double denominator;

    Fraction(){
        Random numeratorR = new Random();
        Random denominatorR = new Random();
        numerator = Double.parseDouble(String.valueOf(numeratorR.nextInt(100)));
        denominator = Double.parseDouble(String.valueOf(denominatorR.nextInt(100) + 1));
    }

    public double getDenominator() {
        return denominator;
    }

    public double getNumerator() {
        return numerator;
    }


}
