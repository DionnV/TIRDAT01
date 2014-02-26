package opdracht2;

/**
 *
 * @author BDion
 */
public class List {

    private Student _start;
    private Student _end;
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
    public void push(Student s, int index) {
        if (index == 0) {
            if (_start == null) {
                _start = s;
                _end = s;
            } else {
                Student tmp = _start;
                tmp.setPrev(s);
                _start = s;
                s.setNext(tmp);
            }
        } else if (index == _size || index > _size) {
            Student tmp = _end;
            tmp.setNext(s);
            _end = s;
            s.setPrev(tmp);
        } else {
            Student tmp = _start;
            for (int i = 0; i < (index - 1); i++) {
                tmp = tmp.getNext();
            }
            s.setNext(tmp.getNext());
            tmp.getNext().setPrev(s);
            tmp.setNext(s);
            s.setPrev(tmp);          
        }
        _size++;
    }

    /**
     * Verwijdert de student op de gegeven index.
     * @param index De index van te verwijderen student.
     * @return De verwijderde student.
     */
    public Student pop(int index) {
        if (_size == 0) {
            System.out.println("Lijst leeg!");
            return null;
        } else if (index == (_size - 1) && _size == 1) {
            Student tmp = _start;
            _start = null;
            _end = null;
            _size--;
            return tmp;
        } else if (index == 0) {
            Student tmp = _start;
            tmp.getNext().setPrev(null);
            _start = _start.getNext();
            _size--;
            return tmp;
        } else if (index == (_size - 1)) {
            Student tmp = _end;
            tmp.getPrev().setNext(null);
            _end = _end.getPrev();
            _size--;
            return tmp;
        } else if(index>(_size-1)){
            System.out.println("Index "+index+"is leeg!");
            return null;
        } else {
            Student tmp = _start;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            _size--;
            return tmp;
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
    public boolean peek(Student s) {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (s.getStudentNummer() == tmp.getStudentNummer()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print gehele queue.
     */
    public void printList() {
        for (Student tmp = _start; tmp!=null;tmp=tmp.getNext()) {
            tmp.printStudent();
        }
    }

    /**
     * Print alle mannen in de queue
     */
    public void printMen() {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht().equals("m")) {
                tmp.printStudent();
            }
        }
    }

    /**
     * print alle vrouwen in de queue.
     */
    public void printWomen() {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht().equals("v")){
                tmp.printStudent();
            }
        }
    }

    /**
     * @return geeft de student van vooraan uit de queue terug.
     */
    public Student getStart() {
        return _start;
    }

    /**
     * @return de student achterin de queue
     */
    public Student getEnd() {
        return _end;
    }
}
