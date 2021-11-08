package paixu;



import java.util.*;

public class testc {
    public static void main(String[] args) {
/*        String s = "aaabb";
        char[] chars = s.toCharArray();
        for (int i=0;i<s.length();i++){
            System.out.println(chars[i]);
        }*/
/*        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        int i = 0;
        int[][] arr = new int[3][list.toArray().length];
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            arr[0][i++] = iterator.next();
        }
        System.out.println();
        Queue<Integer> queue=null;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();*/
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(1);
        sortedSet.add(23);
        sortedSet.add(15);
        sortedSet.stream().forEach(System.out::println);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
