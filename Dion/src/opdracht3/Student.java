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
    
    public Student()
    {
        _vakken = new HashMap<String, Vak>();      
    }
    
    public Student(String nummer, String naam, int leeftijd, String geslacht)
    {
        _studentnummer = nummer;
        _naam = naam;
        _leeftijd = leeftijd;
        _geslacht = (geslacht.toLowerCase().equals("m") || geslacht.toLowerCase().equals("v") ? geslacht : "O");
        _vakken = new HashMap<String, Vak>();        
    }

    public String getStudentnummer() {
        return _studentnummer;
    }

    public void setStudentnummer(String studentnummer) {
        _studentnummer = studentnummer;
    }

    public String getNaam() {
        return _naam;
    }

    public void setNaam(String naam) {
        _naam = naam;
    }

    public int getLeeftijd() {
        return _leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        _leeftijd = leeftijd;
    }

    public String getGeslacht() {
        return _geslacht;
    }

    public void setGeslacht(String geslacht) {
        _geslacht = (geslacht.toLowerCase().equals("m") || geslacht.toLowerCase().equals("v") ? geslacht : "O");
    }
    
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
    
    public LinkedList<Vak> getVakken()
    {
        return getVakken(0);
    }
    
    public void addVak(Vak vak)
    {
        _vakken.put(vak.getModulecode(), vak);
    }
    
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
    
    public void printStudent()
    {
        System.out.println(this.toString());
    }
    
}
