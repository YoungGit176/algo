public class algo_sort {
    //快排
    public static void quickSort(int[] arr, int left, int right){
        if (arr.length==0){
            return;
        }
        if (left>=right){
            return;
        }
        int low = left;
        int high = right;
        int temp=arr[low];
        while(low<high){
            while (low<high && arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while(low<high && arr[low] <= temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low]=temp;
        quickSort(arr,left,low-1);
        quickSort(arr,low+1,right);
    }

    public static void main(String[] args) {
        int[] arr = {9,2,1,5,6,3,10,11};
        quickSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}

