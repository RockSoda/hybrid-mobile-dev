package week2_3;

public class TestMealcard {

    public static void main(String[] args) {
        Mealcard student1 = new Mealcard();
        student1.buyMeal(105);
        student1.purchase(1);
        student1.buyMeal(5);
        student1.purchase(6);
        student1.buyMeal(10);


        Mealcard student2 = new Mealcard(500);
        student2.buyMeal(400);
        student2.buyMeal(105);
        student2.purchase(1);
        student2.buyMeal(5);
        student2.purchase(6);
        student2.buyMeal(10);

    }
}