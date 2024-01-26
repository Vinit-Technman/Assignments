// package Assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssignmentOne {
    /*
 * 
 * 
 * Implement all methods of Stream API
Create a Dummy List, Map and Set for stream
Given a String, find the first non-repeated character in it using Stream functions?
Given a String, find the first repeated character in it using Stream functions?
Given a list of integers, sort all the values present in it using Stream functions?
Write a Java 8 program to concatenate two Streams?
How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
How to count each element/word from the String ArrayList in Java8?
How to find only duplicate elements with its count from the String ArrayList in Java8?
Write a Program to find the Maximum element in an array?
Write a program to print the count of each character in a String?
Implement Streams on employee Data -
How many male and female employees are there in the organization?
Print the name of all departments in the organization.
What is the average age of male and female employees?
Get the details of highest paid employee in the organization
Get the names of all employees who have joined after 2015
Count the number of employees in each department
What is the average salary of each department?
Who has the most working experience in the organization?
Get the details of youngest male employee in the each department.
What is the average salary and total salary of the whole organization?
 */

    public static Character findFirstNonRepeated(String s)
    {
          char ans=s.chars().mapToObj(i->Character.toLowerCase((char)i))
          .collect(Collectors.groupingBy(Function.identity(), 
          LinkedHashMap::new, Collectors.counting()))
          .entrySet()
        .stream().filter(e->e.getValue()==1)
        .findFirst().orElseThrow().getKey();

        return ans;
    }

    public static Character findFirstRepeated(String s)
    {
          char ans=s.chars().mapToObj(i->Character.toLowerCase((char)i))
          .collect(Collectors.groupingBy(Function.identity(), 
          LinkedHashMap::new, Collectors.counting()))
          .entrySet()
        .stream().filter(e->e.getValue()>1)
        .findFirst().orElseThrow().getKey();

        return ans;
    }


   public static void main(String args[])
    {

        List<String>DummyList=Arrays.asList("Apple","Banana","Guavava");

        Map<Integer, String> dummyMap = new HashMap<>();
        dummyMap.put(1, "One");
        dummyMap.put(2, "Two");
        dummyMap.put(3, "Three");
        dummyMap.put(4, "Four");
        dummyMap.put(5, "Five");

        
        
        Set<Integer> dummySet = new HashSet<>();
        dummySet.add(10);
        dummySet.add(20);
        dummySet.add(30);
        dummySet.add(40);
        dummySet.add(50);

        // System.out.println(DummyList+"  "+dummyMap+"  "+dummySet);

        // Scanner in=new Scanner(System.in);
        // String str1=in.nextLine();
        String str1="racecar";

        System.out.println("String: "+str1);
        
        System.out.println("\n First Non Repeated Char: "+findFirstNonRepeated(str1));
        
        System.out.println("\nFirst Repeated Char: "+findFirstRepeated(str1));
        
        List<Integer>listOfInt=Arrays.asList(5,4,3,2,1);
        
        List<Integer>sortedLL=listOfInt.stream().sorted().collect(Collectors.toList());
        System.out.println("\nSorted List of Integers: \n"+sortedLL);

        Stream<String> s1=Stream.of("Abc","Def");
        Stream<String> s2=Stream.of("Ghi","Jkl");

        Stream.concat(s1, s2).forEach(e -> System.out.print(e+'\t'));

        Map<String,Integer>listToConvertMap=DummyList.stream().collect(Collectors.toMap(String::new, String::length));
        System.out.println(listToConvertMap);

        List<String>listOfWords=Arrays.asList("Hello","World","Hello","Java");

        Map<String,Long>countOfWords=listOfWords.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        System.out.println("\nCount of words in String\n\n"+countOfWords);

        ArrayList<String>listOfCar=new ArrayList<String>();
        listOfCar.add("car1");
        listOfCar.add("car2");
        listOfCar.add("car3");
        listOfCar.add("car2");
        listOfCar.add("car1");
       
        Map<String,Long>countOfCar=listOfCar.stream().collect(Collectors.groupingBy(String::toString,Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));    
              
        System.out.println("\n"+countOfCar);

        int[] arr={10,20,45,2330,3000,4000};

        int maxi=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>maxi)
            {
                maxi=arr[i];
            }
        }
        System.out.println("Maximum Element in Array is: "+maxi);

        // Write a program to print the count of each character in a String?
        String s="abcdcba";
        
        System.out.println("Count of Each Character in String: "+s+"\n");
        s.chars().mapToObj(c->Character.toLowerCase((char)c)).collect(Collectors.groupingBy(c->c,Collectors.counting())).forEach((c,n)->
        System.out.println(c+" : "+n));;

    }
}
