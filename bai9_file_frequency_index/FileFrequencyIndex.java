package bai9_file_frequency_index;

public class FileFrequencyIndex {
    /*
     * FileFrequencyIndex.java: Lớp chính chứa phương thức main và phương thức để
     * gọi các phương thức khác.
     * FileReader.java: Chứa phương thức để đọc file và trả về nội dung của file
     * dưới dạng chuỗi.
     * WordFrequencyCounter.java: Chứa phương thức để đếm tần suất xuất hiện của một
     * từ trong một chuỗi.
     * 
     * -,Hãy thay đổi các giá trị filePath và searchWord trong phương thức main của
     * FileFrequencyIndex.java để thích nghi với tên file và từ bạn muốn tìm kiếm.
     * Đảm bảo rằng file path_to_your_file.txt thực sự tồn tại và chứa dữ liệu.
     */
    public static void main(String[] args) {
        // String filePath = "C://Users//tranh//OneDrive//Pictures//LỊCH SỬ ĐẢNG CHƯƠNG
        // 3 ngày 20.docx"; : Đường dẫn bạn đã đặt trong biến filePath có vẻ là đường
        // dẫn
        // đến một tệp tin Word (.docx). Tuy nhiên, lớp FileReader mà bạn sử dụng chỉ
        // đọc dữ liệu từ các tệp tin văn bản thông thường, chẳng hạn như .txt. Do đó,
        // nếu bạn cố gắng đọc một tệp tin Word, chương trình sẽ không thành công.
        String filePath = "C://Users//tranh//OneDrive//Pictures//DangTranPTTKTT.txt";
        String searchWord = "dang";

        ReadFile fileReader = new ReadFile();
        String fileContent = fileReader.readFile(filePath);

        WordFrequencyCounter counter = new WordFrequencyCounter();
        int frequency = counter.getWordFrequency(fileContent, searchWord);

        System.out.println("Frequency of word '" + searchWord + "': " + frequency);
    }
}
