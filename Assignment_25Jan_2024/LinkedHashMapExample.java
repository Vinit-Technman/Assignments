import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String args[]){
        LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();

        lhm.put("one","Vinit");
        lhm.put("two","Aakarshak");

        lhm.put("three","Fidubhai");

        System.out.println("LinkedHashMap: "+lhm);

        System.out.println("Getting value for one: "+ lhm.get("one")); 

        System.out.println("Size of the map: "+ lhm.size()); 

        System.out.println("Is map empty "+ lhm.isEmpty()); 


        for(Map.Entry<String,String>e: lhm.entrySet())
        {
            System.out.println(e.getKey()+"  "+e.getValue());
        }

        System.out.println(lhm.containsKey("two")); 

        lhm.remove("one");

        System.out.println("LinkedHashMap: "+lhm);  
    }
}
