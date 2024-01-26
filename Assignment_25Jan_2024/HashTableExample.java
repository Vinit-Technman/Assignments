import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableExample
{
    public static void main(String args[]){
            Hashtable<String,Integer> hashtable=new Hashtable<>();

            hashtable.put("A",2);
            hashtable.put("B",3);
            hashtable.put("X",5);

            System.out.println("Value of A: "+hashtable.get("A"));

            Enumeration<String>keys=hashtable.keys();
            while(keys.hasMoreElements())
            {
                String key=keys.nextElement();
                System.out.println(key+" value: "+hashtable.get(key));
            }

    }
}