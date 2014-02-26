/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht2;


/**
 *
 * @author Bart
 */
public class Student {

    private int _studentNummer;
    private String _naam;
    private int _leeftijd;
    private String _geslacht;
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
        this._studentNummer = studentNummer;
        this._naam = naam;
        this._leeftijd = leeftijd;
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
        this._studentNummer = studentNummer;
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
        this._naam = naam;
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
        this._leeftijd = leeftijd;
    }

    /**
     * @return the geslacht
     */
    public String getGeslacht() {
        return _geslacht;
    }

    /**
     * @param geslacht the geslacht to set
     * @throws genderException Indien geslacht geen M of V is, wordt genderException gegooid.
     */
    public void setGeslacht(String geslacht) {
        _geslacht = (geslacht.toLowerCase().equals("m") || geslacht.toLowerCase().equals("v") ? geslacht.toLowerCase() : "o");
    }

    /**
     * Print alle gegevens van de student.
     */
    public void printStudent() {
        System.out.println(
                "Studentnummer: " + _studentNummer
                + "\nNaam         : " + _naam
                + "\nLeeftijd     : " + _leeftijd
                + "\nGeslacht     : " + _geslacht
                + "\n");
    }
    @Override
    public String toString()
    {
        return "Studentnummer: " + _studentNummer
                + "\nNaam         : " + _naam
                + "\nLeeftijd     : " + _leeftijd
                + "\nGeslacht     : " + _geslacht
                + "\n";
    }   
}