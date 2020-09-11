package 数组中的第k个最大元素;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 升序建大顶推
        int len = nums.length;
        for(int i=(len-2)/2;i>=0;i--){
            downAdjust(nums, i, len);
        }
        for(int i=nums.length-1;i>0;i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            downAdjust(nums, 0, i);
            if(i == len-k)
                return nums[i];
        }
        return nums[len-k];
    }
    public int[] downAdjust(int[] nums, int parent, int length){
        // 保存下沉元素
        int temp = nums[parent];
        int child = 2*parent + 1;
        while(child < length){
            if(child+1 < length && nums[child+1] > nums[child])
                child = child + 1;
            if(temp > nums[child])
                break;
            nums[parent] = nums[child];
            parent = child;
            child = 2*parent+1;
        }
        nums[parent] = temp;
        return nums;
    }

}
