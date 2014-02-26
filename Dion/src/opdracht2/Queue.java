package opdracht2;

/**
 *
 * @author Dion
 */
public class Queue {
    
    private Node _start;
    private Node _end;
    private int _size;

    /**
     * Lege constructor.
     */
    public Queue(){
    _size = 0;
    _start = null;
    _end = null;
    }
    
    /** Constructor
     * 
     * @param args alle objecten voor in de queue.
     */
    public Queue(Object... args)
    {
        _size = 0;
        _start = null;
        _end = null;
        for(Object obj : args)
        {
            push(obj);
        }        
    }
    
    /**
     * Een student toevoegen aan de queue.
     * @param obj het object om toe te voegen.
     */
    public void push(Object obj){
        Node n = new Node(obj);
        if(_size == 0){
            _start = n;
            _end = n;
        } else {
            _end.setNext(n);
            n.setPrevious(_end);
            _end = n;
        }
        _size++;
    }
    /**
     * Geeft de grootte van de queue terug.
     * @return Int met de grootte van de queue.
     */
    public int size(){
        return _size;
    }
    
    /**
     * Verwijdert student vooraan in de queue.
     * @return De verwijderde student.
     */
    public Object pop(){
        Node tmp = _start;
        _start.getNext().setPrevious(null);
        _start=_start.getNext();
        tmp.setNext(null);
        _size--;
        return tmp.getData();
    }
    
    /**
     * Kijkt op basis van studentnummer of student al bestaat.
     * @param obj het object om toe te voegen.
     * @return True als student al bestaat, anders false.
     */
    public boolean peek(Object obj){
        for(Node tmp=_start; tmp != null; tmp = tmp.getNext()){
            if(obj.equals((tmp.getData()))){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Print gehele queue.
     */
    public void printQueue(){
        for(Node tmp = _start; tmp != null; tmp = tmp.getNext()){
            System.out.println(tmp.toString());
        }
    }
    /**
     * Print alle mannen in de queue
     */
    public void printMen(){
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (((Student)tmp.getData()).getGeslacht().toLowerCase().equals("m")) {
                System.out.println(tmp.toString());
            }
        }
    }
    /**
     * print alle vrouwen in de queue.
     */
    public void printWomen(){
        for (Node tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (((Student)tmp.getData()).getGeslacht().toLowerCase().equals("m")) {
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
