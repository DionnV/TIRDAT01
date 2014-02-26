package opdracht2;

/**
 *
 * @author BDion
 */
public class List {

    private Node _start;
    private Node _end;
    private int _size;
    
    /**
     * Constructor
     */
    public List(){
        _size = 0;
        _start = null;
        _end = null;
    }
    
    /**
     * Een student toevoegen aan de list op de opgegeven plaats.
     * @param s De toe te voegen student
     * @param index De index waar de student moet komen.
     */
    public void push(Object obj, int index) {
        Node n = new Node(obj);
        if (index == 0) {
            if (_start == null) {
                _start = n;
                _end = n;
            } else {
                Node tmp = _start;
                tmp.setPrevious(n);
                _start = n;
                n.setNext(tmp);
            }
        } else if (index == _size || index > _size) {
            Node tmp = _end;
            tmp.setNext(n);
            _end = n;
            n.setPrevious(tmp);
        } else {
            Node tmp = _start;
            for (int i = 0; i < (index - 1); i++) {
                tmp = tmp.getNext();
            }
            n.setNext(tmp.getNext());
            tmp.getNext().setPrevious(n);
            tmp.setNext(n);
            n.setPrevious(tmp);          
        }
        _size++;
    }

    /**
     * Verwijdert de student op de gegeven index.
     * @param index De index van te verwijderen student.
     * @return De verwijderde student.
     */
    public Object pop(int index) {
        if (_size == 0) {
            System.out.println("Lijst leeg!");
            return null;
        } else if (index == (_size - 1) && _size == 1) {
            Node tmp = _start;
            _start = null;
            _end = null;
            _size--;
            return tmp.getData();
        } else if (index == 0) {
            Node tmp = _start;
            tmp.getNext().setPrevious(null);
            _start = _start.getNext();
            _size--;
            return tmp.getData();
        } else if (index == (_size - 1)) {
            Node tmp = _end;
            tmp.getPrevious().setNext(null);
            _end = _end.getPrevious();
            _size--;
            return tmp.getData();
        } else if(index>(_size-1)){
            System.out.println("Index "+index+"is leeg!");
            return null;
        } else {
            Node tmp = _start;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            tmp.getPrevious().setNext(tmp.getNext());
            tmp.getNext().setPrevious(tmp.getPrevious());
            _size--;
            return tmp.getData();
        }
    }

    /**
     * Geeft de grootte van de queue terug.
     * @return Int met de grootte van de queue.
     */
    public int size() {
        return _size;
    }

    /**
     * Kijkt op basis van studentnummer of student al bestaat.
     * @param s De te controleren student.
     * @return True als student al bestaat, anders false.
     */
    public boolean peek(Object obj) {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (obj.equals(tmp.getData())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print gehele queue.
     */
    public void printList() {
        for (Node tmp = _start; tmp!=null;tmp=tmp.getNext()) {
            System.out.println(tmp.toString());
        }
    }

    /**
     * Print alle mannen in de queue
     */
    public void printMen() {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (((Student)tmp.getData()).getGeslacht().toLowerCase().equals("m")) {
                System.out.println(tmp.toString());
            }
        }
    }

    /**
     * print alle vrouwen in de queue.
     */
    public void printWomen() {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (((Student)tmp.getData()).getGeslacht().toLowerCase().equals("v")) {
                System.out.println(tmp.toString());
            }
        }
    }

    /**
     * @return geeft de student van vooraan uit de queue terug.
     */
    public Node getStart() {
        return _start;
    }

    /**
     * @return de student achterin de queue
     */
    public Node getEnd() {
        return _end;
    }
}
