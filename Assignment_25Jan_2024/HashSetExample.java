import java.util.ArrayList;
import java.util.HashSet;

public class HashSetExample {
    public static void main(String args[]){
        HashSet<ArrayList>set=new HashSet<>();

        ArrayList<Integer> list1 = new ArrayList<>(); 
  
        ArrayList<Integer> list2 = new ArrayList<>(); 
  
        list1.add(1); 
        list1.add(2); 
        list2.add(1); 
        list2.add(2); 
        set.add(list1); 
        set.add(list2);

        System.out.println(set.size());

        HashSet<String> h = new HashSet<String>(); 
        h.add("India"); 
        h.add("Australia"); 
        h.add("South Africa"); 
        h.add("India"); 

        System.out.println(h); 

        h.remove("Australia"); 
        
        System.out.println(h); 
        /*
         * 
        *                    Number of stored elements in the table
            Load Factor  = ----------------------------------------
                                   Size of the hash table 
         */
        
    }
}
