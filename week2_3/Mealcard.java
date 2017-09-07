package week2_3;

public class Mealcard {
    private int points = 0;
    Mealcard(){
        points = 100;
    }
    Mealcard(int points){
        this.points = points;
    }

    public void purchase(int topup){
        if(topup > 0){
            points = points + topup;
            System.out.println(points + " points left");
        }else System.out.println("Purchase amount cannot be negative");
    }
    public void buyMeal(int price){
        if(checkPoints(price)){
            points = points - price;
            System.out.println(points + " points left");
        }else {
            System.out.println("Your point is " + points + " you cannot buy a meal with price " + price + ", please purchase points");
        }
    }

    public boolean checkPoints(int price){
        if(points - price < 0){
            return false;
        }else return true;
    }
}
