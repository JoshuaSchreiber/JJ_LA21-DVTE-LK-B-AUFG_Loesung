
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImpfzentrumVerwaltung {
    public static final int STRASSEN = 2;
    public static final int PERSONEN_TAG_STRASSE = 13;
    private List<Person> personen;
    private List<Impfstrasse> strassen;

    public ImpfzentrumVerwaltung(List<Person> personen, List<Impfstrasse> strassen){
        this.personen = personen;
        this.strassen = strassen;
    }

    public List<Person> einladen(Date datum){



        // korigieren, segmentieren und kommentieren !!!



        int impfkapazitaet = STRASSEN * PERSONEN_TAG_STRASSE;
        List<Person> firstPriority = new ArrayList<>();
        List<Person> secondPriority = new ArrayList<>();

        for(int person = 0; person < personen.size(); person++){

            // Time sine last ImpfTermin
            int diffInDays = getDiffInDays(datum, person, personen);

            if(diffInDays > 20){
                firstPriority.add(personen.get(person));
            } else {
                long age = getAge(datum, personen.get(person));
                if(personen.get(person).isRisiko()){
                    age = age*2;
                }
                if(secondPriority.isEmpty()){
                    secondPriority.add(personen.get(person));
                }
                int i = 0;
                boolean added = false;
                while (i < secondPriority.size() && !added) {
                    long secondPriorityPositionAge = getAge(datum, secondPriority.get(i));
                    if (secondPriority.get(i).isRisiko()) {
                        secondPriorityPositionAge = secondPriorityPositionAge * 2;
                    }
                    if (secondPriorityPositionAge < age) {
                        secondPriority.add(i, personen.get(person));
                        added = true;
                    } else {
                        i++;
                    }
                }
                secondPriority.add(personen.get(person));
            }
        }

        List<Person> impfListe = new ArrayList<>();
        for(int i = 0; i < impfkapazitaet; i++){
            if(firstPriority.size() > i){
                impfListe.add(firstPriority.get(i));
            } else if (secondPriority.size() > i-firstPriority.size()){
                impfListe.add(i, secondPriority.get(i-firstPriority.size()));
            }
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
        Calendar today = Calendar.getInstance();

        Calendar hundredYearsAgo = Calendar.getInstance();
        hundredYearsAgo.add(Calendar.YEAR, -100);

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
