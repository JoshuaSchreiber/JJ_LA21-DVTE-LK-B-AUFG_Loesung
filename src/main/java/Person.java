import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Person {
    private int personenID;
    private String nachname;
    private String vorname;
    private Date gebDate;
    private String plz;
    private String ort;
    private String strasse;
    private String hausnummer;
    private boolean risiko;
    private boolean einverstaendnis;
    private int anzahlImpfungen;
    private Impfung impfungen;

    public Person(String contentCSVDatei){
        //String in Array zerlegen
        String[] parts = contentCSVDatei.split(";");

        //personenID, nachname, vorname zuweisen
        personenID = Integer.parseInt(parts[0]);
        nachname = parts[1];
        vorname = parts[2];

        // Date validieren und zuweisen
        String dateStr = parts[3];
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            //Testen, ob Datum valide ist (in den letzten 150 Jahren)
            gebDate = formatter.parse(dateStr);
            if(!ImpfzentrumVerwaltung.pruefeDatum(gebDate)){
                gebDate = null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // plz und ort zuweisen
        plz = parts[4];
        ort = parts[5];

        // Straße und Hausnummer aufteilen und zuweisen
        String[] ortUndHausnummer = parts[6].split(" ");
        strasse = ortUndHausnummer[0];
        hausnummer = ortUndHausnummer[1];

        // Risiko zuweisen
        if(Objects.equals(parts[7], "1")){
            risiko = true;
        } else{
            risiko = false;
        }

    }

    public Person(int personenID, String nachname, String vorname, Date gebDate, String plz, String ort, String strasse, boolean risiko, boolean einverstaendnis, int anzahlImpfungen, Impfung impfungen) {
        this.personenID = personenID;
        this.nachname = nachname;
        this.vorname = vorname;
        this.gebDate = gebDate;
        this.plz = plz;
        this.ort = ort;
        this.strasse = strasse;
        this.risiko = risiko;
        this.einverstaendnis = einverstaendnis;
        this.anzahlImpfungen = anzahlImpfungen;
        this.impfungen = impfungen;
    }

    public String toString(){
        return personenID + " , " + nachname + " , " + vorname + " , " + gebDate.toString() + " , " + plz + " , " + ort + " , " + strasse + " , " + hausnummer + " , " + risiko + " , " + einverstaendnis + " , " + anzahlImpfungen;
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

    public Impfung getImpfungen() {
        return impfungen;
    }

    public void setImpfungen(Impfung impfungen) {
        this.impfungen = impfungen;
    }
}
