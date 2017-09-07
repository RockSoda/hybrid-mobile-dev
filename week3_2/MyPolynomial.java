package week3_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyPolynomial {
    private double[] coefficients;
    private double[] coeffs;
    private int degree;
    public MyPolynomial(double... coeffs) { // varargs
        this.coeffs = coeffs; // varargs is treated as array
    }
    public MyPolynomial(String filename) {
        Scanner in = null;
        try {
            in = new Scanner(new File(filename)); // open file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        degree = in.nextInt(); // read the degree
        coefficients = new double[degree+1]; // allocate the array
        for (int i=0; i<coefficients.length; ++i) {
            coeffs[i] = in.nextDouble();
        }
    }
    public int getDegree(){
        return degree;
    }
    public String toString(){
        String str = "";
        for(int i = coeffs.length-1; i > 0; i--){
            str = str + coeffs[i] + "x^" + i + " + ";
        }
        return str + coeffs[0];
    }
    public double evaluate(double x){
        double ans = 0;
        for(int i = 0; i<coeffs.length; i++){
            ans = ans + coeffs[i] * Math.pow(x, i);
        }
        return ans;
    }
    public String add(MyPolynomial polynomial){
        if(polynomial.coeffs.length <= coeffs.length){
            for(int i=0; i<polynomial.coeffs.length; i++){
                coeffs[i] = coeffs[i] + polynomial.coeffs[i];
            }
            return toString();
        }else{
            for(int i=0; i<coeffs.length; i++){
                polynomial.coeffs[i] = coeffs[i] + polynomial.coeffs[i];
            }
            return polynomial.toString();
        }
    }

    public String multiply(MyPolynomial polynomial){
        double[] p = new double[coeffs.length * polynomial.coeffs.length];
        int[] c = new int[coeffs.length * polynomial.coeffs.length];
        int index = 0;
        if(polynomial.coeffs.length <= coeffs.length){
            for(int i=0; i<coeffs.length; i++) {
                for(int j=0; j<polynomial.coeffs.length; j++){
                    p[index] =  polynomial.coeffs[j] * coeffs[i];
                    c[index] = i+j;
                    index++;
                }
            }

        }else{
            for(int i=0; i<polynomial.coeffs.length; i++){
                for(int j=0; j<coeffs.length; j++){
                    p[index] =  polynomial.coeffs[i] * coeffs[j];
                    c[index] = i+j;
                    index++;
                }
            }

        }


        double[] ans = new double[c[c.length-1]+1];
        for(int i = 0; i<c.length; i++){
            ans[c[i]] += p[i];
        }

        coeffs = ans;
        return toString();
    }



}
