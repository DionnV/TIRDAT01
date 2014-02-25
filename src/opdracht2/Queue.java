/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht2;

/**
 *
 * @author Bart
 */
public class Queue {
    
    private Student start;
    private Student end;
    private int size;

    /**
     * Lege constructor.
     */
    public Queue(){
    size = 0;
    start = null;
    end = null;
    }
    
    public Queue(Student... args){
        for(Student s : args){
            push(s);
        }
    }
    
    /**
     * Een student toevoegen aan de queue.
     * @param s De toe te voegen student
     */
    public void push(Student s){
        if(size==0){
            start = s;
            end = s;
    //        size++;
        } else {
            end.setNext(s);
            s.setPrev(end);
            end = s;
      //      size++;
        }
        size++;
    }
    /**
     * Geeft de grootte van de queue terug.
     * @return Int met de grootte van de queue.
     */
    public int size(){
        return size;
    }
    
    /**
     * Verwijdert student vooraan in de queue.
     * @return De verwijderde student.
     */
    public Student pop(){
        Student temp = start;
        start.getNext().setPrev(null);
        start=start.getNext();
        temp.setNext(null);
        size--;
        return temp;
    }
    
    /**
     * Kijkt op basis van studentnummer of student al bestaat.
     * @param s De te controleren student.
     * @return True als student al bestaat, anders false.
     */
    public boolean peek(Student s){
        for(Student tmp=start; tmp!=null;tmp=tmp.getNext()){
            if(s.getStudentNummer()==tmp.getStudentNummer()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Print gehele queue.
     */
    public void printQueue(){
        for(Student tmp = start; tmp!=null; tmp=tmp.getNext()){
            tmp.printStudent();
        }
    }
    /**
     * Print alle mannen in de queue
     */
    public void printMen(){
        for(Student tmp = start; tmp!=null; tmp=tmp.getNext()){
            if(tmp.getGeslacht()=="m")
                tmp.printStudent();
        }
    }
    /**
     * print alle vrouwen in de queue.
     */
    public void printWomen(){
        for(Student tmp = start; tmp!=null; tmp=tmp.getNext()){
            if(tmp.getGeslacht()=="v")
                tmp.printStudent();
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
