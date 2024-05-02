package bai19_closet_pair;

import java.util.Comparator;

public class Point2D implements Comparable<Point2D> {
    private final double x; // x-coordinate
    private final double y; // y-coordinate

    // Khởi tạo một điểm mới có tọa độ (x, y)
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Trả về tọa độ x của điểm
    public double x() {
        return x;
    }

    // Trả về tọa độ y của điểm
    public double y() {
        return y;
    }

    // Trả về khoảng cách giữa điểm này và điểm khác
    public double distanceTo(Point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // So sánh hai điểm dựa trên tọa độ x, sau đó tới tọa độ y
    public int compareTo(Point2D other) {
        if (this.x < other.x)
            return -1;
        if (this.x > other.x)
            return 1;
        if (this.y < other.y)
            return -1;
        if (this.y > other.y)
            return 1;
        return 0;
    }

    // Trả về một bản sao của điểm
    public Point2D copy() {
        return new Point2D(this.x, this.y);
    }

    // Trả về biểu diễn chuỗi của điểm
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Sắp xếp các điểm theo tọa độ x
    public static final Comparator<Point2D> X_ORDER = new XOrder();

    // So sánh hai điểm theo tọa độ x
    private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p1, Point2D p2) {
            if (p1.x < p2.x)
                return -1;
            if (p1.x > p2.x)
                return 1;
            return 0;
        }
    }
}
