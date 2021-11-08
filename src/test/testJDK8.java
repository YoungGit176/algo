package test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class testJDK8 {

    public static void main(String[] args) {
/*        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        numbers.stream().map(i -> i * i).distinct().forEach(System.out::println);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
// 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
        //limit限制
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);*/
/*        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);*/
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
// 获取空字符串的数量
        strings.parallelStream().filter(string -> !string.isEmpty()).forEach(System.out::println);


    }
}
