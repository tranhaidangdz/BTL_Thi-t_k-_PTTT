package bai18_bieuthuc_hauto;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("D://Downloads//BTL_TKPTTT//bai18_bieuthuc_hauto//input.txt");
            Scanner scanner = new Scanner(inputFile);
            File outputFile = new File("output.txt");
            PrintWriter writer = new PrintWriter(outputFile);

            while (scanner.hasNextLine()) {
                String expression = scanner.nextLine();
                double result = SimpleSuffix.evaluate(expression);
                writer.println(result);
            }

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
