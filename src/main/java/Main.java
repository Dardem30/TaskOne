import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream("file.properties");
        properties.load(fileInputStream);
        PDFMergerUtility ut = new PDFMergerUtility();
        ut.addSource(properties.getProperty("firstPath"));
        ut.addSource(properties.getProperty("secondPath"));
        ut.setDestinationFileName(properties.getProperty("thirdPath"));
        try {
            ut.mergeDocuments();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
    }
}
