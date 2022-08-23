
/**
 * Created by Harry Chou at 2019/5/17.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

public class VerifySequenceOfBST {
    public boolean verifySequence(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = end;
        while (i > start && arr[i - 1] > arr[end]) {
            i--;
        }
        for (int j = start; j < i - 1; j++) {
            if (arr[j] > arr[end]) {
                return false;
            }
        }
        return verify(arr, start, i - 1) && verify(arr, i, end - 1);
    }

    public boolean verifyWithoutRecur(int[] sequence) {
        int len = sequence.length;
        if (len == 0) {
            return false;
        }
        int i = 0;
        while (len > 0) {
            len--;
            while (sequence[i] < sequence[len]) {
                i++;
            }
            while (sequence[i] > sequence[len]) {
                i++;
            }
            if (i < len) {
                return false;
            }
            i = 0;
        }
        return true;
    }
}
