import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String args[]){
        LinkedList<String> LL=new LinkedList<>();
        LL.add("Data1");
        LL.add("Data2");
        LL.add("Data3");
        LL.addLast("Data4"); //Add at Last Index in list
        LL.addFirst("Data5"); // Add at First Index in list
        LL.add(2,"Data6"); //Add at particular Index
        System.out.println("Linked List: "+LL);

        LL.remove("Data1"); //Remove by value
        LL.remove(1); // Remove by index
        System.out.println("Linked List: "+LL);

        // Iteration in LL
        for(String s:LL)
        {
            System.out.println(s);
        }
    }    
}
