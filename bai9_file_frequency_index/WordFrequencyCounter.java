package bai9_file_frequency_index;

public class WordFrequencyCounter {
    public int getWordFrequency(String content, String word) {
        int frequency = 0;
        String[] words = content.split("\\s+");
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                frequency++;
            }
        }
        return frequency;
    }
}
