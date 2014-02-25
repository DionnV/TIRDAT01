package opdracht1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * De klasse student, met daarin getters en setters.
 * @author Bart
 */

public class Student {

    private int studentNummer;
    private String naam;
    private int leeftijd;
    private String geslacht;
    private Student next;
    /**
     * Lege studentconstructor.
     */
    public Student() {
    }
    /**
     * Constructor voor student
     * @param studentNummer Het studentnummer van de te maken student
     * @param naam De naam van de student
     * @param leeftijd De leeftijd van de student
     * @param geslacht Het geslacht van de student, alleen m of v mogelijk
     */
    public Student(int studentNummer, String naam, int leeftijd, String geslacht) {
        this.studentNummer = studentNummer;
        this.naam = naam;
        this.leeftijd = leeftijd;
        try {
            setGeslacht(geslacht);
        } catch (genderException e) {
            System.out.println("Geslacht mag alleen 'm' of 'v' zijn!");
            
        }

    }

    /**
     * @return the studentNummer
     */
    public int getStudentNummer() {
        return studentNummer;
    }

    /**
     * @param studentNummer the studentNummer to set
     */
    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the leeftijd
     */
    public int getLeeftijd() {
        return leeftijd;
    }

    /**
     * @param leeftijd the leeftijd to set
     */
    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    /**
     * @return the geslacht
     */
    public String getGeslacht() {
        return geslacht;
    }

    /**
     * @param geslacht the geslacht to set
     * @throws genderException Indien geslacht geen M of V is, wordt genderException gegooid.
     */
    public void setGeslacht(String geslacht) throws genderException {
        if (geslacht.equalsIgnoreCase("m") || geslacht.equalsIgnoreCase("v")) {
            this.geslacht = geslacht;
        } else {
            throw new genderException();
        }
    }

    /**
     * @return the next
     */
    public Student getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Student next) {
        this.next = next;
    }
    /**
     * Print alle gegevens van de student.
     */
    public void printStudent() {
        System.out.println(
            "Studentnummer: " + studentNummer +
            "\nNaam         : " + naam +
            "\nLeeftijd     : " + leeftijd +
            "\nGeslacht     : " + geslacht );
    }
}
/**
 * Foutmelding die wordt gegooid indien geslacht geen m of v is.
 * @author Bart
 */
class genderException extends Exception {
}