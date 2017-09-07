package week4_1;

import java.util.Date;

public class Visit {
    public Customer customer;
    public Date date;
    public double serviceExpense;
    public double productExpense;

    Visit(Customer customer, Date date){
        this.customer = customer;
        this.date = date;
    }

    public String getName(){
        return customer.getName();
    }

    public double getServiceExpense() {
        if(customer.isMember()){
            DiscountRate rate = new DiscountRate();
            double expense = serviceExpense*(1.0 - rate.getServiceDiscountRate(customer.getMemberType()));
            return expense;
        }else
            return serviceExpense;
    }

    public void setServiceExpense(double ex) {
        serviceExpense = ex;
    }

    public double getProductExpense() {
        if(customer.isMember()){
            DiscountRate rate = new DiscountRate();
            double expense = productExpense*(1.0 - rate.getProductDiscountRate(customer.getMemberType()));
            return expense;
        }else
            return productExpense;
    }

    public void setProductExpense(double ex) {
        productExpense = ex;
    }

    public double getTotalExpense(){
        return getProductExpense() + getServiceExpense();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
