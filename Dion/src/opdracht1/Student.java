package opdracht1;

/**
 * De klasse student, met daarin getters en setters.
 * @author Dion
 */

public class Student {

    private int _studentNummer;
    private String _naam;
    private int _leeftijd;
    private String _geslacht;
    private Student _next;
    
    /**
     * Constructor voor student
     * @param studentNummer Het studentnummer van de te maken student
     * @param naam De naam van de student
     * @param leeftijd De leeftijd van de student
     * @param geslacht Het geslacht van de student, alleen m of v mogelijk
     */
    public Student(int studentNummer, String naam, int leeftijd, String geslacht) {
        _studentNummer = studentNummer;
        _naam = naam;
        _leeftijd = leeftijd;
        if (geslacht.equalsIgnoreCase("m") || geslacht.equalsIgnoreCase("v")) 
        {
            _geslacht = geslacht;
        } 

    }

    /**
     * @return the studentNummer
     */
    public int getStudentNummer() {
        return _studentNummer;
    }

    /**
     * @param studentNummer the studentNummer to set
     */
    public void setStudentNummer(int studentNummer) {
        _studentNummer = studentNummer;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return _naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        _naam = naam;
    }

    /**
     * @return the leeftijd
     */
    public int getLeeftijd() {
        return _leeftijd;
    }

    /**
     * @param leeftijd the leeftijd to set
     */
    public void setLeeftijd(int leeftijd) {
        _leeftijd = leeftijd;
    }

    /**
     * @return the geslacht
     */
    public String getGeslacht() {
        return _geslacht;
    }

    /**
     * @return the next
     */
    public Student getNext() {
        return _next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Student next) {
        _next = next;
    }
    /**
     * Print alle gegevens van de student.
     */
    public void printStudent() {
        System.out.println(
            "Studentnummer: " + _studentNummer +
            "\nNaam         : " + _naam +
            "\nLeeftijd     : " + _leeftijd +
            "\nGeslacht     : " + _geslacht );
    }
}