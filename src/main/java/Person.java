import java.util.Date;

public class Person {
    private int personenID;
    private String nachname;
    private String vorname;
    private Date gebDate;
    private String plz;
    private String ort;
    private String strasse; //besteht aus Straße und Hausnummer nach Beispiel des Klassendiagramms
    private boolean risiko;
    private boolean einverstaendnis;
    private int anzahlImpfungen;

    public Person(String contentCSVDatei){
        String[] parts = contentCSVDatei.split(";");
        personenID = Integer.parseInt(parts[0]);
        nachname = parts[1];
        vorname = parts[2];
        String[] dateParts = parts[3].split(".");
        gebDate = new Date(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
    }

    public String toString(){
        return personenID + " , " + nachname + " , " + vorname + " , " + gebDate.toString() + " , " + plz + " , " + ort + " , " + strasse + " , " + risiko + " , " + einverstaendnis + " , " + anzahlImpfungen;
    }

    public int getPersonenID() {
        return personenID;
    }

    public void setPersonenID(int personenID) {
        this.personenID = personenID;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGebDate() {
        return gebDate;
    }

    public void setGebDate(Date gebDate) {
        this.gebDate = gebDate;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public boolean isRisiko() {
        return risiko;
    }

    public void setRisiko(boolean risiko) {
        this.risiko = risiko;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public boolean isEinverstaendnis() {
        return einverstaendnis;
    }

    public void setEinverstaendnis(boolean einverstaendnis) {
        this.einverstaendnis = einverstaendnis;
    }

    public int getAnzahlImpfungen() {
        return anzahlImpfungen;
    }

    public void setAnzahlImpfungen(int anzahlImpfungen) {
        this.anzahlImpfungen = anzahlImpfungen;
    }
}
