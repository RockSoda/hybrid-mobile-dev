package week4_3;

public class Tally {
    public int cWord;
    public int inGuess;

    public void setcWord(int cWord) {
        this.cWord += cWord;
    }

    public void setInGuess(int inGuess) {
        this.inGuess += inGuess;
    }

    public int getcWord() {
        return cWord;
    }

    public int getInGuess() {
        return inGuess;
    }
}
