package opdracht1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * De stackmethode, een dynamische stack waar studenten in gaan.
 * @author Bart
 */
public class Stack {
    /**
     * Grootte van de stack.
     */
    private int size;
    /**
     * De bovenste student, laatst toegevoegde
     */
    private Student start;

    /**
     * Voeg student toe bovenop stapel, indien student de eerste is, wordt deze als start opgeslagen.
     * @param s De toe te voegen student.
     */
    public void push(Student s) {
        if (start == null) {
            start = s;
        } else {
            s.setNext(start);
            start = s;
        }
        size++;
    }

    /**
     * Geeft de grootte van de stack terug.
     * @return Int van de stack.
     */
    public int size() {
        return size;
    }

    /**
     * Doorloopt naar de voorlaatste student op de stack, en verwijdert de link naar de volgende.
     * @return De verwijderde student.
     */
    public Student pop() {
        Student temp = start;
        start = start.getNext();
        size--;
        return temp;
    }

    /**
     * Controleert of de meegegeven student al in de stack staat op basis van studentnummer.
     * @param s De te controleren student.
     * @return True als student al bestaat, False als student nog niet gemaakt is.
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
     * Print de stack van de eerste student naar de laatste.
     */
    public void printStack() {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            tmp.printStudent();
        }
    }

    /**
     * Print alle mannen in de stack van begin naar eind.
     */
    public void printMen() {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            String g = tmp.getGeslacht();
            if (g.equalsIgnoreCase("m")) {
                tmp.printStudent();
            }
        }
    }

    /**
     * Print alle vrouwen in de stack van begin naar eind.
     */
    public void printWoman() {
        for (Student tmp = start; tmp != null; tmp = tmp.getNext()) {
            String g = tmp.getGeslacht();
            if (g.equalsIgnoreCase("v")) {
                tmp.printStudent();
            }
        }
    }
}
