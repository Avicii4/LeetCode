package problems.array;

/**
 * 给你一个非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 */
public class LC136 {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 10, 0, 0};
        System.out.println(singleNumber(arr));
    }
}
