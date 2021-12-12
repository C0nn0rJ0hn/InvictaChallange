package pl.invicta.app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

public class FileCSV  extends Convert {
    private String text;
    private PrintWriter printWriter;

    public FileCSV(String text) {
        this.text = text;
    }

    public String convertToCSV() {
        Map<String, String[]> resultMap = super.convertToFile(text);
        int maxWords = resultMap.values().stream().mapToInt(strings -> strings.length).max().orElse(0);

        StringBuilder sb = new StringBuilder();
        sb.append("Sentence,");
        for(int i = 1; i < maxWords; i++) {
            sb.append("Word ").append(i).append(",");
        }
        sb.append("Word ").append(maxWords);
        sb.append("\n");

        for(Map.Entry<String, String[]> entry : resultMap.entrySet()) {
            Arrays.sort(entry.getValue(), String.CASE_INSENSITIVE_ORDER);
            sb.append(entry.getKey());
            sb.append(",");
            for (int i = 0; i < entry.getValue().length-1; i++) {
                sb.append(entry.getValue()[i]).append(",");
            }
            sb.append(entry.getValue()[entry.getValue().length-1]);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);

        try {
            printWriter = new PrintWriter("invicta.csv");
            printWriter.write(sb.toString());
            printWriter.close();
            System.out.println("File has been created!");
        }
        catch(FileNotFoundException e) {
            System.out.println("Error creating/writing file");
            e.printStackTrace();
        }
        return sb.toString();
    }
}
