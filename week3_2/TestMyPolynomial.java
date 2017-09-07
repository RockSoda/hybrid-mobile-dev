package week3_2;

public class TestMyPolynomial {

    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
        //MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
// Can also invoke with an array
        double[] coefficients = new double[]{1.2, 3.4, 5.6, 7.8};
        MyPolynomial p2 = new MyPolynomial(coefficients);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        //System.out.println(p1.add(p2));
        System.out.println(p1.multiply(p2));
    }
}