package pl.invicta.app;

public class Main {
    public static void main(String[] args) {
        FileCSV convertToCSVFile = new FileCSV(" Mary had a little lamb .\n" +
                "Peter called for the wolf , and Aesop came .\n" +
                "Cinderella likes shoes..");
        convertToCSVFile.convertToCSV();

        FileXML convertToXMLFile = new FileXML(" Mary had a little lamb .\n" +
                "Peter called for the wolf , and Aesop came .\n" +
                "Cinderella likes shoes..");
        convertToXMLFile.convertToXML();
    }
}
