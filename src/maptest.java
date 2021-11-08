import java.util.*;

public class maptest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("10", "a");
        map.put("3", "b");
        map.put("2", "c");
        map.put("5", "d");
        ListIterator<Map.Entry<String,String>> entryIterator= new ArrayList<>(map.entrySet()).listIterator(map.size());//这里linkIterator（只能用于list家族）可以通过定位从而实现是要通过正向还是逆向遍历链表
        while(entryIterator.hasPrevious()){
            Map.Entry<String,String> map1=entryIterator.previous();
            if (map1.getKey().equals("5")){
                Map<String,String> hashmap = new HashMap<>();
                hashmap.put("7","y");
                entryIterator.add(hashmap.entrySet().iterator().next());/*添加*/
                /*entryIterator.set(hashmap.entrySet().iterator().next());*//*修改*/
                /*entryIterator.remove();*//*删除，这三项功能操作的目标需要根据是顺序遍历还是逆序遍历来判断删除目标*/
            }
            System.out.println(map1.getKey()+"   "+ map1.getValue());
        }
        System.out.println("----------------");
        while(entryIterator.hasNext()){
            Map.Entry<String,String> map1=entryIterator.next();
            System.out.println(map1.getKey()+"   "+ map1.getValue());
        }

    }
}
/*Iterator迭代器包含的方法有：

hasNext()：如果迭代器指向位置后面还有元素，则返回 true，否则返回false

next()：返回集合中Iterator指向位置后面的元素

remove()：删除集合中Iterator指向位置后面的元素

ListIterator迭代器包含的方法有：

add(E e): 将指定的元素插入列表，插入位置为迭代器当前位置之前

hasNext()：以正向遍历列表时，如果列表迭代器后面还有元素，则返回 true，否则返回false

hasPrevious():如果以逆向遍历列表，列表迭代器前面还有元素，则返回 true，否则返回false

next()：返回列表中ListIterator指向位置后面的元素

nextIndex():返回列表中ListIterator所需位置后面元素的索引

previous():返回列表中ListIterator指向位置前面的元素

previousIndex()：返回列表中ListIterator所需位置前面元素的索引

remove():从列表中删除next()或previous()返回的最后一个元素（有点拗口，意思就是对迭代器使用hasNext()方法时，删除ListIterator指向位置后面的元素；当对迭代器使用hasPrevious()方法时，删除ListIterator指向位置前面的元素）

set(E e)：从列表中将next()或previous()返回的最后一个元素返回的最后一个元素更改为指定元素e*/
