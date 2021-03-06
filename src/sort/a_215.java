package sort;

import java.util.PriorityQueue;

//数组中的第K个最大元素
public class a_215 {
    public int findKthLargest(int[] nums, int k) {
        //int index = k-1;
        k = nums.length - k;
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {//< ,<=则不会通过
            int j = partition(nums, lo, hi);
            if (j == k) {
                break;
            } else if (j < k) {
                lo = j + 1;
            } else {
                hi = j - 1;
            }
        }
        return nums[k];
    }
    private int partition(int[] nums ,int lo, int hi) {
        int i = lo, j = hi+1;
        int re = nums[lo];
        while (true) {
            while (nums[++i] < re && i < hi);//后面&&的条件不能省略
            while (nums[--j] > re && j > lo);
            if (i >= j) break;
            swap(nums, i ,j);
        }
        swap(nums, lo, j);
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    class StackClass {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int val : nums) {
                queue.add(val);
                if (queue.size() > k) {//维护堆的大小为k
                    queue.poll();//每次弹出删除堆中最小元素,最后只剩k个元素
                }
            }
            return queue.peek();
        }
    }
}

