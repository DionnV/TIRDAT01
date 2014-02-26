package opdracht3;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Dion
 */
public class Administratie {
    
    private HashMap<String, Student> _studenten;
    private int _totaal;
    
    /** Lege constructor.
     * 
     */
    public Administratie()
    {
        _studenten = new HashMap<String, Student>();
        _totaal = 0;
    }
    
    /** Voegt een student toe aan de administratie
     *
     * @param s de Student
     */
    public void addStudent(Student s)
    {
        _studenten.put(s.getStudentnummer(), s);
        _totaal++;
    }
    
    /** Retourneert alle studenten.
     *
     * @return een Collection<Student> met alle studenten.
     */
    public Collection<Student> getStudents()
    {
        return _studenten.values();
    }
    
    /** Retourneert een student a.d.h.v. zijn studentnummer
     *
     * @param studentnr het studentnummer
     * @return de student met bijbehorend studentnummer.
     */
    public Student getStudent(String studentnr)
    {
        return _studenten.get(studentnr);
    }
    
    /** Retourneert het aantal studenten in de administratie.
     *
     * @return het aantal studenten.
     */
    public int getAantalStudenten()
    {
        return _totaal;
    }

    /** Print alle studenten die het meegegeven vak hebben gehaald.
     *
     * @param vak Het vak.
     */
    public void printStudentenBehaald(Vak vak)
    {
        for(Student s : _studenten.values())
        {
            for(Vak v : s.getVakken())
            {
                if(v.getModulecode().equals(vak.getModulecode()))
                {
                    if(v.getCijfer() >= 6)
                    {
                        s.printStudent();
                        break;
                    }
                }
            }
        }
    }
    
    /** Print het gemiddelde cijfer behaald voor een vak.
     *
     * @param vak Het vak.
     */
    public void printGemiddelde(Vak vak)
    {
        int som = 0;
        int aantal = 0;
        
        for(Student s : _studenten.values())
        {
            for(Vak v : s.getVakken())
            {
                if(v.getModulecode().equals(vak.getModulecode()))
                {
                   aantal++; 
                   som += v.getCijfer();
                   break;
                }
            }
        }       
        System.out.println("Gemiddelde cijfer voor het vak " + vak.getModulecode() + " is " + (float)som/(float)aantal);
    }
    
    /** Print het gemiddelde cijfer van een student.
     *
     * @param student de student.
     */
    public void printGemiddelde(Student student)
    {
        int som = 0;
        int aantal = 0;
        for(Vak v : student.getVakken())
        {
            aantal++;
            som += v.getCijfer();
        }       
        System.out.println("Gemiddelde cijfer van " + student.getStudentnummer() + " is " + (float)som/(float)aantal);
    }
    
    /** Print de cijferlijst van een student.
     *
     * @param student de student.
     */
    public void printCijferlijst(Student student)
    {  
        System.out.println("Cijferlijst van " + student.getStudentnummer());
        for(Vak v : student.getVakken())
        {
            v.printVak();
        }
    }
    
    /** Print alle vakken die een student heeft behaald.
     *
     * @param student de student.
     */
    public void printBehaaldeVakken(Student student)
    {
        System.out.println("Behaalde vakken van " + student.getStudentnummer());
        for(Vak v : student.getVakken())
        {
            if(v.getCijfer() >= 6)
            {
                v.printVak();
            }
        }
    }
    
    /** Print alle vakken die de student niet heeft behaald.
     *
     * @param student de student.
     */
    public void printNietBehaaldeVakken(Student student)
    {
        System.out.println("Niet behaalde vakken van " + student.getStudentnummer());
        for(Vak v : student.getVakken())
        {
            if(v.getCijfer() < 6)
            {
                v.printVak();
            }
        }
    }
    
    /** Print alle studenten die het vak niet hebben gehaald.
     *
     * @param vak het vak.
     */
    public void printStudentenNietBehaald(Vak vak)
    {
        for(Student s : _studenten.values())
        {
            for(Vak v : s.getVakken())
            {
                if(v.getModulecode().equals(vak.getModulecode()))
                {
                    if(v.getCijfer() < 6)
                    {
                        s.printStudent();
                        break;
                    }
                }
            }
        }
    }
}

