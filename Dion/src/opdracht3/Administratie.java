package opdracht3;

import java.util.HashMap;

/**
 *
 * @author Dion
 */
public class Administratie {
    
    private HashMap<String, Student> _studenten;
    private int _totaal;
    
    public Administratie()
    {
        _studenten = new HashMap<String, Student>();
        _totaal = 0;
    }
    
    public void addStudent(Student s)
    {
        _studenten.put("", s);
        _totaal++;
    }
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
    
    public void printCijferlijst(Student student)
    {  
        System.out.println("Cijferlijst van " + student.getStudentnummer());
        for(Vak v : student.getVakken())
        {
            v.printVak();
        }
    }
    
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

