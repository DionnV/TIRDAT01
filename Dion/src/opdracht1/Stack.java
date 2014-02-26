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
    private Node _start;

    /** Lege constructor.
     * 
     */
    public Stack()
    {
        _size = 0;
        _start = null;
    }
    /**
     * Voeg student toe bovenop stapel, indien student de eerste is, wordt deze als start opgeslagen.
     * @param s De toe te voegen student.
     */
    public void push(Node s) {
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
    public Node pop() {
        if(_size > 0)
        {
            Node temp = _start;
            _start = _start.getNext();
            _size--;
            return temp;
        }
        return null;
    }

    /**
     * Controleert of de meegegeven student al in de stack staat op basis van studentnummer.
     * @param s De te controleren student.
     * @return True als student al bestaat, False als student nog niet gemaakt is.
     */
    public boolean peek(Node s) {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (s.getData().equals(tmp.getData())) {
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
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            tmp.toString();
        }
    }

    /**
     * Print alle mannen in de stack van begin naar eind.
     */
    public void printMen() {
        String g;
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            g = ((Student)tmp.getData()).getGeslacht();
            if (g.equalsIgnoreCase("m")) {
                ((Student)tmp.getData()).printStudent();
            }
        }
    }

    /**
     * Print alle vrouwen in de stack van begin naar eind.
     */
    public void printWoman() {
        String g;
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            g = ((Student)tmp.getData()).getGeslacht();
            if (g.equalsIgnoreCase("v")) {
                ((Student)tmp.getData()).printStudent();
            }
        }
    }   
}
