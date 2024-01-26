import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String args[]){
        Set<String>ts=new TreeSet<>();

        ts.add("A");
        ts.add("B");
        ts.add("C");
        
        System.out.println(ts);

        String check="D";
        System.out.println("Contains " + check + " "+ ts.contains(check)); 

        check="B";
        System.out.println("Contains " + check + " "+ ts.contains(check)); 

        ts.remove("B"); 
        System.out.println(ts); 

        for(String i:ts)
        {
            System.out.println(i);
        }

    }
}
