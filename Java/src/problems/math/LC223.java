package problems.math;

public class LC223 {
    // 每个矩形由其 左下 顶点和 右上 顶点坐标表示
    // 计算并返回两个矩形覆盖的总面积
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int totalArea = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        // 两个矩形投影到x轴上的重合长度
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        // 两个矩形投影到y轴上的重合长度
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int coverArea = x * y;
        return totalArea - coverArea;
    }


    public static void main(String[] args) {
        // System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        // System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
    }
}
