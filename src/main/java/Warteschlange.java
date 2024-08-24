import java.util.LinkedList;
import java.util.Queue;

public class Warteschlange {
    private int anzahlPersonen;
    private Queue<Person> queue;
    ;
    public Warteschlange(){
        this.personen = new LinkedList<>();
    }

    public void hinzufuegen(Person personNeu){
        if (Person != null) {
            queue.add(Person);
            System.out.println(person.getName() + " wurde zur Warteschlange hinzugefügt.");
        } else {
            System.out.println("Es kann nur eine gültige Person zur Warteschlange hinzugefügt werden.");
        }
    }

    public Person entfernen(){
        return null;
    }

    public Person löschen(){
        return null;
    }
}
