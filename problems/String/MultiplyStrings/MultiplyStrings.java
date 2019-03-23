/**
 * Created by Harry Chou at 2019/3/23.
 * Description: Given two non-negative integers num1 and num2 represented as
 * strings, return the product of num1 and num2, also represented as a string.
 */
class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;

        if (len1 < 0 || len2 < 0) {
            return "";
        }

        int[] product = new int[len1 + len2 + 2];
        for (int i = len1; i >= 0; i--) {
            for (int j = len2; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                temp += product[i + j + 1];
                product[i + j] += temp / 10;
                product[i + j + 1] = temp % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < product.length - 1 && product[i] == 0) {
            i++;
        }
        for (; i < product.length; i++) {
            sb.append(product[i]);
        }
        return sb.toString();
    }
}