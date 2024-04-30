package bai11_DocFile_excel;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Đọc từ file Excel
            ExcelReader.readExcel("C://Users//tranh//OneDrive//Pictures//KeHoachLamBaiTapLon.xlsx");

            // Tính điểm cho học sinh
            GradeCalculator.main(args);
        } catch (IOException e) {
            System.out.println("Không thể đọc từ file Excel: " + e.getMessage());
        }
    }
}
