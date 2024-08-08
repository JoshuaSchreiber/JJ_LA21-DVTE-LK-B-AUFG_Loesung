
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImpfzentrumVerwaltung {
    public static final int STRASSEN = 2;
    public static final int PERSONEN_TAG_STRASSE = 15;
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
            long timeDifferenceInMillies = datum.getTime() - personen.get(person).getImpfungen().getImpfTermin().getTime();
            long diffInDays = TimeUnit.DAYS.convert(timeDifferenceInMillies, TimeUnit.MILLISECONDS);
            if(diffInDays > 20){
                firstPriority.add(personen.get(person));
            } else {
                long age = datum.getTime() - personen.get(person).getGebDate().getTime();
                if(personen.get(person).isRisiko()){
                    age = age*2;
                }
                if(secondPriority.isEmpty()){
                    secondPriority.add(personen.get(person));
                }
                int i = 0;
                boolean added = false;
                while (i < secondPriority.size() && !added) {
                    long secondPriorityPositionAge = datum.getTime() - secondPriority.get(i).getGebDate().getTime();
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
            if(firstPriority.size()-1 >= i){
                impfListe.add(firstPriority.get(i));
            } else if(secondPriority.size()-1 >= i-firstPriority.size()){
                impfListe.add(secondPriority.get(i-firstPriority.size()));
            }
        }

        return impfListe;

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
