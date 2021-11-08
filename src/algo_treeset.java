import java.util.Set;
import java.util.TreeSet;

public class algo_treeset implements Comparable<algo_treeset>{
    private String name;
    private int age;

    public algo_treeset(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "algo_treeset{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(algo_treeset o) {
        return this.age-o.age;
    }
}
class test00{
    public static void main(String[] args) {
        Set<algo_treeset> set = new TreeSet<>();
        set.add(new algo_treeset("young",21));
        set.add(new algo_treeset("Bruce",25));
        set.add(new algo_treeset("Bob",27));
        set.add(new algo_treeset("Amy",26));
        set.add(new algo_treeset("Lee",18));
        for (algo_treeset algo : set){
            System.out.println(algo.toString());
        }
    }
}
