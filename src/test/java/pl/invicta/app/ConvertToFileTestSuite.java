package pl.invicta.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConvertToFileTestSuite {

    @Test
    void shouldCreateSpecificStringForCSVFile() {
        //Given
        FileCSV fileCSV = new FileCSV(" Mary had a little lamb .\n" +
                "Peter called for the wolf , and Aesop came .\n" +
                "Cinderella likes shoes..");

        //When
        String result = fileCSV.convertToCSV();

        //Then
        Assertions.assertEquals("Sentence,Word 1,Word 2,Word 3,Word 4,Word 5,Word 6,Word 7,Word 8\n" +
                "Sentence 1,a,had,lamb,little,Mary\n" +
                "Sentence 2,Aesop,and,called,came,for,Peter,the,wolf\n" +
                "Sentence 3,Cinderella,likes,shoes", result);

    }

    @Test
    void shouldCreateSpecificStringForXMLFile() {
        //Given
        FileXML fileXML = new FileXML(" Mary had a little lamb .\n" +
                "Peter called for the wolf , and Aesop came .\n" +
                "Cinderella likes shoes..");

        //When
        String result = fileXML.convertToXML();

        //Then
        Assertions.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<text>\n" + " <sentence>\n" + "  <word>a</word>\n" + "  <word>had</word>\n" +
                "  <word>lamb</word>\n" + "  <word>little</word>\n" + "  <word>Mary</word>\n" + " </sentence>\n" +
                " <sentence>\n" + "  <word>Aesop</word>\n" + "  <word>and</word>\n" + "  <word>called</word>\n" +
                "  <word>came</word>\n" + "  <word>for</word>\n" + "  <word>Peter</word>\n" + "  <word>the</word>\n" +
                "  <word>wolf</word>\n" + " </sentence>\n" + " <sentence>\n" + "  <word>Cinderella</word>\n" +
                "  <word>likes</word>\n" + "  <word>shoes</word>\n" + " </sentence>\n" + "</text>", result);
    }
}
