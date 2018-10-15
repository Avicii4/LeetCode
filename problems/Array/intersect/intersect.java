/**
 * Created by Harry Chou at 2018/10/15.
 * Description: Given two arrays, write a function to compute their
 * intersection.
 */
public class intersect {
    public int[] findIntersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> nums2toList = new ArrayList<>();
        for (int x = 0; x < nums2.length; x++)
            nums2toList.add(nums2[x]);
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2toList.size(); j++)
                if (nums1[i] == nums2toList.get(j)) {
                    result.add(nums1[i]);
                    nums2toList.remove(j);
                    break;
                }
        int[] list = new int[result.size()];
        for (int k = 0; k < result.size(); k++)
            list[k] = result.get(k);
        return list;
    }
}