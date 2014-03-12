
package opdracht2;

/**
 * Een dynamische gesorteerde lijst op basis van studentnummer.
 * @author Dion
 * @param <T> het type van het object. 
 */
public class SortedList<T> {

    private Node _start;
    private Node _end;
    private int _size;

    /**
     * Lege constructor.
     */
    public SortedList(){
    }
    
    /**
     * Constructor waar studenten aan mee te geven zijn, die direct gepusht worden.
     * @param args De toe te pushen studenten.
     */
    public SortedList(T... args){
        _start = null;
        _end = null;
        _size = 0;
        for(T t : args){
            push(t);
        }
    }
    
    
    /**
     * Een student toevoegen aan de SortedList.
     * @param t het object.
     */
    public boolean push(T t) {
        Node n = new Node(t);
        if(!(t instanceof Student))
        {
            //Andere objecten worden hier gesorteerd
            //Niet nodig voor deze opdracht
        }
        if(t instanceof Student)
        {
            if(_size==0){
                _start = n;
                _end= n;
            } else if(n.getData().hashCode()<_start.getData().hashCode()){
                _start.setPrevious(n);
                n.setNext(_start);
                _start = n;
            } else if(n.getData().hashCode()>_end.getData().hashCode()){
                n.setPrevious(_end);
                _end.setNext(n);
                _end = n;
            } else {
                Node tmp = _start;
                for(int i = tmp.getData().hashCode();n.getData().hashCode()<i;i=tmp.getData().hashCode()){
                    tmp = tmp.getNext();
                }
                tmp.getPrevious().setNext(n);
                n.setPrevious(tmp.getPrevious());
                tmp.setPrevious(n);
                n.setNext(tmp);        
            }            
        }
        _size++;
        return true;       
    }

    /**
     * Verwijdert student vooraan in de list.
     * @return De verwijderde student.
     */
    public Object head() {
        if(_start != null)
        {
            Node tmp = _start;
            tmp.getNext().setPrevious(null);
            _start = _start.getNext();
            _size--;
            return tmp.getData();
        }
        return null;
    }
    
    /**
     * Verwijdert de student achteraan in de list.
     * @return De verwijderde student.
     */
    public Object tail(){
        if(_end != null)
        {
            Node tmp = _end;
            tmp.getPrevious().setNext(null);
            _end = _end.getPrevious();
            _size--;
            return tmp.getData();
        }
        return null;
    }
    
    /**
     * Zoekt naar de meegegeven student en verwijdert deze indien gevonden.
     * @param t het object.
     * @return De verwijderde student, of null indien niet gevonden.
     */
    public Object pop(T t){
        Node n = new Node(t);
        Node tmp;
        for(tmp = _start; tmp!=null&&!(tmp.getData()).equals(n.getData());tmp = tmp.getNext()){}
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
     * @param t het te controleren object.
     * @return True als student al bestaat, anders false.
     */
    public boolean peek(T t) {
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (t.equals(tmp.getData())) {
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
