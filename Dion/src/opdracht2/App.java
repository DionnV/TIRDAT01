package opdracht2;

/**
 *
 * @author Dion
 */
public class App {
    public static void main(String args[])
    {
        Student s1 = new Student(1001,"Student1",11,"m");
        Student s2 = new Student(1002,"Student2",12,"v");
        Student s3 = new Student(1003,"Student3",13,"m");
        Student s4 = new Student(1004,"Student4",14,"v");
        Student s5 = new Student(1005,"Student5",15,"m");
        Student s6 = new Student(1006,"Student6",16,"v");
        Student s7 = new Student(1007,"Student7",17,"m");
        Student s8 = new Student(1008, "Student8",18,"v");
        
        //Queue testen
        Queue a = new Queue(s1, s2, s3, s4, s5);   
        System.out.println("Complete queue:");
        a.printQueue();
        System.out.println("Alle mannen:");
        a.printMen();
        System.out.println("Pop 2 studenten:");
        a.pop().printStudent();
        a.pop().printStudent();
        System.out.println("Nieuwe queue:");
        a.printQueue();
        System.out.println("Alle vrouwen die over zijn:");
        a.printWomen();
        System.out.println("Grootte van de queue:");
        System.out.println(a.size());
        
        //List test
//        List b = new List();
//        b.push(s1, 0);
//        b.push(s2, 1);
//        b.push(s3, 2);
//        b.push(s4, 3);
//        b.push(s5, 4);
//        b.push(s6, 0);
//        b.push(s7, 3);
//        System.out.println("Totale lijst:");
//        b.printList();
//        System.out.println(" ");
//        System.out.println("Grootte: " + b.size());
//        System.out.println("Gaat nu studenten poppen:\n");
//        b.pop(0).printStudent();
//        b.pop(5).printStudent();
//        b.pop(1).printStudent();
//        System.out.println("\nNieuwe list:");
//        b.printList();
//        System.out.println("Nieuwe grootte: " + b.size());
        
        //SortedList testen
//        SortedList c = new SortedList(s1, s2, s3, s4, s5, s6, s7);
//        System.out.println("7 studenten gepusht, actuele SortedList:");
//        c.printList();
//        System.out.println("Actuele grootte:");
//        System.out.println(c.size());
//        System.out.println("Verwijdert studenten met de hoogste en de laagste studentnummers:");
//        c.tail().printStudent();
//        c.head().printStudent();
//        System.out.println("Controleert Hans' aanwezigheid en probeert te verwijderen uit de list:");
//        System.out.println(c.peek(s3));
//        c.pop(s3).printStudent();
//        System.out.println("Nieuwe SortedList:");
//        c.printList();
//        System.out.println("Verwijdert student op index 1:");
//        c.pop(1).printStudent();
//        System.out.println("Nieuwe sortedlist:\n");
//        c.printList();
//        System.out.println("Probeert nu niet gepushte student te verwijderen:");
//        c.pop(s8);
//        System.out.println("Nieuwe grootte:");
//        System.out.println(c.size());
        
    }
}
