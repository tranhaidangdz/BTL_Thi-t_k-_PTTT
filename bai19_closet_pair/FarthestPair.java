package bai19_closet_pair;

// FarthestPair.java
import java.io.*;
import java.util.*;

public class FarthestPair {
    public static void findAndWriteFarthestPair(String inputFilename, String outputFilename) throws IOException {
        // Đọc dữ liệu từ file input
        List<Point> points = readPointsFromFile(inputFilename);

        // Tìm cặp điểm xa nhất
        Pair farthestPair = findFarthestPair(points);

        // Ghi kết quả ra file output
        writePairToFile(farthestPair, outputFilename);
    }

    // Đọc các điểm từ file input
    private static List<Point> readPointsFromFile(String filename) throws IOException {
        List<Point> points = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] coordinates = line.trim().split(" ");
            double x = Double.parseDouble(coordinates[0]);
            double y = Double.parseDouble(coordinates[1]);
            points.add(new Point(x, y));
        }
        reader.close();
        return points;
    }

    // Tìm cặp điểm xa nhất
    private static Pair findFarthestPair(List<Point> points) {
        int n = points.size();
        Pair farthestPair = new Pair(points.get(0), points.get(1));
        double maxDistance = distance(farthestPair.first, farthestPair.second);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = distance(points.get(i), points.get(j));
                if (d > maxDistance) {
                    maxDistance = d;
                    farthestPair = new Pair(points.get(i), points.get(j));
                }
            }
        }
        return farthestPair;
    }

    // Ghi cặp điểm ra file output
    private static void writePairToFile(Pair pair, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("Farthest pair:\n");
        writer.write("(" + pair.first.x + ", " + pair.first.y + ") - (" + pair.second.x + ", " + pair.second.y + ")");
        writer.close();
    }

    // Tính khoảng cách giữa hai điểm
    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Lớp đại diện cho cặp điểm
    private static class Pair {
        Point first, second;

        public Pair(Point first, Point second) {
            this.first = first;
            this.second = second;
        }
    }

    // Lớp biểu diễn điểm trong không gian 2D
    private static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
