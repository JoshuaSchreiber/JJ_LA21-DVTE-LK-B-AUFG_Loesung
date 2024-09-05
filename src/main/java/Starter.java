import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Starter {

    private static List<Person> personen;

    public static void number1s1(){
        Person person = new Person("77665;Müller;Klaus;31.12.1980;35334;Hausen;Teichweg 8;1");
        System.out.println(person.toString());
    }

    public static void number1s3() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         personen = new ArrayList<>();

        Date baseDate = dateFormat.parse("2024-08-08");
        Random random = new Random();

        personen.add(new Person(77666, "Schmidt", "Anna", dateFormat.parse("1990-05-20"), "10115", "Berlin", "Alexanderplatz 1", false, true, 1, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77667, "Schneider", "Paul", dateFormat.parse("1985-03-15"), "20095", "Hamburg", "Mönckebergstraße 10", false, false, 3, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77668, "Fischer", "Maria", dateFormat.parse("1992-07-10"), "80331", "München", "Marienplatz 5", true, true, 2, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77669, "Weber", "Hans", dateFormat.parse("1988-11-22"), "50667", "Köln", "Domkloster 4", false, false, 1, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77670, "Becker", "Lisa", dateFormat.parse("1995-09-30"), "60594", "Frankfurt am Main", "Zeil 1", true, true, 3, new Impfung(Helper.getRandomDate(baseDate, true, random))));

        personen.add(new Person(77671, "Hoffmann", "Markus", dateFormat.parse("1979-01-05"), "01067", "Dresden", "Prager Straße 2", false, false, 2, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77672, "Schäfer", "Sandra", dateFormat.parse("1983-04-18"), "04109", "Leipzig", "Augustusplatz 8", true, true, 1, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77673, "Bauer", "Thomas", dateFormat.parse("1991-12-11"), "52062", "Aachen", "Markt 12", true, false, 2, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77674, "Koch", "Julia", dateFormat.parse("1982-08-27"), "23552", "Lübeck", "Breite Straße 14", false, true, 3, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77675, "Richter", "Michael", dateFormat.parse("1994-02-14"), "70173", "Stuttgart", "Königstraße 1", true, false, 1, new Impfung(Helper.getRandomDate(baseDate, false, random))));

        personen.add(new Person(77676, "Klein", "Laura", dateFormat.parse("1987-06-07"), "49074", "Osnabrück", "Große Straße 16", false, true, 2, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77677, "Wolf", "Sven", dateFormat.parse("1976-09-21"), "60311", "Frankfurt am Main", "Goetheplatz 9", true, true, 3, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77678, "Schäfer", "Nina", dateFormat.parse("1993-11-30"), "10178", "Berlin", "Karl-Liebknecht-Straße 3", false, false, 1, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77679, "Krüger", "Florian", dateFormat.parse("1986-03-09"), "28203", "Bremen", "Schnoor 7", true, true, 2, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77680, "Mayer", "Simone", dateFormat.parse("1990-12-25"), "01069", "Dresden", "Altmarkt 6", false, false, 3, new Impfung(Helper.getRandomDate(baseDate, false, random))));

        personen.add(new Person(77681, "Fuchs", "Felix", dateFormat.parse("1981-10-14"), "45127", "Essen", "Kettwiger Straße 2", true, true, 1, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77682, "Peters", "Daniel", dateFormat.parse("1989-06-20"), "28195", "Bremen", "Domshof 8", false, false, 2, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77683, "Lang", "Sarah", dateFormat.parse("1978-05-03"), "34117", "Kassel", "Königsplatz 10", true, true, 3, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77684, "Weiß", "Tobias", dateFormat.parse("1996-08-11"), "66111", "Saarbrücken", "Bahnhofstraße 12", false, true, 1, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77685, "Zimmermann", "Jan", dateFormat.parse("1984-01-29"), "99084", "Erfurt", "Domplatz 4", true, false, 2, new Impfung(Helper.getRandomDate(baseDate, true, random))));

        personen.add(new Person(77686, "Braun", "Katharina", dateFormat.parse("1992-02-26"), "99084", "Erfurt", "Domplatz 4", true, false, 2, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77687, "Hartmann", "Alexander", dateFormat.parse("1983-11-19"), "46045", "Oberhausen", "CentrO 1", false, true, 1, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77688, "Lorenz", "Laura", dateFormat.parse("1991-05-07"), "80331", "München", "Viktualienmarkt 6", true, false, 3, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77689, "Franke", "Sebastian", dateFormat.parse("1980-04-23"), "40213", "Düsseldorf", "Königsallee 8", false, true, 2, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77690, "Albrecht", "Lena", dateFormat.parse("1987-09-15"), "60313", "Frankfurt am Main", "Fressgass 2", true, false, 1, new Impfung(Helper.getRandomDate(baseDate, true, random))));

        personen.add(new Person(77691, "Simon", "Nico", dateFormat.parse("1995-07-03"), "90402", "Nürnberg", "Hauptmarkt 3", false, true, 3, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77692, "Böhm", "Clara", dateFormat.parse("1993-03-17"), "01069", "Dresden", "Wilsdruffer Straße 5", true, true, 2, new Impfung(Helper.getRandomDate(baseDate, true, random))));
        personen.add(new Person(77693, "Brandt", "Hannah", dateFormat.parse("1984-12-05"), "14467", "Potsdam", "Brandenburger Straße 7", false, false, 1, new Impfung(Helper.getRandomDate(baseDate, false, random))));
        personen.add(new Person(77694, "Vogel", "Leon", dateFormat.parse("1977-06-02"), "50667", "Köln", "Hohe Straße 11", true, true, 3, new Impfung(Helper.getRandomDate(baseDate, true, random))));

        Date datum = dateFormat.parse("2024-08-08");
        ImpfzentrumVerwaltung impfzentrumVerwaltung = new ImpfzentrumVerwaltung(personen, new ArrayList<>());
        List<Person> einladungsListe = impfzentrumVerwaltung.einladen(datum);

        for(int i = 0; i < einladungsListe.size(); i++){
            System.out.println(i+1);

            int diffInDays = ImpfzentrumVerwaltung.getDiffInDays(datum, i, einladungsListe);
            System.out.println("Time since last Impfung: " + diffInDays);
            System.out.println("Last Impfung: " + einladungsListe.get(i).getImpfungen().getImpfTermin());

            long ageInMillis = datum.getTime() - einladungsListe.get(i).getGebDate().getTime();
            long ageInDays = TimeUnit.DAYS.convert(ageInMillis, TimeUnit.MILLISECONDS);
            System.out.println("Age in days: " + ageInDays + "  Risiko: " + einladungsListe.get(i).isRisiko());
            System.out.println("Birthday: " + einladungsListe.get(i).getGebDate());

            System.out.println();
            System.out.println();
        }
    }

    public static void number1s4(){
        Warteschlange warteschlange = new Warteschlange();
        Impfstrasse impfstrasse = new Impfstrasse(1, warteschlange);
        impfstrasse.getWarteschlange().hinzufuegen(personen.get(0));
        impfstrasse.getWarteschlange().hinzufuegen(personen.get(1));
        impfstrasse.getWarteschlange().hinzufuegen(personen.get(2));
        impfstrasse.getWarteschlange().hinzufuegen(personen.get(3));
        System.out.println("Diese Personen sind in der Warteschlange: " + warteschlange);
        warteschlange.entfernen();
        System.out.println("Diese Personen sind in der Warteschlange: " + warteschlange);
        warteschlange.loeschen(77667);
        System.out.println("Diese Personen sind in der Warteschlange: " + warteschlange);
    }

}
