package week4_1;

import java.util.Date;

public class test {

    public static void main(String[] args) {
        Date date = new Date();
        Customer customer1 = new Customer("1");
        customer1.setMember(true);
        customer1.setMemberType("Gold");
        System.out.println(customer1.getMemberType());
        Visit c1 = new Visit(customer1, date);
        c1.setProductExpense(400);
        c1.setServiceExpense(300);
        System.out.println(c1.getProductExpense() + " " + c1.getServiceExpense() + " " + c1.getTotalExpense());

        Customer customer2 = new Customer("2");
        customer2.setMember(true);
        customer2.setMemberType("Premium");
        System.out.println(customer2.getMemberType());
        Visit c2 = new Visit(customer2, date);
        c2.setProductExpense(700);
        c2.setServiceExpense(300);




        System.out.println(c2.getProductExpense() + " " + c2.getServiceExpense() + " " + c2.getTotalExpense());


    }
}