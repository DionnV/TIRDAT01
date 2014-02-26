package opdracht3;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Dion
 */
public class Student {
    
    private String _studentnummer = "0";
    private String _naam = "";
    private int _leeftijd = 0;
    private String _geslacht = "O";
    private String _klas = "";
    
    private HashMap<String, Vak> _vakken;
    private String _studieRichting;
    
    /** Lege constructor.
     *
     */
    public Student()
    {
        _vakken = new HashMap<String, Vak>();      
    }
    
    /** Constructor.
     *
     * @param nummer het studentnummer.
     * @param naam de naam van de student.
     * @param leeftijd de leeftijd van de student.
     * @param geslacht het geslacht van de student.
     */
    public Student(String nummer, String naam, int leeftijd, String geslacht)
    {
        _studentnummer = nummer;
        _naam = naam;
        _leeftijd = leeftijd;
        _geslacht = (geslacht.toLowerCase().equals("m") || geslacht.toLowerCase().equals("v") ? geslacht.toLowerCase() : "o");
        _vakken = new HashMap<String, Vak>();        
    }

    /** Retourneert het studentnummer.
     *
     * @return het studentnummer.
     */
    public String getStudentnummer() {
        return _studentnummer;
    }

    /** Zet het studentnummer.
     *
     * @param studentnummer het gewenste studentnummer.
     */
    public void setStudentnummer(String studentnummer) {
        _studentnummer = studentnummer;
    }

    /** Retourneert de naam.
     *
     * @return de naam.
     */
    public String getNaam() {
        return _naam;
    }

    /** Zet de naam.
     *
     * @param naam de gewenste naam.
     */
    public void setNaam(String naam) {
        _naam = naam;
    }

    /** Retourneert de leeftijd.
     *
     * @return de leeftijd.
     */
    public int getLeeftijd() {
        return _leeftijd;
    }

    /** Zet de leeftijd.
     *
     * @param leeftijd de gewenste leeftijd.
     */
    public void setLeeftijd(int leeftijd) {
        _leeftijd = leeftijd;
    }

    /** Retourneert het geslacht.
     *
     * @return het geslacht.
     */
    public String getGeslacht() {
        return _geslacht;
    }

    /** Zet het geslacht.
     *
     * @param geslacht het geslacht.
     */
    public void setGeslacht(String geslacht) {
        _geslacht = (geslacht.toLowerCase().equals("m") || geslacht.toLowerCase().equals("v") ? geslacht.toLowerCase() : "o");
    }
    
    /** Retourneert de vakken die een student bijwoonde in een bepaald jaar.
     * jaar = 0 retourneert alle vakken.
     *
     * @param jaar het jaar.
     * @return de vakken.
     */
    public LinkedList<Vak> getVakken(int jaar)
    {
        LinkedList<Vak> list = new LinkedList<Vak>();
        Object[] vakken = _vakken.values().toArray();       
        for (Object vak : vakken) {
            if (((Vak) vak).getCijfer() > 0) {
                if ((((Vak) vak).getJaar() == jaar) || jaar == 0) {
                    list.add((Vak) vak);
                }
            }
        }
        
        return list;
    }
    
    /** Retourneert alle vakken.
     *
     * @return alle vakken.
     */
    public LinkedList<Vak> getVakken()
    {
        return getVakken(0);
    }
    
    /** Voegt een vak toe bij een student.
     *
     * @param vak het vak.
     */
    public void addVak(Vak vak)
    {
        _vakken.put(vak.getModulecode(), vak);
    }
    
    /** Retourneert het gemiddelde van een student.
     *
     * @return het gemiddelde.
     */
    public double gemiddelde()
    {
        double som = 0;
        double aantal = 0;
        for(int i = 0; i < _vakken.values().size(); i++)
        {
            int cijfer = ((Vak)_vakken.values().toArray()[i]).getCijfer();
            if(cijfer > 0)
            {
                aantal++;
                som += cijfer;
                
            }
        }
        
        return som/aantal;
    }
    
    @Override
    public String toString()
    {
        return _naam + " (" + _studentnummer + "), " + _leeftijd + ", " + _geslacht;
    }
    
    /** Print alle info van de student.
     *
     */
    public void printStudent()
    {
        System.out.println(this.toString());
    }
    
}
