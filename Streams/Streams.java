import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streams {
    public static void main(String[] args)
    {
        Stream<String> streamEmpty = Stream.empty();

        List<Integer> Number=Arrays.asList(1,2,3,4,5);
        List<Integer> Square=Number.stream().map(i->i*i).collect(Collectors.toList());

        List<Integer> OddNumber=Number.stream().filter(i->i%2!=0).collect(Collectors.toList());

        List<String> names = Arrays.asList("ABC","DBC","CBA","ACC","BCC","ADE");

        // List Square=number.stream().map(i->i*i).collect(Collectors.toList());

        List<String> sortedNames=names.stream().sorted().collect(Collectors.toList());

        List<String> startWithA=names.stream().filter(i->i.startsWith("A")).collect(Collectors.toList());

        System.out.println(Square);
        System.out.println(OddNumber);
        System.out.println(sortedNames);
        System.out.println(startWithA);

        System.out.println("Hello World");
    }
}
