package paixu;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;






class ArraryPaiXu{
    int[] arrary;

    public ArraryPaiXu(int[] ArraryP){
        this.arrary = ArraryP;
    }

    /*算法描述
比较相邻的元素。如果第一个比第二个大，就交换它们两个；
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
针对所有的元素重复以上的步骤，除了最后一个；
重复步骤1~3，直到排序完成。
内层最小值下沉时间复杂度O（n方）
*/
    public int[] maopao(){
        for (int i = 0;i< arrary.length-1;i++){
            for (int j=arrary.length-1;j>i;j--){
                if (arrary[j]<arrary[j-1]){
                    int temp = arrary[j];
                    arrary[j] = arrary[j-1];
                    arrary[j-1] = temp;
                }
            }
        }
        return arrary;
    }

    /*冒泡优化，内层最小值下沉，当没有出现下沉则以排好序，时间复杂度O(n方)*/
    public int[] maopaoyouhua(){
        int flag=1;
        for (int i = 0;i< arrary.length-1;i++){
            for (int j=arrary.length-1;j>i;j--){
                if (arrary[j]<arrary[j-1]){
                    int temp = arrary[j];
                    arrary[j] = arrary[j-1];
                    arrary[j-1] = temp;
                    flag=0;
                }
            }
            if (flag==1){
                break;
            }
            flag=1;

        }
        return arrary;
    }

    /*
每一次外层排序将右边最小的记录的index，如果最后index和外层i相同的花话，那么i位置就是最小值位置，不用动，其他情况交换
时间复杂度O(n方)
    * */
    public int[] xuanze(){
        int min;
        for (int i=0;i<arrary.length-1;i++){
            min=i;
            for (int j=i+1;j<arrary.length;j++){
                if (arrary[j]<arrary[min]){
                    min = j;
                }
            }
            if (min != i){
                int tem=arrary[i];
                arrary[i] = arrary[min];
                arrary[min] = tem;
            }
        }
        return arrary;
    }
/*插入排序,默认0到i是已经排序好了的，当加入j=i+1元素时，和左边的默认有序数组比较，如果遇到不能交换了，那么先状态也是有序数组了
* 时间复杂度O(n方)*/
    public int[] charu(){
        for (int i=0;i<arrary.length-1;i++){
            for (int j=i+1;j>0;j--){
                if (arrary[j]<arrary[j-1]){
                    int temp = arrary[j];
                    arrary[j] = arrary[j-1];
                    arrary[j-1] = temp;
                }
                else {
                    break;
                }
            }
        }
        return arrary;
    }
    /*希尔排序,时插入排序的升级版，增加了个步长序列，根据他的步长，把一列数据分为length/步长个列，然后每个列对应位置进行插入排序，从而最后步长为1之后，在进行插入排序*/
    public int[] xier(){
        int incre = arrary.length;
        while (true){
            incre = incre/2;
            for (int k=0;k<incre;k++){
                for (int i = k;i< arrary.length-incre;i=i+incre){
                    for (int j = i+incre;j>k;j=j-incre){
                        if (arrary[j]<arrary[j-incre]){
                            int tem = arrary[j];
                            arrary[j] = arrary[j-incre];
                            arrary[j-incre] = tem;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            if (incre==1){
                break;
            }
        }
        return arrary;
    }

    /*快速排序，选定一个基准数，小的放左边，大的放右边，然后再两个序列中再次重复操作,时间复杂度O(NlogN)*/
    public void kuaisu(int[] arr, int left,int right ){
        if (arr.length==0){
            return;
        }
        if (left>=right){
            return;
        }
        int key=arr[left];
        int low=left;
        int high=right;
        while (low<high){
            while(low<high && arr[high]>=key){
                high--;
            }
            arr[low] = arr[high];
            while (low<high && arr[low]<=key){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        kuaisu(arr,left,low-1);
        kuaisu(arr,high+1,right);
    }

    /*归并排序,划分到最小单位之后再对两两单位进行合并，时间复杂度O（NlogN）,空间复杂度O(N)*/
    public void huafen(int[] arr,int[] temp,int left,int right){
        if (left<right){
            int middle = (left+right)/2;
            huafen(arr,temp,left,middle);
            huafen(arr,temp,middle+1,right);
            merge(arr,temp,left,middle,right);
        }
    }

    public void merge(int[] arr,int[] temp,int left,int middle,int right){
        int i = left;
        int j = middle+1;
        int k = 0;

        while(i<=middle && j<=right){
            temp[k++] = arr[i]<arr[j] ? arr[i++]:arr[j++];
        }
        while (i<=middle){
            temp[k++] = arr[i++];
        }
        while (j<=right){
            temp[k++] = arr[j++];
        }
        for (i=0;i<k;i++){
            arr[left+i] = temp[i];
        }
    }

    /*
    * 堆排序原理
堆排序就是把最大堆堆顶的最大数取出，将剩余的堆继续调整为最大堆，再次将堆顶的最大数取出，这个过程持续到剩余数只有一个时结束。在堆中定义以下几种操作：

最大堆调整（Max-Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
创建最大堆（Build-Max-Heap）：将堆所有数据重新排序，使其成为最大堆
堆排序（Heap-Sort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算 继续进行下面的讨论前，需要注意的一个问题是：数组都是 Zero-Based，这就意味着我们的堆数据结构模型要发生改变*/

    /*
    * 基数排序(Radix Sort)是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
排序过程：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。*/

}



public class PaiXuSuanFa {
    public static void main(String[] args) {
        int[] arr = {9,2,1,5,6,3,10,11};


        ArraryPaiXu arraryPaiXu = new ArraryPaiXu(arr);
        arraryPaiXu.huafen(arr,new int[arr.length],0,arr.length-1);
        for (int i: arr){
            System.out.print(i+"、");
        }
    }
}
