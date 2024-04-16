package exam;

import java.util.Scanner;

// 用,分隔的整数字符串
// 有一个数字出现次数超过一半的
public class FindNumberMoreThanHalf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] nums = string.split(",");
        String res = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i].equals(res)) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        count = 0;
        for (String num : nums) {
            if (num.equals(res)) {
                count++;
            }
        }
        if (count >= nums.length / 2) {
            System.out.println(res);
        } else {
            System.out.println(nums[0]);
        }
    }
}
