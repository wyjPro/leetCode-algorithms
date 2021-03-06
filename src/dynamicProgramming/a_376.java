package dynamicProgramming;

/**
 * 摆动序列
 */
public class a_376 {
    public int wiggleMaxLength(int[] nums) {
        /*
         用up[i]和down[i]分别记录到第i个元素为止以上升沿和下降沿结束的最长“摆动”
         序列长度，遍历数组，如果nums[i]>nums[i-1]，表明第i-1到第i个元素是上升的，
         因此up[i]只需在down[i-1]的基础上加1即可，而down[i]保持down[i-1]不变；
         如果nums[i]<nums[i-1]，表明第i-1到第i个元素是下降的，因此down[i]
         只需在up[i-1]的基础上加1即可，而up[i]保持up[i-1]不变；如果nums[i]==nums[i-1]，
         则up[i]保持up[i-1]，down[i]保持down[i-1]。比较最终以上升沿和下降沿结束的
         最长“摆动”序列长度即可获取最终结果
        */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up = down + 1;
            } else if (nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
