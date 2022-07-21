import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class ReportGenerationExample {

    public static void main(String[] args) throws IOException {
        //final String filePath = "";
        final String filePath = "/home/daypay/workspace/intellij/mp-report-poc/reports/tax-recipt.html";
        HtmlConverter.convertToPdf(
                new File(filePath),
                new File("demo-html.pdf"));
    }
}
