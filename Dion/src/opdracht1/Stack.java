package opdracht1;
/**
 * De stackmethode, een dynamische stack waar studenten in gaan.
 * @author Dion
 */
public class Stack {
    /**
     * Grootte van de stack.
     */
    private int _size;
    /**
     * De bovenste student, laatst toegevoegde
     */
    private Student _start;

    /**
     * Voeg student toe bovenop stapel, indien student de eerste is, wordt deze als start opgeslagen.
     * @param s De toe te voegen student.
     */
    public void push(Student s) {
        if (_start == null) {
            _start = s;
        } else {
            s.setNext(_start);
            _start = s;
        }
        _size++;
    }

    /**
     * Geeft de grootte van de stack terug.
     * @return Int van de stack.
     */
    public int size() {
        return _size;
    }

    /**
     * Doorloopt naar de voorlaatste student op de stack, en verwijdert de link naar de volgende.
     * @return De verwijderde student.
     */
    public Student pop() {
        Student temp = _start;
        _start = _start.getNext();
        _size--;
        return temp;
    }

    /**
     * Controleert of de meegegeven student al in de stack staat op basis van studentnummer.
     * @param s De te controleren student.
     * @return True als student al bestaat, False als student nog niet gemaakt is.
     */
    public boolean peek(Student s) {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (s.getStudentNummer() == tmp.getStudentNummer()) {
                return true;
            }
        }
        //Einde van de loop
        return false;
    }

    /**
     * Print de stack van de eerste student naar de laatste.
     */
    public void printStack() {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            tmp.printStudent();
        }
    }

    /**
     * Print alle mannen in de stack van begin naar eind.
     */
    public void printMen() {
        String g;
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            g = tmp.getGeslacht();
            if (g.equalsIgnoreCase("m")) {
                tmp.printStudent();
            }
        }
    }

    /**
     * Print alle vrouwen in de stack van begin naar eind.
     */
    public void printWoman() {
        String g;
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            g = tmp.getGeslacht();
            if (g.equalsIgnoreCase("v")) {
                tmp.printStudent();
            }
        }
    }
}
