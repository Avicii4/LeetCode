package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        String[] myArray = {"Ap-ple", "Ban-ana", "Oran-ge", "Waterme-lon"};
        List<String> myList = Arrays.asList(myArray);

        Stream<String> stringStream = myList.stream().filter(s -> "Apple".equals(s));
        //System.out.println(stringStream.count());
        stringStream.forEach(System.out::print);

    }
}
