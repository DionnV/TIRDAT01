
package opdracht2;

/**
 * Een dynamische gesorteerde lijst op basis van studentnummer.
 * @author Dion
 */
public class SortedList {

    private Node _start;
    private Node _end;
    private int _size;

    /**
     * Lege constructor.
     */
    public SortedList(){
        _start = null;
        _end = null;
        _size = 0;
    }
    
    /**
     * Constructor waar studenten aan mee te geven zijn, die direct gepusht worden.
     * @param args De toe te pushen studenten.
     */
    public SortedList(Object... args){
        _start = null;
        _end = null;
        _size = 0;
        for(Object obj : args){
            push(obj);
        }
    }
    
    
    /**
     * Een student toevoegen aan de SortedList.
     * @param obj het object.
     */
    public void push(Object obj) {
        Node n = new Node(obj);
        if(_size==0){
            _start = n;
            _end= n;
        } else if(((Student)n.getData()).getStudentNummer()<((Student)_start.getData()).getStudentNummer()){
            _start.setPrevious(n);
            n.setNext(_start);
            _start = n;
        } else if(((Student)n.getData()).getStudentNummer()>((Student)_start.getData()).getStudentNummer()){
            n.setPrevious(_end);
            _end.setNext(n);
            _end = n;
        } else {
            Node tmp = _start;
            for(int i = ((Student)tmp.getData()).getStudentNummer();((Student)n.getData()).getStudentNummer()<i;i=((Student)tmp.getData()).getStudentNummer()){
                tmp = tmp.getNext();
            }
            tmp.getPrevious().setNext(n);
            n.setPrevious(tmp.getPrevious());
            tmp.setPrevious(n);
            n.setNext(tmp);        
        }
        _size++;
    }

    /**
     * Verwijdert student vooraan in de list.
     * @return De verwijderde student.
     */
    public Object head() {
        Node tmp = _start;
        tmp.getNext().setPrevious(null);
        _start = _start.getNext();
        _size--;
        return tmp.getData();
    }
    
    /**
     * Verwijdert de student achteraan in de list.
     * @return De verwijderde student.
     */
    public Object tail(){
        Node tmp = _end;
        tmp.getPrevious().setNext(null);
        _end = _end.getPrevious();
        _size--;
        return tmp.getData();
    }
    
    /**
     * Zoekt naar de meegegeven student en verwijdert deze indien gevonden.
     * @param obj het object.
     * @return De verwijderde student, of null indien niet gevonden.
     */
    public Object pop(Object obj){
        Node n = new Node(obj);
        Node tmp;
        for(tmp = _start; tmp!=null&&!tmp.equals(n);tmp = tmp.getNext()){}
        if(tmp==null){
            System.out.println("Student niet gevonden!");
            return null;
        } else {
            tmp.getPrevious().setNext(tmp.getNext());
            tmp.getNext().setPrevious(tmp.getPrevious());
            tmp.setPrevious(null);
            tmp.setNext(null);
            _size--;
            return tmp.getData();
        }
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
        } else if (index == 0 && _size == 1) {
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
            _end.getPrevious().setNext(null);
            _end = _end.getPrevious();
            _size--;
            return tmp;
        } else if(index>(_size-1)){
            System.out.println("De opgegeven index is leeg!");
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
     * Geeft de grootte van de SortedList terug.
     * @return Int met de grootte van de SortedList.
     */
    public int size() {
        return _size;
    }

    /**
     * Kijkt op basis van studentnummer of student al bestaat.
     * @param obj het te controleren object.
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
     * Print gehele SortedList.
     */
    public void printList() {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            System.out.println(tmp.toString());
        }
    }

    /**
     * Print alle mannen in de SortedList.
     */
    public void printMen() {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (((Student)tmp.getData()).getGeslacht().toLowerCase().equals("m")) {
                System.out.println(tmp.toString());
            }
        }
    }

    /**
     * print alle vrouwen in de SortedList.
     */
    public void printWomen() {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (((Student)tmp.getData()).getGeslacht().toLowerCase().equals("v")) {
                System.out.println(tmp.toString());
            }
        }
    }

    /**
     * @return geeft de student van vooraan uit de SortedList terug.
     */
    public Node getStart() {
        return _start;
    }

    /**
     * @return de student achterin de SortedList.
     */
    public Node getEnd() {
        return _end;
    }
}
