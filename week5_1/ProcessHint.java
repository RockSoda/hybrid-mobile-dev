package week5_1;

public class ProcessHint {
    Word WordList = new Word();
    public String hiddenWord;
    private String[] theHint;
    public String input;
    public int counter = 0;
    private String previousInput = "aa";

    ProcessHint(){
        hiddenWord = WordList.getTheWord();
        theHint = new String[hiddenWord.length()];
        for(int i = 0; i<hiddenWord.length(); i++){
            theHint[i] = "_";
        }
    }

    public int getCounter() {
        return counter;
    }

    public boolean checkWin(){
        boolean check = true;
        for(int i = 0; i<theHint.length; i++){
            if(theHint[i].equals("_")){
                check = false;
            }
        }

        return check;

    }

    public void setInput(String input){
        this.input = input;
        checkWord();
    }

    private void checkWord(){
        boolean check = false;

        if(input.length() != 1 || (input.charAt(0)<'A'||input.charAt(0)>'z'||(input.charAt(0)>'Z'&&input.charAt(0)<'a'))){
            System.out.println("Invalid Input");
        }else {
            for(int i = 0; i<hiddenWord.length(); i++){
                if(hiddenWord.substring(i,i+1).equalsIgnoreCase(input)){
                    theHint[i] = input;
                    check = true;
                }
            }

            if(!check && !input.equalsIgnoreCase(previousInput)){
                counter++;
                previousInput = input;
            }
        }
    }

    public String toString() {
        String str = "";
        for(int i = 0; i<theHint.length; i++){
            str += theHint[i] + " ";
        }
        return str;
    }

}
