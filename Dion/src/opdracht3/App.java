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

            //Student 1001
            Vak v1 = new Vak("123", 6, 1);
            Vak v2 = new Vak("321", 4, 2);
            Vak v3 = new Vak("231", 8, 3);

            //Student 1002
            Vak v4 = new Vak("123", 7, 1);
            Vak v5 = new Vak("321", 1, 2);
            Vak v6 = new Vak("231", 1, 3);

            //Student 1003
            Vak v7 = new Vak("123", 9, 1);
            Vak v8 = new Vak("321", 8, 2);
            Vak v9 = new Vak("231", 9, 3);
            
            //Student 1004
            Vak v10 = new Vak("123", 6, 1);
            Vak v11 = new Vak("321", 6, 2);
            Vak v12 = new Vak("231", 6, 3);

            //Student 1005
            Vak v13 = new Vak("123", 7, 1);
            Vak v14 = new Vak("321", 2, 2);
            Vak v15 = new Vak("231", 9, 3);

            //Student 1006
            Vak v16 = new Vak("123", 8, 1);
            Vak v17 = new Vak("321", 9, 2);
            Vak v18 = new Vak("231", 2, 3);
            
            //Student 1007
            Vak v19 = new Vak("123", 7, 1);
            Vak v20 = new Vak("321", 4, 2);
            Vak v21 = new Vak("231", 3, 3);

            //Student 1008
            Vak v22 = new Vak("123", 5, 1);
            Vak v23 = new Vak("321", 6, 2);
            Vak v24 = new Vak("231", 5, 3);

            
            s1.addVak(v1, v2, v3);
            s2.addVak(v4, v5, v6);
            s3.addVak(v7, v8, v9);
            s4.addVak(v10, v11, v12);
            s5.addVak(v13, v14, v15);
            s6.addVak(v16, v17, v18);
            s7.addVak(v19, v20, v21);
            s8.addVak(v22, v23, v24);
            
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
            /******END OF PRINTING******/
        }   
}
