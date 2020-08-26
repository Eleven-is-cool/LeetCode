package 排序.插入排序;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        if(arr == null && arr.length<2)
            return arr;
        int len = arr.length;
        for(int i=1;i<len;i++){
            int temp = arr[i];
            int j=i;
            while(j>0 && temp<arr[j-1]){
                // 前面有比arr[i]大的，就往后腾位置
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }
}
