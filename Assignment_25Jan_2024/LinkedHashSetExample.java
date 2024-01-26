import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String args[])
    {
         LinkedHashSet<String> linkedset 
            = new LinkedHashSet<String>(); 
  
        linkedset.add("A"); 
        linkedset.add("B"); 
        linkedset.add("C"); 
        linkedset.add("D"); 

        System.out.println(linkedset);

        System.out.println("Removing D from LinkedHashSet: "
        + linkedset.remove("D")); 

        System.out.println("Trying to Remove Z which is not "+ "present: " + linkedset.remove("Z")); 

        
  
    }    
}
