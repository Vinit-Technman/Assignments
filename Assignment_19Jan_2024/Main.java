public class Main {
    // Learn About HashCode and Equals
// Cotrol statements
// Looping Statement 
// Is-a and Has-a relationship of classes
// What is java record? Write an implementation.
// What is java enum? Write an implementation.
// Differentiate between stack memory and heap memory.



    // HashCode and equals
    /*
    Equal: Equal method will return when reference will point to the same object in memory.

    Hashcode: JVM is calculate hashcode based on a memory address of an object.
    
    If we want to overriding equals() method then we must override hashcode method properly.
     
    */
    public static class HashAndEqual{
        public HashAndEqual()
        {
            System.out.println("Constructor of HashAndEqual is called");
        }
    }

    /*
     * Is-A relationship: Describes Inheritance, where a class extends subclass.
     * Has-A relationship: Describes Composition, where a class contain objects of another class.
     */

    public static class Person{
        public void eat(){
            System.out.println("Person is eating");   
        }
    }
    public static class Developer extends Person{
            public void code(){
                System.out.println("Developer do coding");
            }
    }

    public static class Engine{
        public void start(){
            System.out.println("Engine Starting");
        }
    }
    public static class Car{
        Engine eng; //Has-A relationship

        Car(Engine engine)
        {
            this.eng=engine;
        }

        public void start(){
            eng.start();
            System.out.println("Car is moving");
        }
    }
    
        // Enum - enum is special data type which represents a fixed set of constants.
        enum Day{
            SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
        }

        /*  Record - it provides a concise way to create immutable data classes. 
        
            It aims to eliminate all the boilerplate code needed to set and get data from instance.

            It generates constructor,field getters, hashcode(), equals() as well as toString() methods.

        */
        record Animal(String type,int age)
        {
            // No need to write constructor
        }

        /*
         * Stack Memory: This allocation happens in the function call stack.The size of memory to be allocated 
           is known to the compiler whenever function is called. This kind of memory allocation is also known as
           temporary memory allocation because as soon as function/method finishes its execution all the data belonging
           to that method flushes out from the stack automatically.Stack memory is allocated in contiguous block and it is limited.
          
         * Heap Memory: It is pile of memory space available to programmers to allocate and de-allocate. Every time when 
           we made an object it always creates in Heap-space and the referencing information to these objects is always 
           stored in Stack-memory. Memory leak can happen in the program if the programmer does not handle this memory.
           Heap memory is allocated in non-contiguous block and it is larger than stack memory.
         */
    public static void main(String[] args)
    {

        // HashCode and Equals
        HashAndEqual o1=new HashAndEqual();
        HashAndEqual o2=o1;
        HashAndEqual o3=new HashAndEqual();
        System.out.println(o1.equals(o2)); //References are point the same object in memory.
        System.out.println(o1.equals(o3)); //References are point different object in memory.

        System.out.println(o1.hashCode()); //based on memory address hashcode is calculated by JVM.
        System.out.println(o2.hashCode()); //based on memory address hashcode is calculated by JVM.

        // Control Statements - If-else and Switch
        int age=18;
        if(age>18)
        {
            System.out.println("You are eligible for license");
        }
        else if(age==18)
        {
            System.out.println("You are also eligible for license");
        }
        else
        {
            System.out.println("You are not eligible for license");
        }
        int deptNo=2;
        switch (deptNo) {
            case 1:
                System.out.println("Marketing Department");
                break;
            case 2:
            System.out.println("Engineering Department");
                break;
            default:
            System.out.println("Staff Members");
                break;
        }

        // Looping Statements
        System.out.println("2's Table");
        // 2's Table using for loop
        for(int i=1;i<=10;i++)
        {
            System.out.printf("%d x %d = %d \n",2,i,2*i);
        }

        // 2's Table using While loop
        int i=1;
        while(i<=10)
        {
            System.out.printf("%d x %d = %d \n",2,i,2*i);
            i++;
        }       

        // do-While loop
        boolean Flag=false;
        do{
            System.out.println("Benefit of do while is that it will must iterate one time even condition is wrong");
        }while(Flag==true);

        
        // Is-A relationship
        Developer dev=new Developer();
        dev.eat();
        dev.code();

        // Has-A relationship
        Engine carEngine=new Engine();
        Car car=new Car(carEngine);
        car.start();

        // ENUM
        Day toDay=Day.SUNDAY;
        System.out.println("today is: "+toDay);

        // RECORD
        Animal Dog = new Animal("Dog", 25);
        System.out.println(Dog); // Automatically calls toString()   

        
    }

}
