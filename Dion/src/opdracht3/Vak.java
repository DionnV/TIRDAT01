package opdracht3;

/**
 *
 * @author Dion
 */
public class Vak {
    
    private String _modulecode;
    private int _cijfer;
    private int _jaar;
    
    public Vak()
    {
        _cijfer = -1;
        _jaar = 0;
    }

    public String getModulecode() {
        return _modulecode;
    }

    public void setModulecode(String modulecode) {
        _modulecode = modulecode;
    }

    public int getCijfer() {
        return _cijfer;
    }

    public void setCijfer(int cijfer) {
        if(cijfer > 0 && cijfer < 11)
        {      
            _cijfer = cijfer;
        }
    }

    public int getJaar() {
        return _jaar;
    }

    public void setJaar(int jaar) {
        _jaar = jaar;
    }
    
    public void printVak()
    {
        System.out.println(_modulecode + ": " + _cijfer + ", " + _jaar);
    }
    
    
}
