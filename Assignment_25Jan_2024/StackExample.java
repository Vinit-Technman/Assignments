import java.util.Stack;

public class StackExample {
    public static void main(String atgs[]){
        Stack<Integer>s=new Stack<>();
        
        for(int i=0;i<5;i++)
        {
            s.add(i);
        }
        System.out.println(s.peek());

        Integer x=s.pop();
        System.out.println(x);

        System.out.println(s.peek());

        Integer index=(Integer)s.search(2);

        if(index==-1)
        {
            System.out.println("Element 2 is not present in stack");
        }
        else
        System.out.println("Element 2 is present in stack at index: "+index);

        s.push(2);

        while(!s.isEmpty()){
                System.out.println(s.pop());
        }

    }
}
