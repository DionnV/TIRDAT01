package opdracht2;

/**
 *
 * @author Dion
 */
public class Queue {
    
    private Student _start;
    private Student _end;
    private int _size;

    /**
     * Lege constructor.
     */
    public Queue(){
    _size = 0;
    _start = null;
    _end = null;
    }
    
    public Queue(Student... args)
    {
        _size = 0;
        _start = null;
        _end = null;
        for(Student s : args)
        {
            push(s);
        }        
    }
    
    /**
     * Een student toevoegen aan de queue.
     * @param s De toe te voegen student
     */
    public void push(Student s){
        if(_size == 0){
            _start = s;
            _end = s;
    //        size++;
        } else {
            _end.setNext(s);
            s.setPrev(_end);
            _end = s;
      //      size++;
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
    public Student pop(){
        Student temp = _start;
        _start.getNext().setPrev(null);
        _start=_start.getNext();
        temp.setNext(null);
        _size--;
        return temp;
    }
    
    /**
     * Kijkt op basis van studentnummer of student al bestaat.
     * @param s De te controleren student.
     * @return True als student al bestaat, anders false.
     */
    public boolean peek(Student s){
        for(Student tmp=_start; tmp != null; tmp = tmp.getNext()){
            if(s.getStudentNummer() == tmp.getStudentNummer()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Print gehele queue.
     */
    public void printQueue(){
        for(Student tmp = _start; tmp != null; tmp = tmp.getNext()){
            tmp.printStudent();
        }
    }
    /**
     * Print alle mannen in de queue
     */
    public void printMen(){
        for(Student tmp = _start; tmp != null; tmp = tmp.getNext()){
            if(tmp.getGeslacht()=="m")
                tmp.printStudent();
        }
    }
    /**
     * print alle vrouwen in de queue.
     */
    public void printWomen(){
        for(Student tmp = _start; tmp != null; tmp = tmp.getNext()){
            if(tmp.getGeslacht()=="v")
                tmp.printStudent();
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
