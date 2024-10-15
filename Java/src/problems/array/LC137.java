package problems.array;

// 除某个元素仅出现一次外，其余每个元素都恰出现三次。
// 请你找出并返回那个只出现了一次的元素。
public class LC137 {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 答案的第i个二进制位就是数组中所有元素的第i个二进制位之和除以3的余数
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,2};
        System.out.println(singleNumber(arr));
    }
}
