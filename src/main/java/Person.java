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

        System.out.println(personenID + nachname + vorname);
        System.out.println(gebDate);
    }
}
