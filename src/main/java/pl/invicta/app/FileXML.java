package pl.invicta.app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

public class FileXML extends Convert {
    private String text;
    private PrintWriter printWriter;

    public FileXML(String text) {
        this.text = text;
    }

    public String convertToXML() {
        Map<String, String[]> resultMap = super.convertToFile(text);

        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        StringBuilder sb = new StringBuilder(xmlString);
        sb.append("\n<text>\n");

        for(Map.Entry<String, String[]> entry : resultMap.entrySet()) {
            Arrays.sort(entry.getValue(), String.CASE_INSENSITIVE_ORDER);
            sb.append(" <sentence>\n");
            for (int i = 0; i < entry.getValue().length; i++) {
                sb.append("  <word>").append(entry.getValue()[i]).append("</word>\n");
            }
            sb.append(" </sentence>\n");
        }
        sb.append("</text>");

        try {
            printWriter = new PrintWriter("invicta.xml");
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
