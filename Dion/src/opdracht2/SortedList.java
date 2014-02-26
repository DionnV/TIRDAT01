/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht2;

/**
 * Een dynamische gesorteerde lijst op basis van studentnummer.
 * @author Bart
 */
public class SortedList {

    private Student _start;
    private Student _end;
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
    public SortedList(Student... args){
        _start = null;
        _end = null;
        _size = 0;
        for(Student s : args){
            push(s);
        }
    }
    
    
    /**
     * Een student toevoegen aan de SortedList.
     * @param s De toe te voegen student
     */
    public void push(Student s) {
        if(_size==0){
            _start = s;
            _end= s;
        } else if(s.getStudentNummer()<_start.getStudentNummer()){
            _start.setPrev(s);
            s.setNext(_start);
            _start = s;
        } else if(s.getStudentNummer()>_end.getStudentNummer()){
            s.setPrev(_end);
            _end.setNext(s);
            _end = s;
        } else {
            Student tmp = _start;
            for(int i = tmp.getStudentNummer();s.getStudentNummer()<i;i=tmp.getStudentNummer()){
                tmp = tmp.getNext();
            }
            tmp.getPrev().setNext(s);
            s.setPrev(tmp.getPrev());
            tmp.setPrev(s);
            s.setNext(tmp);
            
        }
        _size++;
    }

    /**
     * Verwijdert student vooraan in de list.
     * @return De verwijderde student.
     */
    public Student head() {
        Student tmp = _start;
        tmp.getNext().setPrev(null);
        _start = _start.getNext();
        _size--;
        return tmp;
    }
    
    /**
     * Verwijdert de student achteraan in de list.
     * @return De verwijderde student.
     */
    public Student tail(){
        Student tmp = _end;
        tmp.getPrev().setNext(null);
        _end = _end.getPrev();
        _size--;
        return tmp;
    }
    
    /**
     * Zoekt naar de meegegeven student en verwijdert deze indien gevonden.
     * @param s De te verwijderen student
     * @return De verwijderde student, of null indien niet gevonden.
     */
    public Student pop(Student s){
        Student tmp;
        for(tmp = _start; tmp!=s&&tmp!=null;tmp = tmp.getNext()){}
        if(tmp==null){
            System.out.println("Student niet gevonden!");
            return null;
        } else {
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            tmp.setPrev(null);
            tmp.setNext(null);
            _size--;
            return tmp;
        }
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
        } else if (index == 0 && _size == 1) {
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
            _end.getPrev().setNext(null);
            _end = _end.getPrev();
            _size--;
            return tmp;
        } else if(index>(_size-1)){
            System.out.println("De opgegeven index is leeg!");
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
     * Geeft de grootte van de SortedList terug.
     * @return Int met de grootte van de SortedList.
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
     * Print gehele SortedList.
     */
    public void printList() {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            tmp.printStudent();
        }
    }

    /**
     * Print alle mannen in de SortedList.
     */
    public void printMen() {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht().equals("m")) {
                tmp.printStudent();
            }
        }
    }

    /**
     * print alle vrouwen in de SortedList.
     */
    public void printWomen() {
        for (Student tmp = _start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht().equals("v")) {
                tmp.printStudent();
            }
        }
    }

    /**
     * @return geeft de student van vooraan uit de SortedList terug.
     */
    public Student getStart() {
        return _start;
    }

    /**
     * @return de student achterin de SortedList.
     */
    public Student getEnd() {
        return _end;
    }
}
