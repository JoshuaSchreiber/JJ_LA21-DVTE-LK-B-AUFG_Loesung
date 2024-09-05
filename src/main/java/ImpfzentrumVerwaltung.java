
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImpfzentrumVerwaltung {
    public static final int STRASSEN = 2;
    public static final int PERSONEN_TAG_STRASSE = 17;
    private List<Person> personen;
    private List<Impfstrasse> strassen;

    public ImpfzentrumVerwaltung(List<Person> personen, List<Impfstrasse> strassen){
        this.personen = personen;
        this.strassen = strassen;
    }

    public List<Person> einladen(Date datum){

        // Gesamt Impfkapazität am Tag
        int impfkapazitaet = STRASSEN * PERSONEN_TAG_STRASSE;

        // Lehre Listen für 1. und 2. Priorität
        List<Person> firstPriority = new ArrayList<>();
        List<Person> secondPriority = new ArrayList<>();

        // Alle Personen durchlaufen
        for(int person = 0; person < personen.size(); person++){

            // Zeit seit letztem Impftermin feststellen
            int diffInDays = getDiffInDays(datum, person, personen);

            // Wenn die 1. Impfung mehr als 20 Tage zurückliegt gehört die Person zur 1. Priorität
            if(diffInDays > 20){
                firstPriority.add(personen.get(person));

            // Wenn die Person nicht zur 1. Priorität gehört ordner nach zweiter Priorität
            } else {

                // Alter der Person festellen
                long age = getAge(datum, personen.get(person));

                // Alter verdoppeln, wenn die Person in einer Risikogruppe ist
                if(personen.get(person).isRisiko()){
                    age = age*2;
                }

                // Wenn die Liste für die zweite Priorität noch leer ist einfach so hinzufügen
                if(secondPriority.isEmpty()){
                    secondPriority.add(personen.get(person));

                // Wenn die Liste für die zweite Priorität nicht leer ist einordnen
                } else {

                    // Solange Elemente in der Liste ist und das Element noch nicht hinzugefügt wurde
                    int i = 0;
                    boolean added = false;
                    while (i < secondPriority.size() && !added) {

                        long secondPriorityPositionAge = getAge(datum, secondPriority.get(i));

                        // Auch Element der Liste mit dem gerade verglichen wird muss im Risiko Fall mit doppeltem Alter berechnet werden
                        if (secondPriority.get(i).isRisiko()) {
                            secondPriorityPositionAge = secondPriorityPositionAge * 2;
                        }

                        // Vergleichen und an der angegebenen Stelle hinzufügen notieren
                        if (secondPriorityPositionAge < age) {
                            secondPriority.add(i, personen.get(person));
                            added = true;

                        // Wenn noch nicht hinzugefügt für nächste Runde auf neue Stelle testen
                        } else {
                            i++;
                        }
                    }

                    //SecondPriority hinzufügen
                    secondPriority.add(personen.get(person));
                }
            }
        }


        // How many persons can be added to the list?
        int personCountToAdd = 0;
        if(impfkapazitaet > personen.size()){
            personCountToAdd = personen.size();
        } else{
            personCountToAdd = impfkapazitaet;
        }

        // Erste und Zweite Impfliste nacheinander solange adden wie die Gesamte Tageskapazität noch nicht erreicht ist
        List<Person> impfListe = new ArrayList<>();
        for(int i = 0; i < personCountToAdd; i++){
            if(firstPriority.size() > i){
                impfListe.add(firstPriority.get(i));
            } else if (secondPriority.size() > i-firstPriority.size()){
                impfListe.add(i, secondPriority.get(i-firstPriority.size()));
            }
        }
        for(int i = 0; i < impfListe.size(); i++){
            System.out.println(impfListe.get(i).isRisiko());
        }

        return impfListe;

    }

    public static int getDiffInDays(Date datum, int personNumber, List<Person> personen){
        long timeDifferenceInMillies = datum.getTime() - personen.get(personNumber).getImpfungen().getImpfTermin().getTime();
        long diffInDays = TimeUnit.DAYS.convert(timeDifferenceInMillies, TimeUnit.MILLISECONDS);
        return (int)diffInDays;
    }

    public static long getAge(Date datum, Person person){
        long age = datum.getTime() - person.getGebDate().getTime();
        return age;
    }

    public static boolean pruefeDatum(Date date) {

        // Nicht echte Methode, die musste man nur als Struktogramm implementieren
        Calendar today = Calendar.getInstance();

        Calendar hundredYearsAgo = Calendar.getInstance();
        hundredYearsAgo.add(Calendar.YEAR, -150);

        return date.after(hundredYearsAgo.getTime()) && date.before(today.getTime());
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
