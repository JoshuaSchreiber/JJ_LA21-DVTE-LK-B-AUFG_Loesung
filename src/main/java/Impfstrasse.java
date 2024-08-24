public class Impfstrasse {
    private final Warteschlange warteschlange;
    private int strassenNr;

    public Impfstrasse(int nr, Warteschlange warteschlange){
        this.strassenNr = nr;
        this.warteschlange = warteschlange;
    }

    public Warteschlange getWarteschlange() {
        return warteschlange;
    }

    public int getStrassenNr() {
        return strassenNr;
    }

    public void setStrassenNr(int strassenNr) {
        this.strassenNr = strassenNr;
    }
}
