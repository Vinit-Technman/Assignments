import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String args[]) {
        /*
         * The TreeMap in Java is a concrete implementation of the java.util.SortedMap
         * interface. It provides an ordered collection of key-value pairs, where the
         * keys are ordered based on their natural order or a custom Comparator passed
         * to the constructor.
         */
        Map<Integer, String> tM = new TreeMap<>();

        tM.put(1, "Vinit");
        tM.put(2, "Fenil");
        tM.put(3, "Fidubhai");

        System.out.println(tM.get(1));

        for (int i : tM.keySet()) {
            System.out.println(i + " " + tM.get(i));
        }

    }
}
