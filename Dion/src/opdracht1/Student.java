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
        _geslacht = (geslacht.toLowerCase().equals("m") || geslacht.toLowerCase().equals("v") ? geslacht.toLowerCase() : "o");
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
     * Print alle gegevens van de student.
     */
    public void printStudent() {
        System.out.println(
            "Studentnummer: " + _studentNummer +
            "\nNaam         : " + _naam +
            "\nLeeftijd     : " + _leeftijd +
            "\nGeslacht     : " + _geslacht );
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Student)) return false;
        
        return  hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + _studentNummer;
        return hash;
    }
}