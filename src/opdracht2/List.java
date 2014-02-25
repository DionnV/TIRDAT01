/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht2;

/**
 *
 * @author Bart
 */
public class List {

    private Student start;
    private Student end;
    private int size;
    
    /**
     * Lege constructor.
     */
    public List(){
        size =0;
        start=null;
        end=null;
    }
    
    /**
     * Een student toevoegen aan de list op de opgegeven plaats.
     * @param s De toe te voegen student
     * @param index De index waar de student moet komen.
     */
    public void push(Student s, int index) {

        if (index == 0) {
            if (start == null) {
                start = s;
                end = s;
            } else {
                Student tmp = start;
                start.setPrev(s);
                start = s;
                s.setNext(tmp);
            }

        } else if (index == (size)||index>size) {
            Student tmp = end;
            end.setNext(s);
            end = s;
            end.setPrev(tmp);
        } else {
            Student tmp = start;
            for (int i = 0; i < (index - 1); i++) {
                tmp = tmp.getNext();
            }
            s.setNext(tmp.getNext());
            tmp.getNext().setPrev(s);
            tmp.setNext(s);
            s.setPrev(tmp);
            
        }
        size++;
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
            System.out.println("Index "+index+"is leeg!");
            return null;
        } else {
            Student tmp = start;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            size--;
            return tmp;
        }
    }

    /**
     * Geeft de grootte van de queue terug.
     * @return Int met de grootte van de queue.
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
     * Print gehele queue.
     */
    public void printList() {
        for (Student tmp = start; tmp!=null;tmp=tmp.getNext()) {
            tmp.printStudent();
        }
    }

    /**
     * Print alle mannen in de queue
     */
    public void printMen() {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht() == "m") {
                tmp.printStudent();
            }
        }
    }

    /**
     * print alle vrouwen in de queue.
     */
    public void printWomen() {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getGeslacht() == "v") {
                tmp.printStudent();
            }
        }
    }

    /**
     * @return geeft de student van vooraan uit de queue terug.
     */
    public Student getStart() {
        return start;
    }

    /**
     * @return de student achterin de queue
     */
    public Student getEnd() {
        return end;
    }
}
