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

        //Initialize Stack.
        Stack Stack = new Stack();

        Stack.push(s1);
        Stack.push(s2);
        Stack.push(s3);
        Stack.push(s4);
        Stack.push(s5);

        /*--------------- START OF TESTING METHODS ---------------*/
        System.out.println("Created a Stack. Content:");
        Stack.printStack();

        System.out.println("Printing all the male students...");
        Stack.printMen();

        System.out.println("Printing all the female students...");
        Stack.printWoman();

        System.out.println("Peeking student: s1 (should be true)");
        System.out.println("Result: " + Stack.peek(s1));

        System.out.println("Peeking student: s6 (should be false)");
        System.out.println("Result: " + Stack.peek(s6));

        System.out.println("\nLet's pop some students.");
        Stack.pop().printStudent();
        System.out.println("print:");
        Stack.printStack();
        Stack.pop().printStudent();
        Stack.pop().printStudent();

        System.out.println("\nThe Stack content is now: ");
        Stack.printStack();

        System.out.println("Now add some new students to the Stack.");
        Stack.push(s6);
        Stack.push(s7);
        Stack.push(s8);

        System.out.println("The Stack content is now: ");
        Stack.printStack();
        /*--------------- END OF TESTING METHODS ---------------*/
    }
}
