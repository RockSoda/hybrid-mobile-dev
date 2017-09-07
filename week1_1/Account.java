package week1_1;

public class Account {
    int counterSaving = 0;
    int counterChecking = 0;
    private double account = 0;
    String month = "";

    Account(double account, String month, int counterSaving, int counterChecking){
        this.account = account;
        this.month = month;
        this.counterSaving = counterSaving;
        this.counterChecking = counterChecking;
    }

    public void resetCounters(){
        if(!checkMonth()){
            counterSaving = 0;
            counterChecking = 0;
        }
    }

    public String savingAccount(double tmp){
        resetCounters();
        account = account + tmp;
        if(counterSaving >= 3){
            account = account - 1;
            System.out.println("Charge $1.0");
            counterSaving++;
            return "Saved $" + tmp + "\n" + "Charged $1.0" + "\n";
        }else{
            counterSaving++;
            return "Saved $" + tmp + "\n" + "Charged $0.0" + "\n";
        }
    }

    public String output(){
        return account + "\n" + getTime.outMonth() + "\n" + counterSaving + "\n" + counterChecking + "\n";
    }


    public String checkingAccount(){
        resetCounters();
        if(counterChecking < 20){
            account = account - 0.5;
            System.out.println("Charge $0.5");
            counterChecking++;
            System.out.println("Your balance is $" + account);
            return "Checked balance and Charged $0.5" + "\n" + "Your balance is $ " + account + "\n";
        }else{
            counterChecking++;
            System.out.println("Your balance is $" + account);
            return "Checked balance and Charged $0.0" + "\n" + "Your balance is $ " + account + "\n";
        }

    }


    public boolean checkMonth(){
        if(getTime.outMonth().equals(month)){
            return true;
        }else{
            return false;
        }
    }

}