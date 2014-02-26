package opdracht3;

/**
 *
 * @author Dion
 */
public class App {
        
        
        public static void main(String[] args)
        {
            Administratie admin = new Administratie();
            
            Student s1 = new Student("1001","Student1",11,"m");
            Student s2 = new Student("1002","Student2",12,"v");
            Student s3 = new Student("1003","Student3",13,"m");
            Student s4 = new Student("1004","Student4",14,"v");
            Student s5 = new Student("1005","Student5",15,"m");
            Student s6 = new Student("1006","Student6",16,"v");
            Student s7 = new Student("1007","Student7",17,"m");
            Student s8 = new Student("1008", "Student8",18,"v");

            Vak v1 = new Vak("123", 6, 1);
            Vak v2 = new Vak("321", 4, 2);
            Vak v3 = new Vak("231", 8, 2);

            Vak v4 = new Vak("321", 7, 2);
            Vak v5 = new Vak("654", 1, 3);
            Vak v6 = new Vak("456", 1, 2);

            Vak v7 = new Vak("123", 9, 1);
            Vak v8 = new Vak("456", 8, 2);
            Vak v9 = new Vak("897", 9, 4);
            
            s1.addVak(v1, v2, v3);
            s2.addVak(v4, v5, v6);
            s3.addVak(v7, v8, v9);
            
            admin.addStudent(s1, s2, s3, s4, s5, s6, s7, s8);   
            
            /*******START THE PRINTING*******/
            admin.printCijferlijst(s1);
            
            admin.printGemiddelde(s2);
            
            admin.printGemiddelde(v1);
            
            admin.printNietBehaaldeVakken(s1);
            
            System.out.println("Studenten die " + v1.getModulecode() + " hebben gehaald");
            admin.printStudentenBehaald(v1);
            
            System.out.println("Studenten die " + v2.getModulecode() + " niet hebben gehaald");
            admin.printStudentenNietBehaald(v2);          
            
        }
    
}
