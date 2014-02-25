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

    private Student start;
    private Student end;
    private int size;

    /**
     * Lege constructor.
     */
    public SortedList(){}
    
    /**
     * Constructor waar studenten aan mee te geven zijn, die direct gepusht worden.
     * @param args De toe te pushen studenten.
     */
    public SortedList(Student... args){
        for(Student s : args){
            push(s);
        }
    }
    
    
    /**
     * Een student toevoegen aan de SortedList.
     * @param s De toe te voegen student
     */
    public void push(Student s) {

        if(size==0){
            start = s;
            end= s;
        } else if(s.getStudentNummer()<start.getStudentNummer()){
            start.setPrev(s);
            s.setNext(start);
            start = s;
        } else if(s.getStudentNummer()>end.getStudentNummer()){
            s.setPrev(end);
            end.setNext(s);
            end = s;
        } else {
            Student tmp = start;
            for(int i = tmp.getStudentNummer();s.getStudentNummer()<i;i=tmp.getStudentNummer()){
                tmp = tmp.getNext();
            }
            tmp.getPrev().setNext(s);
            s.setPrev(tmp.getPrev());
            tmp.setPrev(s);
            s.setNext(tmp);
            
        }
        size++;
    }

    /**
     * Verwijdert student vooraan in de list.
     * @return De verwijderde student.
     */
    public Student head() {
        Student tmp = start;
        start.getNext().setPrev(null);
        start = start.getNext();
        size--;
        return tmp;
    }
    
    /**
     * Verwijdert de student achteraan in de list.
     * @return De verwijderde student.
     */
    public Student tail(){
        Student tmp = end;
        end.getPrev().setNext(null);
        end = end.getPrev();
        size--;
        return tmp;
    }
    
    /**
     * Zoekt naar de meegegeven student en verwijdert deze indien gevonden.
     * @param s De te verwijderen student
     * @return De verwijderde student, of null indien niet gevonden.
     */
    public Student pop(Student s){
        Student tmp;
        for(tmp = start; tmp!=s&&tmp!=null;tmp = tmp.getNext()){}
        if(tmp==null){
            System.out.println("Student niet gevonden!");
            return null;
        } else {
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            tmp.setPrev(null);
            tmp.setNext(null);
            size--;
            return tmp;
        }
    }
    
    /**
     * Verwijdert de student op de gegeven index.
     * @param index De index van te verwijderen student.
     * @return De verwijderde student.
     */
    public Student pop(int index) {
        if (size == 0) {
            System.out.println("Lijst leeg!");
            return null;
        } else if (index == (size - 1) && size == 1) {
            Student tmp = start;
            start = null;
            end = null;
            size--;
            return tmp;
        } else if (index == 0) {
            Student tmp = start;
            start.getNext().setPrev(null);
            start = start.getNext();
            size--;
            return tmp;
        } else if (index == (size - 1)) {
            Student tmp = end;
            end.getPrev().setNext(null);
            end = end.getPrev();
            size--;
            return tmp;
        } else if(index>(size-1)){
            System.out.println("De opgegeven index is leeg!");
            return null;
        } else {
            Student tmp = start;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            //System.out.println(tmp.getPrev());
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            size--;
            return tmp;
        }
    }

    /**
     * Geeft de grootte van de SortedList terug.
     * @return Int met de grootte van de SortedList.
     */
    public int size() {
        return size;
    }

    /**
     * Kijkt op basis van studentnummer of student al bestaat.
     * @param s De te controleren student.
     * @return True als student al bestaat, anders false.
     */
    public boolean peek(Student s) {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
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
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            tmp.printStudent();
        }
    }

    /**
     * Print alle mannen in de SortedList.
     */
    public void printMen() {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht() == "m") {
                tmp.printStudent();
            }
        }
    }

    /**
     * print alle vrouwen in de SortedList.
     */
    public void printWomen() {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht() == "v") {
                tmp.printStudent();
            }
        }
    }

    /**
     * @return geeft de student van vooraan uit de SortedList terug.
     */
    public Student getStart() {
        return start;
    }

    /**
     * @return de student achterin de SortedList.
     */
    public Student getEnd() {
        return end;
    }
}
