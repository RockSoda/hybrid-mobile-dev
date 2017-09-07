package week4_1;

public class DiscountRate {
    public static double serviceDiscountPremium = 0.2;
    public static double serviceDiscountGlod = 0.15;
    public static double serviceDiscountSilver = 0.1;

    public static double productDiscountPremium = 0.1;
    public static double productDiscountGlod = 0.1;
    public static double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type){
        if(type.equalsIgnoreCase("Premium")){
            return serviceDiscountPremium;
        }else if(type.equalsIgnoreCase("Gold")){
            return serviceDiscountGlod;
        }else if(type.equalsIgnoreCase("Silver")){
            return serviceDiscountSilver;
        }else{
            return 0.0;
        }
    }

    public static double getProductDiscountRate(String type){
        if(type.equalsIgnoreCase("Premium")){
            return productDiscountPremium;
        }else if(type.equalsIgnoreCase("Gold")){
            return productDiscountGlod;
        }else if(type.equalsIgnoreCase("Silver")){
            return productDiscountSilver;
        }else {
            return 0.0;
        }
    }


}
