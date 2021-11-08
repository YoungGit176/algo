import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。
*/
public class Solution{

    public  int[] twoSum(int[] nums, int target) {
        int i=0;
        Map<Integer,Integer> map = new HashMap<>();
        for (i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                int[] result = {map.get(target-nums[i]),i};
                return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }

}


class demo{
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums,target)));
        Map<Integer,Integer> map = new HashMap<>();
        map.put(null,1);
        map.put(2,1);
        map.put(null,2);
        map.values().forEach(System.out::println);
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        Executors.newFixedThreadPool(2).submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        Solution solution1 = new Solution();

    }
}
