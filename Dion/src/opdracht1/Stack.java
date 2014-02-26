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
     * @param obj het object om toe te voegen.
     */
    public void push(Object obj) {
        Node n = new Node(obj);
        if (_start == null) {
            _start = n;
        } else {
            n.setNext(_start);
            _start = n;
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
     * @param obj het object
     * @return True als student al bestaat, False als student nog niet gemaakt is.
     */
    public boolean peek(Object obj) {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (obj.equals(tmp.getData())) {
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
            System.out.println(tmp.toString());
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
