package week13_1;

public class Renter {
    private int renter = -1;
    private int type = -1;

    Renter(int renter, int type){
        this.renter = renter;
        this.type = type;
    }

    int getPoints(){

        switch (renter){

            case 1:switch (type){

                case 1:return 15;
                case 2: return 20;

            }
            case 2:switch (type){

                case 1:return 10;
                case 2:return 15;

            }
            case 3:switch (type){

                case 1:return 20;
                case 2:return 30;

            }
        }

        return -1;
    }
}
