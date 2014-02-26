package opdracht3;

/**
 *
 * @author Dion
 */
public class Vak {
    
    private String _modulecode;
    private int _cijfer;
    private int _jaar;
    
    /** Lege constructor.
     *
     */
    public Vak()
    {
        _cijfer = -1;
        _jaar = 0;
    }

    /** Contructor
     * 
     * @param modulecode de modulecode
     * @param cijfer het cijfer
     * @param jaar het jaar
     */
    public Vak(String modulecode, int cijfer, int jaar)
    {
        _modulecode = modulecode;
        _cijfer = cijfer;
        _jaar = jaar;
    }
    /** Retourneert de modulecode.
     *
     * @return de modulecode.
     */
    public String getModulecode() {
        return _modulecode;
    }

    /** Zet de modulecode.
     *
     * @param modulecode de gewenste modulecode.
     */
    public void setModulecode(String modulecode) {
        _modulecode = modulecode;
    }

    /** Retourneert het cijfer.
     *
     * @return het cijfer.
     */
    public int getCijfer() {
        return _cijfer;
    }

    /** Zet het cijfer.
     *
     * @param cijfer het gewenste cijfer.
     */
    public void setCijfer(int cijfer) {
        if(cijfer > 0 && cijfer < 11)
        {      
            _cijfer = cijfer;
        }
    }

    /** Retourneert het jaar.
     *
     * @return het jaar.
     */
    public int getJaar() {
        return _jaar;
    }

    /** Zet het jaar.
     *
     * @param jaar het gewenste jaar.
     */
    public void setJaar(int jaar) {
        _jaar = jaar;
    }
    
    /** Print alle info over een vak.
     *
     */
    public void printVak()
    {
        System.out.println(_modulecode + ": " + _cijfer + ", " + _jaar);
    }     
}
