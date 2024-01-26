import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
public class ConcurrentHashMapExample {
    public static void main(String args[]) {

        /*
         * ConcurrentHashMap is a thread-safe implementation of the Map interface in
         * Java, which means multiple threads can access it simultaneously without any
         * synchronization issues
         */
        ConcurrentHashMap<String, Integer> cM = new ConcurrentHashMap<>();

        cM.put("A", 1);
        cM.put("B", 2);
        cM.put("A", 1);

        System.out.println("Map size: " + cM.size());

        System.out.println(cM.get("A"));

        cM.remove("B");
        System.out.println("Map size: " + cM.size());

        System.out.println(cM);

        //  Here we cant add 2 because A key is already present in ConcurrentHashMap object
        cM.putIfAbsent("A",2);  
        
        // We cant replace 23 with 2
        cM.replace("A",23,2);
        System.out.println(cM);
        
        cM.put("DD",292);

        Iterator<ConcurrentHashMap.Entry<String,Integer>>itr=cM.entrySet().iterator();

        while(itr.hasNext()){
            System.out.println("Key: "+itr.next().getKey()+" Value: "+itr.next().getValue());

        }
    }
}
