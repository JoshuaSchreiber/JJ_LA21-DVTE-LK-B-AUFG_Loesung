import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImpfzentrumVerwaltung {
    public static final int STRASSEN = 10;
    public static final int PERSONEN_TAG_STRASSE = 100;
    private List<Person> personen;
    private List<Impfstrasse> strassen;

    public ImpfzentrumVerwaltung(List<Person> personen, List<Impfstrasse> strassen){
        this.personen = personen;
        this.strassen = strassen;
    }

    public List<Person> einladen(Date datum){
        int impfkapazitaet = STRASSEN * PERSONEN_TAG_STRASSE;
        List<Person> impfEinladungenListe = new ArrayList<>();
        for(int impfkandidat = 0; impfkandidat < impfkapazitaet; impfkandidat++){
            for(int person = 0; person < personen.size(); person++){

            }
        }
    }

    public List<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(List<Person> personen) {
        this.personen = personen;
    }

    public List<Impfstrasse> getStrassen() {
        return strassen;
    }

    public void setStrassen(List<Impfstrasse> strassen) {
        this.strassen = strassen;
    }
}
