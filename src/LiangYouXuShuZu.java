import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LiangYouXuShuZu {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int zhong;
        int[] arr = new int[length];
        int flag1=0;
        int flag2=0;
        int i=0;

        while (true){
            if (flag1==nums1.length || flag2==nums2.length){
                break;
            }
            if (nums1[flag1]<=nums2[flag2]){
                arr[i++] = nums1[flag1];
                flag1++;
            }
            else {
                arr[i++] = nums2[flag2];
                flag2++;
            }
        }
        if (flag1== nums1.length){
            while(flag2 != nums2.length){
                arr[i++] = nums2[flag2++];
            }
        }
        else {
            while(flag1 != nums1.length){
                arr[i++] = nums1[flag1++];
            }
        }
        if ((length&1)==1){
            zhong = length/2;
            return arr[zhong]*1.0;
        }
        else {
            zhong =length/2-1;
            return (arr[zhong]+arr[zhong+1])*1.0/2;
        }
    }
}

class DemoLiangYouXuShuZu{
    public static void main(String[] args) {
        int[] num1={2};
        int[] num2 = {};
        LiangYouXuShuZu liangYouXuShuZu = new LiangYouXuShuZu();
        double value = liangYouXuShuZu.findMedianSortedArrays(num1, num2);
        System.out.println(value);
    }
}
