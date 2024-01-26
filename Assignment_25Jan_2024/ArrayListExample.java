import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListExample {
    public static void main(String args[])
    {
        int n=5;
        ArrayList<Integer>arr1=new ArrayList<>(5);

        System.out.println("Array List: "+arr1);

        for(int i=0;i<=n;i++)
        {
            arr1.add(i);
        }
        System.out.println("Array List: "+arr1);

        ArrayList<String>arr2=Stream.of("A","B","C").collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arr2);
    }
}
