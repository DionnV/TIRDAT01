package opdracht1;
/**
 *
 * @author Dion
 */
public class App {

    /**
     * De main klasse waarin alles getest wordt
     * @param args NVT
     */
    public static void main(String args[]) {
        //Initialize students
        Student s1 = new Student(1001,"Student1",11,"m");
        Student s2 = new Student(1002,"Student2",12,"v");
        Student s3 = new Student(1003,"Student3",13,"m");
        Student s4 = new Student(1004,"Student4",14,"v");
        Student s5 = new Student(1005,"Student5",15,"m");
        Student s6 = new Student(1006,"Student6",16,"v");
        Student s7 = new Student(1007,"Student7",17,"m");
        Student s8 = new Student(1008, "Student8",18,"v");

        Node e1 = new Node(s1);
        Node e2 = new Node(s2);
        Node e3 = new Node(s3);
        Node e4 = new Node(s4);
        Node e5 = new Node(s5);
        Node e6 = new Node(s6);
        Node e7 = new Node(s7);
        Node e8 = new Node(s8);
        //Initialize Stack.
        Stack Stack = new Stack();

        Stack.push(e1);
        Stack.push(e2);
        Stack.push(e3);
        Stack.push(e4);
        Stack.push(e5);

        /*--------------- START OF TESTING METHODS ---------------*/
        System.out.println("Created a Stack. Content:");
        Stack.printStack();

        System.out.println("Printing all the male students...");
        Stack.printMen();

        System.out.println("Printing all the female students...");
        Stack.printWoman();

        System.out.println("Peeking student: s1 (should be true)");
        System.out.println("Result: " + Stack.peek(e1));

        System.out.println("Peeking student: s6 (should be false)");
        System.out.println("Result: " + Stack.peek(e6));

        System.out.println("\nLet's pop some students.");
        ((Student)Stack.pop().getData()).printStudent();
        System.out.println("print:");
        Stack.printStack();
        ((Student)Stack.pop().getData()).printStudent();
        ((Student)Stack.pop().getData()).printStudent();

        System.out.println("\nThe Stack content is now: ");
        Stack.printStack();

        System.out.println("Now add some new students to the Stack.");
        Stack.push(e6);
        Stack.push(e7);
        Stack.push(e8);

        System.out.println("The Stack content is now: ");
        Stack.printStack();
        /*--------------- END OF TESTING METHODS ---------------*/
    }
}
