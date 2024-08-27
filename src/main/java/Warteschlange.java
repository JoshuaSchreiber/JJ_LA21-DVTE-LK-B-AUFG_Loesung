import java.util.LinkedList;
import java.util.Queue;

public class Warteschlange {
    private int anzahlPersonen;
    private static Queue<Person> queue;
    ;

    public Warteschlange() {
        this.queue = new LinkedList<>();
    }

    public void hinzufuegen(Person personNeu) {
        if (personNeu != null) {
            queue.add(personNeu);
        }
    }

    public Person entfernen() {
        if (!queue.isEmpty()) {
            Person person = queue.poll();
            return person;
        }
        return null;
    }

    public Person loeschen(int personenID) {
        if (!queue.isEmpty()) {
            Person person = null;
            for (Person p : queue) {
                if (p.getPersonenID() == personenID) {
                    person = p;
                    queue.remove(p);
                    break;
                }
            }
            return person;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person p : queue) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
