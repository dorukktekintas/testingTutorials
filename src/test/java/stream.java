import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream {

    @Test

    public void regular() {


        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");
        int count = 0;

        for (int i=0; i<names.size();i++){

            String actual = names.get(i);
            if (actual.startsWith("A")){
                count++;

            }

        }
        System.out.println(count);



    }

    @Test
    public void streamFilter(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");

        //there is no life for intermediate operation if there is no terminal operation
        //terminal op will execute if only inter op returns true
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        Long d = Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s -> {
            s.startsWith("A");
            return true;
        }).count();//another decleration
        System.out.println(d);
        //print all the names of arraylist
        names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));


    }

    @Test
    public void map(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Doruk");
        names.add("Ata");
        names.add("Yeto");

        //print names with a last letter and uppercase
        Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //print names uppercase first letter and sorted

        List<String> names1 = Arrays.asList("Azbhijeet","Don","Alekhya","Adam","Rama");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        //concat
        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
       // newStream.sorted().forEach(s -> System.out.println(s));

        //match
        boolean flag = newStream.allMatch(s -> s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);




    }
    @Test
    public void streamCollect(){

        List<String> ls = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        //print unique numbers and sort the array
        //ive 3rd index
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));


    }

}
